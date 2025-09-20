package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import frc.lib.generic.GenericSubsystem;
import frc.lib.generic.hardware.motor.MotorProperties;

import static frc.robot.subsystems.intake.IntakeConstants.INTAKE_MOTOR;

public class Intake extends GenericSubsystem {
    public Command runVoltage(double voltage) {
        return new FunctionalCommand(
                () -> {
                },
                () -> INTAKE_MOTOR.setOutput(MotorProperties.ControlMode.VELOCITY, voltage),
                (interrupt) -> INTAKE_MOTOR.stopMotor(),
                () -> false,
                this
        );
    }
}
