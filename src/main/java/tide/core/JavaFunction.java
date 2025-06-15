package tide.core;

import java.util.HashSet;
import java.util.Map;

public abstract class JavaFunction extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("fun", null, new HashSet<>());

    protected final Map<String, String> signature;

    public JavaFunction(Map<String, String> signature) {
        this.signature = signature;
    }

    public abstract TideObject invoke(Map<String, TideObject> args);

    public Map<String, String> getSignature() {
        return signature;
    }
}
