package org.firstinspires.ftc.teamcode.Challenges;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Chalange0 extends LinearOpMode {

    String name = "Chalange0";
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("you did a thing", "yay");
    }
}
