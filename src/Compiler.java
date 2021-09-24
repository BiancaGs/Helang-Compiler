import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;

import ast.*;
import errorHandling.CompilerError;
import lexer.*;

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

        return program();
    }

    // Program ::= VarList { Stat }
    private Program program() {

        VarList varList = varList();

        // Stat ::= AssignStat | IfStat | ForStat | PrintStat | PrintlnStat | WhileStat
        ArrayList<Stat> statList = new ArrayList<>();

        while (lexer.token == Symbol.IDENT || lexer.token == Symbol.IF || lexer.token == Symbol.FOR
                || lexer.token == Symbol.PRINT || lexer.token == Symbol.PRINTLN || lexer.token == Symbol.WHILE) {
            Stat stat = stat();
            statList.add(stat);
            lexer.nextToken();
        }

        return null;
    }

    // VarList ::= { "var" Int Ident ";" }
    private VarList varList() {

        VarList varList = new VarList();

        while (lexer.token == Symbol.VAR) {
            lexer.nextToken();
            Variable var = variable();
            varList.addVar(var);
        }

        return varList;
    }

    // Stat ::= AssignStat | IfStat | ForStat | PrintStat | PrintlnStat | WhileStat 
    // - All above expressions classes will extend Stat
    private Stat stat() {
        Stat stat;

        if (lexer.token == Symbol.IDENT) {
            stat = assignStat();
        } else if ( lexer.token == Symbol.IF) {
            
        } else if ( lexer.token == Symbol.FOR) {
            
        } else if ( lexer.token == Symbol.PRINT) {
            
        } else if ( lexer.token == Symbol.PRINTLN) {
            
        } else if ( lexer.token == Symbol.WHILE) {
            
        }

        return null;
    }

    // AssignStat ::= Ident "=" Expr ";"
    private AssignStat assignStat() {
        
        String ident = lexer.getStringValue();
        lexer.nextToken();
        
        if (lexer.token != Symbol.ASSIGN) {
            error.signal("= expected");
        }
        lexer.nextToken();

        Expr expr = expr();

        if (lexer.token != Symbol.SEMICOLON) {
            error.signal("; expected");
        }
        lexer.nextToken();

        return new AssignStat(ident, expr);
    }

    // Expr ::= AndExpr [ "||" AndExpr ]
    private Expr expr() {
        return null;
    }

    /**
     * Auxiliary Functions and Methods
     **/

    // "var" Int Ident ";"
    private Variable variable() {

        if (!(lexer.token == Symbol.IDENT && lexer.getStringValue().equals("Int"))) {
            error.signal("Int expected");
        }
        lexer.nextToken();

        if (lexer.token != Symbol.IDENT) {
            error.signal("Ident expected");
        }
        String ident = lexer.getStringValue();
        lexer.nextToken();

        if (lexer.token != Symbol.SEMICOLON) {
            error.signal("; expected");
        }
        lexer.nextToken();

        return new Variable(ident);
    }

}
