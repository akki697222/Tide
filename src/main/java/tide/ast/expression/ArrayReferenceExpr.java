package tide.ast.expression;

import tide.parser.NodeInfo;

public class ArrayReferenceExpr extends ReferenceExpr {
    public final Expression arrayAccess;

    public ArrayReferenceExpr(NodeInfo nodeInfo, String identifier, Expression arrayAccess) {
        super(nodeInfo, identifier);
        this.arrayAccess = arrayAccess;
    }
}
