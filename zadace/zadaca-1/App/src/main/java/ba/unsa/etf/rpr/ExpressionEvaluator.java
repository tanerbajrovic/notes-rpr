package ba.unsa.etf.rpr;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Allows to evaluate mathematical expressions.
 * <br>
 * It achieves this by using <b>Dijkstra algorithm</b> (<a href="https://algs4.cs.princeton.edu/13stacks/Evaluate.java.html">
 * as implemented by Professor Sedgewick</a>) and returns the value of expression.
 * @author Taner Bajrovic
 */
public class ExpressionEvaluator {

    /** Stores numerical values parsed from the expression. */
    private Stack<Double> values;
    /** Stores operators parsed from the expression. */
    private Stack<String> operators;

    /**
     * Constructor without parameters.
     * It instantiates stacks named operators and values with empty
     * stacks.
     * */
    public ExpressionEvaluator() {
        this.values = new Stack<Double>();
        this.operators = new Stack<String>();
    }

    /**
     * Parses the mathematical expression passed as a String, and returns its value.
     * @param expression Mathematical expression of type String
     * to be parsed and evaluated.
     * @return Returns the evaluated value.
     * @throws NumberFormatException If no numerical value was passed or if spacing between
     * values and operators is not equal to <b>one space</b>.
     * @throws EmptyStackException If no numeraical values are entered or no operators are
     * entered.
     * */
    public Double evaluate(String expression) {

        // Putting individual elements separated by spaces
        String[] arrayOfElements = expression.split(" ");
        int numberOfParens = 0;

        // Parsing the expression, pushing if it's an operator
        for (String element : arrayOfElements) {
            if (element.equals("("))
                numberOfParens = numberOfParens + 1;
            else if (element.equals("+")) // Addition
                operators.push(element);
            else if (element.equals("-")) // Subtraction
                operators.push(element);
            else if (element.equals("*")) // Multiplication
                operators.push(element);
            else if (element.equals("/")) // Division
                operators.push(element);
            else if (element.equals("sqrt")) // Square root
                operators.push(element);
            else if (element.equals(")")) {
                numberOfParens = numberOfParens - 1;
                String currentOperator = operators.pop();
                Double currentValue = values.pop();
                switch (currentOperator) {
                    case "+":
                        currentValue = values.pop() + currentValue;
                        break;
                    case "-":
                        currentValue = values.pop() - currentValue;
                        break;
                    case "*":
                        currentValue = values.pop() * currentValue;
                        break;
                    case "/":
                        currentValue = values.pop() / currentValue;
                        break;
                    case "sqrt":
                        currentValue = Math.sqrt(currentValue);
                        break;
                }
                values.push(currentValue);
            }
            else {
                try {
                    values.push(Double.parseDouble(element));
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException("Invalid formatting or non-numerical value passed.");
                } catch (RuntimeException ex) {
                    throw ex;
                }
            }
        }

        // Check if there are no parens left
        if (numberOfParens != 0)
            throw new IllegalArgumentException("Invalid number of parentheses.");

        return (values.pop());
    }
}
