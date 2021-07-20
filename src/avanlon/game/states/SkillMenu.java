package avanlon.game.states;

import avanlon.framework.gui.MyButton;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Skills;
import avanlon.game.entity.Player.Player;
import avanlon.game.entity.Player.Skill;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SkillMenu extends JPanel implements ActionListener
{
    Player player;
    private BufferedImage sprite;
    private final JButton [] buttons;
    private final MyButton backButton;

    public SkillMenu(Player player)
    {
        this.player = player;
        buttons = new JButton[25];
        this.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.backButton = new MyButton("BACK");
        this.backButton.setBounds(20, 450, 70, 50);
        this.backButton.setFont(new Font("Dialog", Font.BOLD, 20));
        this.backButton.setMargin(new Insets(0,0,0,0));
        this.backButton.setBorder(null);
        this.backButton.setFocusPainted(false);
        this.backButton.setForeground(Color.GREEN);
        this.backButton.setBackground(Color.BLACK);
        this.backButton.setHoverBackgroundColor(Color.BLACK.brighter());
        this.backButton.setPressedBackgroundColor(Color.BLACK);
        this.backButton.addActionListener(this);
        this.add(backButton);
        try
        {
            for (int i = 0; i < buttons.length; i++)
            {
                int number = i + 1;
                String name = String.valueOf(number);
                String path = "";
                switch (player.getPlayerClass())
                {
                    case 0 -> path = "res/textures/Skill/SKILL_PALADIN_";
                    case 1 -> path = "res/textures/Skill/SKILL_WIZARD_";
                    case 2 -> path = "res/textures/Skill/SKILL_ARCHER_";
                }
                if(Skills.treeArcher.findSkill(i + 1).isUnLocked())
                    path += number + ".png";
                else
                    path += number + " (1).png";

                sprite = ImageIO.read(new File(path));

                buttons[i] = new JButton();
                buttons[i].setActionCommand(name);
                buttons[i].setIcon(new ImageIcon(sprite));
                buttons[i].setMargin(new Insets(0,0,0,0));
                buttons[i].setBorder(null);
                buttons[i].setFocusPainted(false);
                buttons[i].addActionListener(this);
            }

            int width = sprite.getWidth();
            int height = sprite.getHeight();

            buttons[0].setBounds(472, 80, width, height);

            buttons[1].setBounds(247, 170, width, height);
            buttons[2].setBounds(697, 170, width, height);

            buttons[3].setBounds(117, 260, width, height);
            buttons[4].setBounds(247, 260, width, height);
            buttons[5].setBounds(377, 260, width, height);

            buttons[6].setBounds(77, 350, width, height);
            buttons[7].setBounds(117, 350, width, height);
            buttons[8].setBounds(157, 350, width, height);

            buttons[9].setBounds(247, 350, width, height);

            buttons[10].setBounds(337, 350, width, height);
            buttons[11].setBounds(417, 350, width, height);

            buttons[12].setBounds(567, 260, width, height);
            buttons[13].setBounds(697, 260, width, height);
            buttons[14].setBounds(827, 260, width, height);

            buttons[15].setBounds(527, 350, width, height);
            buttons[16].setBounds(567, 350, width, height);
            buttons[17].setBounds(607, 350, width, height);

            buttons[20].setBounds(657, 350, width, height);
            buttons[21].setBounds(697, 350, width, height);
            buttons[22].setBounds(737, 350, width, height);

            buttons[23].setBounds(787, 350, width, height);
            buttons[24].setBounds(867, 350, width, height);

            buttons[18].setBounds(117, 80, width, height);
            buttons[19].setBounds(827, 80, width, height);

            for (JButton button : buttons) this.add(button);
        }
        catch (IOException e)
        {
            System.err.println("[Resources] [SkillMenu] Error Image Path Resources");
            e.printStackTrace();
        }
        repaint();
    }

    public void paint(Graphics graphics)
    {
        super.paint(graphics);

        graphics.setFont(new Font("Dialog", Font.BOLD, 35));
        graphics.setColor(Color.WHITE);
        graphics.drawString("SKILLS", 423, 40);
        graphics.setFont(new Font("Dialog", Font.BOLD, 15));
        graphics.drawString("Point Skill : " + player.getPointSkill(), 57, 440);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawRoundRect(47, 50, 880, 370, 10, 10);
        graphics2D.setStroke(new BasicStroke(4));

        graphics2D.drawLine(262,138,712,138);
        graphics2D.drawLine(487,112,487,138);
        graphics2D.drawLine(262, 138, 262, 168);
        graphics2D.drawLine(712, 138, 712, 168);

        graphics2D.drawLine(132,228,392,228);
        graphics2D.drawLine(262,202,262,224);
        graphics2D.drawLine(132,228,132,258);
        graphics2D.drawLine(262, 228, 262, 258);
        graphics2D.drawLine(392, 228, 392, 258);

        graphics2D.drawLine(582,228,842,228);
        graphics2D.drawLine(712, 202, 712, 224);
        graphics2D.drawLine(582,228,582,258);
        graphics2D.drawLine(712, 228, 712, 258);
        graphics2D.drawLine(842, 228, 842, 258);

        graphics2D.drawLine(92,318,172,318);
        graphics2D.drawLine(132, 292, 132, 314);
        graphics2D.drawLine(92,318,92,348);
        graphics2D.drawLine(132, 318, 132, 348);
        graphics2D.drawLine(172, 318, 172, 348);

        graphics2D.drawLine(262, 292, 262, 348);

        graphics2D.drawLine(352,318,432,318);
        graphics2D.drawLine(392, 292, 392, 314);
        graphics2D.drawLine(352,318,352,348);
        graphics2D.drawLine(432, 318, 432, 348);

        graphics2D.drawLine(542,318,622,318);
        graphics2D.drawLine(582, 292, 582, 314);
        graphics2D.drawLine(542,318,542,348);
        graphics2D.drawLine(582, 318, 582, 348);
        graphics2D.drawLine(622, 318, 622, 348);

        graphics2D.drawLine(672,318,752,318);
        graphics2D.drawLine(712, 292, 712, 314);
        graphics2D.drawLine(672,318,672,348);
        graphics2D.drawLine(712, 318, 712, 348);
        graphics2D.drawLine(752, 318, 752, 348);

        graphics2D.drawLine(802,318,882,318);
        graphics2D.drawLine(842, 292, 842, 314);
        graphics2D.drawLine(802,318,802,348);
        graphics2D.drawLine(882, 318, 882, 348);
    }

    public void setImage(int i)
    {
        Skill skill = Skills.treeArcher.findSkill(i+1);
        if(skill.isUnLocked())
            player.addSkillYesOrNo(skill);
        else
        {
            if(player.getPointSkill() == 0)
                JOptionPane.showMessageDialog(null, "Your Point Skill is not Enough", "Unlock Skill", JOptionPane.WARNING_MESSAGE);
            else
            {
                String path = "";
                switch (player.getPlayerClass())
                {
                    case 0 -> path = "res/textures/Skill/SKILL_PALADIN_";
                    case 1 -> path = "res/textures/Skill/SKILL_WIZARD_";
                    case 2 -> path = "res/textures/Skill/SKILL_ARCHER_";
                }
                path += i + 1 + ".png";

                ImageIcon icon = new ImageIcon(path);

                int value = JOptionPane.showOptionDialog(null, "Do you want unlock this skill ?\nName : " + skill.getDisplayName(), "Unlock Skill", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, 0);

                if(value == 0)
                {
                    try
                    {
                        Skill rootSkill = Skills.treeArcher.findSkill(Integer.parseInt(skill.getRootId()), (Integer.parseInt((skill.getSkillId()))));
                        if (rootSkill != null)
                        {
                            if(rootSkill.isUnLocked())
                            {
                                player.minPointSkill();
                                repaint();
                                buttons[i].setIcon(icon);
                                JOptionPane.showOptionDialog(null, "Congratulation You Unlock this Skill", "Unlock Skill", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, null, 0);
                                skill.unlockSkill(true);
                            }
                            else
                                JOptionPane.showOptionDialog(null, "You not yet Unlock " + rootSkill.getDisplayName() , "Unlock Skill", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
                        }
                        else
                        {
                            player.minPointSkill();
                            repaint();
                            buttons[i].setIcon(icon);
                            JOptionPane.showOptionDialog(null, "Congratulation You Unlock this Skill", "Unlock Skill", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, null, 0);
                            skill.unlockSkill(true);
                        }
                    }
                    catch (NumberFormatException arg0)
                    {
                        System.err.println("[Resources] [SkillMenu] Error Parse Integer");
                        arg0.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == backButton)
        {
            LaunchSkillPage.frame.dispose();
            WindowManager.frame.setVisible(true);
        }
        else if(e.getSource() == buttons[0])
            setImage(0);
        else if(e.getSource() == buttons[1])
            setImage(1);
        else if(e.getSource() == buttons[2])
            setImage(2);
        else if(e.getSource() == buttons[3])
            setImage(3);
        else if(e.getSource() == buttons[4])
            setImage(4);
        else if(e.getSource() == buttons[5])
            setImage(5);
        else if(e.getSource() == buttons[6])
            setImage(6);
        else if(e.getSource() == buttons[7])
            setImage(7);
        else if(e.getSource() == buttons[8])
            setImage(8);
        else if(e.getSource() == buttons[9])
            setImage(9);
        else if(e.getSource() == buttons[10])
            setImage(10);
        else if(e.getSource() == buttons[11])
            setImage(11);
        else if(e.getSource() == buttons[12])
            setImage(12);
        else if(e.getSource() == buttons[13])
            setImage(13);
        else if(e.getSource() == buttons[14])
            setImage(14);
        else if(e.getSource() == buttons[15])
            setImage(15);
        else if(e.getSource() == buttons[16])
            setImage(16);
        else if(e.getSource() == buttons[17])
            setImage(17);
        else if(e.getSource() == buttons[18])
            setImage(18);
        else if(e.getSource() == buttons[19])
            setImage(19);
        else if(e.getSource() == buttons[20])
            setImage(20);
        else if(e.getSource() == buttons[21])
            setImage(21);
        else if(e.getSource() == buttons[22])
            setImage(22);
        else if(e.getSource() == buttons[23])
            setImage(23);
    }
}
