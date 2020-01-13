import java.util.Scanner;

public class kzuleger_calculator {
	
	
	

		private TokenStack operatorStack;
	    private TokenStack valueStack;
	    private boolean error;
	    
	    public kzuleger_calculator() {
	        operatorStack = new TokenStack();
	        valueStack = new TokenStack();
	        error = false;
	    }

	    private void processOperator(Token t) {
	        Token A = null, B = null;
	        if (valueStack.isEmpty()) {
	            System.out.println("Expression error.");
	            error = true;
	            return;
	        } else {
	            B = valueStack.top();
	            valueStack.pop();
	        }
	        if (valueStack.isEmpty()) {
	            System.out.println("Expression error.");
	            error = true;
	            return;
	        } else {
	            A = valueStack.top();
	            valueStack.pop();
	        }
	        Token R = t.operate(A.getValue(), B.getValue());
	        valueStack.push(R);
	    }

	    public void processInput(String input) {
	        // The tokens that make up the input
	        String[] parts = input.split(" ");
	        Token[] tokens = new Token[parts.length];
	        for (int n = 0; n < parts.length; n++) {
	            tokens[n] = new Token(parts[n]);
	        }
	        // Main loop - process all input tokens
	        for (int n = 0; n < tokens.length; n++) {
	            Token nextToken = tokens[n];
	            if (nextToken.getType() == Token.NUMBER) {
	                valueStack.push(nextToken);
	            } else if (nextToken.getType() == Token.OPERATOR) {
	                if (operatorStack.isEmpty() || nextToken.getPrecedence() > operatorStack.top().getPrecedence()) {
	                    operatorStack.push(nextToken);
	                } else {
	                    while (!operatorStack.isEmpty() && nextToken.getPrecedence() <= operatorStack.top().getPrecedence()) {
	                        Token toProcess = operatorStack.top();
	                        operatorStack.pop();
	                        processOperator(toProcess);
	                    }
	                    operatorStack.push(nextToken);
	                }
	            } else if (nextToken.getType() == Token.LEFT_PARENTHESIS) {
	                operatorStack.push(nextToken);
	            } else if (nextToken.getType() == Token.RIGHT_PARENTHESIS) {
	                while (!operatorStack.isEmpty() && operatorStack.top().getType() == Token.OPERATOR) {
	                    Token toProcess = operatorStack.top();
	                    operatorStack.pop();
	                    processOperator(toProcess);
	                }
	                if (!operatorStack.isEmpty() && operatorStack.top().getType() == Token.LEFT_PARENTHESIS) {
	                    operatorStack.pop();
	                } else {
	                    System.out.println("Error: unbalanced parenthesis.");
	                    error = true;
	                }
	            }

	        }
	        // Empty out the operator stack at the end of the input
	        while (!operatorStack.isEmpty() && operatorStack.top().getType() == Token.OPERATOR) {
	            Token toProcess = operatorStack.top();
	            operatorStack.pop();
	            processOperator(toProcess);
	        }
	        // Print the result if no error has been seen.
	        if(error == false) {
	            Token result = valueStack.top();
	            valueStack.pop();
	            if (!operatorStack.isEmpty() || !valueStack.isEmpty()) {
	                System.out.println("Expression error.");
	            } else {
	                System.out.println("The result is " + result.getValue());
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        // The original input
	        System.out.print("Enter an expression to compute: Must use spaces between characters: ");
	        String userInput = input.nextLine();
	        while(!userInput.equalsIgnoreCase("quit")) {
	        kzuleger_calculator calc = new kzuleger_calculator();
	        calc.processInput(userInput);
          System.out.print("Enter an expression to compute: Must use spaces between characters: ");
          userInput = input.nextLine();
	        }
	    }
	    
}