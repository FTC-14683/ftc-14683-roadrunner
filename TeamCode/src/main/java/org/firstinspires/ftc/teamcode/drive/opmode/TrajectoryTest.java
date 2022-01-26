package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
@Autonomous(group = "drive")
public class TrajectoryTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        Trajectory goForward = drivetrain.trajectoryBuilder(new Pose2d(0,0,0))
                .forward(20)
                .build();
    drivetrain.followTrajectory(goForward);


    Trajectory lineToPosition = drivetrain.trajectoryBuilder(new Pose2d(20,0,0))
            .lineTo(new Vector2d(0,0))
            .build();
    drivetrain.followTrajectory(lineToPosition);


    Trajectory strafeLeft = drivetrain.trajectoryBuilder(new Pose2d(0,0,0))
            .strafeLeft(30)
            .build();
    drivetrain.followTrajectory(strafeLeft);


    Trajectory strafeToPosition = drivetrain.trajectoryBuilder(new Pose2d(0,30,0))
            .strafeTo(new Vector2d(0,20))
            .build();
    drivetrain.followTrajectory(strafeToPosition);
    }
}