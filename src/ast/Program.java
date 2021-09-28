package ast;

import java.util.ArrayList;

// Program ::= VarList { Stat }
public class Program {

    private VarList varList;
    private ArrayList<Stat> statList;

    // public int run() {
    // }

    public Program(VarList varList, ArrayList<Stat> statList) {
        this.varList = varList;
        this.statList = statList;
	}

	public void genC(PW pw) {
    }
    
}
