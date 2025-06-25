package tide.runtime.error.internal;

import org.jetbrains.annotations.ApiStatus;
import tide.core.TideObject;

/**
 * @author akki697222
 * @since V1
 */
@ApiStatus.Internal
public class Return extends RuntimeException {
    public final TideObject result;

    public Return(TideObject result) {
        super();
        this.result = result;
    }
}
