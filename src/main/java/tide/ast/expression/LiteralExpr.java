package tide.ast.expression;

import tide.parser.NodeInfo;

public abstract class LiteralExpr extends Expression {
    public LiteralExpr(NodeInfo nodeInfo) {
        super(nodeInfo);
    }
}
