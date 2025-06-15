package tide.ast.expression;

import tide.parser.NodeInfo;

public class ChainExpr extends Expression {
    public final Expression left;
    public final Expression right;

    public ChainExpr(NodeInfo nodeInfo, Expression left, Expression right) {
        super(nodeInfo);
        this.left = left;
        this.right = right;
    }
}
