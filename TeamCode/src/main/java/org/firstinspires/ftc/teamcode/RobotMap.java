package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class RobotMap {

    // Robot Parameters
    public static final Boolean DISPLAY_TIME = true;

    // Drivetrain Parameters
    public static final String LEFT_FRONT_MOTOR = "left_front_drive";
    public static final String RIGHT_FRONT_MOTOR = "right_front_drive";
    public static final String LEFT_BACK_MOTOR = "left_back_drive";
    public static final String RIGHT_BACK_MOTOR = "right_back_drive";
    public static final DcMotor.Direction LEFT_DRIVE_DIRECTION = DcMotor.Direction.FORWARD;
    public static final DcMotor.Direction RIGHT_DRIVE_DIRECTION = DcMotor.Direction.REVERSE;

    //TankDrive Parameters
    public static final Boolean DISPLAY_MOTOR_VALUES = true;
    public static final Boolean REVERSE_JOYSTICKS = false;
    public static final double HIGHSPEED = 0.9;
    public static final double LOWSPEED = 0.3;

    //Encoder Parameters
    public static final Boolean DISPLAY_ENCODER_VALUES = true;

    //Claw Parameters

    public static final String CLAW_SERVO_LEFT = "claw_servo_left"; // port 4
    public static final String CLAW_SERVO_RIGHT = "claw_servo_right"; // port 3
    public static final double SERVO_OPEN_LEFT = 0.66;
    public static final double SERVO_OPEN_RIGHT = 0.22;
    public static final double SERVO_CLOSED_LEFT = 0.33;
    public static final double SERVO_CLOSED_RIGHT = 0.55;
    public static final double SERVO_ANGLE_DEFAULT_LEFT = SERVO_CLOSED_LEFT;
    public static final double SERVO_ANGLE_DEFAULT_RIGHT = SERVO_CLOSED_RIGHT;
    public static final String CLAW_SERVO = "claw_servo"; // port 5
    public static final double SERVO_OPEN = 0.55;
    public static final double SERVO_CLOSED = 0.22;
    public static final double MINIMUM_SERVO_POSITION = 0.0;
    public static final double MAXIMUM_SERVO_POSITION = 1.0;
    public static final double SERVO_ANGLE_DEFAULT = SERVO_CLOSED;
    public static final double SERVO_PARALLEL_LEFT = 0.95;
    public static final double SERVO_PARALLEL_RIGHT = 0.00;

    //Collision Avoidance Parameters
    public static final double ARM_GROUND_CLEARANCE = 2; // Arm ground clearance in inches
    public static final double ARM_LENGTH = 18;
    public static final double ARM_ENCODER_CONSTANT = 0.5; // Degrees per encoder count
    public static final double ELEVATOR_MIN_HEIGHT = 12; // minimum elevator height in inches
    public static final double ELEVATOR_ENCODER_CONSTANT = 0.5; // Elevator's inches per encoder count

    //Arm Parameters
    public static final String LEFT_ARM_MOTOR = "arm_left";
    public static final String RIGHT_ARM_MOTOR = "arm_right";
    public static final DcMotor.Direction LEFT_ARM_DIRECTION = DcMotor.Direction.FORWARD;
    public static final DcMotor.Direction RIGHT_ARM_DIRECTION = DcMotor.Direction.FORWARD;
    public static final double ARM_SPEED_UP = 0.25;
    public static final double ARM_SPEED_DOWN = 0.1;
    public static final double kP = 0.05;
    public static final double DEADZONE = 0.05;

    //Elevator Parameters
    public static final String ELEVATOR_MOTOR = "elevator_motor";
    public static final DcMotor.Direction ELEVATOR_DIRECTION = DcMotor.Direction.FORWARD;
    public static final double ELEVATOR_SPEED = 0.5;

    //Auton Parameters
    public static final int ENCODER_TOLERANCE = 10;
    public static final double AUTO_ARM_SPEED = 0.17;
}
