import java.util.*;

class kschmaus {
	private String resolveParen(String paren) {
		kschmaus ks = new kschmaus();
		
		if (!paren.contains("+") || !paren.contains("-") || !paren.contains("*") || !paren.contains("/")) {
			return paren;
		}
		
		else {
			paren = paren.indexOf("(", 0).replace("(", "");
			paren = paren.lastIndexOf(")").replace(")", "");
			if (paren.contains("(")) {
				String subParen = paren.substring(userExpression.indexOf("("), userExpression.lastIndexOf(")");
				subParen = subParen.indexOf("(", 0).replace("(", "");
				subParen = subParen.lastIndexOf(")").replace(")", "");
				ks.resolveParen(subParen);
				paren = paren + subParen;
			}
			else {
				if (paren.contains(".") == true) {
					String[] op = paren.split("");
					op = ks.calcDouble(op);
					paren = String.join("", op);
				}
				else {
					String op[] = paren.split("");
					op = ks.calcLong(op);
					paren = String.join("", op);
				}
			}
		}
	}
	
	private double calcDouble(String[] pmArray) {
		
	}
	
	private long calcLong(String[] pmArray) {
		
	}
	
	public void finalResultDouble(String userExpression) {
		kschmaus ks = new kschmaus();
		String result = "";
		if (userExpression.contains("(")) {
			String subExpression = userExpression.substring(userExpression.indexOf("(", 0), userExpression.lastIndexOf(")");
			ks.resolveParen(subExpression);
			userExpression = userExpression + subExpression;
			String[] plusMinus = userExpression.split("(?=[+])|(?<=[+])");
			result = String.join("", plusMinus);
			return result;
		}
		else {
			String[] plusMinus = userExpression.split("(?=[+])|(?<=[+])");
			result = String.join("", plusMinus);
			return result;
		}
		
	}
	public void finalResultLong(String userExpression) {
		kschmaus ks = new kschmaus();
		
		
		
	}
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userExpression = "";
		boolean inputDone = false;
		kschmaus ks = new kschmaus();
		
		while (!inputdone) {
			System.out.println("Enter expression:");
			userExpression = scnr.nextLine();
			userExpression = userExpression.replaceAll(" ", "");
			userExpression = userExpression.replaceAll("-", "+-");
			String result = "";
			
			if (userExpression.equalsIgnoreCase("quit")) {
				inputDone = true;
			}
			else {
				if (userExpression.contains(".")) {
					result = ks.finalResultDouble(userExpression);
					System.out.println("Result: " + result);
				}
				else {
					result = ks.finalResultLong(userExpression);
					System.out.println("Result: " + result);
				}
					
			}
		}
	}
}