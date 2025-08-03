package tide.ast.expression;

import tide.parser.NodeInfo;

import java.util.List;

public class SuperExpr extends Expression {
    public final List<Expression> args;

    public SuperExpr(NodeInfo nodeInfo, List<Expression> args) {
        super(nodeInfo);
        this.args = args;
    }

    @Override
    public String toString() {
        return "super(" + formatArgs(args) + ")";
    }
}
