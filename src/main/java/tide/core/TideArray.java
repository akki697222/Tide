package tide.core;

import tide.runtime.error.IndexOutOfBoundsError;
import tide.runtime.error.TypeError;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author akki697222
 * @since V1
 */
public class TideArray extends TideObject {
    private final TideTypeObject type;
    private final TideObject[] value;
    private final int cap;

    public TideArray(String typeName, int initialCapacity) {
        this.cap = initialCapacity;
        value = new TideObject[initialCapacity];
        setField("len", TideInteger.newInstance(initialCapacity));
        type = new TideTypeObject(typeName + "[]", new HashSet<>());
    }

    public TideArray(TideObject[] value) {
        this.value = value;
        if (value.length > 0) {
            type = new TideTypeObject(value[0].getType().getTypeName() + "[]", new HashSet<>());
        } else {
            throw new IllegalArgumentException("type required for array initialize");
        }
        this.cap = value.length;
        setField("len", TideInteger.newInstance(value.length));
    }

    public TideObject get(TideObject i) {
        if (i instanceof TideInteger tideInteger) {
            return get(tideInteger);
        } else {
            throw new TypeError("Array access must be integer");
        }
    }

    public TideObject get(TideInteger i) {
        return get(i.getValue());
    }

    public TideObject get(int i) {
        if (i > value.length) {
            throw new IndexOutOfBoundsError("index " + i + " out of bounds " + value.length);
        } else {
            return value[i];
        }
    }

    public void set(TideInteger i, TideObject o) {
        set(i.getValue(), o);
    }

    public void set(int i, TideObject o) {
        if (i > value.length) {
            throw new IndexOutOfBoundsError("index " + i + " out of bounds " + value.length);
        } else {
            value[i] = o;
        }
    }

    public TideObject[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }

    @Override
    public TideTypeObject getType() {
        return type;
    }

    @Override
    public TideObject copy() {
        TideObject[] newArray = new TideObject[cap];
        System.arraycopy(value, 0, newArray, 0, cap);
        return new TideArray(newArray);
    }

    public int length() {
        return cap;
    }


}
