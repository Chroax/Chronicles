package avanlon.game.states;

import avanlon.framework.gui.WindowManager;
import avanlon.game.entity.Player.Player;

import javax.swing.*;

public class LaunchSkillPage
{
    public static JFrame frame = new JFrame();

    public LaunchSkillPage(Player player)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        frame.setLayout(null);
        frame.add(new SkillMenu(player));
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
