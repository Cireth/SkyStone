package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FoundationAuton {

    public static enum SideColor {RED, BLUE;}
    public static enum Park {PARK, NO_PARK;}
    SideColor color;
    Park park;
    private DriveTrain drivetrain;
    private Claw claw;
    private Arm arm;
    private Elevator elevator;
    private int stage = 0;
    private double expirationTime;
    private int driveGoal;
    private ElapsedTime runtime;
    int strafeSign;


    public FoundationAuton (SideColor color, Park park, HardwareMap hardwareMap,
                            Telemetry telemetry, ElapsedTime runtime){
        this.color = color;
        this.park = park;
        this.runtime = runtime;
        drivetrain = new DriveTrain(hardwareMap, telemetry);
        claw = new Claw(hardwareMap, telemetry);
        arm = new Arm (hardwareMap, telemetry);
        elevator = new Elevator(hardwareMap, telemetry);
        strafeSign = (color == SideColor.BLUE) ? 1: -1;
    }

    public void mainStages(){
        arm.autonMaintain();
        elevator.autonMaintain();

        //Elevator up
        if (stage == 0){
            int elevatorGoal = elevator.getEncoder() + 400;
            elevator.setAutonGoal(elevatorGoal);
            expirationTime = runtime.time() + 1.5;
            stage = 1;

        }
        //Elevator up
        if (stage == 0){
            int elevatorGoal = elevator.getEncoder() + 400;
            elevator.setAutonGoal(elevatorGoal);
            expirationTime = runtime.time() + 1.5;
            stage = 1;
        }
        //Stop
        else if (stage == 1) {
            if (elevator.atGoal() || (runtime.time() > expirationTime)) stage = 2;
        }
        //Arm out of starting position
        else if (stage == 2) {
            int armGoal = arm.getEncoder() + 600;
            arm.setAutonGoal(armGoal);
            expirationTime = runtime.time() + 3.0;
            stage = 3;
        }
        //Stop Arm
        else if (stage == 3) {
            if (arm.atGoal() || (runtime.time() > expirationTime)) stage = 4;
        }
        //Elevator down
        else if (stage == 4) {
            int elevatorGoal = elevator.getEncoder() - 660;
            elevator.setAutonGoal(elevatorGoal);
            expirationTime = runtime.time() + 1.5;
            stage = 5;
        }
        //Stop Elevator
        else if (stage == 5) {
            if (arm.atGoal() || (runtime.time() > expirationTime)) stage = 6;
        }
        //First Strafe
        else if (stage == 6){
            drivetrain.mecanumDrive(0,0, 0.5*strafeSign);
            driveGoal = drivetrain.leftEncoder.getCurrentPosition() - 3000*strafeSign;
            expirationTime = runtime.time() + 3.5;
            claw.parallel();
            stage = 7;
        }
        //Stop
        else if (stage == 7){
            if ((drivetrain.leftEncoder.getCurrentPosition()*strafeSign < driveGoal*strafeSign) ||
                    (runtime.time() > expirationTime)){
                drivetrain.mecanumDrive(0,0,0);
                stage = 8;
            }
        }
        //Twords foundation
        else if (stage == 8){
            drivetrain.mecanumDrive(-.5,-.5,0);
            driveGoal = drivetrain.leftEncoder.getCurrentPosition() - 4000;
            expirationTime = runtime.time() + 3.5;
            stage = 9;
        }
        //Stop driving
        else if (stage == 9){
            if((drivetrain.leftEncoder.getCurrentPosition() < driveGoal) ||
                    (runtime.time() > expirationTime)){
                drivetrain.mecanumDrive(0,0,0);
                stage = 10;
            }

        }
        //Arm down on foundation
        else if (stage== 10) {
            int armGoal = arm.getEncoder() - 345;
            arm.setAutonGoal(armGoal);
            expirationTime = runtime.time() + 3;
            stage = 11;
        }
        //Stop arm
        else if (stage == 11){
            if (arm.atGoal() || (runtime.time() > expirationTime)) stage = 12;
        }
        //Pull foundation back
        else if (stage == 12){
            drivetrain.mecanumDrive(.3,.3,0);
            driveGoal = drivetrain.leftEncoder.getCurrentPosition() + 5000;
            expirationTime = runtime.time() + 7.5;
            stage = 13;
        }
        //Stop Driving
        else if (stage == 13){
            if((drivetrain.leftEncoder.getCurrentPosition() > driveGoal) ||
                    (runtime.time() > expirationTime)){
                drivetrain.mecanumDrive(0,0,0);
                stage = 14;
            }

        }
        //lift arm
        else if (stage == 14) {
            int armGoal = arm.getEncoder() + 300;
            arm.setAutonGoal(armGoal);
            expirationTime = runtime.time() + 1.0;
            stage = 15;
        }
        //stop arm
        else if (stage == 15){
            if (arm.atGoal() || (runtime.time() > expirationTime)) stage = 16;
        }
        //Lower elevator for bridge
        else if (stage == 16) {
            int elevatorGoal = elevator.getEncoder() - 600;
            elevator.setAutonGoal(elevatorGoal);
            expirationTime = runtime.time() + 2.0;
            stage = 17;
        }
        //Stop elevator
        else if (stage == 17) {
            if (arm.atGoal() || (runtime.time() > expirationTime)) stage = 18;
        }
        // Second Strafe (go towards bridge)
        else if (stage == 18){
            drivetrain.mecanumDrive(0,0, -0.5*strafeSign);
            int distance = (park == Park.PARK) ? 7150 : 4200;
            driveGoal = drivetrain.leftEncoder.getCurrentPosition() + distance*strafeSign;
            expirationTime = runtime.time() + 4.5;
            stage = 19;
        }
        //Stop
        else if (stage == 19){
            if ((drivetrain.leftEncoder.getCurrentPosition()*strafeSign > driveGoal*strafeSign) ||
                    (runtime.time() > expirationTime)){
                drivetrain.mecanumDrive(0,0,0);
                stage = 20;
            }
        }
        else if (stage == 20){
            if (color == SideColor.BLUE){
                int armGoal = arm.getEncoder() - 300;
                arm.setAutonGoal(armGoal);

                int elevatorGoal = elevator.getEncoder() + 650;
                elevator.setAutonGoal(elevatorGoal);
            }
            stage = 21;
        }

    }
}


