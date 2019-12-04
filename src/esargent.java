import java.util.Scanner;

class esargent {
	
	private double calcDouble(String[] plusArray) {
		Calculations calc = new Calculations();
		String[] plusMinus = plusArray;
		double result = 0.0;
					
		for (String element : plusMinus) {   //Loop through plus/minus array
			String [] multDiv = element.split("(?=[/*])|(?<=[/*])");   //Split into array including values, multiplication, and division symbols
			double multResult = 0.0;
			if (multDiv[0].equals("+") || multDiv[0].equals("-")) {
				continue;
			} else {
				multResult = Double.parseDouble(multDiv[0]);   //Initialize mult/div result as 1st element in the multiplication/division array
			}			
			for (int i = 1; i < multDiv.length; i +=2) {   //Iterate throuh mult/div array by two to evaluate based on operand
				String operand = multDiv[i];
				Double val = Double.parseDouble(multDiv[i + 1]);
				switch (operand) {
					case "*":
						multResult = calc.multiply(multResult, val);
						break;
					case "/":
						multResult = calc.divide(multResult, val);
						break;
				default:
						break;
				}
			}
			result = calc.add(result, multResult);
		}
		return result;

	}
	
	private long calcLong(String[] plusArray) {
		Calculations calc = new Calculations();
		String[] plusMinus = plusArray;
		long result = 0;
					
		for (String element : plusMinus) {   //Loop through plus/minus array
			String [] multDiv = element.split("(?=[*])|(?<=[*])");   //Split into array including values, multiplication, and division symbols
			long multResult = 0;
			if (multDiv[0].equals("+") || multDiv[0].equals("-")) {
				continue;
			} else {
				multResult = Long.parseLong(multDiv[0]);   //Initialize mult/div result as 1st element in the multiplication/division array
			}
			for (int i = 1; i < multDiv.length; i +=2) {   //Iterate throuh mult/div array by two to evaluate based on operand
				long val = Long.parseLong(multDiv[i + 1]);
				multResult = calc.multiply(multResult, val);
			}
			result = calc.add(result, multResult);
		}
		return result;
	}
	
	public void doubleResult(String userInput) {
		esargent es = new esargent();
		//Perform calculations inside parentheses
		while (userInput.contains("(")) {
			String insidePar = userInput.substring(userInput.indexOf("("), (userInput.indexOf(")") + 1));
			String insidePar2 = insidePar.replace("(", "");   //Create new string w/o parentheses
			insidePar2 = insidePar2.replace(")", "");
				
			String[] plusMinus = insidePar2.split("(?=[+])|(?<=[+])");   //Split into array including values and addition symbols			
			userInput = userInput.replace(insidePar, Double.toString(calcDouble(plusMinus)));   //Replace parentheses in original string with result				
		}
		//Perform calculations outside parentheses
		String[] plusMinus2 = userInput.split("(?=[+])|(?<=[+])");   //Split into array including values and addition symbols
		try {
			if (Double.toString(es.calcDouble(plusMinus2)).equals("Infinity")) {   //Error message printed if user tries to divide by zero
				System.out.println("Not Computable\n");
			} else {
				System.out.println(es.calcDouble(plusMinus2) + "\n");
			}
		} catch (NumberFormatException e) {
			System.out.println("Not Computable\n");
		}
	}
	
	public void longResult(String userInput) {
		esargent es = new esargent();
		//Perform calculations inside parentheses
		while (userInput.contains("(")) {
			String insidePar = userInput.substring(userInput.indexOf("("), (userInput.indexOf(")") + 1));
			String insidePar2 = insidePar.replace("(", "");   //Create new string w/o parentheses
			insidePar2 = insidePar2.replace(")", "");
			
			String[] plusMinus = insidePar2.split("(?=[+])|(?<=[+])");   //Split into array including values and addition symbols		
			userInput = userInput.replace(insidePar, Long.toString(calcLong(plusMinus)));   //Replace parentheses in original string with result				
		}
		//Perform calculations outside parentheses
		String[] plusMinus2 = userInput.split("(?=[+])|(?<=[+])");   //Split into array including values and addition symbols	
		//System.out.println(calcLong(plusMinus2) + "\n");
		try {
			System.out.println(es.calcLong(plusMinus2) + "\n");
		} catch (NumberFormatException e) {
			System.out.println("Not Computable\n");
		}
	}
	
	public static void main(String[] args) {
		esargent escalc = new esargent();
		Scanner scnr = new Scanner(System.in);
		String userInput = "";
		boolean endCalc = false;   //Flag for "quit"
		
		while (!endCalc) {   //Loop until endCalc is true (user enters quit)
			System.out.println("Enter an equation:");
			userInput = scnr.nextLine();
			userInput = userInput.replaceAll(" ", "");   //Remove whitespace from equation
			userInput = userInput.replaceAll("-", "+-");   //Turn all minus signs into +-, making the relevant digits negative
			
			if (userInput.equals("quit")) {
				endCalc = true;  //Change flag if input is "quit" and end program
				break;
			} else {
				if (userInput.contains(".") || userInput.contains("/")) {   //Use double calculations if user specifies decimals or if there will be division
					escalc.doubleResult(userInput);
				} else {
					escalc.longResult(userInput);
				}
			}
		}
	}
}