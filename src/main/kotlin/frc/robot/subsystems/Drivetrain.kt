package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase

/** Before we can program the driving of the robot, we need to program the subsystem, which will be the
 * interface for interacting with the drivetrain
 */
class Drivetrain(
        /** Here we can pass arguments to the class that we think it should have.
         * What do you think we should pass into the drivetrain subystem?
         * Motors? Controllers? Constants? Anything else? **/
) : SubsystemBase() {

    /**
     * Here you can specify any variables you think would be helpful for the class.
     * Last year we had motorcontrollergroups and encoders initialized here.
     */

    init {
        /** The code you write in here will be run as soon as a Drivetrain instance is created.
         * What do you think should go here?
         */
    }

    override fun periodic() {
        super.periodic()
        /** Here you can put code that will be run every "frame" (20 times/second). Is there
         * any useful code we could put here, or should we leave everything to commands?
         */
    }

    /** Feel free to put any functions or variables you think would be useful to have when working
     * with the drivetrain. For example, last year we had tankDriveVolts() (spin the motors at a certain voltage),
     * wheelSpeeds() (Get the wheel speeds of the motors using encoders), heading() (We had the gyro in the drivetrain
     * subsystem and this function got the angle of it), and more.
     */
}