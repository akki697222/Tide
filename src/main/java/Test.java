import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tide.ast.Program;
import tide.compiler.TideLexer;
import tide.compiler.TideParser;
import tide.core.JavaFunction;
import tide.core.TideASTProgram;
import tide.core.TideObject;
import tide.parser.ASTParser;
import tide.runtime.error.RuntimeError;
import tide.runtime.interpreter.Interpreter;
import tide.runtime.modules.GlobalModule;
import tide.runtime.modules.MathModule;
import tide.runtime.modules.OsModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        System.out.println("Running on " + interpreter.getVersion() + " (" + interpreter.getEngineVersion() + " Engine)");
        try {
            CharStream source = CharStreams.fromFileName(args[0]);
            TideLexer lexer = new TideLexer(source);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TideParser parser = new TideParser(tokens);
            TideParser.RootContext root = parser.root();
            TreeViewer viewer = new TreeViewer(Arrays.stream(parser.getRuleNames()).toList(), root);
            //viewer.open();
            ASTParser astParser = new ASTParser();
            Program program = (Program) astParser.parse(root, args[0]);
            interpreter.addModule(new GlobalModule());
            interpreter.addModule(new MathModule());
            interpreter.addModule(new OsModule());
            System.out.println(program);
            List<Long> result = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                long start = System.currentTimeMillis();
                interpreter.execute(new TideASTProgram(program), args);
                long end = System.currentTimeMillis();
                System.out.println("[" + (i + 1) + "回目] 実行時間: " + (end - start) + "ms");
                result.add(end - start);
            }
            long sum = 0;
            for (long l : result) {
                sum += l;
            }
            System.out.println("実行速度の平均値: " + (sum / result.size()) + "ms");
        } catch (Exception e) {
            interpreter.printStackTrace(e);
        }
    }
}
