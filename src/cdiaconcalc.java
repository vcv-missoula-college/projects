//Camillia Diacon

public class CamilliaCalc {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int tlength = userInput.length();
      String[] Clean = new String[tlength];
      char[] preCalc = new char[tlength/2];
      int[] Calc = new int[tlength/2];
      String find;
		int whitespaces = 0;
		int whitespacee;
		int a; //for iterating
		int b; // for iterating		
		int cr = 0; //for incrimenting array clean
		int pr = 0; // for incrimenting arrays Calc
		char chara;
		
	//Clean code of letters 
	while (go) {
			
			System.out.println("enter equation");
			String input = scnr.nextLine();

			  if (input.equalsIgnoreCase("quit")) {
				go = false;
				break;
			  }
			  
			  else {
				 int Slength = input.length();
				 int i;
				 int indexws = 0;
				 String Clean;
				 

				for (i = 0; i < Slength; ++i) {
					char chari = input.charAt(i);
					if (Character.isLetter(chari)) {
					  System.out.println("Not Computable");
					  break;
					}  
					else if (input.IndexOf(")") == -1) {
						continue; // add method for adding the substring to calculate and replace the supstring with the result
						//will do once calculate is converted to methode
						/*
						ParaMethod
						int indexpo = uinput.IndexOf("(");
						int indexpc = uinput.IndexOF(")");
						String clean = index.substring(indexpo, indexpc)
						int replaces = CalcMethod(clean)
						input= input.replace(clean, replaces
						*/
					}
				}


					//parse
					  for (a = 0; a < tlength; ++a) {
						 chara = userInput.charAt(a);
						 if (Character.isWhitespace(chara)) {
							whitespacee = a;
							   find = userInput.substring(whitespaces, whitespacee);
								  if (find.equalsIgnoreCase("+")) {
								  Clean[cr] = find;
								  cr += 1;
								  }
								  else if (find.equalsIgnoreCase("-")) {
								  Clean[cr] = find;
								  cr += 1;
								  }
								  else if (find.equalsIgnoreCase("*")) {
								  Clean[cr] = find;
								  cr += 1;
								  }
								  else if (find.equalsIgnoreCase("/")) {
								  Clean[cr] = find;
								  cr += 1;
								  }
								  else {
									 b = Integer.parseInt(find);
									 Calc[pr] = b;
									 pr += 1;
										
								  }
									 
							whitespaces = whitespacee + 1;            
						 }
						 else {
							continue;
						 }
					  }

					  //grabs last number
					  whitespacee = tlength;
					  find = userInput.substring(whitespaces, whitespacee);
					  b = Integer.parseInt(find);
					  Calc[pr] = b;	
					  
					  System.out.print("Clean:" + Clean[0] + "and" +Clean[1]);
					  System.out.println("Calc:" + Calc[0] + "and" + Calc[1] + " " + Calc[2]);
					  
					  //trim arrays
					  int clnlength = 0;
					  int canlength = 0;
					  for (a=0; a < Clean.length; ++a) {
						 if (Clean[a] != null) {
							clnlength += 1;
						 }
						 else {
							continue;
						 }
					  }
					  for (a=0; a < Calc.length; ++a) {
         if (Calc[a] != 0) {
            canlength += 1;
         }
         else {
            continue;
         }
      }
      
           

					  //Calculate
					  b = 0;
					  cr = 0;
					  int total;
					  //System.out.print(total);
					  int[] Calc2 = new int[canlength];
					  for (a = 0; a < clnlength; ++a) {
						 if (Clean[a] != null) {
							   if (Clean[a].equalsIgnoreCase("+") || Clean[a].equalsIgnoreCase("-")) {
								  Calc2[cr] = Calc[a];
								  //System.out.print(Calc2[cr]);
								  cr += 1;
							   }
							   else if (Clean[a].equalsIgnoreCase("*")) {
								  total = Calc[a] * Calc[a+1];
								  Calc2[cr] = total;
								  cr += 1;
							   }
							   else if (Clean[a].equalsIgnoreCase("/")) {
								  total = Calc[a] / Calc[a+1];
								  Calc2[cr] = total;
								  cr +=1;
							   }
							   else {
								  System.out.print("Not Computable");
							   }
						 }
						 else {
							break;
						 }
					  }
					  
					  
					  if (Clean[clnlength - 1].equalsIgnoreCase("+") || Clean[clnlength - 1].equalsIgnoreCase("-")) {
						 System.out.println("alive");
						 Calc2[cr] = Calc[canlength -1];
						 cr += 1;
					  }
					  System.out.println(Calc2[0] + " " + Calc2[1] + " " + Calc2[2] + " ");
					  
					  total = Calc2[0];
					  for (a = 0; a < Calc2.length; ++a) {
						 if (Clean[a] != null) {
							if (Clean[a].equalsIgnoreCase("+")) {
							   System.out.println(Calc2[0] + " " + Calc2[1]);
							   total = total + Calc2[a+1];
							}
							else if (Clean[a].equalsIgnoreCase("-")) {
							   total -= Calc2[a];
							}
							else {
							   continue;
							}
						 }
					  }
					  System.out.print(total);
				}
   }
}