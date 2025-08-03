package tide.runtime.modules;

import tide.core.JavaFunction;
import tide.core.TideObject;
import tide.core.TideString;
import tide.runtime.Runtime;
import tide.runtime.error.JavaRuntimeError;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * @author akki697222
 * @since V1
 */
public class GlobalModule extends Module {
    public static final class print extends JavaFunction {
        public static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        public print() {
            super(Map.of("message", "object"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            try {
                out.write(args.get("message").toString());
                out.newLine();
                out.flush();
            } catch (IOException e) {
                throw new JavaRuntimeError(e);
            }
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
