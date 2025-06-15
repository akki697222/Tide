package tide.runtime.error.internal;

import tide.core.TideObject;

public class Return extends RuntimeException {
    public final TideObject result;

    public Return(TideObject result) {
        super();
        this.result = result;
    }
}
