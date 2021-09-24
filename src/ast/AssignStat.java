package ast;

// AssignStat ::= Ident "=" Expr ";"
public class AssignStat extends Stat {
    
    private String ident;
    private Expr expr;

    public AssignStat(String ident, Expr expr) {
        this.ident = ident;
        this.expr = expr;
    }

}
