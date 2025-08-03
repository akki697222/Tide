package tide.ast.statements;

import tide.ast.Program;
import tide.ast.expression.Expression;
import tide.parser.NodeInfo;

public class ForNumerical extends Statement {
    public final boolean exclusive;
    public final String varName;
    public final Expression left;
    public final Expression right;
    public final Program body;

    public ForNumerical(NodeInfo nodeInfo, boolean exclusive, String varName, Expression left, Expression right, Program body) {
        super(nodeInfo);
        this.exclusive = exclusive;
        this.varName = varName;
        this.left = left;
        this.right = right;
        this.body = body;
    }
}
