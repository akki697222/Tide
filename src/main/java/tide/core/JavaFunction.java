package tide.core;

import java.util.HashSet;
import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public abstract class JavaFunction extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("function", new HashSet<>());

    protected final Map<String, String> signature;

    public JavaFunction(Map<String, String> signature) {
        this.signature = signature;
    }

    public abstract TideObject invoke(Map<String, TideObject> args);

    public Map<String, String> getSignature() {
        return signature;
    }

    @Override
    public TideTypeObject getType() {
        return TYPE;
    }
}
