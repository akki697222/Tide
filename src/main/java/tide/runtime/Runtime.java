package tide.runtime;

import tide.core.*;
import tide.runtime.modules.Module;

import java.util.Map;

/**
 * The {@code Runtime} interface defines the contract for executing and interacting with
 * Tide programs at runtime. Implementations of this interface are responsible for:
 * <ul>
 *     <li>Managing execution flow of Tide programs</li>
 *     <li>Handling program arguments and execution context</li>
 *     <li>Maintaining the runtime scope and status</li>
 *     <li>Loading runtime modules</li>
 * </ul>
 *
 * <p>Typical implementations include interpreters and bytecode runtimes.</p>
 *
 * @author akki697222
 * @since V1
 */
public interface Runtime {
    TideObject invoke(TideProgram program, Map<String, TideObject> arguments, boolean createNewFrame, boolean throwReturn);
    TideObject invoke(TideProgram program, Map<String, TideObject> arguments, boolean createNewFrame);
    TideObject invoke(TideProgram program, Map<String, TideObject> arguments);
    TideObject invoke(TideProgram program);
    void execute(TideProgram program);
    void execute(TideProgram program, String[] programArgs);
    TideScope env();
    TideScope global();
    RuntimeStatus getStatus();
    void addModule(Module module);
    String getVersion();
    String getEngineVersion();
}
