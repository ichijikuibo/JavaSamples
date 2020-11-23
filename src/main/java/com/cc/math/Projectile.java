package com.cc.math;

public class Projectile {
	public double intitalSpeed = 0;
	public double angle = 0;
	public double horizontalD = 0;
	public double horizontalD2 = 0;
	public double verticalD = 0;
	public double horizontalS = 0;
	public double verticalS = 0;
	public double time1 = 0;
	public double time2 = 0;
	final static double gravity = 9.807;
	public Projectile(double newInitialSpeed,double newAngle,double newHorizontalD,double newVerticalD,double newTime)
	{
		horizontalS = newInitialSpeed/Math.sin(Math.toRadians(90))*Math.sin(Math.toRadians(90-newAngle));
		verticalS = newInitialSpeed/Math.sin(Math.toRadians(90))*Math.sin(Math.toRadians(newAngle));
		intitalSpeed = newInitialSpeed;
		angle = newAngle;
		horizontalD = newHorizontalD;
		verticalD = newVerticalD;
		time1 = newTime;
		Quadratic result = new Quadratic(gravity*0.5,verticalS,-newVerticalD);
		time2 = result.positiveResult;
		horizontalD2 = horizontalS*time2;
	}
	public static Projectile fromAngleSpeedTime(double newAngle,double newInitialSpeed,double newTime)
	{
		double horizontalS = newInitialSpeed/Math.sin(Math.toRadians(90))*Math.sin(Math.toRadians(90-newAngle));
		double newHorizontalD = horizontalS*newTime;
		double verticalS = newInitialSpeed/Math.sin(Math.toRadians(90))*Math.sin(Math.toRadians(newAngle));
		double newVerticalD = (verticalS*newTime) - 0.5*gravity*Math.pow(newTime,2);

		return new Projectile(newInitialSpeed, newAngle, newHorizontalD, newVerticalD, newTime);
	}
	public static Projectile fromHDistanceAngleSpeed(double newAngle,double newInitialSpeed,double newDistance)
	{
		double horizontalS = newInitialSpeed/Math.sin(Math.toRadians(90))*Math.sin(Math.toRadians(90-newAngle));
		double verticalS = newInitialSpeed/Math.sin(Math.toRadians(90))*Math.sin(Math.toRadians(newAngle));
		double newTime = newDistance/horizontalS;
		double newVerticalD = (verticalS*newTime) - 0.5*gravity*Math.pow(newTime,2);
		return new Projectile(newInitialSpeed, newAngle, newDistance, newVerticalD, newTime);
	}
	public static Projectile fromVDistanceAngleSpeed(double newAngle,double newInitialSpeed,double newDistance)
	{
		double horizontalS = newInitialSpeed/Math.sin(Math.toRadians(90))*Math.sin(Math.toRadians(90-newAngle));
		double verticalS = newInitialSpeed/Math.sin(Math.toRadians(90))*Math.sin(Math.toRadians(newAngle));
		double newVerticalD = newDistance;
		Quadratic result = new Quadratic(gravity*0.5,verticalS,-newDistance);
		return new Projectile(newInitialSpeed, newAngle, horizontalS*result.negativeResult, newVerticalD, result.negativeResult);
	}
}
