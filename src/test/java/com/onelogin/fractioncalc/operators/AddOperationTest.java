package com.onelogin.fractioncalc.operators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.onelogin.fractioncalc.model.MixedNum;

public class AddOperationTest {
	
	Operation op = new AddOperation();
	
	static MixedNum[][] testData = {
			{new MixedNum(1, 1, 2),new MixedNum(1, 1, 2),new MixedNum(3,null,null)},
			{new MixedNum(null, 1, 2),new MixedNum(null, 1, 2),new MixedNum(1,null,null)},
			{new MixedNum(3, 1, 2),new MixedNum(4, 1, 4),new MixedNum(7,3,4)}
	};
	
	@Test
	public void testPerform() {
		for(int i=0; i<testData.length; i++) {
			//TODO we can use Junit's data provider ( or TestNGs data provider)
			
			MixedNum m1 = testData[i][0];
			MixedNum m2 = testData[i][1];
			MixedNum exp = testData[i][2];
			
			MixedNum res = op.perform(m1, m2);
			
			if( exp == null) {
				assertTrue(res == null);
			}else {
				assertTrue(res != null);
				
				if(exp.getFraction() == null) {
					assertTrue(res.getFraction()==null);
				}else {
					assertTrue(res.getFraction().getNr() == exp.getFraction().getNr());
					assertTrue(res.getFraction().getNr() == exp.getFraction().getNr());
				}
				
			}
		}
	}
	


}
