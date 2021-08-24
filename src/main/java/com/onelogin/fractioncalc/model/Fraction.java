package com.onelogin.fractioncalc.model;

import com.onelogin.fractioncalc.misc.Utils;


/**
 * Encapsulates a fraction represented by numerator and denominator.
 *
 */
public class Fraction {
	private Integer nr;
	private Integer dr;
	
	public Fraction(Integer nr,Integer dr) {
		if( nr == null || dr == null) {
			throw new IllegalArgumentException("numerator or denominator cant be null");
		}
		if(dr == 0) {
            throw new IllegalArgumentException("denominator is zero");
        }
		this.nr = nr;
		this.dr = dr;
	}
	
	public Integer getNr() {
		return nr;
	}
	public Integer getDr() {
		return dr;
	}
	
	// Reduces the fraction so that numerator and denominator are not divisble by any number.
	// Eg:  12/4 = 3/1
	//      15/10 =  3/2
	public Fraction reduce() {
		int gcd = Utils.gcd(nr, dr);
		
		nr /= gcd;
		dr /= gcd;
		
		return new Fraction(nr, dr);
	}
	
	@Override
	public String toString() {
		return String.valueOf(nr) + "/" +String.valueOf(dr);
	}

	
}
