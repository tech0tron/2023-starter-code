// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj2.command.Command
import frc.robot.commands.Drive

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the [Robot]
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
class RobotContainer {
    /**
     * Like the subsystem and commands, up here we can put any variables we think we should initialize.
     * In practice, this is where we initialize motors, controllers, any other hardware, and subsystems on the robot.
     */

    init {
        configureButtonBindings()
        configureAutoOptions()
    }

    var autoCommandChooser: SendableChooser<Command> = SendableChooser()

    /**
     * Controller ([GenericHID], [XboxController]) mapping.
     */
    private fun configureButtonBindings() {
        // Uncomment this line and add whatever args you made Drive take in!
        // Also make sure your drivetrain subsystem is initialized under the name drivetrain.
        // drivetrain.defaultCommand = Drive( ... )
    }

    private fun configureAutoOptions() {

    }

    val autonomousCommand: Command
        get() = autoCommandChooser.selected
}