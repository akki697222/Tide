package tide.ast.expression;

import tide.ast.UnaryOperator;
import tide.parser.NodeInfo;

public class UnaryOperationExpr extends Expression {
    public final UnaryOperator operator;
    public final Expression operand;

    public UnaryOperationExpr(NodeInfo nodeInfo, UnaryOperator operator, Expression operand) {
        super(nodeInfo);
        this.operator = operator;
        this.operand = operand;
    }
}
