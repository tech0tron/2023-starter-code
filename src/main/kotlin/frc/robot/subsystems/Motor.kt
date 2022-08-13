package frc.robot.subsystems

import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj.motorcontrol.MotorController
import edu.wpi.first.wpilibj2.command.SubsystemBase

class Motor(val motor: MotorController) : SubsystemBase() {
    fun set(volts: Double) {
        motor.setVoltage(volts)
    }
}