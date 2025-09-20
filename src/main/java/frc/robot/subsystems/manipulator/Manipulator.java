package frc.robot.subsystems.manipulator;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import frc.lib.generic.GenericSubsystem;
import frc.lib.generic.hardware.motor.MotorProperties;

import static frc.robot.subsystems.manipulator.ManipulatorConstants.MANIPULATOR_MOTOR;

public class Manipulator extends GenericSubsystem {
    public Command runVoltage(double voltage) {
        return new FunctionalCommand(
                () -> {
                },
                () -> MANIPULATOR_MOTOR.setOutput(MotorProperties.ControlMode.VELOCITY, voltage),
                (interrupt) -> MANIPULATOR_MOTOR.stopMotor(),
                () -> false,
                this
        );
    }
}