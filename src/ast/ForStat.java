package ast;

// ForStat ::= "for" Id "in" Expr ".." Expr StatList
public class ForStat extends Stat {

    private String ident;
    private Expr leftExpr;
    private Expr rightExpr;
    private StatList statList;

    public ForStat(String ident, Expr leftExpr, Expr rightExpr, StatList statList) {
        this.ident = ident;
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
        this.statList = statList;
    }

    @Override
    public void genC(PW pw) {
        // TODO Auto-generated method stub
        
    }

}
