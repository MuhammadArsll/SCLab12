package expressivo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExprToStringTest {

    @Test
    public void testNumberExpr() {
        Expression n = new NumberExpr(42);
        assertEquals("42", n.toString());
    }

    @Test
    public void testVariableExpr() {
        Expression x = new VariableExpr("x");
        Expression y = new VariableExpr("y");
        assertEquals("x", x.toString());
        assertEquals("y", y.toString());
    }

    @Test
    public void testPlusExprSimple() {
        Expression expr = new PlusExpr(new NumberExpr(3), new NumberExpr(4));
        assertEquals("(3 + 4)", expr.toString());
    }

    @Test
    public void testTimesExprSimple() {
        Expression expr = new TimesExpr(new NumberExpr(2), new NumberExpr(5));
        assertEquals("(2 * 5)", expr.toString());
    }

    @Test
    public void testNestedExpressions() {
        Expression expr = new PlusExpr(
                new NumberExpr(3),
                new TimesExpr(
                        new VariableExpr("x"),
                        new NumberExpr(4)
                )
        );
        // Expected fully parenthesized string
        assertEquals("(3 + (x * 4))", expr.toString());

        Expression expr2 = new TimesExpr(
                new PlusExpr(new NumberExpr(1), new NumberExpr(2)),
                new VariableExpr("y")
        );
        assertEquals("((1 + 2) * y)", expr2.toString());
    }

    @Test
    public void testDeeplyNestedExpression() {
        Expression expr = new PlusExpr(
                new TimesExpr(new NumberExpr(2), new NumberExpr(3)),
                new PlusExpr(new VariableExpr("x"), new NumberExpr(5))
        );
        assertEquals("((2 * 3) + (x + 5))", expr.toString());
    }

    @Test
    public void testMultipleNested() {
        Expression expr = new PlusExpr(
                new PlusExpr(new NumberExpr(1), new NumberExpr(2)),
                new PlusExpr(new NumberExpr(3), new NumberExpr(4))
        );
        assertEquals("((1 + 2) + (3 + 4))", expr.toString());
    }
}
