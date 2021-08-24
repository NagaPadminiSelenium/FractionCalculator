package com.onelogin.fractioncalc.misc;

public class Utils {
	
	public static int lcm(int num1,int num2) {
		int gcd = gcd(num1,num2);
		return (num1 * num2)/gcd;
	}
	
	public static int gcd(int nr, int dr) {
		int n = nr;
		int d = dr;

		while (d != 0) {
			
			int t = d;
			//System.out.println(String.format("%s %s %s", n,d,t));
			d = n % d; 
			n = t;
		}
		int gcd = n;
		return gcd;
	}

}
