package ast;

// WhileStat ::= "while" Expr StatList
public class WhileStat extends Stat {

    private Expr expr;
    private StatList statList;

    public WhileStat(Expr expr, StatList statList) {
        this.expr = expr;
        this.statList = statList;
    }

    @Override
    public void genC(PW pw) {
        
        
    }

}
