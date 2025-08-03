package tide.ast.statements;

import tide.ast.Program;
import tide.core.Modifier;
import tide.parser.NodeInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class InterfaceDecl extends Statement {
    public final String name;
    public final Set<Modifier> modifiers;
    public final List<String> inherits;
    public final List<InterfaceMethod> methods;

    public InterfaceDecl(NodeInfo nodeInfo, String name, Set<Modifier> modifiers, List<String> inherits, List<InterfaceMethod> methods) {
        super(nodeInfo);
        this.name = name;
        this.modifiers = modifiers;
        this.inherits = inherits;
        this.methods = methods;
    }

    public record InterfaceMethod(String name, Map<String, String> signature) {}
}
