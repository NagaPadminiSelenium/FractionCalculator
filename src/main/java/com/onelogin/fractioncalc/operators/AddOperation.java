package com.onelogin.fractioncalc.operators;

import com.onelogin.fractioncalc.misc.Utils;
import com.onelogin.fractioncalc.model.Fraction;
import com.onelogin.fractioncalc.model.MixedNum;

public class AddOperation implements Operation {

	@Override
	public MixedNum perform(MixedNum arg1, MixedNum arg2) {
		
		//convert mixed number to a fraction
		//Use LCM to match both the denominators 
		//Add 
		//convert it to a mixed number
		
		//Eg: 1_1/2 + 1_3/4
		//  = 3/2 +  7/4
		//  = 6/4 + 7/4
		//  = 13/4
		//  = 3_1/4
		
		Fraction f1 = arg1.convertToFraction();
		Fraction f2 = arg2.convertToFraction();
		
		int lcm = Utils.lcm(f1.getDr(), f2.getDr());
		
		
		int nr = (f1.getNr() * (lcm/f1.getDr()) + f2.getNr() * (lcm/f2.getDr()));
		int dr = lcm;
		
		Fraction red = new Fraction(nr,dr).reduce();
		
		MixedNum res = MixedNum.convertToMixedNum(red.getNr(),red.getDr());
		
		return res;
		
	}

}
