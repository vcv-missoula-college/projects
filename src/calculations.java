class Calculations{

  // Cole
  public long add(long x, long y) {
	long sum = x + y;
	return sum;
  }
  // Cole
  public double add(double x, double y) {
	double sum = x + y;
	return sum;
  }
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

  // Emerald //
  public long returnDiff(long num1, long num2) {
	long diff = num1 - num2;
	return diff;
  }
  // Emerald //
  public double returnDiff(double num1, double num2) {
	double diff = num1 - num2;
	return diff;
  }

  public static void main(String[] args) {
	Calculations myc = new Calculations();
	
	// Cole - Tests add() with longs 
	assert (myc.add(3, 5) == 8);
	assert (myc.add(0, 0) == 0);
	assert (myc.add(1000000, 2000000) == 3000000);
	assert (myc.add(-1000000, -2000000) == -3000000);
	
	// Cole - Tests add() with doubles
	assert (myc.add(3.1, 5.2) == 8.3);
	assert (myc.add(0.0, 0.0) == 0.0);
	assert (myc.add(1000000.0000001, 2000000.0000002) == 3000000.0000003);
	assert (myc.add(-1000000.0000001, -2000000.0000002) == -3000000.0000003);

	//Camillia Unit test Long//
	if (Divide(10000/2) == 500) 
		System.out.println("Divide double works");
	//Camillia unit test double//
	if (Divide(20,0.5) == 400)
		System.out.println("Divide float works");
	
	// Unit tests for returnDiff long methods -- Emerald //
	assert (myc.returnDiff(15, 10) == 5);
	assert (myc.returnDiff(0, 0) == 0);
	assert (myc.returnDiff(9500000, 1500000) == 8000000);
	assert (myc.returnDiff(-9500000, 1500000) == -11000000);
	
	// Unit tests for returnDiff double methods -- Emerald //
	assert (myc.returnDiff(15.25, 10.10) == 5.15);
	assert (myc.returnDiff(0.0, 0.0) == 0.0);
	assert (myc.returnDiff(9500000.0000125, 1500000.0000015) == 8000000.0000110);
	assert (myc.returnDiff(9500000.0000125, 1500000.0000015) == -11000000.0000140);
  }
}

