
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
  	public static void Divide (float x, float y) {
		//Camillia Divide by float//
		if ((y > 0) || (y < 0)) {	
			float z = x / y;
			System.out.println(z);
		}
		else {
			System.out.println("Not valid");
		}
   }


  public static void main(String[] args) {
	Calculations myc = new Calculations();
	//Camillia Unit test Double//
	if (Divide(10000/2) == 500) 
		System.out.println("Divide double works");
	//Camillia unit test float//
	if (Divide(20,0.5) == 400)
		System.out.println("Divide float works");
  }
}

