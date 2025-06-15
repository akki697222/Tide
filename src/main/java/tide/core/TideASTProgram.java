package tide.core;

import tide.ast.Program;

import java.util.Map;

public class TideASTProgram extends TideProgram {
    public final Program program;

    public TideASTProgram(Program program) {
        this.program = program;
    }

    @Override
    public TideObject invoke(Map<String, TideObject> args) {
        return TideObject.runtime.invoke(this, args);
    }

    @Override
    public TideObject invoke(TideObject self, Map<String, TideObject> args) {
        return TideObject.runtime.invoke(this, args);
    }

    @Override
    public TideObject invoke() {
        return TideObject.runtime.invoke(this);
    }

    @Override
    public TideObject invoke(TideObject self) {
        return TideObject.runtime.invoke(this);
    }
}
