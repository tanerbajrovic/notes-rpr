package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class for testing ExpressionEvaluator class
 * @author Taner Bajrovic
 */
public class ExpressionEvaluatorTest {

    private ExpressionEvaluator expressionEvaluator;

    /** Creating a new ExpressionEvaluator before each test */
    @BeforeEach
    public void setup() {
         expressionEvaluator = new ExpressionEvaluator();
    }

    // Testing invalid arguments

    /**
     * Expressions that don't contain numerical values will not be evaluated.
     */
    @Test
    public void containsNonNumericalExpressions() {
        String invalidArgument = "( 2 + sqrt ( 2 ) ) + 16 * a";
        Throwable exception = assertThrows(NumberFormatException.class, () -> {expressionEvaluator.evaluate(invalidArgument);});
        assertEquals("Invalid formatting or non-numerical value passed.", exception.getMessage());
    }

    /**
     * Extra parentheses in the expression is not valid.
     */
    @Test
    public void extraPairOfParentheses() {
        assertThrows(EmptyStackException.class, () -> {expressionEvaluator.evaluate("( ( 2 + 2 ) )");});
    }

    /** Stacked opening and leading parentheses */
    @Test
    public void stackedOpeningParens() {
        assertThrows(IllegalArgumentException.class, () -> {expressionEvaluator.evaluate("( ( 1 + 2 )");});
    }

    /** Passing an expression with only parentheses and no arguments. */
    @Test
    public void onlyPassingParens() {
        assertThrows(EmptyStackException.class, () -> {expressionEvaluator.evaluate("( ( ( ) ) )");});
    }

    /** Passing only "sqrt(16)" as the expression. */
    @Test
    public void justSquareRoot() {
        String expression = "sqrt ( 16 )";
        assertEquals(4.0, expressionEvaluator.evaluate(expression));
    }

    /** Expression contains only one invalid spacing */
    @Test
    public void invalidNoSpacing() {
        String expression = "( (2 + 2 ) / ( sqrt ( 4 ) ) )";
        assertThrows(NumberFormatException.class, () -> {expressionEvaluator.evaluate(expression);});
    }

    /** Adding extra space between operators and values is invalid. */
    @Test
    public void invalidExtraSpacing() {
        String expression = "(  2 + 3 )";
        assertThrows(NumberFormatException.class, () -> {expressionEvaluator.evaluate(expression);});
    }

    //  Testing valid arguments

    /**
     * Valid input of the form: ( 2 + ( 2 + 2 ) )
     */
    @Test
    public void twoPlusTwoTimesTwo() {
        assertEquals(6, expressionEvaluator.evaluate("( 2 + ( 2 * 2 ) )"));
    }

    /** Passing a valid input with all operators combined */
    @Test
    public void allOperatorsInSingleExpression() {
        assertEquals(4.0, expressionEvaluator.evaluate("( ( 5 * 2.4 ) / ( 1 + sqrt ( 4 ) ) )"));
    }

    /**
     * Passing a postfix expression which doesn't look valid, but it is.
     * @see <a href="https://algs4.cs.princeton.edu/13stacks/Evaluate.java.html">Professor Sedgewick's example</a>
     * */
    @Test
    public void sendingPostfixExpression() {
        String expression = "( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + )";
        assertEquals(101.0, expressionEvaluator.evaluate(expression));
    }

}
