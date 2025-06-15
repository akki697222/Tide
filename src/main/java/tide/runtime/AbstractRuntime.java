package tide.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tide.core.*;
import tide.runtime.error.JavaRuntimeError;
import tide.runtime.error.RuntimeError;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRuntime implements Runtime {
    public static final Logger LOGGER = LoggerFactory.getLogger("Runtime");

    protected final TideScope globalScope = new TideScope();
    protected RuntimeStatus status;
    protected final Deque<RuntimeFrame> callStack = new ArrayDeque<>();

    public AbstractRuntime() {
        status = RuntimeStatus.STAND_BY;
        LOGGER.info("Runtime initialized");
    }

    @Override
    public TideScope env() {
        if (callStack.isEmpty()) {
            return globalScope;
        }
        return callStack.peek().localScope;
    }

    @Override
    public TideObject invoke(TideProgram program) {
        return invoke(program, new HashMap<>());
    }

    @Override
    public TideObject invoke(TideProgram program, Map<String, TideObject> arguments) {
        TideScope newScope = new TideScope();
        newScope.parent = globalScope;
        RuntimeFrame frame = new RuntimeFrame(program, newScope, null, arguments);
        callStack.push(frame);

        try {
            return doInvoke(frame);
        } catch (RuntimeError error) {
            status = RuntimeStatus.ERROR;
            throw error;
        } catch (Exception e) {
            throw new JavaRuntimeError(e);
        } finally {
            callStack.pop();
        }
    }

    @Override
    public void execute(TideProgram program) {
        execute(program, new String[0]);
    }

    @Override
    public void execute(TideProgram program, String[] programArgs) {
        invoke(program, new HashMap<>());
    }

    @Override
    public RuntimeStatus getStatus() {
        return status;
    }

    protected abstract TideObject doInvoke(RuntimeFrame frame);
}
