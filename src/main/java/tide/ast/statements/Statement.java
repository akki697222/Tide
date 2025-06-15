package tide.ast.statements;

import tide.ast.Node;
import tide.parser.NodeInfo;

public abstract class Statement extends Node {
    public Statement(NodeInfo nodeInfo) {
        super(nodeInfo);
    }
}
