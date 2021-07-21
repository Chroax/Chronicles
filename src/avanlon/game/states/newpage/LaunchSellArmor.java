package avanlon.game.states.newpage;

import avanlon.framework.gui.WindowManager;
import avanlon.game.entity.Player.Player;
import avanlon.game.states.inventorystates.InvArmorMenu;

import javax.swing.*;

public class LaunchSellArmor
{
    public static JFrame frame = new JFrame();

    public LaunchSellArmor(Player player, boolean isInv)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(new InvArmorMenu(player, isInv));
        frame.setVisible(true);
    }
}
