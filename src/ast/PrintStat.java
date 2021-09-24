package ast;

// PrintStat ::= "print" Expr ";"
public class PrintStat extends Stat {
    
    private Expr expr;

    public PrintStat(Expr expr) {
        this.expr = expr;
    }

}
