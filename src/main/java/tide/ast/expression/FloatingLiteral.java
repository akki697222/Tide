package tide.ast.expression;

import tide.parser.NodeInfo;

public class FloatingLiteral extends LiteralExpr {
    public final Double value;

    public FloatingLiteral(NodeInfo nodeInfo, Double value) {
        super(nodeInfo);
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
