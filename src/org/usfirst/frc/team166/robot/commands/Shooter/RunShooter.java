package org.usfirst.frc.team166.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team166.robot.Robot;
import org.usfirst.frc.team166.robot.RobotMap;

/**
 *
 */
public class RunShooter extends Command {

	public RunShooter() {
		requires(Robot.shooter);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	@Override
	protected void initialize() {
		Robot.shooter.shooterOn();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {

		double waitForShooter = Preferences.getInstance().getDouble(RobotMap.waitForShooter, 5.0);
		return Robot.shooter.hasRunFor(waitForShooter);

	}

	@Override
	protected void end() {
		Robot.shooter.stopShooter();
	}

	@Override
	protected void interrupted() {
		Robot.shooter.stopShooter();
	}
}
