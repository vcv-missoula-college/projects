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
  
  
<<<<<<< HEAD
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
=======
  //method to return sqrt(long)--Kendra//
  public long calcSqrt(long userNum) {	  
	  if(userNum < 0){
		userNum = -userNum;
		long negSqrt = Math.pow(num, 0.5);
		return (negSqrt + "i");
	  }
	  else {		
		long squareRoot = math.sqrt(userNum);
		return squareRoot;
	  }
  }
  
  //method to reutrn sqrt(double)--Kendra//
  public double calcSqrt(double userNum) {	  
	  if(userNum < 0){
		userNum = -userNum;
		double negSqrt = Math.pow(num, 0.5);
		return (negSqrt + "i");
	  }
	  else {		
		double squareRoot = math.sqrt(userNum);
		return squareRoot;
	  }
  
>>>>>>> 730e702a56dedbfb834171b607ba9adb44a782f1

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
	  Calculations myc = new Calculations();
	  // Add Unit tests here! //
	  // Kajun - Tests square() with longs
	  assert myc.square(3) == 9;
	  assert myc.square(0) == 0;
	  assert myc.square(20000) == 400000000;		
	  assert myc.square(-20000) == 400000000;
	
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
	Calculations myMult = new Calculations();
	
	// Testing Multiplication with longs
	assert (myMult.multiply(23,19) == 437);
	assert(myMult.multiply(0,0)==0);
	assert(myMult.multiply(45392,15603)==708251376);
	assert(myMult.multiply(-65279,-20823)==1359304617);
	assert(myMult.multiply(-12946,9623)==-124579358);
	
	//Testing Multiplication with doubles
	assert(myMult.multiply(14.5,6.7)==97.15);
	assert(myMult.multiply(0.0,0.0)==0.0);
	assert(myMult.multiply(75426.53,24381.054)==1838978300.96262);
	assert(myMult.multiply(-14373.06,-9281.21)==133399388.2026);
	assert(myMult.multiply(-5326.39,8532.87)==-44490643.2393);

	//Camillia Unit test Long//
	if (Divide(10000/2) == 500) 
		System.out.println("Divide double works");
	//Camillia unit test double//
	if (Divide(20,0.5) == 400)
		System.out.println("Divide float works");
	
	  // Kajun - Tests square() with doubles
	  assert myc.square(3.3) == 10.889999999999999;
	  assert myc.square(0.0) == 0;
	  assert myc.square(30000.03) == 9.000018000008999E8;
	  assert myc.square(-30000.03) == 9.000018000008999E8;
	
	
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
	
	//unit tests for calcSqrt long method--Kendra//
	assert (myc.calcSqrt((64) == 8);
	assert (myc.calcSqrt((0) == 0);
	assert (myc.calcSqrt((9801) == 99);
	assert (myc.calcSqrt((-16) == (4+"i"));
	
	//unit tests for calcSqrt double method--Kendra//
	assert (myc.calcSqrt((10.0) == 3.1622777);
	assert (myc.calcSqrt((0.0) == 0.0);
	assert (myc.calcSqrt((73.42) == 8.5685471);
	assert (myc.calcSqrt((-31) == (5.5677644+"i"));
	
  }
}

