package avanlon.game.states.newpage;

import avanlon.framework.gui.WindowManager;
import avanlon.game.entity.Player.Player;
import avanlon.game.states.merchantstates.BuyMenu;

import javax.swing.*;

public class LaunchBuyPage
{
    public static JFrame frame = new JFrame();

    public LaunchBuyPage(Player player)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        frame.setLayout(null);
        frame.add(new BuyMenu(player));
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
