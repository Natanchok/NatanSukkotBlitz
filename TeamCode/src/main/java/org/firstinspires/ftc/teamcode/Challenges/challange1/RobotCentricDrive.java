package org.firstinspires.ftc.teamcode.Challenges.challange1;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp
public class RobotCentricDrive extends LinearOpMode {

    DcMotor RF;
    DcMotor RB;
    DcMotor LF;
    DcMotor LB;

    @Override
    public void runOpMode() {

        RF = hardwareMap.get(DcMotor.class, "RF");
        RB = hardwareMap.get(DcMotor.class, "RB");
        LF = hardwareMap.get(DcMotor.class, "LF");
        LB = hardwareMap.get(DcMotor.class, "LB");

        LF.setDirection(DcMotor.Direction.REVERSE);
        RF.setDirection(DcMotor.Direction.REVERSE);

        LF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
        telemetry.addData("Status", "running");
        telemetry.update();

        }
    }
}
