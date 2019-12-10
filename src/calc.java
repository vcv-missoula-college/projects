
class MCCalculator{
  public static void main(String[] args) {
	if (args == null || args.length == 0) {
		System.out.println("Did not designate the calculator to use! Quitting!");
	}
	String which_calc = args[0];
	if (which_calc.equalsIgnoreCase("caldeen")){
		// Add code here to starting point of implemtation
	} else if(which_calc.equalsIgnoreCase("ccunningham")) {
		// Add code here to starting point of implemtation
		ccunningham_calc.main(args);
	} else if(which_calc.equalsIgnoreCase("cdiacon")) {
		// Add code here to starting point of implemtation
	} else if(which_calc.equalsIgnoreCase("esargent")) {
		// Add code here to starting point of implemtation
		System.out.println("Using esargent's calculator:");
		esargent.main(args);
	} else if(which_calc.equalsIgnoreCase("kschmaus")) {
		// Add code here to starting point of implemtation
	} else if(which_calc.equalsIgnoreCase("kzuleger")) {
		// Add code here to starting point of implemtation
    kzuleger_calculator.main(args);
	} else{
		System.out.println("Did not select a valid calculator valid calculator! Quitting!");
	}
  }
}