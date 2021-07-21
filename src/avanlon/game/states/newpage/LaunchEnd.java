package avanlon.game.states.newpage;

import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Player.Player;
import avanlon.game.states.inventorystates.InvPotionMenu;
import avanlon.game.states.mainstates.EndMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class LaunchEnd
{
    public static JFrame frame = new JFrame();
    public LaunchEnd()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(new EndMenu());
        frame.setVisible(true);
    }
}
