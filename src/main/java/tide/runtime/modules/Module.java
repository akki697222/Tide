package tide.runtime.modules;

import tide.core.TideObject;
import tide.runtime.Runtime;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public abstract class Module {
    private final Map<String, TideObject> globals = new HashMap<>();

    public final void load(Runtime runtime) {
        onLoad(runtime);
        globals.forEach((name, obj) -> runtime.env().set(name, obj));
    }

    protected final void addGlobal(String name, TideObject o) {
        globals.put(name, o);
    }

    protected abstract void onLoad(Runtime runtime);
}
