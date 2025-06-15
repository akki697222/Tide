package tide.ast.statements;

import tide.ast.Program;
import tide.ast.expression.Expression;
import tide.parser.NodeInfo;

import java.util.List;

public class IfStmt extends Statement {
    public final Expression expression;
    public final Program body;
    public final List<ElseIf> elseIfs;
    public final Else ifElse;

    public IfStmt(NodeInfo nodeInfo, Expression expression, Program body, List<ElseIf> elseIfs, Else ifElse) {
        super(nodeInfo);
        this.expression = expression;
        this.body = body;
        this.elseIfs = elseIfs;
        this.ifElse = ifElse;
    }

    public static class ElseIf extends Statement {
        public final Expression expression;
        public final Program body;

        public ElseIf(NodeInfo nodeInfo, Expression expression, Program body) {
            super(nodeInfo);
            this.expression = expression;
            this.body = body;
        }

        @Override
        public String toString() {
            return "elseif " + expression + " " + formatProgramNode(body);
        }
    }

    public static class Else extends Statement {
        public final Program body;

        public Else(NodeInfo nodeInfo, Program body) {
            super(nodeInfo);
            this.body = body;
        }

        @Override
        public String toString() {
            return "else " + formatProgramNode(body);
        }
    }

    @Override
    public String toString() {
        return "if " + expression + " " + formatProgramNode(body) + (!elseIfs.isEmpty() ? getFormatElseIf() : "") + (ifElse != null ? " " + ifElse : "");
    }

    private String getFormatElseIf() {
        StringBuilder sb = new StringBuilder();
        elseIfs.forEach(elseIf -> sb.append(elseIf).append(" "));
        return sb.substring(0, sb.length() - 1);
    }
}
