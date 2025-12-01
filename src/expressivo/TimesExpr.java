package expressivo;

public final class TimesExpr implements Expression {

    private final Expression left;
    private final Expression right;

    TimesExpr(Expression left, Expression right) {
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
        // Parenthesize binary multiplication to preserve structure
        return "(" + left.toString() + " * " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TimesExpr)) return false;
        TimesExpr other = (TimesExpr) o;
        return left.equals(other.left) && right.equals(other.right);
    }

    @Override
    public int hashCode() {
        return 37 * left.hashCode() + right.hashCode();
    }
}
