package tide.ast.statements;

import tide.ast.Program;
import tide.parser.Modifier;
import tide.parser.NodeInfo;

import java.util.Map;
import java.util.Set;

public class FunDecl extends Statement {
    public final Program body;
    public final String name;
    public final Set<Modifier> modifiers;
    public final Map<String, String> signature;

    public FunDecl(NodeInfo nodeInfo, Program body, String name, Set<Modifier> modifiers, Map<String, String> signature) {
        super(nodeInfo);
        this.body = body;
        this.name = name;
        this.modifiers = modifiers;
        this.signature = signature;
    }

    @Override
    public String toString() {
        return formatModifiers(modifiers) + " fun " + name + "(" + formatMap(signature, " ") + ") " + formatProgramNode(body);
    }
}
