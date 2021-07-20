package avanlon.framework.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class WindowManager
{
    public static JButton[] buttons;
    public static JFrame frame;
    public static JPanel panel;
    public static boolean openBuyMenu;
    public static final int WIDTH = 986;
    public static final int HEIGHT = 555;

    public WindowManager()
    {
        ImageIcon icon = new ImageIcon("res/textures/SCREEN/TITLESCREEN.png");
        openBuyMenu = false;
        frame = new JFrame("AVANLON RPG GAME");
        frame.setBounds(70, 70, 0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        buttons = new JButton[100];
    }

    public void addPanel(JPanel panel)
    {
        this.panel = panel;
        this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.panel.setFocusable(true);
        this.panel.requestFocusInWindow();
    }

    public void addKeyListener(KeyListener listener) {
        try
        {
            panel.addKeyListener(listener);
        } catch(NullPointerException e) {
            System.err.println("[WindowManager]: Error! Tried to add KeyListener before JPanel");
            System.exit(-1);
        }
    }

    public void addMouseListener(MouseListener listener)
    {
        try
        {
            panel.addMouseListener(listener);
        } catch(NullPointerException e)
        {
            System.err.println("[WindowManager]: Error! Tried to add Mouse Listener before JPanel");
            System.exit(-1);
        }
    }

    public void createWindow()
    {
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
