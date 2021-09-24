package ast;

import java.util.ArrayList;

// VarList ::= { "var" Int Ident ";" }
public class VarList {
    
    private ArrayList<Variable> varList;

    public VarList() {
        varList = new ArrayList<Variable>();
    }

    public void addVar(Variable var) {
        varList.add(var);
    }
}
