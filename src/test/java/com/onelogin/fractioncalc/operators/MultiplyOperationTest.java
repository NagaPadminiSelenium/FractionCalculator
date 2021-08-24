package com.onelogin.fractioncalc.operators;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.onelogin.fractioncalc.model.MixedNum;

public class MultiplyOperationTest {

	Operation op = new MultiplyOperation();

	@ParameterizedTest(name = "Run {index}: op1={0}, op2={1}")
	@MethodSource("testParameters")
	public void testPerformTwoMixedNums(String op1, String op2, Integer exWhole,Integer exNr,Integer exDr) {

		MixedNum res = op.perform(MixedNum.valueOf(op1), MixedNum.valueOf(op2));
		

		if( exWhole != null) {
		  assertNotNull(res);
		  assertTrue(res.getWhole() == exWhole);
		  
		  if( exNr == null) {
			  assertTrue(res.getFraction() == null || res.getFraction().getNr() == null);
		  }
		} else {
		  assertTrue(res == null);
		}
	}

	@Test
	public void testPerformZeroOperand() {

		MixedNum res = op.perform(MixedNum.valueOf("1_1/2"), MixedNum.valueOf("0"));

		assertNotNull(res);
		assertTrue(res.getWhole() == 0);
		assertTrue(res.getFraction() == null);

	}

	static Stream<Arguments> testParameters() throws Throwable {
		return Stream.of(
				Arguments.of("1_1/2","3",4,1,2),
				Arguments.of("3","3",9,null,null),
				Arguments.of("0","3_1/2",0,null,null),
				Arguments.of(null,"3",null,null,null)
				
				);
	}

}
