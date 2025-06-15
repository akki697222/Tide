package tide.ast.expression;

import tide.parser.NodeInfo;

public class IntegerLiteral extends LiteralExpr {
    public final Integer value;

    public IntegerLiteral(NodeInfo nodeInfo, Integer value) {
        super(nodeInfo);
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
