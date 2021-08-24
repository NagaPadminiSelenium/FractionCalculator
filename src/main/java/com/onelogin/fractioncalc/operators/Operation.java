package com.onelogin.fractioncalc.operators;

import com.onelogin.fractioncalc.model.MixedNum;

/*
 * Interface to represent a math operations with 2 operands.
 */
public interface Operation {
	
	public MixedNum perform(MixedNum arg1,MixedNum arg2);

}
