package tide.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tide.core.*;

import java.util.Map;

public interface Runtime {
    TideObject invoke(TideProgram program, Map<String, TideObject> arguments);
    TideObject invoke(TideProgram program);
    void execute(TideProgram program);
    void execute(TideProgram program, String[] programArgs);
    TideScope env();
    RuntimeStatus getStatus();
}
