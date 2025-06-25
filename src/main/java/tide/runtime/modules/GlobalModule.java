package tide.runtime.modules;

import tide.core.JavaFunction;
import tide.core.TideObject;
import tide.core.TideString;
import tide.runtime.Runtime;

import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public class GlobalModule extends Module {
    public static final class print extends JavaFunction {
        public print() {
            super(Map.of("message", "object"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            System.out.println(args.get("message"));
            return NULL;
        }
    }

    public static final class type extends JavaFunction {
        public type() {
            super(Map.of("o", "object"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            return new TideString(args.get("o").getType().getTypeName());
        }
    }

    @Override
    protected void onLoad(Runtime runtime) {
        addGlobal("print", new print());
        addGlobal("type", new type());
    }
}
