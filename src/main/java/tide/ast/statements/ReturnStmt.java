package tide.ast.statements;

import tide.ast.expression.Expression;
import tide.parser.NodeInfo;

public class ReturnStmt extends Statement {
    public final Expression expression;

    public ReturnStmt(NodeInfo nodeInfo, Expression expression) {
        super(nodeInfo);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "ret " + expression;
    }
}
