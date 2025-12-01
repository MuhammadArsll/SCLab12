package expressivo;

/**
 * Immutable numeric literal expression.
 *
 * Rep invariant:
 *    No constraints (any int is valid)
 *
 * Abstraction function:
 *   AF(value) = the integer literal represented by 'value'
 *
 * Safety from rep exposure:
 *    All fields are private and final.
 *    No mutable objects are exposed.
 */
public final class NumberExpr implements Expression {

    private final int value;

    /** Constructor is package-private; use Expression.number() instead. */
    NumberExpr(int value) {
        this.value = value;
        checkRep();
    }

    private void checkRep() { /* nothing to check */ }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NumberExpr)) return false;
        NumberExpr other = (NumberExpr) o;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
