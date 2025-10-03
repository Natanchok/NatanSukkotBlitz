package org.firstinspires.ftc.teamcode.Challenges.challange1;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MotorTriggerOperation extends LinearOpMode {
    DcMotor danik;

    @Override
    public void runOpMode() throws InterruptedException {
        // Get motor from config – make sure it's named "motor" in the DS config
        danik = hardwareMap.get(DcMotor.class, "motor");
        danik.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        danik.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        danik.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double power = 0;

            if (gamepad1.right_trigger > 0) {
                // forward
                power = (gamepad1.right_trigger <= 0.5) ? 0.5 : 1.0;
            } else if (gamepad1.left_trigger > 0) {
                // backward
                power = (gamepad1.left_trigger <= 0.5) ? -0.5 : -1.0;
            }

            danik.setPower(power);

            telemetry.addData("Right Trigger", gamepad1.right_trigger);
            telemetry.addData("Left Trigger", gamepad1.left_trigger);
            telemetry.addData("Motor Power", power);
            telemetry.update();
        }
    }
}
