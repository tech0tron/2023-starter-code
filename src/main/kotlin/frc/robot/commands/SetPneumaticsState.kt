package frc.robot.commands

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.Pneumatics

class SetPneumaticsState(val pneumatics: Pneumatics) : CommandBase() {
    init {
        addRequirements(pneumatics)
    }

    override fun execute() {
        super.execute()
        pneumatics.set(DoubleSolenoid.Value.kForward)

    }

    override fun end(interrupted: Boolean) {
        super.end(interrupted)
        pneumatics.set(DoubleSolenoid.Value.kReverse)
    }
}