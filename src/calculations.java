
class Calculations{

	  // Charlie Aldeen
	  public long multiply(long one, long two) {
		long product = (one*two);
		return product;
	  }
	  //Charlie Aldeen
	  public double multiply(double one, double two) {
		double product=(one*two);
		return product;
	  }


  public static void main(String[] args) {
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
  }
}

