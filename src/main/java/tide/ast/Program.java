package tide.ast;

import tide.ast.statements.Statement;
import tide.parser.NodeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program extends Node {
    public final List<Node> body = new ArrayList<>();
    public final String source;
    public final SourceType sourceType;

    public Program(NodeInfo nodeInfo, String source, SourceType sourceType) {
        super(nodeInfo);
        this.source = source;
        this.sourceType = sourceType;
    }

    public Program(NodeInfo nodeInfo) {
        super(nodeInfo);
        this.source = "(unknown)";
        this.sourceType = SourceType.UNKNOWN;
    }

    @Override
    public String toString() {
        return body.toString();
    }

    public enum SourceType {
        PROGRAM("program"),
        FUNCTION("function"),
        JAVA("java function"),
        UNKNOWN("");

        public final String id;
        SourceType(String id) {
            this.id = id;
        }
    }
}
