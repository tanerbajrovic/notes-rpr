package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class for testing ExpressionEvaluator class
 */
public class ExpressionEvaluatorTest {

    // Testing invalid arguments

    /**
     * Passing more than one argument is not valid.
     */
    @Test
    public void passingMoreThanOneArgument() {
        String[] invalidArguments = {"( 3 + 2 ) * 6", ""};
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {App.validateConsoleInput(invalidArguments);});
        assertEquals("No arguments or more than one argument was passed.", exception.getMessage());
    }

    /**
     * Passing no arguments at all is not valid.
     */
    @Test
    public void passingNoArguments() {
        String[] noArguments = {};
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {App.validateConsoleInput(noArguments);});
        assertEquals("No arguments or more than one argument was passed.", exception.getMessage());
    }

    /**
     * Passing expression with an odd number of parentheses is not valid.
     */
    @Test
    public void oddNumberOfParens() {
        String invalidExpression = "( 2 + sqrt (2) ) )";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {App.checkValidNumberOfParens(invalidExpression);});
        assertEquals("Invalid number of parentheses.", exception.getMessage());
    }

    /**
     * Expressions that don't contain numerical values will not be evaluated.
     */
    @Test
    public void containsNonNumericalExpressions() {
        String invalidArgument = "( 2 + sqrt ( 2 ) ) + 16 * a";
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        Throwable exception = assertThrows(NumberFormatException.class, () -> {expressionEvaluator.evaluate(invalidArgument);});
        assertEquals("Invalid formatting or non-numerical value passed.", exception.getMessage());
    }

    /**
     * Extra parentheses in the expression is not valid.
     */
    @Test
    public void extraPairOfParentheses() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        Throwable exception = assertThrows(EmptyStackException.class, () -> {expressionEvaluator.evaluate("( ( 2 + 2 ) )");});
    }

    //  Testing valid arguments

    /**
     * Valid input of the form: ( 2 + ( 2 + 2 ) )
     */
    @Test
    public void twoPlusTwoTimesTwo() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(6, expressionEvaluator.evaluate("( 2 + ( 2 * 2 ) )"));
    }

}
