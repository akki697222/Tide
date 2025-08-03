package tide.ast.statements;

import tide.ast.Program;
import tide.ast.expression.Expression;
import tide.parser.NodeInfo;

public class WhileStmt extends Statement {
    public final Expression expression;
    public final Program block;

    public WhileStmt(NodeInfo nodeInfo, Expression expression, Program block) {
        super(nodeInfo);
        this.expression = expression;
        this.block = block;
    }
}
