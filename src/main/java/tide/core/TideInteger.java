package tide.core;

import tide.runtime.error.TypeError;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TideInteger extends TideObject {
    public static final TideTypeObject TYPE = new TideTypeObject("int", TideObject.TYPE, new HashSet<>());
    private final Integer value;
    private static final Map<Integer, TideInteger> cache = new HashMap<>();

    public TideInteger(Integer value) {
        this.value = value;
    }

    public static TideInteger newInstance(Integer integer) {
        if (cache.containsKey(integer)) {
            return cache.get(integer);
        } else {
            TideInteger tideInteger = new TideInteger(integer);
            cache.put(integer, tideInteger);
            return tideInteger;
        }
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
    public TideObject abs(TideObject other) {
        return newInstance(Math.abs(value));
    }

    @Override
    public TideObject neg(TideObject other) {
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

    private Integer parseInt(TideObject object) {
        if (object instanceof TideInteger tideInteger) {
            return tideInteger.value;
        } else if (object instanceof TideString tideString) {
            try {
                return Integer.parseInt(tideString.toString());
            } catch (NumberFormatException e) {
                throw new TypeError("Cannot convert string \"" + tideString + "\" to integer format");
            }
        } else {
            throw new TypeError("Cannot convert " + object.getType() + " to int");
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
}
