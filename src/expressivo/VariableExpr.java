package expressivo;

/**
 * Immutable variable expression.
 *
 * Rep invariant:
 *   - name is non-null
 *   - name matches [a-zA-Z][a-zA-Z0-9]* (optional check)
 *
 * Abstraction function:
 *   AF(name) = a symbolic variable
 */
public final class VariableExpr implements Expression {

    private final String name;

    /** Constructor is package-private; use Expression.variable(). */
    VariableExpr(String name) {
        this.name = name;
        checkRep();
    }

    private void checkRep() {
        assert name != null : "variable name must not be null";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VariableExpr)) return false;
        VariableExpr other = (VariableExpr) o;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
