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
public class TideDouble extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("double", new HashSet<>());
    private final Double value;
    private static final Map<Double, TideDouble> cache = new HashMap<>();

    public TideDouble(Double value) {
        this.value = value;
    }

    public static TideDouble newInstance(double value) {
        if (cache.containsKey(value)) {
            return cache.get(value);
        } else {
            TideDouble tideDouble = new TideDouble(value);
            cache.put(value, tideDouble);
            return tideDouble;
        }
    }

    @Override
    public TideObject add(TideObject other) {
        Double right = parseDouble(other);
        return newInstance(value + right);
    }

    @Override
    public TideObject sub(TideObject other) {
        Double right = parseDouble(other);
        return newInstance(value - right);
    }

    @Override
    public TideObject mul(TideObject other) {
        Double right = parseDouble(other);
        return newInstance(value * right);
    }

    @Override
    public TideObject div(TideObject other) {
        Double right = parseDouble(other);
        return newInstance(value / right);
    }

    @Override
    public TideObject mod(TideObject other) {
        Double right = parseDouble(other);
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
    public TideObject pow(TideObject other) {
        return newInstance(Math.pow(value, parseDouble(other)));
    }

    @Override
    public TideBool eq(TideObject other) {
        Double right = parseDouble(other);
        return TideBool.of(value.equals(right));
    }

    @Override
    public TideBool ne(TideObject other) {
        Double right = parseDouble(other);
        return TideBool.of(!value.equals(right));
    }

    @Override
    public TideBool lt(TideObject other) {
        Double right = parseDouble(other);
        return TideBool.of(value < right);
    }

    @Override
    public TideBool le(TideObject other) {
        Double right = parseDouble(other);
        return TideBool.of(value <= right);
    }

    @Override
    public TideBool gt(TideObject other) {
        Double right = parseDouble(other);
        return TideBool.of(value > right);
    }

    @Override
    public TideBool ge(TideObject other) {
        Double right = parseDouble(other);
        return TideBool.of(value >= right);
    }

    public static Double parseDouble(TideObject object) {
        switch (object) {
            case TideDouble tideDouble -> {
                return tideDouble.value;
            }
            case TideInteger tideInteger -> {
                return tideInteger.getValue().doubleValue();
            }
            case TideLong tideLong -> {
                return tideLong.getValue().doubleValue();
            }
            case TideFloat tideFloat -> {
                return tideFloat.getValue().doubleValue();
            }
            case TideString tideString -> {
                try {
                    return Double.parseDouble(tideString.toString());
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

    public Double getValue() {
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
