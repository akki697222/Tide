package tide.core;

import java.util.HashSet;

/**
 * @author akki697222
 * @since V1
 */
public class TideString extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("string", TideObject.TYPE, new HashSet<>());
    private final String value;

    public TideString(String value) {
        this.value = value;
    }

    @Override
    public TideObject add(TideObject other) {
        return new TideString(value + other.toString());
    }

    public TideTypeObject getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
}
