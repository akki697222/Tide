package tide.core;

import tide.ast.Program;

import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
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

    @Override
    public int line() {
        return program.nodeInfo.line();
    }

    @Override
    public int column() {
        return program.nodeInfo.column();
    }

    @Override
    public String getSource() {
        return program.source;
    }

    @Override
    public String getSourceType() {
        return program.sourceType.id;
    }

    @Override
    public String toString() {
        return program.toString();
    }
}
