package org.usfirst.frc.team3167.robot;

import edu.wpi.first.wpilibj.Jaguar;

public class BallWheels {
	
	private static final double ballPullInSpeed = 0.5; 
	private static final double ballShootOutSpeed = 1.0; 
	private static final double stopSpeed = 0.0; 
	
	private Jaguar leftWheelMotor;
	private Jaguar rightWheelMotor;
	
	public BallWheels(int leftChannel, int rightChannel) 
	{
		leftWheelMotor = new Jaguar(5);
		rightWheelMotor = new Jaguar(6); 
	}
	public void pullIn() 
	{
		leftWheelMotor.set(ballPullInSpeed);
		rightWheelMotor.set(-ballPullInSpeed);
	}
	public void shoot() 
	{
		leftWheelMotor.set(-ballShootOutSpeed);
		rightWheelMotor.set(ballShootOutSpeed);
	}
	public void stop() 
	{
		leftWheelMotor.set(stopSpeed);
		rightWheelMotor.set(stopSpeed);
	}

}
