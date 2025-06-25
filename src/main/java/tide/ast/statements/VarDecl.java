package tide.ast.statements;

import tide.ast.expression.Expression;
import tide.core.Modifier;
import tide.parser.NodeInfo;

import java.util.Set;

public class VarDecl extends Statement {
    public final String name;
    public final Set<Modifier> modifiers;
    public final String type;
    public final Expression initializer;

    public VarDecl(NodeInfo nodeInfo, String name, Set<Modifier> modifiers, String type, Expression initializer) {
        super(nodeInfo);
        this.name = name;
        this.modifiers = modifiers;
        this.type = type;
        this.initializer = initializer;
    }
}
