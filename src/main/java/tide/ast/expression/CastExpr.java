package tide.ast.expression;

import tide.parser.NodeInfo;

public class CastExpr extends Expression {
    public final String type;
    public final Expression right;

    public CastExpr(NodeInfo nodeInfo, String type, Expression right) {
        super(nodeInfo);
        this.type = type;
        this.right = right;
    }
}
