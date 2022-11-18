// Razvoj programskih rješenja, 2022
// Zadaca #1

package ba.unsa.etf.rpr;

import java.util.EmptyStackException;

/**
 * Main class for the console application used to evaluate mathematical expressions.
 * @author Taner
 */
public class App {

    /**
     * Parses and validates the expression passed through
     * the console.
     * @param args Array of Strings passed through the console
     */
    public static void main(String[] args) {
        try {
            validateConsoleInput(args);
            ExpressionEvaluator expressionEval = new ExpressionEvaluator();
            Double result = expressionEval.evaluate(args[0]);
            System.out.println(args[0] + " = " + result);
        } catch (RuntimeException ex) {
            if (ex instanceof EmptyStackException)
                System.out.println("Extra pair of parentheses or operators.");
            else
                System.out.println(ex.getMessage());
        }
    }

    /**
     * Checks if the passed input is in the right format.
     * @param arrayOfArguments Array of Strings
     * @throws IllegalArgumentException If no arguments or more than one argument
     * is found in the arrayOfArguments, throws an exception.
     */
    public static void validateConsoleInput(String[] arrayOfArguments) {

        // Checking the number of arguments passed
        if (arrayOfArguments.length != 1)
            throw new IllegalArgumentException("No arguments or more than one argument was passed.");
        if (arrayOfArguments[0].isEmpty())
            throw new IllegalArgumentException("No arguments were passed.");

        // Reference to first element
        String expression = arrayOfArguments[0];
        checkValidNumberOfParens(expression);
    }

    /**
     * Checks if the expression contains an even number of parentheses and if it's greater than <b>two</b>, thus excluding the case
     * when it's equal to zero. If the
     * expression is correct, it will contain an even number of parentheses.
     * @param expression Mathematical expression of type String.
     * @throws IllegalArgumentException In the case where the number of
     * parentheses is not even.
     * */
    public static void checkValidNumberOfParens(String expression) {
        int numberOfParens = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == ')')
                numberOfParens = numberOfParens + 1;
        }
        if (numberOfParens % 2 != 0 || numberOfParens < 2)
            throw new IllegalArgumentException("Invalid number of parentheses.");
    }
}
