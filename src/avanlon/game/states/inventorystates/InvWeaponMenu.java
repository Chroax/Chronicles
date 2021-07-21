package avanlon.game.states.inventorystates;

import avanlon.framework.gui.MyButton;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Items;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Player.Player;
import avanlon.game.items.Weapon;
import avanlon.game.states.newpage.LaunchInvWeapon;
import avanlon.game.states.newpage.LaunchSellWeapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Enumeration;
import java.util.Hashtable;

public class InvWeaponMenu extends JPanel implements ActionListener
{
    Player player;
    private MyButton backButton;
    private MyButton [] buttons;
    private Rectangle [] rectangle;
    private final Hashtable <Weapon, Integer> weaponList;
    private final boolean isInv;

    public InvWeaponMenu(Player player, boolean isInv)
    {
        this.player = player;
        this.weaponList = player.myInventory.getInvWeaponList();
        this.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.isInv = isInv;

        this.backButton = new MyButton("BACK");
        this.backButton.setFont(new Font("Dialog", Font.BOLD, 20));
        this.backButton.setMargin(new Insets(0, 0, 0, 0));
        this.backButton.setBorder(null);
        this.backButton.setFocusPainted(false);
        this.backButton.setForeground(Color.GREEN);
        this.backButton.setBackground(Color.BLACK);
        this.backButton.setHoverBackgroundColor(Color.BLACK.brighter());
        this.backButton.setPressedBackgroundColor(Color.BLACK);
        this.backButton.addActionListener(this);
        this.backButton.setBounds(50, 450, 100, 50);
        this.add(backButton);

        addPanel();
    }

    public void addPanel()
    {
        this.rectangle = new Rectangle[12];
        this.buttons = new MyButton[12];
        int x = 25, y = 65;
        for (int i = 0; i < 12; i++)
        {
            rectangle[i] = new Rectangle();
            this.buttons[i] = new MyButton("");
            if(i % 4 == 0 && i != 0)
            {
                x += 320;
                y = 65;
            }
            rectangle[i].setBounds(x, y, 280, 72);
            buttons[i].setBounds(rectangle[i].x + 240, rectangle[i].y+47, 40, 20);
            y += 82;
        }

        for (int i = 0; i < buttons.length; i++)
        {
            this.buttons[i].setFont(new Font("Dialog", Font.BOLD, 15));
            this.buttons[i].setMargin(new Insets(0,0,0,0));
            this.buttons[i].setBorder(null);
            this.buttons[i].setFocusPainted(false);
            this.buttons[i].setForeground(Color.WHITE);
            this.buttons[i].setBackground(Color.BLACK);
            this.buttons[i].setHoverBackgroundColor(Color.BLACK.brighter());
            this.buttons[i].setPressedBackgroundColor(Color.BLACK);
            this.buttons[i].addActionListener(this);
            this.buttons[i].setVisible(false);
        }

        for (int i = 0; i < weaponList.size(); i++)
            this.buttons[i].setVisible(true);
        setName();
    }

    private void setName()
    {
        int index = 0;
        Enumeration <Weapon> it = weaponList.keys();
        while (it.hasMoreElements())
        {
            this.buttons[index].setActionCommand(it.nextElement().getName());
            index++;
        }
        for (MyButton button : buttons) this.add(button);
    }

