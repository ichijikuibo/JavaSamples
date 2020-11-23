package com.cc.math;

public class Quadratic {
	public double a = 0;
	public double b = 0;
	public double c = 0;
	public double positiveResult = 0;
	public double negativeResult = 0;
	public Quadratic(double A, double B, double C)
	{
		a=A;
		b=B;
		c=C;
		positiveResult = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
		negativeResult = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
	}
}
