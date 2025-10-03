package org.firstinspires.ftc.teamcode.Challenges;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class IntakeSystem extends LinearOpMode {

    DcMotor intakeMotor;

    @Override
    public void runOpMode() {
        intakeInit();
        waitForStart();
        while(opModeIsActive()){
            intakeMotor.setPower(1.0);
        }
    }


    public void intakeInit(){
        intakeMotor = hardwareMap.get(DcMotor.class, "right motor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        telemetry.addLine("the intake is initialized" );
        telemetry.update();
    }

}
