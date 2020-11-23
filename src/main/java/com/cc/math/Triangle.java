package com.cc.math;

public class Triangle {
	public double angleA = 0;
	public double sideA = 0;
	public double angleB = 0;
	public double sideB = 0;
	public double angleC = 0;
	public double sideC = 0;
	public Triangle(double newAngleA,double newAngleB,double newAngleC,double newSideA,double newSideB,double newSideC)
	{
		angleA = newAngleA;
		angleB =newAngleB;
		angleC =newAngleC;
		sideA = newSideA;
		sideB = newSideB;
		sideC = newSideC;
	}
	public static Triangle fromABa(double angle1, double side1, double angle2)
	{
		double side2 = side1/Math.sin(Math.toRadians(angle1))*Math.sin(Math.toRadians(angle2));
		double angle3 = 180-angle1-angle2;
		double side3 = side1/Math.sin(Math.toRadians(angle1))*Math.sin(Math.toRadians(angle3));
		return new Triangle(angle1,angle2,angle3,side1,side2,side3);
	}
	public static Triangle fromAab(double angle1, double side1, double side2)
	{
		double angle2 = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(angle1))/side1*side2));
		double angle3 = 180-angle1-angle2;
		double side3 = side1/Math.sin(Math.toRadians(angle1))*Math.sin(Math.toRadians(angle3));
		return new Triangle(angle1,angle2,angle3,side1,side2,side3);
	}
	public static Triangle fromaBC(double angle1, double side2, double side3)
	{
		double side1 = Math.sqrt(side2*side2+side3*side3 - 2*side2*side3*Math.cos(Math.toRadians(angle1)));
		double angle2 = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(angle1))/side1*side2));
		double angle3 = 180-angle1-angle2;		
		return new Triangle(angle1,angle2,angle3,side1,side2,side3);
	}
	public static Triangle fromabc(double side1, double side2, double side3)
	{
		double angle1 = Math.toDegrees(Math.acos(((side1*side1-(side2*side2+side3*side3))/-(2*side2*side3))));
		double angle2 = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(angle1))/side1*side2));
		double angle3 = 180-angle1-angle2;		
		return new Triangle(angle1,angle2,angle3,side1,side2,side3);
	}
}
