package org.usfirst.frc.team3167.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class Autonomous {
	
	private Talon leftMotorA;
	private Talon leftMotorB;
	
	private Talon rightMotorA; 
	private Talon rightMotorB;
	
	Timer timer = new Timer(); 
	
	public Autonomous(int leftChannelA, int leftChannelB,
			int rightChannelA, int rightChannelB) {

		leftMotorA = new Talon(leftChannelA);
		leftMotorB = new Talon(leftChannelB); 
		
		rightMotorA = new Talon(rightChannelA); 
		rightMotorB = new Talon(rightChannelB); 	
	}
	public void run()
	{
		timer.start();
		
		leftMotorA.set(1.0); 
		leftMotorB.set(1.0);
		
		rightMotorA.set(1.0);
		rightMotorB.set(1.0); 
		
		timer.delay(10);
		
		leftMotorA.set(1.0); 
		leftMotorB.set(1.0);
		
		rightMotorA.set(1.0);
		rightMotorB.set(1.0); 
		
		timer.stop();
	}
}
