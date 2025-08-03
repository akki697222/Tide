package tide.ast.expression;

import tide.parser.NodeInfo;

public class ClassAccessorExpr extends Expression {
    public final boolean isSuper;
    public final Expression access;

    public ClassAccessorExpr(NodeInfo nodeInfo, boolean isSuper, Expression access) {
        super(nodeInfo);
        this.isSuper = isSuper;
        this.access = access;
    }
}
