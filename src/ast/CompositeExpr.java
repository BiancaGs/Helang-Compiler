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
        // pw.out.print("(");
        // left.genC(pw);
        // pw.out.print(" " + oper.toString() + " ");
        // right.genC(pw);
        // pw.out.print(")");
    }

    // @Override
    // public Type getType() {
    //     // left and right must be the same type
    //     if (oper == Symbol.EQ || oper == Symbol.NEQ || oper == Symbol.LE || oper == Symbol.LT || oper == Symbol.GE
    //             || oper == Symbol.GT || oper == Symbol.AND || oper == Symbol.OR)
    //         return Type.booleanType;
    //     else
    //         return Type.integerType;
    // }
    
}