    public void paint(Graphics graphics)
    {
        super.paint(graphics);

        graphics.setColor(Color.WHITE);

        BufferedImage sprite = Textures.getSprite("GOLD", "Icon");
        BufferedImage sprite2 = Textures.getSprite("INVENTORY", "Icon");
        graphics.drawImage(sprite, 810, 430, sprite.getWidth(), sprite.getHeight(), null);
        graphics.drawImage(sprite2, 810, 470, sprite2.getWidth(), sprite2.getHeight(), null);

        graphics.setFont(new Font("Dialog", Font.BOLD, 30));

        if(isInv)
            graphics.drawString("INVENTORY", 400, 50);
        else
            graphics.drawString("MERCHANT", 400, 50);

        graphics.setColor(Color.YELLOW);
        graphics.drawString(String.valueOf(player.getGold()), 850, 453);

        graphics.setFont(new Font("Dialog", Font.BOLD, 20));
        graphics.setColor(new Color(0xD7B19D));
        graphics.drawString(player.myInventory.getCapacity() + "/" + player.myInventory.getMaxCapacity(), 850, 493);

        graphics.setColor(Color.WHITE);
        for (int i = 0; i < rectangle.length; i++) 
        {
            if(i >= weaponList.size())
                break;
            graphics.drawRoundRect(rectangle[i].x, rectangle[i].y, rectangle[i].width, rectangle[i].height, 10, 10);
            graphics.drawRoundRect(rectangle[i].x, rectangle[i].y, rectangle[i].height, rectangle[i].height, 10, 10);
        }
        int i = 0;

        Enumeration <Weapon> iterator = weaponList.keys();
        while (iterator.hasMoreElements())
        {
            Weapon weapon = iterator.nextElement();
            BufferedImage sprite3 = Textures.getSprite(weapon.getName(), "Weapon");
            graphics.setFont(new Font("Dialog", Font.BOLD, 13));
            graphics.drawImage(sprite3, rectangle[i].x + 12, rectangle[i].y + 12, sprite3.getWidth()/3, sprite3.getHeight()/3, null);
            graphics.drawString(weapon.getDisplayName() + " [" + weapon.getRarity() + "]", rectangle[i].x+77, rectangle[i].y+17);
            graphics.drawString("Type : " + weapon.getType(), rectangle[i].x+77, rectangle[i].y+34);
            graphics.drawString( "Class : " + weapon.getWeaponClass(), rectangle[i].x+77, rectangle[i].y+49);
            graphics.drawString(weapon.getDescription(), rectangle[i].x+77, rectangle[i].y+64);
            graphics.drawString("X" + weaponList.get(weapon), rectangle[i].x+250, rectangle[i].y+17);
            if(isInv)
                graphics.drawString("Use", rectangle[i].x+245, rectangle[i].y+64);
            else
                graphics.drawString("Sell", rectangle[i].x+245, rectangle[i].y+64);
            i++;
        }
    }

    private void actionIsInv(ActionEvent e)
    {
        Weapon useWeapon = Items.weapons.get(e.getActionCommand());
        int value = getTotalUse();
        if(value != 0 && value != -1)
        {
            if(JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Use " + useWeapon.getDisplayName() + " [x" + value + "]", "Inventory Weapon", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0)
                player.useItem("Weapon", useWeapon, value, isInv);
        }
    }

    private void actionIsNotInv(ActionEvent e)
    {
        Weapon sellWeapon = Items.weapons.get(e.getActionCommand());
        int value = getTotalSell();
        if(value != 0 && value != -1)
        {
            if(JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Sell " + sellWeapon.getDisplayName() + " [x" + value + "]\nSell Price : " + sellWeapon.getSellPrice(), "Sell Weapon", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0)
            {
                int totalPrice = sellWeapon.getSellPrice() * value;
                player.addGold("Weapon", sellWeapon, totalPrice, value, isInv);
            }
        }
    }

    private int getTotalSell()
    {
        int value = 0;
        try
        {
            String answer = JOptionPane.showInputDialog("How Many do You want to sell ?", "1");
            if(answer != null)
                value = Integer.parseInt(answer);
        }
        catch (NumberFormatException arg0)
        {
            value = -1;
            System.err.println("[InvWeaponMenu] [SellMenu] Error Parse Integer");
            arg0.printStackTrace();
        }
        return value;
    }

    private int getTotalUse()
    {
        int value = 0;
        try
        {
            String answer = JOptionPane.showInputDialog("How Many do You want to use ?", "1");
            if(answer != null)
                value = Integer.parseInt(answer);
        }
        catch (NumberFormatException arg0)
        {
            value = -1;
            System.err.println("[InvWeaponMenu] [SellMenu] Error Parse Integer");
            arg0.printStackTrace();
        }
        return value;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == backButton)
        {
            if(isInv)
                LaunchInvWeapon.frame.dispose();
            else
                LaunchSellWeapon.frame.dispose();
            WindowManager.frame.setVisible(true);
        }
        else
        {
            if(isInv)
                actionIsInv(e);
            else
                actionIsNotInv(e);
            setName();
            repaint();
        }
    }
}
