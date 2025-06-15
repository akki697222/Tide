package tide.core;

import tide.runtime.error.ReferenceError;

import java.util.HashMap;
import java.util.Map;

public class TideScope {
    public TideScope parent;
    protected Map<String, TideObject> env = new HashMap<>();

    public TideScope() {}

    public void set(String name, TideObject o) {
        if (!setParents(name, o)) {
            env.put(name, o);
        }
    }

    public void replace(String name, TideObject o) {
        if (env.containsKey(name)) {
            env.replace(name, o);
        } else if (parent != null) {
            parent.replace(name, o);
        } else {
            throw new ReferenceError(name + " is undefined");
        }
    }

    public TideObject get(String name) {
        if (env.containsKey(name)) {
            return env.get(name);
        } else if (parent != null) {
            return parent.get(name);
        } else {
            throw new ReferenceError(name + " is undefined");
        }
    }

    public boolean isEmpty() {
        return env.isEmpty();
    }

    public boolean isGlobalEmpty() {
        boolean flag = env.isEmpty();
        if (parent != null) {
            flag = parent.isGlobalEmpty();
        }
        return flag;
    }

    private boolean setParents(String name, TideObject o) {
        if (env.containsKey(name)) {
            env.replace(name, o);
            return true;
        } else if (parent != null) {
            return parent.setParents(name, o);
        } else {
            return false;
        }
    }

    public boolean contains(String name) {
        return env.containsKey(name);
    }

    public boolean contains(TideObject o) {
        return env.containsValue(o);
    }

    public boolean containsGlobal(String name) {
        if (env.containsKey(name)) {
            return true;
        } else if (parent != null) {
            return parent.containsGlobal(name);
        } else {
            return false;
        }
    }

    public boolean containsGlobal(TideObject o) {
        if (env.containsValue(o)) {
            return true;
        } else if (parent != null) {
            return parent.containsGlobal(o);
        } else {
            return false;
        }
    }

    public boolean containsParent(String name) {
        if (parent != null) {
            return parent.containsGlobal(name);
        } else {
            return false;
        }
    }

    public boolean containsParent(TideObject o) {
        if (parent != null) {
            return parent.containsGlobal(o);
        } else {
            return false;
        }
    }
}
