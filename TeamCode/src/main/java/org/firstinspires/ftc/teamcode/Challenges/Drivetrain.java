package org.firstinspires.ftc.teamcode.Challenges;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

@TeleOp(name = "Drivetrain Fixed", group = "Challenges")
public class Drivetrain extends LinearOpMode {

    private DcMotor LF, RF, LB, RB;
    private double strafe, forward, turn;
    private boolean slowModeEnabled = false;
    private boolean previousBState = false;

    // IMU orientation settings (if used)
    private final RevHubOrientationOnRobot revHubOrientation = new RevHubOrientationOnRobot(
            RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
            RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD
    );

    @Override
    public void runOpMode() {
        initializeDrivetrain();

        telemetry.addLine("Drivetrain initialized — waiting for start");
        telemetry.update();

        waitForStart();

        // Safety: reset powers once more when match starts
        stopAllMotors();

        while (opModeIsActive()) {
            // Read inputs with deadzone applied
            strafe = applyDeadzone(gamepad1.left_stick_x);
            forward = applyDeadzone(-gamepad1.left_stick_y);
            turn = applyDeadzone(gamepad1.right_stick_x);

            drive(forward, strafe, turn);

            // Telemetry for debugging
            telemetry.addData("Forward", forward);
            telemetry.addData("Strafe", strafe);
            telemetry.addData("Turn", turn);
            telemetry.addData("Slow Mode", slowModeEnabled ? "ON" : "OFF");
            telemetry.update();
        }

        stopAllMotors();
    }

    private void initializeDrivetrain() {
        LF = hardwareMap.get(DcMotor.class, "leftFront");
        RF = hardwareMap.get(DcMotor.class, "rightFront");
        LB = hardwareMap.get(DcMotor.class, "leftBack");
        RB = hardwareMap.get(DcMotor.class, "rightBack");

        // Reverse the left side to ensure correct mecanum behavior
        LF.setDirection(DcMotorSimple.Direction.REVERSE);
        LB.setDirection(DcMotorSimple.Direction.REVERSE);
        RF.setDirection(DcMotorSimple.Direction.FORWARD);
        RB.setDirection(DcMotorSimple.Direction.FORWARD);

        // Make sure motors don’t spin on init
        stopAllMotors();

        // Set zero power behavior
        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Run without encoders (standard for TeleOp)
        LF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Initialize IMU (optional)
        IMU imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(revHubOrientation));
    }

    private void drive(double forward, double strafe, double rotate) {
        double lFPower = forward + strafe + rotate;
        double lBPower = forward - strafe + rotate;
        double rFPower = forward - strafe - rotate;
        double rBPower = forward + strafe - rotate;

        // Normalize so no value exceeds 1.0
        double max = Math.max(1.0, Math.abs(lFPower));
        max = Math.max(max, Math.abs(lBPower));
        max = Math.max(max, Math.abs(rFPower));
        max = Math.max(max, Math.abs(rBPower));

        double slowMultiplier = slowMode();

        LF.setPower((lFPower / max) * slowMultiplier);
        LB.setPower((lBPower / max) * slowMultiplier);
        RF.setPower((rFPower / max) * slowMultiplier);
        RB.setPower((rBPower / max) * slowMultiplier);
    }

    private double slowMode() {
        double slow = 0.5;

        if (gamepad1.b && !previousBState) {
            slowModeEnabled = !slowModeEnabled;
        }
        previousBState = gamepad1.b;

        return slowModeEnabled ? slow : 1.0;
    }

    private double applyDeadzone(double value) {
        double deadzone = 0.1;
        return (Math.abs(value) < deadzone) ? 0 : value;
    }

    private void stopAllMotors() {
        if (LF != null) LF.setPower(0);
        if (RF != null) RF.setPower(0);
        if (LB != null) LB.setPower(0);
        if (RB != null) RB.setPower(0);
    }
}
