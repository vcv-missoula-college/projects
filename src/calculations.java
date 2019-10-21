
class Calculations{

  // Add methods here //
  
  
	// Kajun
	public long square(long x) {
		long sqr = x * x;
		return sqr;
	}
	// Kajun
	public double square(double x) {
		double sqr = x * x;
		return sqr;
	}

  

  public static void main(String[] args) {
	  Calculations myc = new Calculations();
	  // Add Unit tests here! //
	  // Kajun - Tests square() with longs
	  assert myc.square(3) == 9;
	  assert myc.square(0) == 0;
	  assert myc.square(20000) == 400000000;		
	  assert myc.square(-20000) == 400000000;
	
	  // Kajun - Tests square() with doubles
	  assert myc.square(3.3) == 10.889999999999999;
	  assert myc.square(0.0) == 0;
	  assert myc.square(30000.03) == 9.000018000008999E8;
	  assert myc.square(-30000.03) == 9.000018000008999E8;
	
  }
}

