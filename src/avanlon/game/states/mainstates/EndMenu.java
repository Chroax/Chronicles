package avanlon.game.states.mainstates;

import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Textures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class EndMenu extends JPanel implements MouseListener
{
    Timer timer;
    private int index;
    public EndMenu()
    {
        index = 0;
        this.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.addMouseListener(this);
    }
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        graphics.setColor(Color.BLACK);

        graphics.setFont(new Font("Dialog", Font.BOLD, 60));
        BufferedImage sprite = Textures.getSprite("THANKYOU", "Screen");
        if(index == 0)
        {
            graphics.drawImage(sprite, 0, 0, sprite.getWidth()/2, sprite.getHeight()/2, null);
            graphics.drawString("THANK YOU FOR PLAYING", 80, 470);
        }
        else if(index == 1)
        {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Dialog", Font.BOLD, 50));
            graphics.drawString("Made By", 395, 180);
            graphics.drawString("Cahyadi Surya Nugraha 5025201184", 55, 250);
            graphics.drawString("Frederick Wijayadi Susilo 5025201111", 35, 320);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        index++;
        if(index == 2)
            System.exit(0);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
