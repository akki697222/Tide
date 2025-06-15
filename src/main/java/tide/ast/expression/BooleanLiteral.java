package tide.ast.expression;

import tide.parser.NodeInfo;

public class BooleanLiteral extends LiteralExpr {
    public final Boolean value;

    public BooleanLiteral(NodeInfo nodeInfo, Boolean value) {
        super(nodeInfo);
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
