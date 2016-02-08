package org.usfirst.frc.team3167.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain {
	
	private Joystick driveStick = new Joystick(1);
	
	private static final double stopSpeed = 0.0; 
	
	private Talon leftMotorA = new Talon(1);
	private Talon leftMotorB = new Talon(2);
	
	private Talon rightMotorA = new Talon(3);
	private Talon rightMotorB = new Talon(4);
	
	private RobotDrive driveA =
			new RobotDrive(leftMotorA, rightMotorA); 
	private RobotDrive driveB = 
			new RobotDrive(leftMotorB, rightMotorB); 
	
	public void drive() 
	{
		driveA.arcadeDrive(-driveStick.getRawAxis(1),
				-driveStick.getRawAxis(2));
		driveB.arcadeDrive(-driveStick.getRawAxis(1), 
				-driveStick.getRawAxis(2));
		
		if(driveStick.getRawButton(4)) 
		{
			setAllDriveMotorsStop();
		}
	}
	
	public void setAllDriveMotorsStop()
	{
		leftMotorA.set(stopSpeed);
		leftMotorB.set(stopSpeed);
		
		rightMotorA.set(stopSpeed);
		rightMotorB.set(stopSpeed);
	}
}
