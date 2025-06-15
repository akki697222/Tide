package tide.ast.expression;

import tide.parser.NodeInfo;

public class ReferenceExpr extends Expression {
    public final String identifier;

    public ReferenceExpr(NodeInfo nodeInfo, String identifier) {
        super(nodeInfo);
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
