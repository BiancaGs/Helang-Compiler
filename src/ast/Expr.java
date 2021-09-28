package ast;

// Expr ::= AndExpr [ "||" AndExpr ]
abstract public class Expr {

    abstract public void genC(PW pw);

    // // New Method: the type of the expression
    // abstract public Type getType();
}
