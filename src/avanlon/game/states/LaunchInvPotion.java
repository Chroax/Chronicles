package avanlon.game.states;

import avanlon.framework.gui.WindowManager;
import avanlon.game.entity.Player.Player;

import javax.swing.*;

public class LaunchInvPotion 
{
    public static JFrame frame = new JFrame();

    public LaunchInvPotion(Player player, boolean isInv)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(new InvPotionMenu(player, isInv));
        frame.setVisible(true);
    }
}
