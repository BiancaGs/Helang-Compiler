package ast;

// "var" Int Ident ";"
public class Variable {

    private String ident;

    public Variable(String ident) {
        this.ident = ident;
    }

    public String getName() {
        return ident;
    }
}
