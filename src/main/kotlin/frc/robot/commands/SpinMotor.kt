package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.Motor

class SpinMotor(val motor: Motor) : CommandBase() {
    init {
        addRequirements(motor)
    }

    override fun execute() {
        super.execute()
        motor.set(12.0)
    }

    override fun end(interrupted: Boolean) {
        super.end(interrupted)
        motor.set(0.0)
    }
}