package tide.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tide.runtime.Runtime;
import tide.runtime.error.UnsupportedBinaryOperationError;

import java.io.Serializable;
import java.util.*;

/**
 * @author akki697222
 * @since V1
 */
public class TideObject implements Serializable {
    public static final TideObject NULL = new TideObject() {
        final TideTypeObject TYPE_NULL = new TideTypeObject("null", null, new HashSet<>());

        @Override
        public TideTypeObject getType() {
            return TYPE_NULL;
        }
    };
    public static final TideTypeObject TYPE = new TideTypeObject("object", null, new HashSet<>());
    private static final Logger log = LoggerFactory.getLogger(TideObject.class);
    public static Runtime runtime;

    protected final Map<String, TideObject> fields = new HashMap<>();

    protected TideObject() {

    }

    public static void initializeForExecute(Runtime runtime) {
        TideObject.runtime = runtime;
    }

    public TideObject getField(String name) {
        return fields.getOrDefault(name, NULL);
    }

    public void setField(String name, TideObject object) {
        if (fields.containsKey(name)) {
            fields.replace(name, object);
        } else {
            fields.put(name, object);
        }
    }

    public TideObject add(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject sub(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject mul(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject div(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject mod(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject bor(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject bxor(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject band(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideBool eq(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideBool ne(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideBool lt(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideBool le(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideBool gt(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideBool ge(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideBool or(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideBool and(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject lsh(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject rsh(TideObject other) {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject binvert() {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject invert() {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject abs() {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject neg() {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject incl() {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideObject decl() {
        throw new UnsupportedBinaryOperationError("");
    }

    public TideTypeObject getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return getType().getTypeName() + "#" + HexFormat.of().toHexDigits(System.identityHashCode(this));
    }
}
