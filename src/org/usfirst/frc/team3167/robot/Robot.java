
package org.usfirst.frc.team3167.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3167.robot.commands.ExampleCommand;
import org.usfirst.frc.team3167.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * The code that will operate the Judge 2016 Robot. 
 * 
 * Author: Kerry L. and Liam Heisler.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	
	private Joystick driveStick; 
	
	private BallWheels ballWheels; 
	private DriveTrain driveTrain;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        
        driveStick = new Joystick(1);
        
        ballWheels = new BallWheels(); 
        driveTrain = new DriveTrain(); 
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	System.out.println("The robot is ready to rock and roll!");
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        
        /*
         * Control drive train. 
         * Double check axes in DriveTrain
         * class before uploading. 
         */
        driveTrain.drive();
		
        /*driveA.arcadeDrive(-driveStick.getRawAxis(1),
				-driveStick.getRawAxis(2) * turnScaleFactor);
		driveB.arcadeDrive(-driveStick.getRawAxis(1), 
				-driveStick.getRawAxis(2) * turnScaleFactor);*/
		
        /* 
         * Control shooting mechanism. 
         * Double check buttons in BallWheels
         * class before uploading.
         */
        ballWheels.shooterGrabber();
        
        /*if(driveStick.getRawButton(3)) 
        {
        	ballWheels.pullIn(); 
        }
        else if(driveStick.getRawButton(4)) 
        {
        	ballWheels.shoot(); 
        }
        else 
        {
        	ballWheels.stop(); 
        }*/
      }

    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
    
    /*public void pullBallIn() 
    {
    	ballWheelLeft.set(-ballPullInSpeed);
    	ballWheelRight.set(ballPullInSpeed);
    }
    public void shootBall() 
    {
    	ballWheelLeft.set(ballPullInSpeed);
    	ballWheelRight.set(-ballShootOutSpeed);
    }*/
}
