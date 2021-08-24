package com.onelogin.fractioncalc.model;

//TODO negative numbers
//TODO support floats

/**
 * Encapsulates a Mixed number that consists of a whole number and a fraction.
 * It also represents just a whole number, just a fraction or a mixed number.
 *
 */
public class MixedNum {
	private Integer whole;
	private Fraction fraction;
	
	
	//TODO remove.   This is for testing only
	public static void main(String[] args) {
		MixedNum m1 = new MixedNum(1, 0, 1); // 1
		MixedNum m2 = new MixedNum(0, 0, 1);
		MixedNum m3 = new MixedNum(1, null, 1);
		MixedNum m4 = new MixedNum(0, null, 1);
		MixedNum m5 = new MixedNum(5, null, null);
		MixedNum m6 = new MixedNum(3, 1, null);
		MixedNum m7 = new MixedNum(3, 1, 2);
		MixedNum m8 = new MixedNum(null, null, 2);
		MixedNum m9 = new MixedNum(null, 1, 2);
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		System.out.println(m4);
		System.out.println(m5);
		System.out.println(m6);
		
		System.out.println(m7);
		System.out.println(m8);
		System.out.println(m9);
		
		MixedNum m = MixedNum.valueOf("-3_2/3");
		System.out.println(m);
		
		m = MixedNum.valueOf("-2/3");
		System.out.println(m);
		
		m = MixedNum.valueOf("-2");
		System.out.println(m);
	}

	public MixedNum(Integer whole, Integer nr, Integer dr) {
		
		this.whole = whole;

		if (nr != null && dr != null)
			this.fraction = new Fraction(nr, dr);
	}

	public Integer getWhole() {
		return whole;
	}

	public Fraction getFraction() {
		return fraction;
	}
	
	public boolean isWholeEmptyOrZero() {
		return whole == null || whole == 0 ? true: false;
	}
	
	public boolean isFractionEmptyOrZero() {
		return ( fraction == null ||
		         fraction.getNr() == null || 
		         fraction.getNr() == 0 )? true : false;
	}


    /*
     * Converts a mixed number to a string.
     * 
     * Eg:  1_1/2, 1, 1/2, 0 etc
     *  
     * Format of the String output depends on the number it represents.  
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		//0_1/2 = 1/2
		//null_1/2 = 1/2 
		//1_1/2 = 1_1/2
		if( !isWholeEmptyOrZero() && !isFractionEmptyOrZero() ){
			sb.append(whole);
            sb.append("_");
			sb.append(fraction.getNr());
			sb.append("/");
			sb.append(fraction.getDr());
			
		}else if( !isWholeEmptyOrZero() && isFractionEmptyOrZero() ) {
			sb.append(whole);
			
		}else if ( isWholeEmptyOrZero() && !isFractionEmptyOrZero() ) {
			
			sb.append(fraction.getNr());
			sb.append("/");
			sb.append(fraction.getDr());
		}else {
			//both are empty
			sb.append(0);
		}
		return sb.toString();
	}
	
	// we can move it to a different class if we want to support different string
	// representation
	public static MixedNum valueOf(String s) {
		if (s == null || s.length() == 0)
			return null;

		s = s.trim();

		// 2_3/8, 9/8, 4
		// 4
		if (!s.contains("_") && !s.contains("/")) {
			// whole number
			return new MixedNum(Integer.valueOf(s), null, null);
		}

		String fractionalPart = null;
		Integer wholeNumber = null;

		if (s.contains("_")) {
			String[] parts = s.split("_");

			wholeNumber = Integer.valueOf(parts[0]);
			fractionalPart = parts[1];
		} else if (s.contains("/")) {
			fractionalPart = s;
		}
		String[] nrDr = fractionalPart.split("/");

		if (nrDr.length != 2) {
			// error
		}
		return new MixedNum(wholeNumber, Integer.valueOf(nrDr[0]), Integer.valueOf(nrDr[1]));
	}
	
	
	//Eg: 5_1/2 =  11/2
	//   1_1/2 = 3/2
	//   0_1/2 = 1/2
	public Fraction convertToFraction() {
		if( (whole == null || whole == 0) && fraction != null) {
			return new Fraction(fraction.getNr(), fraction.getDr());
		}
		
		if( whole != null && fraction == null) {
			return new Fraction(whole, 1);
		}
		
		return new Fraction(whole*fraction.getDr() + fraction.getNr(), fraction.getDr());
	}
	
	
	/*
	 * Eg:  5/4  into 4_1/4
	 *      8/2  into 4
	 */
    public static MixedNum convertToMixedNum(int nr,int dr) {
    	if( nr == 0) {
    		return new MixedNum(0,null, null);
    	}
		
		if( nr < dr ) {
			return new MixedNum(0,nr, dr);
		}
		
		int mod = nr % dr;
		if( mod == 0) {
			return new MixedNum(nr/dr,null, null);
		}
		
		return new MixedNum(nr/dr,mod, dr);
	}

}
