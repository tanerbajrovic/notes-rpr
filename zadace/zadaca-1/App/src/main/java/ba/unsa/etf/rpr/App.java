/**
 * Razvoj programskih rješenja, 2022
 * Zadaca #1
 * @author Taner Bajrović
 */

package ba.unsa.etf.rpr;

/** Main class for the console application for evaluating mathematical expressions. */
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
            System.out.println(result);
        } catch (RuntimeException ex) {
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
        if (arrayOfArguments.length != 1) { // Invalid input
            throw new IllegalArgumentException("No arguments or more than one argument was passed.");
        }
    }
}
