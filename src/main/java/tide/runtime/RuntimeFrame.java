package tide.runtime;

import tide.core.*;

import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public class RuntimeFrame {
    public final TideProgram program;
    public final TideScope localScope;
    public final Map<String, TideObject> args;
    public final TideObject self; // optional
    public final int line;

    public RuntimeFrame(TideProgram program, TideScope localScope, TideObject self, Map<String, TideObject> args, int line) {
        this.program = program;
        this.localScope = localScope;
        this.self = self;
        this.args = args;
        this.line = line;
        for (Map.Entry<String, TideObject> entry : args.entrySet()) {
            localScope.set(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "RuntimeFrame{" +
                "program=" + program +
                ", localScope=" + localScope +
                ", args=" + args +
                ", self=" + self +
                '}';
    }
}
