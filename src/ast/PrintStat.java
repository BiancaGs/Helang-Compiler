package ast;

// PrintStat ::= "print" Expr ";"
public class PrintStat extends Stat {
    
    private Expr expr;

    public PrintStat(Expr expr) {
        this.expr = expr;
    }

	@Override
	public void genC(PW pw) {
		// TODO Auto-generated method stub
		
	}

}
