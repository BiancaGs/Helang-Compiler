package ast;

import lexer.*;

public class CompositeExpr extends Expr {

    private Expr left, right;
    private Symbol oper;

    public CompositeExpr(Expr pleft, Symbol poper, Expr pright) {
        this.left = pleft;
        this.oper = poper;
        this.right = pright;
    }

    @Override
    public void genC(PW pw) {
        pw.out.print("(");
        left.genC(pw);
        pw.out.print(" " + oper.toString() + " ");
        right.genC(pw);
        pw.out.print(")");
    }

}