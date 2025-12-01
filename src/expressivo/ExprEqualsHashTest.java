package expressivo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExprEqualsHashTest {

    @Test
    public void testNumberExprEquality() {
        Expression n1 = new NumberExpr(5);
        Expression n2 = new NumberExpr(5);
        Expression n3 = new NumberExpr(10);

        assertTrue(n1.equals(n2), "Numbers with same value should be equal");
        assertEquals(n1.hashCode(), n2.hashCode(), "Hash codes must match for equal numbers");
        assertFalse(n1.equals(n3), "Different numbers should not be equal");
    }

    @Test
    public void testVariableExprEquality() {
        Expression x1 = new VariableExpr("x");
        Expression x2 = new VariableExpr("x");
        Expression y = new VariableExpr("y");

        assertTrue(x1.equals(x2), "Variables with same name should be equal");
        assertEquals(x1.hashCode(), x2.hashCode(), "Hash codes must match for equal variables");
        assertFalse(x1.equals(y), "Different variables should not be equal");
    }

    @Test
    public void testPlusExprEquality() {
        Expression e1 = new PlusExpr(new NumberExpr(1), new VariableExpr("x"));
        Expression e2 = new PlusExpr(new NumberExpr(1), new VariableExpr("x"));
        Expression e3 = new PlusExpr(new VariableExpr("x"), new NumberExpr(1));

        assertTrue(e1.equals(e2), "PlusExpr with same left/right should be equal");
        assertEquals(e1.hashCode(), e2.hashCode(), "Hash codes must match for equal PlusExpr");
        assertFalse(e1.equals(e3), "PlusExpr with swapped operands should not be equal");
    }

    @Test
    public void testTimesExprEquality() {
        Expression e1 = new TimesExpr(new NumberExpr(2), new VariableExpr("y"));
        Expression e2 = new TimesExpr(new NumberExpr(2), new VariableExpr("y"));
        Expression e3 = new TimesExpr(new VariableExpr("y"), new NumberExpr(2));

        assertTrue(e1.equals(e2), "TimesExpr with same left/right should be equal");
        assertEquals(e1.hashCode(), e2.hashCode(), "Hash codes must match for equal TimesExpr");
        assertFalse(e1.equals(e3), "TimesExpr with swapped operands should not be equal");
    }

    @Test
    public void testNestedExpressionsEquality() {
        Expression nested1 = new PlusExpr(
                new NumberExpr(3),
                new TimesExpr(new VariableExpr("x"), new NumberExpr(4))
        );

        Expression nested2 = new PlusExpr(
                new NumberExpr(3),
                new TimesExpr(new VariableExpr("x"), new NumberExpr(4))
        );

        Expression nested3 = new PlusExpr(
                new TimesExpr(new VariableExpr("x"), new NumberExpr(4)),
                new NumberExpr(3)
        );

        assertTrue(nested1.equals(nested2), "Nested expressions with same structure should be equal");
        assertEquals(nested1.hashCode(), nested2.hashCode(), "Hash codes must match for equal nested expressions");
        assertFalse(nested1.equals(nested3), "Nested expressions with different grouping should not be equal");
    }

    @Test
    public void testDeeplyNestedExpressions() {
        Expression deep1 = new PlusExpr(
                new TimesExpr(new NumberExpr(2), new NumberExpr(3)),
                new PlusExpr(new VariableExpr("x"), new NumberExpr(5))
        );

        Expression deep2 = new PlusExpr(
                new TimesExpr(new NumberExpr(2), new NumberExpr(3)),
                new PlusExpr(new VariableExpr("x"), new NumberExpr(5))
        );

        Expression deep3 = new PlusExpr(
                new PlusExpr(new NumberExpr(2), new NumberExpr(3)),
                new PlusExpr(new VariableExpr("x"), new NumberExpr(5))
        );

        assertTrue(deep1.equals(deep2), "Deeply nested expressions with same structure should be equal");
        assertEquals(deep1.hashCode(), deep2.hashCode(), "Hash codes must match for equal deeply nested expressions");
        assertFalse(deep1.equals(deep3), "Deeply nested expressions with different grouping should not be equal");
    }
}
