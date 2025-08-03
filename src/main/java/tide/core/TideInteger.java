package tide.core;

import tide.runtime.error.CastError;
import tide.runtime.error.TypeError;

import java.util.HashSet;

/**
 * @author akki697222
 * @since V1
 */
public class TideInteger extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("int", new HashSet<>());
    private final Integer value;
    private static final int CACHE_LOW = -1024;
    private static final int CACHE_HIGH = 1024;
    private static final TideInteger[] cache = new TideInteger[CACHE_HIGH - CACHE_LOW + 1];

    public TideInteger(Integer value) {
        this.value = value;
    }

    static {
        for (int i = CACHE_LOW; i <= CACHE_HIGH; i++) {
            cache[i - CACHE_LOW] = new TideInteger(i);
        }
    }

    public static TideInteger newInstance(Integer integer) {
        if (integer >= CACHE_LOW && integer <= CACHE_HIGH) {
            return cache[integer - CACHE_LOW];
        }
        return new TideInteger(integer);
    }

    @Override
    public TideObject add(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value + right);
    }

    @Override
    public TideObject sub(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value - right);
    }

    @Override
    public TideObject mul(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value * right);
    }

    @Override
    public TideObject div(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value / right);
    }

    @Override
    public TideObject mod(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value % right);
    }

    @Override
    public TideObject bor(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value | right);
    }

    @Override
    public TideObject bxor(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value ^ right);
    }

    @Override
    public TideObject band(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value & right);
    }

    @Override
    public TideObject lsh(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value << right);
    }

    @Override
    public TideObject rsh(TideObject other) {
        Integer right = parseInt(other);
        return newInstance(value >> right);
    }

    @Override
    public TideObject binvert() {
        return newInstance(~value);
    }

    @Override
    public TideObject abs() {
        return newInstance(Math.abs(value));
    }

    @Override
    public TideObject neg() {
        return newInstance(-value);
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
        return newInstance((int) Math.pow(value, parseInt(other)));
    }

    @Override
    public TideBool eq(TideObject other) {
        Integer right = parseInt(other);
        return TideBool.of(value.equals(right));
    }

    @Override
    public TideBool ne(TideObject other) {
        Integer right = parseInt(other);
        return TideBool.of(!value.equals(right));
    }

    @Override
    public TideBool lt(TideObject other) {
        Integer right = parseInt(other);
        return TideBool.of(value < right);
    }

    @Override
    public TideBool le(TideObject other) {
        Integer right = parseInt(other);
        return TideBool.of(value <= right);
    }

    @Override
    public TideBool gt(TideObject other) {
        Integer right = parseInt(other);
        return TideBool.of(value > right);
    }

    @Override
    public TideBool ge(TideObject other) {
        Integer right = parseInt(other);
        return TideBool.of(value >= right);
    }

    public static Integer parseInt(TideObject object) {
        switch (object) {
            case TideInteger tideInteger -> {
                return tideInteger.value;
            }
            case TideLong tideLong -> {
                return tideLong.getValue().intValue();
            }
            case TideFloat tideFloat -> {
                return tideFloat.getValue().intValue();
            }
            case TideDouble tideDouble -> {
                return tideDouble.getValue().intValue();
            }
            case TideString tideString -> {
                try {
                    return Integer.parseInt(tideString.toString());
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

    public Integer getValue() {
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
