
class Calculations{

  // Add methods here //

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
	// Add Unit tests here! //
	
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

