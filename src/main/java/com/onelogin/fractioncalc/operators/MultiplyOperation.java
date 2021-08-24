package com.onelogin.fractioncalc.operators;

import com.onelogin.fractioncalc.model.Fraction;
import com.onelogin.fractioncalc.model.MixedNum;

public class MultiplyOperation  implements Operation {

	@Override
	public MixedNum perform(MixedNum arg1, MixedNum arg2) {
		//TODO comments
		
		if( arg1 == null || arg2 == null) {
			return null;
		}
		Fraction f1 = arg1.convertToFraction();
		Fraction f2 = arg2.convertToFraction();
		
		int nr = f1.getNr() * f2.getNr();
		int dr = f1.getDr() * f2.getDr();
		
		Fraction red = new Fraction(nr,dr).reduce();
		
		return MixedNum.convertToMixedNum(red.getNr(),red.getDr());
	}

}
