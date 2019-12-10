import java.util.*;
import java.lang.*;

class kschmaus1 {
	private enum Operator {
		ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);
		
		final int precedence;							//enumerator to store precedence of operators 
		Operator(int p) {
			precedence = p;
		}
	}
	
	private HashMap<String, Operator> operatorMap = new HashMap<String, Operator>(); {{
		operatorMap.put("+", Operator.ADD);
		operatorMap.put("-", Operator.SUBTRACT);
		operatorMap.put("*", Operator.MULTIPLY);		//HashMap to associate string operators with their enumerator counterparts
		operatorMap.put("/", Operator.DIVIDE);
	}};
	
	private boolean isHigherPrec(String op, String sub) {
		return (operatorMap.containsKey(sub) &&
				operatorMap.get(sub).precedence >= operatorMap.get(op).precedence);		//method that when called checks precedence for given operator in
	}																					//inFixToPostFix method
	
	public String infixToPostfix(String infix) {
		StringBuilder postFix = new StringBuilder();	//StringBuilder object to store postFix expression as it is converted 
		Stack<String> op = new Stack<String>();		//stack to store operators before they are added to StringBuilder object 
		
		for (String token : infix.split(" ")) {	
			if (operatorMap.containsKey(token)) {		//checks if is operator
				while (!op.isEmpty() && isHigherPrec(token, op.peek())) {
					postFix.append(op.pop()).append(' ');					//checks precedence against mapping
				}
				op.push(token);
			}
			else if (token.equals("(")) {		//pushes opening bracket to stack
				op.push(token);
			}
			else if (token.equals(")")) {
				while (!op.peek().equals("(")) {			//if closing bracket is found pop operators to StringBuilder until 
					postFix.append(op.pop()).append(' ');	//opening bracket is found, then discard.
				}
				op.pop();
			}
			else {
				postFix.append(token).append(' ');
			}
		}
		while(!op.isEmpty()) {
			postFix.append(op.pop()).append(' ');			//pop rest of operators to StringBuilder 
		}
		return postFix.toString();
	}
	
	public String calcPostFixLong(String postFix) {		//calculate result if it is a long
		Stack<String> numbers = new Stack<>();
		String[] splitPost = postFix.split(" ");
		Calculations calc = new Calculations();
		long result = 0;
		String temp = "";
		
		for (int i = 0; i < splitPost.length; i++) {
			String currItem = splitPost[i];
			
			if (!operatorMap.containsKey(currItem)) {
				numbers.push(currItem);
			}
			else {
				temp = numbers.pop();
				long val1 = Long.parseLong(temp);
				temp = numbers.pop();
				long val2 = Long.parseLong(temp);
				
				switch(currItem) {
					case "+":
						result = calc.add(val2, val1);
						numbers.push(Long.toString(result));
						break;
						
					case "-":
						result = calc.returnDiff(val2, val1);
						numbers.push(Long.toString(result));
						break;
					
					case "/":
						result = calc.divide(val2, val1);
						numbers.push(Long.toString(result));
						break;
			
					case "*":
						result = calc.multiply(val2, val1);
						numbers.push(Long.toString(result));
						break;
				}
			}
		}
		return numbers.pop();
	}
	
	public String calcPostFixDouble(String postFix) {
		Stack<String> numbers = new Stack<>();
		String[] splitPost = postFix.split(" ");
		Calculations calc = new Calculations();
		double result = 0.0;
		String temp = "";
		
		for (int i = 0; i < splitPost.length; i++) {
			String currItem = splitPost[i];
			
			if (!operatorMap.containsKey(currItem)) {
				numbers.push(currItem);
			}
			else {
				temp = numbers.pop();
				double val1 = Double.parseDouble(temp);
				temp = numbers.pop();
				double val2 = Double.parseDouble(temp);
				
				switch(currItem) {
					case "+":
						result = calc.add(val2, val1);
						numbers.push(Double.toString(result));
						break;
						
					case "-":
						result = calc.returnDiff(val2, val1);
						numbers.push(Double.toString(result));
						break;
					
					case "/":
						result = calc.divide(val2, val1);
						numbers.push(Double.toString(result));
						break;
						
					case "*":
						result = calc.multiply(val2, val1);
						numbers.push(Double.toString(result));
						break;
				}
			}
		}
		return numbers.pop();
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userExpression;
		boolean inputDone = false;
		kschmaus1 ks = new kschmaus1();
		String result = "";
		
		while (!inputDone) {
			System.out.println("Expression must have all items split by space");
			System.out.println("i.e 1 + 2 / ( 3 + 1 )");
			System.out.println("Enter expression (quit to end):");
			userExpression = scnr.nextLine();
			if (userExpression.equalsIgnoreCase("quit")) {
				inputDone = true;
			}
			
			else {
				result = ks.infixToPostfix(userExpression);
				if (result.contains(".")) {
						result = ks.calcPostFixDouble(result);
						System.out.println(result);
				}
				else {
					result = ks.calcPostFixLong(result);
					System.out.println(result);
				}
			}
		}
	}
}