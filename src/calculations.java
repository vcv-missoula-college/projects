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
  }
}

