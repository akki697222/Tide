package tide.ast.statements;

import tide.ast.Program;
import tide.core.Modifier;
import tide.parser.NodeInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassDecl extends Statement {
    public final String name;
    public final Set<Modifier> modifiers;
    public final List<String> inherits;
    public final Program body;

    public ClassDecl(NodeInfo nodeInfo, String name, Set<Modifier> modifiers, List<String> inherits, Program body) {
        super(nodeInfo);
        this.name = name;
        this.modifiers = modifiers;
        this.inherits = inherits;
        this.body = body;
    }

    public static class ClassConstructor extends Statement {
        public final Program body;
        public final Modifier accessModifier;
        public final Map<String, String> signature;

        public ClassConstructor(NodeInfo nodeInfo, Program body, Modifier accessModifier, Map<String, String> signature) {
            super(nodeInfo);
            this.body = body;
            this.accessModifier = accessModifier;
            this.signature = signature;
        }
    }

    @Override
    public String toString() {
        return "ClassDecl{" +
                "name='" + name + '\'' +
                ", modifiers=" + modifiers +
                ", inherits=" + inherits +
                ", body=" + body +
                '}';
    }
}
