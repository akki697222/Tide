package tide.runtime.error;

/**
 * @author akki697222
 * @since V1
 */
public class JavaRuntimeError extends RuntimeException {
    public JavaRuntimeError(Throwable throwable) {
        super("A fatal error occurred at java runtime", throwable);
    }
}
