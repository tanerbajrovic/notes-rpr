# Mathematical Expression Evaluator

This program parses mathematical expressions passed through the console and 
returns their value. It implements **Dijikstra's Algorithm** to achieve this.
_**Examples:**_ 
- ( 2 + 2) = 4 
- ( 2 + ( sqrt ( 4 ) * 5) ) = 12

## App class
**App** class is the main class of the program. It checks the validity of the 
arguments passed through the console, and then invokes the method for evaluation.

## ExpressionEvaluator class
**ExpressionEvaluator** class does the expression evaluation. It achieves this by 
having two stacks which store _**operators**_ and _**values**_ respectively.

### Exception handling
If the parsed input doesn't match the formatting (spacing between each value or operator),
it throws a **RuntimeException** which is then handled in the **App.main**.