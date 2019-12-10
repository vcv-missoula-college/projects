
import java.util.Scanner;

class ccunningham_calc {
	
	public static void main(String[] args){
		Calculations calc = new Calculations();
		Scanner scnr = new Scanner(System.in);
		String userInput = "";
		boolean endCalc = false;   
		
		while(!endCalc){   // run until quit
			System.out.println("Please enter your equation:");
			userInput = scnr.nextLine();
			userInput = userInput.replaceAll(" ", "");   
			userInput = userInput.replaceAll("-", "+-");   
			
			if(userInput.equals("quit")){
				endCalc = true;  
			}else{
				// resolve EQs inside parens
				while(userInput.contains("(")){
					String parenVals = userInput.substring(userInput.indexOf("("), (userInput.indexOf(")") + 1));
					
					String parenVals2 = parenVals.replace("(", "");   
					parenVals2 = parenVals2.replace(")", "");
					double result = 0.0;
					
					String[] toAdd = parenVals2.split("(?=[+])|(?<=[+])");  // splits EQ into vals and specified symbol
					
					
					for(String element: toAdd){   
						String [] toMultOrDiv = element.split("(?=[/*])|(?<=[/*])");
						Double mdResult;
						if(toMultOrDiv[0].equals("+") || toMultOrDiv[0].equals("-")){
							continue;
						}else{
							mdResult = Double.parseDouble(toMultOrDiv[0]); 
						}
						

						for(int i = 1; i < toMultOrDiv.length; i +=2){
							String operand = toMultOrDiv[i];
							Double val = Double.parseDouble(toMultOrDiv[i + 1]);
							switch(operand){
								case "*":
									//call mult method
									mdResult = calc.multiply(mdResult, val);
									break;
								case "/":
									//call div method 
									mdResult = calc.divide(mdResult, val);
									break;
								default:
									break;
							}
						}
                        result = calc.add(mdResult, result);
						
					}
					userInput = userInput.replace(parenVals, Double.toString(result));   //Replace parentheses in original string with result
									
				}
				
				// now resolve original equation
				double result2 = 0.0;
				String[] toAdd2 = userInput.split("(?=[+])|(?<=[+])");
				for(String element2 : toAdd2){   
					String [] toMultOrDiv2 = element2.split("(?=[/*])|(?<=[/*])");
					Double mdResult2;
					if(toMultOrDiv2[0].equals("+") || toMultOrDiv2[0].equals("-")){
						continue;
					}else{
						mdResult2 = Double.parseDouble(toMultOrDiv2[0]);
					}
				
					for(int i = 1; i < toMultOrDiv2.length; i +=2){   
						String operand2 = toMultOrDiv2[i];
						Double val2 = Double.parseDouble(toMultOrDiv2[i + 1]);
						switch(operand2){
							case "*":
								// call mult method
								mdResult2 = calc.multiply(mdResult2, val2);
								break;
							case "/":
								// call div method
								mdResult2 = calc.divide(mdResult2, val2);
								break;
							default:
								break;
						}
					}
					result2 = calc.add(mdResult2, result2);
					
				}
				System.out.println(result2);
			}
		}
	
	}
}