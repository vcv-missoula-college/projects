
class Calculations{

  // Add methods here //
  
  
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
  

  public static void main(String[] args) {
	Calculations myc = new Calculations();
	// Add Unit tests here! //
	
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

