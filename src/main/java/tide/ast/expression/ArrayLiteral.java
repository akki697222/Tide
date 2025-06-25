package tide.ast.expression;

import tide.parser.NodeInfo;

import java.util.List;

public class ArrayLiteral extends LiteralExpr {
    public final List<Expression> elements;

    public ArrayLiteral(NodeInfo nodeInfo, List<Expression> elements) {
        super(nodeInfo);
        this.elements = elements;
    }
}
