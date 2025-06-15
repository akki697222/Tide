package tide.parser;

public record NodeInfo(int line, int column) {
    public static final NodeInfo ZERO = new NodeInfo(0, 0);
}
