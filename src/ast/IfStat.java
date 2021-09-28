package ast;

// IfStat ::= "if" Expr StatList [ "else" StatList ]
public class IfStat extends Stat {

    private Expr expr;
    private StatList leftStatList;
    private StatList rightStatList;

    public IfStat(Expr expr, StatList leftStatList, StatList rightStatList) {
        this.expr = expr;
        this.leftStatList = leftStatList;
        this.rightStatList = rightStatList;
    }

    @Override
    public void genC(PW pw) {
        // TODO Auto-generated method stub
        
    }
    
}
