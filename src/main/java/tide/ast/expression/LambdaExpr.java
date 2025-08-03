package tide.ast.expression;

import tide.ast.Program;
import tide.parser.NodeInfo;

import java.util.List;
import java.util.Map;

public class LambdaExpr extends Expression {
    public final Map<String, String> parameters;
    public final Program program;

    public LambdaExpr(NodeInfo nodeInfo, Map<String, String> parameters, Program program) {
        super(nodeInfo);
        this.parameters = parameters;
        this.program = program;
    }
}
