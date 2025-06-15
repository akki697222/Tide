package tide.runtime.error;

public class JavaRuntimeError extends RuntimeException {
    public JavaRuntimeError(Throwable throwable) {
        super("A fatal error occurred at java runtime", throwable);
    }
}
