package com.onelogin.fractioncalc.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import com.onelogin.fractioncalc.misc.InvalidCommandException;
import com.onelogin.fractioncalc.model.MixedNum;
import com.onelogin.fractioncalc.operators.AddOperation;
import com.onelogin.fractioncalc.operators.DivideOperation;
import com.onelogin.fractioncalc.operators.MultiplyOperation;
import com.onelogin.fractioncalc.operators.Operation;
import com.onelogin.fractioncalc.operators.SubstractOperation;


public class CommandProcessor {
	
    private static Set<String> ALLOWED_BINARY_OPERATORS = new HashSet<String>();
    
    private static Map<String,Operation> registry = new HashMap<String, Operation>();
	
	static {
		Collections.addAll(ALLOWED_BINARY_OPERATORS, "*", "+","/","-");
	}
	
	
	public CommandProcessor(){
		//create registry
		registry.put("+", new AddOperation());
		registry.put("-", new SubstractOperation());
		registry.put("*", new MultiplyOperation());
		registry.put("/", new DivideOperation());
		
	}
	
	public MixedNum evaluate(String expr) {
		List<String> tokens = getOperandsAndOperators(expr);
		
		//validate
		//supports only 
		if( tokens.size() != 3) {
			throw new InvalidCommandException("Only binary operations are supported");
		}
		
		String operator = tokens.get(1);
		if( !ALLOWED_BINARY_OPERATORS.contains(operator) ) {
			throw new InvalidCommandException("Incorrect expression - incorrect operator");
		}
		
		MixedNum operand1 = MixedNum.valueOf(tokens.get(0));
		MixedNum operand2 = MixedNum.valueOf(tokens.get(2));
		
		//Look up operation based on operator.
		return registry.get(operator).perform(operand1, operand2);
		
	}
	
	private static List<String> getOperandsAndOperators(String s) {
		List<String> tokens = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			tokens.add(st.nextToken());
		}
		return tokens;
	}

}
