package ast;

// PrintlnStat ::= "println" Expr ";"
public class PrintlnStat extends Stat {
    
    private Expr expr;
    
	public PrintlnStat(Expr expr) {
        this.expr = expr;
	}

    @Override
    public void genC(PW pw) {
        // TODO Auto-generated method stub
        
    }

}
