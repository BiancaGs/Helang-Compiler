package ast;

import java.util.ArrayList;

// StatList ::=  "{" { Stat } "}"
public class StatList {
    
    private ArrayList<Stat> statList;

    public StatList(ArrayList<Stat> statList) {
        this.statList = statList;
    }

}
