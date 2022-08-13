package frc.robot.commands

import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.networktables.NetworkTable
import edu.wpi.first.networktables.NetworkTableInstance
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.PIDCommand
import frc.robot.subsystems.Drivetrain
import java.time.LocalTime

/** Now that you've written the Drivetrain subsystem (or maybe you're doing this first idk), it's time to write
 * the command to drive the robot.
 */
class Drive(val drivetrain: Drivetrain, val speeds: () -> Pair<Double, Double>
    /** Like the DrivetrainSubsystem we can pass in args here too. What do you think the Drive command
     * should have? Motors? Controllers? Constants? Anything else?
     */
) : CommandBase() {

    // testing values!
    var time: Long = 0
    var lastTime: Long = 0
    var deltaTime: Double = 0.0
    var measured = 0.0
    var setpoint = 0.0


    var entry = NetworkTableInstance.getDefault().getTable("PID Tuning").getEntry("Drivetrain")
    var text = "time,measured,setpoint"
    /** Like the DrivetrainSubsystem, are there any useful variables we should initialize?**/
    val leftPID = PIDController(1.0,0.0,0.0)
    val rightPID = PIDController(1.0,0.0,0.0)
    init {
        /** This line here is required by WPILib, it just tells the CommandScheduler (which runs things behind
            the scenes what subsystems this command is using.
         **/
        addRequirements(drivetrain)
        entry.setString(text)
        /** Feel free to put any init code you think would be useful **/
    }

    override fun execute() {
        super.execute()
        var desired = speeds()
        var measured = drivetrain.wheelSpeeds()

        var leftPIDGain = leftPID.calculate(measured.leftMetersPerSecond, desired.first)
        var rightPIDGain = rightPID.calculate(measured.rightMetersPerSecond, desired.second)
        drivetrain.tankDriveVolts(desired.first, desired.second)
        lastTime = time
        time = System.currentTimeMillis()
        deltaTime = (time - lastTime).toDouble() / 1000.0
        text += "\n${time},${measured.leftMetersPerSecond},${desired.first}"
        entry.setString(text)
    }

    override fun end(interrupted: Boolean) {
        /** Here you can put code that will be run when this command is told to stop running. **/
    }

    /** The command scheduler uses this to determine when a command should be told to stop running.
     * Since we want to run this command throughout the match (We want to drive throughout the whole match,
     * don't we?), it's good to set this to false. If you have another idea though, feel free to implement it.
     */
    override fun isFinished() = false
}