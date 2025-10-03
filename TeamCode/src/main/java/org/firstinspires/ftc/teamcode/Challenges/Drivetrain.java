package org.firstinspires.ftc.teamcode.Challenges;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

@TeleOp
public class Drivetrain extends LinearOpMode {
    DcMotor LF, RF, LB, RB;
    double strafe, forward, turn;

    final RevHubOrientationOnRobot revHubOrientation = new RevHubOrientationOnRobot(
            RevHubOrientationOnRobot.LogoFacingDirection.UP,
            RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);

    @Override
    public void runOpMode() {
        InitializeDrivetrain();
        telemetry.addData("Robot is initialized", "did init ");
         while (opModeIsActive()){
             strafe = gamepad1.left_stick_x;
             forward = -gamepad1.left_stick_y;
             turn = gamepad1.right_stick_x;

             drive(forward, strafe, turn);
         }

    }

    public void InitializeDrivetrain() {

        final IMU imu;

        LF = hardwareMap.get(DcMotor.class, "leftFront");
        RF = hardwareMap.get(DcMotor.class, "rightFront");
        LB = hardwareMap.get(DcMotor.class, "leftBack");
        RB = hardwareMap.get(DcMotor.class, "rightBack");

        LF.setDirection(DcMotorSimple.Direction.REVERSE);
        LB.setDirection(DcMotorSimple.Direction.REVERSE);

        LF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        imu = hardwareMap.get(IMU.class, "imu");

        imu.initialize(new IMU.Parameters(revHubOrientation));
    }

    public void drive(double forward, double strafe, double rotate) {
        double lFPower = forward + strafe + rotate;
        double lBPower = forward - strafe + rotate;
        double rFPower = forward - strafe - rotate;
        double rBPower = forward + strafe - rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        maxPower = Math.max(maxPower, Math.abs(lFPower));
        maxPower = Math.max(maxPower, Math.abs(lBPower));
        maxPower = Math.max(maxPower, Math.abs(rFPower));
        maxPower = Math.max(maxPower, Math.abs(rBPower));

        LF.setPower(maxSpeed * (lFPower / maxPower));
        LB.setPower(maxSpeed * (lBPower / maxPower));
        RF.setPower(maxSpeed * (rFPower / maxPower));
        RB.setPower(maxSpeed * (rBPower / maxPower));
    }
}
