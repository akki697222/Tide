package tide.runtime.modules;

import tide.core.*;
import tide.runtime.AbstractRuntime;
import tide.runtime.Runtime;

import java.util.*;

/**
 * @author akki697222
 * @since V1
 */
public class OsModule extends Module {
    public static final class arguments extends JavaFunction {
        public arguments() {
            super(new HashMap<>());
        }

        @Override
        public TideObject invoke(Map<String, TideObject> args) {
            String[] originalArgs = AbstractRuntime.getProgramArgs();

            String[] pArgs;
            if (originalArgs.length <= 1) {
                return new TideArray("string", 0);
            } else {
                pArgs = new String[originalArgs.length - 1];
                System.arraycopy(originalArgs, 1, pArgs, 0, pArgs.length);
            }

            TideObject[] pTideArgs = new TideObject[pArgs.length];
            for (int i = 0; i < pArgs.length; i++) {
                pTideArgs[i] = new TideString(pArgs[i]);
            }
            return new TideArray(pTideArgs);
        }
    }

    @Override
    protected void onLoad(Runtime runtime) {
        TideModule module = new TideModule();
        module.setField("arguments", new arguments());
        addGlobal("os", module);
    }
}
