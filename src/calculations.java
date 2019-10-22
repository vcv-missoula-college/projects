
class Calculations{

	public static void Divide (double x, double y) {
		//Camillia Divide by double//
		if ((y > 0) || (y < 0)) {	
			double z = x / y;
			System.out.println(z);
		}
		else {
			System.out.println("Not valid");
		}
   }
  	public static void Divide (long x, long y) {
		//Camillia Divide by long//
		if ((y > 0) || (y < 0)) {	
			long z = x / y;
			System.out.println(z);
		}
		else {
			System.out.println("Not valid");
		}
   }


  public static void main(String[] args) {
	Calculations myc = new Calculations();
	//Camillia Unit test Long//
	if (Divide(10000/2) == 500) 
		System.out.println("Divide double works");
	//Camillia unit test double//
	if (Divide(20,0.5) == 400)
		System.out.println("Divide float works");
  }
}

