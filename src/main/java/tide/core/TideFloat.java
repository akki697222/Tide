package tide.core;

import tide.runtime.error.CastError;
import tide.runtime.error.TypeError;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public class TideFloat extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("float", new HashSet<>());
    private final Float value;
    private static final Map<Float, TideFloat> cache = new HashMap<Float, TideFloat>();

    public TideFloat(Float value) {
        this.value = value;
    }

    public static TideFloat newInstance(Float value) {
        if (cache.containsKey(value)) {
            return cache.get(value);
        } else {
            TideFloat tideFloat = new TideFloat(value);
            cache.put(value, tideFloat);
            return tideFloat;
        }
    }

    @Override
    public TideObject add(TideObject other) {
        Float right = parseFloat(other);
        return newInstance(value + right);
    }

    @Override
    public TideObject sub(TideObject other) {
        Float right = parseFloat(other);
        return newInstance(value - right);
    }

    @Override
    public TideObject mul(TideObject other) {
        Float right = parseFloat(other);
        return newInstance(value * right);
    }

    @Override
    public TideObject div(TideObject other) {
        Float right = parseFloat(other);
        return newInstance(value / right);
    }

    @Override
    public TideObject mod(TideObject other) {
        Float right = parseFloat(other);
        return newInstance(value % right);
    }

    @Override
    public TideObject abs() {
        return newInstance(Math.abs(value));
    }

    @Override
    public TideObject neg() {
        return newInstance(-Math.abs(value));
    }

    @Override
    public TideObject incl() {
        return newInstance(value + 1);
    }

    @Override
    public TideObject decl() {
        return newInstance(value - 1);
    }

    @Override
    public TideBool eq(TideObject other) {
        Float right = parseFloat(other);
        return TideBool.of(value.equals(right));
    }

    @Override
    public TideBool ne(TideObject other) {
        Float right = parseFloat(other);
        return TideBool.of(!value.equals(right));
    }

    @Override
    public TideBool lt(TideObject other) {
        Float right = parseFloat(other);
        return TideBool.of(value < right);
    }

    @Override
    public TideBool le(TideObject other) {
        Float right = parseFloat(other);
        return TideBool.of(value <= right);
    }

    @Override
    public TideBool gt(TideObject other) {
        Float right = parseFloat(other);
        return TideBool.of(value > right);
    }

    @Override
    public TideBool ge(TideObject other) {
        Float right = parseFloat(other);
        return TideBool.of(value >= right);
    }

    @Override
    public TideObject pow(TideObject other) {
        return newInstance((float) Math.pow(value, parseFloat(other)));
    }

    public static Float parseFloat(TideObject object) {
        switch (object) {
            case TideFloat tideFloat -> {
                return tideFloat.value;
            }
            case TideInteger tideInteger -> {
                return tideInteger.getValue().floatValue();
            }
            case TideLong tideLong -> {
                return tideLong.getValue().floatValue();
            }
            case TideDouble tideDouble -> {
                return tideDouble.getValue().floatValue();
            }
            case TideString tideString -> {
                try {
                    return Float.parseFloat(tideString.toString());
                } catch (NumberFormatException e) {
                    throw new TypeError("Cannot convert string \"" + tideString + "\" to integer format");
                }
            }
            case null, default -> throw new TypeError("Cannot convert " + object.getType() + " to int");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public TideTypeObject getType() {
        return TYPE;
    }

    public Float getValue() {
        return value;
    }

    @Override
    public TideObject copy() {
        return newInstance(value);
    }

    @Override
    public TideObject cast(TideTypeObject type) {
        if (type == TideInteger.TYPE) {
            return TideInteger.newInstance(TideInteger.parseInt(this));
        } else if (type == TideLong.TYPE) {
            return TideLong.newInstance(TideLong.parseLong(this));
        } else if (type == TideFloat.TYPE) {
            return TideFloat.newInstance(TideFloat.parseFloat(this));
        } else if (type == TideDouble.TYPE) {
            return TideDouble.newInstance(TideDouble.parseDouble(this));
        } else {
            throw new CastError("Cannot cast " + TYPE.getTypeName() + " to " + type.getTypeName());
        }
    }
}
