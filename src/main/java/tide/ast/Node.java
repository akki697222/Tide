package tide.ast;

import tide.ast.expression.Expression;
import tide.parser.Modifier;
import tide.parser.NodeInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Node {
    public final NodeInfo nodeInfo;

    public Node(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    public static String formatMap(Map<?, ?> map, String sep) {
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append(key).append(sep).append(value).append(", "));
        return sb.substring(0, sb.length() - 2);
    }

    public static String formatArgs(List<Expression> args) {
        if (args.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        args.forEach(value -> sb.append(value).append(", "));
        return sb.substring(0, sb.length() - 2);
    }

    public static String formatProgramNode(Program program) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        program.body.forEach(node -> {
            sb.append(node).append("\n");
        });
        sb.append("}");
        return sb.toString();
    }

    public static String formatModifiers(Set<Modifier> modifiers) {
        if (modifiers.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        modifiers.forEach(modifier -> sb.append(modifier.name().toLowerCase()).append(" "));
        return sb.substring(0, sb.length() - 1);
    }
}
