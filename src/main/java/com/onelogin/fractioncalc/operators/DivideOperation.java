package com.onelogin.fractioncalc.operators;

import com.onelogin.fractioncalc.model.Fraction;
import com.onelogin.fractioncalc.model.MixedNum;

public class DivideOperation implements Operation {

	@Override
	public MixedNum perform(MixedNum arg1, MixedNum arg2) {
		//TODO:  comments
		Fraction f1 = arg1.convertToFraction();
		Fraction f2 = arg2.convertToFraction();
		
		int nr = f1.getNr() * f2.getDr();
		int dr = f1.getDr() * f2.getNr();
		
		Fraction red = new Fraction(nr,dr).reduce();
		
		return MixedNum.convertToMixedNum(red.getNr(),red.getDr());
		
	}

}
