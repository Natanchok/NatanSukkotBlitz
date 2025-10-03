package org.firstinspires.ftc.teamcode.Challenges;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@TeleOp
public class Shooter extends LinearOpMode {
    DcMotor shootermotor;

    @Override
    public void runOpMode(){
        shooterInit();
        waitForStart();
        while (opModeIsActive()){
           double power = 0;
            if(gamepad1.right_trigger>0){
                power = (gamepad1.right_trigger<=0.5)? 0.5 : 1.0;
            }
            shootermotor.setPower(power);
            telemetry.addData("Right Trigger: ", gamepad1.right_trigger);
            telemetry.addData("Motor Power: ", power);
            telemetry.update();
        }
    }
    private void shooterInit(){
        shootermotor = hardwareMap.get(DcMotor.class, "shooter motor");
        shootermotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shootermotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shootermotor.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addLine("the shooter is initialized" );
        telemetry.update();
    }

}
