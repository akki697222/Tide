import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import tide.ast.Program;
import tide.compiler.TideLexer;
import tide.compiler.TideParser;
import tide.core.JavaFunction;
import tide.core.TideASTProgram;
import tide.core.TideObject;
import tide.parser.ASTParser;
import tide.runtime.error.RuntimeError;
import tide.runtime.interpreter.Interpreter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        CharStream source = CharStreams.fromFileName(args[0]);
        TideLexer lexer = new TideLexer(source);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TideParser parser = new TideParser(tokens);
        TideParser.RootContext root = parser.root();
        TreeViewer viewer = new TreeViewer(Arrays.stream(parser.getRuleNames()).toList(), root);
        //viewer.open();
        ASTParser astParser = new ASTParser();
        Program program = (Program) astParser.visitRoot(root);
        System.out.println(program.body);
        Interpreter interpreter = new Interpreter();
        interpreter.env().set("print", new JavaFunction(Map.of("message", "object")) {
            @Override
            public TideObject invoke(Map<String, TideObject> args) {
                System.out.println(args.get("message"));
                return NULL;
            }
        });
        interpreter.execute(new TideASTProgram(program));
    }
}
