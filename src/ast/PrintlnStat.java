package ast;

// PrintlnStat ::= "println" Expr ";"
public class PrintlnStat extends Stat {
    
    private Expr expr;
    
	public PrintlnStat(Expr expr) {
        this.expr = expr;
	}

}
