package expressivo;

/**
 * Immutable addition expression.
 *
 * Rep invariant:
 *   - left != null
 *   - right != null
 *
 * Abstraction Function:
 *   AF(left, right) = (left + right)
 *
 * Safety from rep exposure:
 *   - fields are private and final
 *   - left and right are immutable Expressions
 */
public final class PlusExpr implements Expression {

    private final Expression left;
    private final Expression right;

    /** Constructor is package-private; use Expression.plus(). */
    PlusExpr(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
    }

    private void checkRep() {
        assert left != null : "left operand must not be null";
        assert right != null : "right operand must not be null";
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PlusExpr)) return false;
        PlusExpr other = (PlusExpr) o;
        return left.equals(other.left) && right.equals(other.right);
    }

    @Override
    public int hashCode() {
        return 31 * left.hashCode() + right.hashCode();
    }
}
