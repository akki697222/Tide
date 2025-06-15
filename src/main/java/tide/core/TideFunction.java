package tide.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TideFunction extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("fun", null, new HashSet<>());

    protected final Map<String, String> signature;
    protected final TideProgram program;
    protected final String funName;

    public TideFunction(Map<String, String> signature, TideProgram program, String funName) {
        this.signature = signature;
        this.program = program;
        this.funName = funName;
    }

    public TideFunction(Map<String, String> signature, TideProgram program) {
        this.signature = signature;
        this.program = program;
        this.funName = "$";
    }

    public TideFunction(TideProgram program) {
        this.signature = new HashMap<>();
        this.program = program;
        this.funName = "$";
    }

    public TideFunction(TideProgram program, String funName) {
        this.signature = new HashMap<>();
        this.program = program;
        this.funName = funName;
    }

    public Map<String, String> getSignature() {
        return signature;
    }

    public TideProgram getProgram() {
        return program;
    }

    public String getFunName() {
        return funName;
    }

    @Override
    public TideTypeObject getType() {
        return super.getType();
    }
}
