import java.io.PrintWriter;
import java.util.Hashtable;

import ast.*;
import errorHandling.CompilerError;
import lexer.Lexer;

public class Compiler {

    private Hashtable symbolTable;
    private CompilerError error;
    private Lexer lexer;

    public Program compile(char[] input, PrintWriter outError, PW pw) {

        symbolTable = new Hashtable();
        error = new CompilerError(outError);
        lexer = new Lexer(input, error);
        error.setLexer(lexer);

        lexer.nextToken();
        return program(pw);
    }

    private Program program(PW pw) {
        return null;
    }

}
