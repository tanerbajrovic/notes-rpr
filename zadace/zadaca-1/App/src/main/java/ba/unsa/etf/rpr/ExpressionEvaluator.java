package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class comment
 *  */
public class ExpressionEvaluator {

    /** Storing numerical values parsed from the expression. */
    private Stack<Double> values;
    /** Storing operators parsed from the expression. */
    private Stack<String> operators;

    /**
     * Constructor without parameters.
     * It instantiates stacks named operators and operands with empty
     * stacks.
     * */
    public ExpressionEvaluator() {
        this.values = new Stack<Double>();
        this.operators = new Stack<String>();
    }

    /**
     * Parses the mathematical expression passed as a String
     * using Dijkstra algorithm and returns the value of expression.
     * @param expression Mathematical expression of type String
     * to be parsed and evaluated.
     * @return Returns the evaluated value.
     *
     * */
    public Double evaluate(String expression) {
        String[] arrayOfElements = expression.split(" ");

        // Parsing the expression, pushing if it's an operator
        for (String arrayOfElement : arrayOfElements) {
            if (arrayOfElement.equals("(")) ;
            else if (arrayOfElement.equals("+")) // Addition
                operators.push(arrayOfElement);
            else if (arrayOfElement.equals("-")) // Subtraction
                operators.push(arrayOfElement);
            else if (arrayOfElement.equals("*")) // Multiplication
                operators.push(arrayOfElement);
            else if (arrayOfElement.equals("/")) // Division
                operators.push(arrayOfElement);
            else if (arrayOfElement.equals("sqrt")) // Square root
                operators.push(arrayOfElement);
            else if (arrayOfElement.equals(")")) {
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
            // Parsing the expression, pushing if it's an operand
            else
                values.push(Double.parseDouble(arrayOfElement));
        }
        return (values.pop());
    }
}
