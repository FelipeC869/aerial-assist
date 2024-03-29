/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.commands.pickup.PickUpDeploy;
import edu.wpi.first.wpilibj.templates.commands.pickup.ResetArmCommand;
import edu.wpi.first.wpilibj.templates.subsystems.PickUp;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;


public class ShootSeries extends CommandGroup {
    
    public ShootSeries() {
        addParallel(new PickUpDeploy(PickUp.DEPLOY, 0, PickUp.CLOSE));
        addSequential(new WaitCommand(0.25));
        addSequential(new SetShooterPosition(Shooter.FIRE));
        addSequential(new WaitCommand(0.2));
        addSequential(new SetShooterPosition(Shooter.PRIME));
        addSequential(new WaitCommand(0.1));
        addParallel(new ResetArmCommand());    
    }
}
