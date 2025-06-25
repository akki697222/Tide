package tide.core;

import tide.runtime.error.TypeError;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public class TideLong extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("long", TideObject.TYPE, new HashSet<>());
    private final Long value;
    private static final Map<Long, TideLong> cache = new HashMap<>();

    public TideLong(Long value) {
        this.value = value;
    }

    public static TideLong newInstance(long value) {
        if (cache.containsKey(value)) {
            return cache.get(value);
        } else {
            TideLong tideLong = new TideLong(value);
            cache.put(value, tideLong);
            return tideLong;
        }
    }

    @Override
    public TideObject add(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value + right);
    }

    @Override
    public TideObject sub(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value - right);
    }

    @Override
    public TideObject mul(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value * right);
    }

    @Override
    public TideObject div(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value / right);
    }

    @Override
    public TideObject mod(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value % right);
    }

    @Override
    public TideObject bor(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value | right);
    }

    @Override
    public TideObject bxor(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value ^ right);
    }

    @Override
    public TideObject band(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value & right);
    }

    @Override
    public TideObject lsh(TideObject other) {
        Long right = parseLong(other);
        return newInstance(value << right);
    }

    @Override
    public TideObject rsh(TideObject other) {
        Long right = parseLong(other);
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
        Long right = parseLong(other);
        return TideBool.of(value.equals(right));
    }

    @Override
    public TideBool ne(TideObject other) {
        Long right = parseLong(other);
        return TideBool.of(!value.equals(right));
    }

    @Override
    public TideBool lt(TideObject other) {
        Long right = parseLong(other);
        return TideBool.of(value < right);
    }

    @Override
    public TideBool le(TideObject other) {
        Long right = parseLong(other);
        return TideBool.of(value <= right);
    }

    @Override
    public TideBool gt(TideObject other) {
        Long right = parseLong(other);
        return TideBool.of(value > right);
    }

    @Override
    public TideBool ge(TideObject other) {
        Long right = parseLong(other);
        return TideBool.of(value >= right);
    }

    private Long parseLong(TideObject object) {
        switch (object) {
            case TideLong tideLong -> {
                return tideLong.value;
            }
            case TideInteger tideInteger -> {
                return tideInteger.getValue().longValue();
            }
            case TideFloat tideFloat -> {
                return tideFloat.getValue().longValue();
            }
            case TideDouble tideDouble -> {
                return tideDouble.getValue().longValue();
            }
            case TideString tideString -> {
                try {
                    return Long.parseLong(tideString.toString());
                } catch (NumberFormatException e) {
                    throw new TypeError("Cannot convert string \"" + tideString + "\" to long format");
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

    public Long getValue() {
        return value;
    }
}
