package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.Drivetrain

/** Now that you've written the Drivetrain subsystem (or maybe you're doing this first idk), it's time to write
 * the command to drive the robot.
 */
class Drive(val drivetrain: Drivetrain, val speeds: () -> Pair<Double, Double>
    /** Like the DrivetrainSubsystem we can pass in args here too. What do you think the Drive command
     * should have? Motors? Controllers? Constants? Anything else?
     */
) : CommandBase() {

    /** Like the DrivetrainSubsystem, are there any useful variables we should initialize?**/

    init {
        /** This line here is required by WPILib, it just tells the CommandScheduler (which runs things behind
            the scenes what subsystems this command is using.
         **/
        addRequirements(drivetrain)

        /** Feel free to put any init code you think would be useful **/
    }

    override fun execute() {
        super.execute()
        var speedsToSet = speeds()
        drivetrain.tankDriveVolts(speedsToSet.first, speedsToSet.second)
        /** Here you can put code that will be run periodicaly (20 times/second)
         * Here is a good place to put the code that will read in whatever inputs you're using
         * and apply the new voltage or speed to the motors.
         */
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