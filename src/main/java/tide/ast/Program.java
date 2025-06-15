package tide.ast;

import tide.ast.statements.Statement;
import tide.parser.NodeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program extends Node {
    public final List<Node> body = new ArrayList<>();

    public Program(NodeInfo nodeInfo) {
        super(nodeInfo);
    }

    @Override
    public String toString() {
        return body.toString();
    }
}
