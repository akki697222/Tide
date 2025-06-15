package tide.ast.expression;

import tide.parser.NodeInfo;

import java.util.List;

public class FunCall extends Expression {
    public final String identifier;
    public final List<Expression> args;

    public FunCall(NodeInfo nodeInfo, String identifier, List<Expression> args) {
        super(nodeInfo);
        this.identifier = identifier;
        this.args = args;
    }

    @Override
    public String toString() {
        return identifier + "(" + formatArgs(args) + ")";
    }
}
