package avanlon.game.states.dungeonstates;

import avanlon.framework.gui.MyButton;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Monster;
import avanlon.game.entity.Player.Player;
import avanlon.game.states.newpage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BattleMonster extends JPanel implements ActionListener
{
    private Player player;
    private final MyButton[] buttons;
    private int selected;
    ArrayList <Monster> spawnMob;
    private int level;
    private int monsterIndex;

    public BattleMonster(Player player, int totalMonster, int level, List<Monster> spawnMob)
    {
        this.monsterIndex = 0;
        this.selected = 0;
        this.player = player;
        this.buttons = new MyButton[4];
        this.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.level = level;
        int x = 10, y = 370;
        for (int i = 0; i < buttons.length; i++)
        {
            if(i == 0)
                this.buttons[i] = new MyButton("   Attack");
            else if(i == 1)
                this.buttons[i] = new MyButton("Skill");
            else if(i == 2)
                this.buttons[i] = new MyButton("Item");
            else if(i == 3)
                this.buttons[i] = new MyButton("Flee");
            this.buttons[i].setFont(new Font("Dialog", Font.BOLD, 25));
            this.buttons[i].setMargin(new Insets(0,0,0,0));
            this.buttons[i].setBorder(null);
            this.buttons[i].setFocusPainted(false);
            this.buttons[i].setForeground(Color.WHITE);
            this.buttons[i].setBackground(Color.BLACK);
            this.buttons[i].setHoverBackgroundColor(Color.BLACK.brighter());
            this.buttons[i].setPressedBackgroundColor(Color.BLACK);
            this.buttons[i].addActionListener(this);
            if(i < 4)
            {
                this.buttons[i].setBounds(x, y, 100, 30);
                y += 30;
            }
        }

        for (MyButton button : buttons)
        {
            this.add(button);
        }
       this.spawnMob = new ArrayList<>(spawnMob);
    }

    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Dialog", Font.BOLD, 35));
        graphics.drawString("BATTLE", 400, 50);
        graphics.drawRoundRect(20, 60, 600, 300, 10, 10);
        graphics.drawRoundRect(640, 60, 310, 300, 10, 10);
        graphics.drawRoundRect(640, 370, 310, 130, 10, 10);

        int x = 325, y = 110;
        BufferedImage sprite;
        if(monsterIndex != spawnMob.size())
        {
            sprite = Textures.getSprite(spawnMob.get(monsterIndex).getName(), "Monster");
            graphics.drawImage(sprite, 30, 70, sprite.getWidth()*2, sprite.getHeight()*2, null);
            graphics.setFont(new Font("Dialog", Font.BOLD, 25));
            graphics.drawString("Name : " + spawnMob.get(monsterIndex).getName(), x, y);
            graphics.drawString("Level : " + spawnMob.get(monsterIndex).getLevel(), x, y+35);
            graphics.drawString("HP : " + spawnMob.get(monsterIndex).getHP() + "/" + spawnMob.get(monsterIndex).getHPMax(), x, y+70);
            graphics.drawString("Mag Def : " + spawnMob.get(monsterIndex).getMagDef(), x, y+105);
            graphics.drawString("Phy Def : " + spawnMob.get(monsterIndex).getPhyDef(), x, y+140);
            graphics.drawString("MAtt : " + spawnMob.get(monsterIndex).getMagAtt(), x, y+175);
            graphics.drawString("PAtt : " + spawnMob.get(monsterIndex).getPhyAtt(), x, y+210);
        }
        graphics.drawString("You", x+450, y-20);
        graphics.drawString("HP : " + player.getHP() + "/" + player.getHPMax(), x+335, y+35);
        graphics.drawString("MP : " + player.getMP() + "/" + player.getMPMax(), x+335, y+70);
        graphics.drawString("Mag Def : " + player.getMagDef(), x+335, y+105);
        graphics.drawString("Phy Def : " + player.getPhyDef(), x+335, y+140);
        graphics.drawString("MAtt : " + player.getMagAtt(), x+335, y+175);
        graphics.drawString("PAtt : " + player.getPhyAtt(), x+335, y+210);

        for(int i=0; i < 4; i++)
        {
            if(i == this.selected)
                buttons[i].setForeground(Color.GREEN);
            else
                buttons[i].setForeground(Color.WHITE);
        }

    }
    public void playerAttack()
    {
        player.giveDamage(this.spawnMob.get(monsterIndex));
        if (this.spawnMob.get(monsterIndex).isDie())
        {
            player.addExpAndGold(this.spawnMob.get(monsterIndex));
            monsterIndex++;
            if(monsterIndex == spawnMob.size())
            {
                JOptionPane.showMessageDialog(null, "You Win", "Clear Dungeon", JOptionPane.WARNING_MESSAGE);
                if(this.level >= player.getDungeonLevel())
                    this.player.plusDungeonLevel();
                LaunchBattleMonster.frame.dispose();
                WindowManager.frame.setVisible(true);
                if(!WindowManager.openCaveMenu1)
                {
                    LaunchBattleMonster.frame.dispose();
                    WindowManager.openCaveMenu1 = true;
                }
                else if(!WindowManager.openCaveMenu2)
                {
                    LaunchBattleMonster2.frame.dispose();
                    WindowManager.openCaveMenu2 = true;
                }
                else if(!WindowManager.openCaveMenu3)
                {
                    LaunchBattleMonster3.frame.dispose();
                    WindowManager.frame.dispose();
                    new LaunchEnd();
                }
            }

        }
        else
        {
            spawnMob.get(monsterIndex).giveDamage(player);
            if (player.isDie())
            {
                JOptionPane.showMessageDialog(null, "YOU DIE", "LOSE MESSAGE", JOptionPane.WARNING_MESSAGE);
                if(!WindowManager.openCaveMenu1)
                    LaunchBattleMonster.frame.dispose();
                else if(!WindowManager.openCaveMenu2)
                    LaunchBattleMonster2.frame.dispose();
                else if(!WindowManager.openCaveMenu3)
                    LaunchBattleMonster3.frame.dispose();
                WindowManager.frame.setVisible(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == buttons[0])
            selected = 0;
        else if (e.getSource() == buttons[1])
            selected = 1;
        else if (e.getSource() == buttons[2])
            selected = 2;
        else if (e.getSource() == buttons[3])
            selected = 3;
        if (selected >= 0 && selected <= 3)
        {
            if(selected == 0)
                playerAttack();
            if (selected == 2)
            {
                new LaunchUseItemMenu(player);
                repaint();
                spawnMob.get(monsterIndex).giveDamage(player);
                if (player.isDie())
                {
                    JOptionPane.showMessageDialog(null, "YOU DIE", "LOSE MESSAGE", JOptionPane.WARNING_MESSAGE);
                    WindowManager.frame.setVisible(true);
                }
            }
            if (selected == 3)
            {
                selected = 0;
                if(!WindowManager.openCaveMenu1)
                {
                    LaunchBattleMonster.frame.dispose();
                    WindowManager.openCaveMenu1 = true;
                    WindowManager.frame.setVisible(true);
                }
                else if(!WindowManager.openCaveMenu2)
                {
                    LaunchBattleMonster2.frame.dispose();
                    WindowManager.openCaveMenu2 = true;
                    WindowManager.frame.setVisible(true);
                }
                else if(!WindowManager.openCaveMenu3)
                {
                    LaunchBattleMonster3.frame.dispose();
                    new LaunchEnd();
                }
            }
            repaint();
        }
    }
}
