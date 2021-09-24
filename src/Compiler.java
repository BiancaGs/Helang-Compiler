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
            stat = ifStat();
        } else if ( lexer.token == Symbol.FOR) {
            stat = forStat();
        } else if ( lexer.token == Symbol.PRINT) {
            
        } else if ( lexer.token == Symbol.PRINTLN) {
            
        } else if ( lexer.token == Symbol.WHILE) {
            
        }
        return null;
    }

    // IfStat ::= "if" Expr StatList [ "else" StatList ]
    private IfStat ifStat() {

        lexer.nextToken();

        Expr expr = expr();

        StatList leftStatList = statList();

        StatList rightStatList = null;

        if (lexer.token == Symbol.ELSE) {
            lexer.nextToken();
            rightStatList = statList();
        }
        
        return new IfStat(expr, leftStatList, rightStatList);
    }

    // ForStat ::= "for" Id "in" Expr ".." Expr StatList
    private ForStat forStat() {

        lexer.nextToken();

        if (lexer.token != Symbol.IDENT) {
            error.signal("Identifier expected");
        }
        
        String ident = lexer.getStringValue();
        lexer.nextToken();

        if (lexer.token != Symbol.IN) {
            error.signal("in expected");
        }
        lexer.nextToken();

        Expr leftExpr = expr();
        
        if (lexer.token != Symbol.DOTDOT) {
            error.signal(".. expected");
        }
        lexer.nextToken();

        Expr rightExpr = expr();

        StatList statList = statList();
        
        return new ForStat(ident, leftExpr, rightExpr, statList);
    }

    // StatList ::=  "{" { Stat } "}"
    private StatList statList() {

        if (lexer.token != Symbol.LEFTBRACE) {
            error.signal("{ expected");
        }
        lexer.nextToken();

        // Stat ::= AssignStat | IfStat | ForStat | PrintStat | PrintlnStat | WhileStat
        ArrayList<Stat> statList = new ArrayList<>();

        while (lexer.token == Symbol.IDENT || lexer.token == Symbol.IF || lexer.token == Symbol.FOR
                || lexer.token == Symbol.PRINT || lexer.token == Symbol.PRINTLN || lexer.token == Symbol.WHILE) {
            Stat stat = stat();
            statList.add(stat);
            lexer.nextToken();
        }

        if (lexer.token != Symbol.RIGHTBRACE) {
            error.signal("} expected");
        }
        lexer.nextToken();

        return new StatList(statList);
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
