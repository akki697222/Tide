package tide.core;

import tide.runtime.error.TypeError;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public class TideBool extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("bool", TideObject.TYPE, new HashSet<>());
    private final Boolean value;

    private TideBool(Boolean value) {
        this.value = value;
    }

    public static final TideBool TRUE = new TideBool(true);
    public static final TideBool FALSE = new TideBool(false);

    public static TideBool of(Boolean b) {
        return b ? TRUE : FALSE;
    }

    private boolean parseBool(TideObject object) {
        if (object instanceof TideBool tideBool) {
            return tideBool.value;
        } else {
            throw new TypeError("Cannot convert " + object.getType() + " to bool");
        }
    }

    @Override
    public TideBool and(TideObject other) {
        return value && parseBool(other) ? TRUE : FALSE;
    }

    @Override
    public TideBool or(TideObject other) {
        return value || parseBool(other) ? TRUE : FALSE;
    }

    @Override
    public TideObject invert() {
        return value ? FALSE : TRUE;
    }

    @Override
    public TideBool eq(TideObject other) {
        return value == parseBool(other) ? TRUE : FALSE;
    }

    @Override
    public TideBool ne(TideObject other) {
        return value != parseBool(other) ? TRUE : FALSE;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public TideTypeObject getType() {
        return TYPE;
    }

    public Boolean getValue() {
        return value;
    }
}
