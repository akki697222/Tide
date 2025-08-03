package tide.core;

import tide.runtime.error.AttributeError;
import tide.runtime.error.ReferenceError;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author akki697222
 * @since V1
 */
public class TideScope {
    public TideScope parent;
    protected Map<String, TideObjectHolder> env = new HashMap<>();

    public TideScope() {}

    public void set(String name, TideObject o) {
        if (!setParents(name, o)) {
            env.put(name, new TideObjectHolder(o, new HashSet<>()));
        }
    }

    public void replace(String name, TideObject o) {
        if (env.containsKey(name)) {
            TideObjectHolder holder = env.get(name);
            if (holder.modifiers().contains(Modifier.FINAL)) {
                throw new AttributeError("Attempt to change read-only variable");
            } else {
                env.replace(name, new TideObjectHolder(o, new HashSet<>()));
            }
        } else if (parent != null) {
            parent.replace(name, o);
        } else {
            throw new ReferenceError(name + " is undefined");
        }
    }

    public TideObject get(String name) {
        if (env.containsKey(name)) {
            return env.get(name).object();
        } else if (parent != null) {
            return parent.get(name);
        } else {
            throw new ReferenceError(name + " is undefined");
        }
    }

    public void set(String name, TideObjectHolder o) {
        if (!setParents(name, o)) {
            env.put(name, o);
        }
    }

    public void replace(String name, TideObjectHolder o) {
        if (env.containsKey(name)) {
            TideObjectHolder holder = env.get(name);
            if (holder.modifiers().contains(Modifier.FINAL)) {
                throw new AttributeError("Attempt to change read-only variable");
            } else {
                env.replace(name, o);
            }
        } else if (parent != null) {
            parent.replace(name, o);
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
            TideObjectHolder holder = env.get(name);
            if (holder.modifiers().contains(Modifier.FINAL)) {
                throw new AttributeError("Attempt to change read-only variable");
            } else {
                env.replace(name, new TideObjectHolder(o, new HashSet<>()));
            }
            return true;
        } else if (parent != null) {
            return parent.setParents(name, o);
        } else {
            return false;
        }
    }

    private boolean setParents(String name, TideObjectHolder o) {
        if (env.containsKey(name)) {
            TideObjectHolder holder = env.get(name);
            if (holder.modifiers().contains(Modifier.FINAL)) {
                throw new AttributeError("Attempt to change read-only variable");
            } else {
                env.replace(name, o);
            }
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

    public boolean containsGlobal(String name) {
        if (env.containsKey(name)) {
            return true;
        } else if (parent != null) {
            return parent.containsGlobal(name);
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

    @Override
    public String toString() {
        return env.toString();
    }
}
