package frc.robot.subsystems

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds
import edu.wpi.first.math.util.Units
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.drive.MecanumDrive.WheelSpeeds
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup
import edu.wpi.first.wpilibj2.command.SubsystemBase

/** Before we can program the driving of the robot, we need to program the subsystem, which will be the
 * interface for interacting with the drivetrain
 */
class Drivetrain(
        /** Here we can pass arguments to the class that we think it should have.
         * What do you think we should pass into the drivetrain subystem?
         * Motors? Controllers? Constants? Anything else? **/
) : SubsystemBase() {

    val motorLF = CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless)
    val motorRF = CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless)
    val motorLB = CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless)
    val motorRB = CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless)

    val motorsRight = MotorControllerGroup(motorRF, motorRB)
    val motorsLeft = MotorControllerGroup(motorLF, motorLB)

    val encoderLF = motorLF.encoder
    val encoderRF = motorRF.encoder
    val encoderLB = motorLB.encoder
    val encoderRB = motorRB.encoder

    init {
        /** The code you write in here will be run as soon as a Drivetrain instance is created.
         * What do you think should go here?
         */
        motorsRight.inverted = true
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
    fun tankDriveVolts(leftVolts : Double, rightVolts : Double){
        motorsLeft.setVoltage(leftVolts)
        motorsRight.setVoltage(rightVolts)
    }

    fun wheelSpeeds(): DifferentialDriveWheelSpeeds {
        return DifferentialDriveWheelSpeeds(
            (encoderLF.velocity / 10.71) * (Math.PI * Units.inchesToMeters(6.0)) / 60,
            (encoderRF.velocity / 10.71) * (Math.PI * Units.inchesToMeters(6.0)) / 60
        )
    }
}