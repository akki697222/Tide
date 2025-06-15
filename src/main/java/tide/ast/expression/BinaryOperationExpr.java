package tide.ast.expression;

import tide.ast.BinaryOperator;
import tide.parser.NodeInfo;

public class BinaryOperationExpr extends Expression {
    public final BinaryOperator operator;
    public final Expression left;
    public final Expression right;

    public BinaryOperationExpr(NodeInfo nodeInfo, BinaryOperator operator, Expression left, Expression right) {
        super(nodeInfo);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left + " " + operator.getSymbol() + " " + right;
    }
}
