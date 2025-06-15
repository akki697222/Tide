package tide.ast.expression;

import tide.parser.NodeInfo;

public class StringLiteral extends LiteralExpr {
    public final String value;

    public StringLiteral(NodeInfo nodeInfo, String value) {
        super(nodeInfo);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
