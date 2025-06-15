package tide.core;

import java.util.Map;

public abstract class TideProgram {
    public abstract TideObject invoke(Map<String, TideObject> args);
    public abstract TideObject invoke(TideObject self, Map<String, TideObject> args);
    public abstract TideObject invoke();
    public abstract TideObject invoke(TideObject self);
}
