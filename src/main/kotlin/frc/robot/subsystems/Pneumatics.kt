package frc.robot.subsystems

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj2.command.SubsystemBase

class Pneumatics(val solenoid: DoubleSolenoid) : SubsystemBase() {
    fun set(state: DoubleSolenoid.Value) {
        solenoid.set(state)
    }

    override fun periodic() {
        super.periodic()
    }
}