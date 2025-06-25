package tide.runtime.modules;

import tide.core.*;
import tide.runtime.Runtime;
import tide.runtime.error.TypeError;

import java.util.Map;

/**
 * Provides basic mathematical functions to the Tide runtime.
 *
 * <p>This module registers under the global name {@code math} and includes
 * utility functions such as {@code abs}, {@code min}, {@code max}, {@code pow}, {@code sqrt},
 * {@code log}, {@code exp}, {@code round}, {@code floor}, and {@code ceil}.
 *
 * @author akki697222
 * @since V1
 */
public class MathModule extends Module {

    public static final class abs extends JavaFunction {
        public abs() {
            super(Map.of("a", "int"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            return args.get("a").abs();
        }
    }

    public static final class min extends JavaFunction {
        public min() {
            super(Map.of("a", "int", "b", "int"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            return ((TideInteger) args.get("a")).getValue() <= ((TideInteger) args.get("b")).getValue()
                    ? args.get("a")
                    : args.get("b");
        }
    }

    public static final class max extends JavaFunction {
        public max() {
            super(Map.of("a", "int", "b", "int"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            return ((TideInteger) args.get("a")).getValue() >= ((TideInteger) args.get("b")).getValue()
                    ? args.get("a")
                    : args.get("b");
        }
    }

    public static final class pow extends JavaFunction {
        public pow() {
            super(Map.of("a", "double", "b", "double"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            double base = ((TideDouble) args.get("a")).getValue();
            double exponent = ((TideDouble) args.get("b")).getValue();
            return new TideDouble(Math.pow(base, exponent));
        }
    }

    public static final class sqrt extends JavaFunction {
        public sqrt() {
            super(Map.of("a", "double"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            double val = ((TideDouble) args.get("a")).getValue();
            if (val < 0) throw new TypeError("sqrt: negative input");
            return new TideDouble(Math.sqrt(val));
        }
    }

    public static final class log extends JavaFunction {
        public log() {
            super(Map.of("a", "double"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            double val = ((TideDouble) args.get("a")).getValue();
            if (val <= 0) throw new TypeError("log: non-positive input");
            return new TideDouble(Math.log(val));
        }
    }

    public static final class exp extends JavaFunction {
        public exp() {
            super(Map.of("a", "double"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            double val = ((TideDouble) args.get("a")).getValue();
            return new TideDouble(Math.exp(val));
        }
    }

    public static final class round extends JavaFunction {
        public round() {
            super(Map.of("a", "double"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            double val = ((TideDouble) args.get("a")).getValue();
            return new TideLong(Math.round(val));
        }
    }

    public static final class floor extends JavaFunction {
        public floor() {
            super(Map.of("a", "double"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            double val = ((TideDouble) args.get("a")).getValue();
            return new TideInteger((int) Math.floor(val));
        }
    }

    public static final class ceil extends JavaFunction {
        public ceil() {
            super(Map.of("a", "double"));
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            double val = ((TideDouble) args.get("a")).getValue();
            return new TideInteger((int) Math.ceil(val));
        }
    }

    @Override
    protected void onLoad(Runtime runtime) {
        TideModule module = new TideModule();
        module.setField("abs", new abs());
        module.setField("min", new min());
        module.setField("max", new max());
        module.setField("pow", new pow());
        module.setField("sqrt", new sqrt());
        module.setField("log", new log());
        module.setField("exp", new exp());
        module.setField("round", new round());
        module.setField("floor", new floor());
        module.setField("ceil", new ceil());
        addGlobal("math", module);
    }
}
