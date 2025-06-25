package tide.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tide.core.*;
import tide.runtime.error.JavaRuntimeError;
import tide.runtime.error.RuntimeError;
import tide.runtime.error.internal.Return;
import tide.runtime.modules.Module;

import java.util.*;

/**
 * The {@code AbstractRuntime} class provides a base implementation of the {@link Runtime} interface
 * for executing Tide programs. It manages runtime state including call stack, global scope,
 * program arguments, and module integration.
 * <p>
 * Subclasses must implement the {@link #doInvoke(RuntimeFrame, boolean)} and {@link #printStackTrace(Throwable)} methods.
 * </p>
 *
 * <p><b>Features:</b></p>
 * <ul>
 *     <li>Function invocation with stack frame management</li>
 *     <li>Runtime error handling and Return propagation</li>
 *     <li>Global/module scope setup and program argument injection</li>
 *     <li>Hook for loading custom modules before execution</li>
 * </ul>
 *
 * @author akki697222
 * @since V1
 */
public abstract class AbstractRuntime implements Runtime {
    protected static String[] programArgs;
    protected final TideScope globalScope = new TideScope();
    protected RuntimeStatus status;
    protected final List<Module> modules = new ArrayList<>();
    protected final Deque<RuntimeFrame> callStack = new ArrayDeque<>();

    public AbstractRuntime() {
        status = RuntimeStatus.STAND_BY;
    }

    @Override
    public TideScope env() {
        if (callStack.isEmpty()) {
            throw new IllegalStateException("call stack is empty");
        }
        return callStack.peek().localScope;
    }

    @Override
    public TideScope global() {
        if (callStack.isEmpty()) {
            throw new IllegalStateException("call stack is empty");
        }
        return callStack.getLast().localScope;
    }

    @Override
    public TideObject invoke(TideProgram program) {
        return invoke(program, new HashMap<>());
    }

    @Override
    public TideObject invoke(TideProgram program, Map<String, TideObject> arguments) {
        return invoke(program, arguments, true);
    }

    @Override
    public TideObject invoke(TideProgram program, Map<String, TideObject> arguments, boolean createNewFrame) {
        return invoke(program, arguments, createNewFrame, false);
    }

    @Override
    public TideObject invoke(TideProgram program, Map<String, TideObject> arguments, boolean createNewFrame, boolean throwReturn) {
        logDebug("[INV] " + program + " (createNewFrame=" + createNewFrame + ",throwReturn=" + throwReturn + ")");
        RuntimeFrame frame;
        if (createNewFrame) {
            TideScope newScope = new TideScope();
            newScope.parent = env();
            frame = new RuntimeFrame(program, newScope, null, arguments, program.line());
            pushFrame(frame);
        } else {
            frame = callStack.peek();
        }

        TideObject result;
        try {
            result = doInvoke(frame, throwReturn);
            logDebug("[RET(INV)] " + result);
        } catch (RuntimeError error) {
            status = RuntimeStatus.ERROR;
            throw error;
        } catch (Exception e) {
            if (e instanceof Return ret) {
                if (throwReturn) {
                    popFrame();
                    throw ret;
                } else {
                    result = ret.result;
                }
            } else {
                throw new JavaRuntimeError(e);
            }
        }
        popFrame();
        return result;
    }

    @Override
    public void addModule(Module module) {
        modules.add(module);
    }

    @Override
    public void execute(TideProgram program) {
        execute(program, new String[0]);
    }

    @Override
    public void execute(TideProgram program, String[] programArgs) {
        AbstractRuntime.programArgs = programArgs;
        TideArray args = new TideArray("string", programArgs.length);
        int i = 0;
        for (String arg : programArgs) {
            args.set(i, new TideString(arg));
            i++;
        }
        Map<String, TideObject> _args = new HashMap<>();
        callStack.push(new RuntimeFrame(program, globalScope, null, _args, program.line()));
        for (Module module : modules) {
            module.load(this);
        }
        status = RuntimeStatus.RUNNING;
        invoke(program, _args, false);
    }

    protected void pushFrame(RuntimeFrame frame) {
        callStack.push(frame);
    }

    protected void popFrame() {
        callStack.pop();
    }

    @Override
    public RuntimeStatus getStatus() {
        return status;
    }

    public static String[] getProgramArgs() {
        return programArgs;
    }

    public abstract void printStackTrace(Throwable e);

    protected abstract TideObject doInvoke(RuntimeFrame frame, boolean skipReturn);

    public static void logDebug(String x) {
        String runtime_debug = System.getProperty("runtime.debug.log");
        if (runtime_debug != null) {
            System.out.println(x);
        }
    }

    @Override
    public String getEngineVersion() {
        return "V1";
    }
}
