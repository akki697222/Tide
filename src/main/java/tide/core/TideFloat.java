package tide.core;

import tide.runtime.error.TypeError;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public class TideFloat extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("double", TideObject.TYPE, new HashSet<>());
    private final Float value;
    private static final Map<Float, TideFloat> cache = new HashMap<Float, TideFloat>();

    public TideFloat(Float value) {
        this.value = value;
    }

    public static TideFloat newInstance(Float value) {
        if (cache.containsKey(value)) {
            return cache.get(value);
        } else {
            TideFloat tideDouble = new TideFloat(value);
            cache.put(value, tideDouble);
            return tideDouble;
        }
    }

    @Override
    public TideObject add(TideObject other) {
        Float right = parseDouble(other);
        return newInstance(value + right);
    }

    @Override
    public TideObject sub(TideObject other) {
        Float right = parseDouble(other);
        return newInstance(value - right);
    }

    @Override
    public TideObject mul(TideObject other) {
        Float right = parseDouble(other);
        return newInstance(value * right);
    }

    @Override
    public TideObject div(TideObject other) {
        Float right = parseDouble(other);
        return newInstance(value / right);
    }

    @Override
    public TideObject mod(TideObject other) {
        Float right = parseDouble(other);
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
        Float right = parseDouble(other);
        return TideBool.of(value.equals(right));
    }

    @Override
    public TideBool ne(TideObject other) {
        Float right = parseDouble(other);
        return TideBool.of(!value.equals(right));
    }

    @Override
    public TideBool lt(TideObject other) {
        Float right = parseDouble(other);
        return TideBool.of(value < right);
    }

    @Override
    public TideBool le(TideObject other) {
        Float right = parseDouble(other);
        return TideBool.of(value <= right);
    }

    @Override
    public TideBool gt(TideObject other) {
        Float right = parseDouble(other);
        return TideBool.of(value > right);
    }

    @Override
    public TideBool ge(TideObject other) {
        Float right = parseDouble(other);
        return TideBool.of(value >= right);
    }

    private Float parseDouble(TideObject object) {
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
}
