package frc.robot.subsystems.manipulator;

import frc.lib.generic.hardware.motor.*;

import static frc.robot.utilities.PortsConstants.ManipulatorPorts.MANIPULATOR_MOTOR_PORT;

public class ManipulatorConstants {
    public static Motor MANIPULATOR_MOTOR = MotorFactory.createSpark("MANIPULATOR_MOTOR", MANIPULATOR_MOTOR_PORT, MotorProperties.SparkType.MAX);

    static {
        configureManipulatorMotor();
    }

    private static void configureManipulatorMotor() {
        final MotorConfiguration manipulatorConfiguration = new MotorConfiguration();

        manipulatorConfiguration.inverted = false;
        manipulatorConfiguration.gearRatio = 1;
        manipulatorConfiguration.supplyCurrentLimit = 40;
        manipulatorConfiguration.idleMode = MotorProperties.IdleMode.COAST;

        manipulatorConfiguration.slot = new MotorProperties.Slot(1, 0, 0, 0, 0, 0);

        MANIPULATOR_MOTOR.configure(manipulatorConfiguration);

        MANIPULATOR_MOTOR.setupSignalUpdates(MotorSignal.POSITION);
        MANIPULATOR_MOTOR.setupSignalUpdates(MotorSignal.VELOCITY);
        MANIPULATOR_MOTOR.setupSignalUpdates(MotorSignal.VOLTAGE);
        MANIPULATOR_MOTOR.setupSignalUpdates(MotorSignal.CLOSED_LOOP_TARGET);
    }
}
