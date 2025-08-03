package tide.ast.statements;

import tide.ast.Program;
import tide.ast.expression.Expression;
import tide.ast.expression.LiteralExpr;
import tide.parser.NodeInfo;

import java.util.List;

public class ForIterate extends Statement {
    public final String varName;
    public final Expression value;
    public final Program body;

    public ForIterate(NodeInfo nodeInfo, String varName, Expression value, Program body) {
        super(nodeInfo);
        this.varName = varName;
        this.value = value;
        this.body = body;
    }
}