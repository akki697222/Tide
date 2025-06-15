package tide.ast.expression;

import tide.parser.NodeInfo;

public class NullLiteral extends LiteralExpr {
    public final Object value = null;

    public NullLiteral(NodeInfo nodeInfo) {
        super(nodeInfo);
    }

    @Override
    public String toString() {
        return "null";
    }
}
