package com.onelogin.fractioncalc.operators;

import com.onelogin.fractioncalc.misc.Utils;
import com.onelogin.fractioncalc.model.Fraction;
import com.onelogin.fractioncalc.model.MixedNum;

public class SubstractOperation implements Operation {

	
	@Override
	public MixedNum perform(MixedNum arg1, MixedNum arg2) {
		//TODO: comments
		
		Fraction f1 = arg1.convertToFraction();
		Fraction f2 = arg2.convertToFraction();
		
		int lcm = Utils.lcm(f1.getDr(), f2.getDr());
		
		
		int nr = (f1.getNr() * (lcm/f1.getDr()) - f2.getNr() * (lcm/f2.getDr()));
		int dr = lcm;
		
		Fraction red = new Fraction(nr,dr).reduce();
		
		MixedNum res = MixedNum.convertToMixedNum(red.getNr(),red.getDr());
		
		return res;
		
	}

}
