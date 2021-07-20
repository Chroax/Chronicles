package avanlon.game.states;

import avanlon.framework.gui.WindowManager;
import avanlon.game.entity.Player.Player;

import javax.swing.*;

public class LaunchBuyPage
{
    public static JFrame frame = new JFrame();

    LaunchBuyPage(Player player)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        frame.setLayout(null);
        frame.add(new BuyMenu(player));
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
