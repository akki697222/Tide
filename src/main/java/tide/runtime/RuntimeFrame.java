package tide.runtime;

import tide.core.*;

import java.util.Map;

public class RuntimeFrame {
    public final TideProgram program;
    public final TideScope localScope;
    public final Map<String, TideObject> args;
    public final TideObject self; // optional

    public RuntimeFrame(TideProgram program, TideScope localScope, TideObject self, Map<String, TideObject> args) {
        this.program = program;
        this.localScope = localScope;
        this.self = self;
        this.args = args;
    }
}
