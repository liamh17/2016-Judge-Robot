package org.usfirst.frc.team3167.robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;

public class BallWheels {
	
	private static final double ballPullInSpeed = 0.5; 
	private static final double ballShootOutSpeed = 1.0; 
	private static final double stopSpeed = 0.0; 
	
	private Joystick driveStick = new Joystick(1); 
	
	private Jaguar leftWheelMotor = new Jaguar(5);
	private Jaguar rightWheelMotor = new Jaguar(6);
	
	public void shooterGrabber() 
	{
        if(driveStick.getRawButton(3)) 
        {
        	pullIn(); 
        }
        else if(driveStick.getRawButton(4)) 
        {
        	shoot(); 
        }
        else 
        {
        	stop(); 
        }
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
