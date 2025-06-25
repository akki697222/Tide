package tide.core;

import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public abstract class TideProgram {
    public abstract TideObject invoke(Map<String, TideObject> args);
    public abstract TideObject invoke(TideObject self, Map<String, TideObject> args);
    public abstract TideObject invoke();
    public abstract TideObject invoke(TideObject self);
    public abstract int line();
    public abstract int column();
    public abstract String getSource();
    public abstract String getSourceType();
}
