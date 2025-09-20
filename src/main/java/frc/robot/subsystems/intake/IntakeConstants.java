package frc.robot.subsystems.intake;

import frc.lib.generic.hardware.motor.*;

import static frc.robot.utilities.PortsConstants.IntakePorts.INTAKE_MOTOR_PORT;

public class IntakeConstants {
    public static Motor INTAKE_MOTOR = MotorFactory.createSpark("INTAKE_MOTOR", INTAKE_MOTOR_PORT, MotorProperties.SparkType.MAX);

    static {
        configureIntakeMotor();
    }

    private static void configureIntakeMotor() {
        final MotorConfiguration intakeConfiguration = new MotorConfiguration();

        intakeConfiguration.inverted = false;
        intakeConfiguration.gearRatio = 1;
        intakeConfiguration.supplyCurrentLimit = 40;
        intakeConfiguration.idleMode = MotorProperties.IdleMode.COAST;

        intakeConfiguration.slot = new MotorProperties.Slot(1, 0, 0, 0, 0, 0);

        INTAKE_MOTOR.configure(intakeConfiguration);

        INTAKE_MOTOR.setupSignalUpdates(MotorSignal.POSITION);
        INTAKE_MOTOR.setupSignalUpdates(MotorSignal.VELOCITY);
        INTAKE_MOTOR.setupSignalUpdates(MotorSignal.VOLTAGE);
        INTAKE_MOTOR.setupSignalUpdates(MotorSignal.CLOSED_LOOP_TARGET);
    }
}
