package avanlon.game.states.dungeonstates;

import avanlon.framework.gui.MyButton;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Items;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Player.Player;
import avanlon.game.items.Item;
import avanlon.game.states.newpage.LaunchInvArmor;
import avanlon.game.states.newpage.LaunchSellArmor;
import avanlon.game.states.newpage.LaunchUseItemMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Enumeration;
import java.util.Hashtable;

public class UseItemMenu extends JPanel implements ActionListener
{
    Player player;
    private MyButton [] buttons;
    private Rectangle[] rectangle;
    private final Hashtable<Item, Integer> potionList;
    private final boolean isInv;
    private MyButton backButton;

    public UseItemMenu(Player player, boolean isInv)
    {
        this.player = player;
        this.potionList = player.myInventory.getInvPotionList();
        this.setSize(WindowManager.WIDTH/2+20, WindowManager.HEIGHT);
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

        addButton();
    }

    public void addButton()
    {
        this.rectangle = new Rectangle[12];
        this.buttons = new MyButton[12];
        int x = 20, y = 65;
        for (int i = 0; i < 12; i++)
        {
            rectangle[i] = new Rectangle();
            this.buttons[i] = new MyButton("");
            if(i % 4 == 0 && i != 0)
            {
                x += 236;
                y = 65;
            }
            rectangle[i].setBounds(x, y, 216, 72);
            buttons[i].setBounds(rectangle[i].x + 170, rectangle[i].y+47, 40, 20);
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

        for (int i = 0; i < potionList.size(); i++)
            this.buttons[i].setVisible(true);
        setName();
    }

    private void setName()
    {
        int index = 0;
        Enumeration<Item> it = potionList.keys();
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

        graphics.setFont(new Font("Dialog", Font.BOLD, 25));

        if(isInv)
            graphics.drawString("INVENTORY", 190, 50);

        graphics.setColor(Color.WHITE);

        for (int i = 0; i < rectangle.length; i++)
        {
            if(i >= potionList.size())
                break;
            graphics.drawRoundRect(rectangle[i].x, rectangle[i].y, rectangle[i].width, rectangle[i].height, 10, 10);
            graphics.drawRoundRect(rectangle[i].x, rectangle[i].y, rectangle[i].height, rectangle[i].height, 10, 10);
        }
        int i = 0;

        Enumeration <Item> iterator = potionList.keys();
        while (iterator.hasMoreElements())
        {
            Item potion = iterator.nextElement();
            BufferedImage sprite = Textures.getSprite(potion.getName(), "Potion");
            graphics.setFont(new Font("Dialog", Font.BOLD, 10));
            graphics.drawImage(sprite, rectangle[i].x + 12, rectangle[i].y + 12, sprite.getWidth()/3, sprite.getHeight()/3, null);
            graphics.drawString(potion.getDisplayName() + " [" + potion.getRarity() + "]", rectangle[i].x+77, rectangle[i].y+17);
            graphics.drawString(potion.getDescription(), rectangle[i].x+77, rectangle[i].y+34);
            graphics.drawString("X" + potionList.get(potion), rectangle[i].x+77, rectangle[i].y+51);
            graphics.setFont(new Font("Dialog", Font.BOLD, 13));
            if(isInv)
                graphics.drawString("Use", rectangle[i].x+180, rectangle[i].y+64);
            i++;
        }
    }

    private void actionIsInv(ActionEvent e)
    {
        Item usePotion = Items.potions.get(e.getActionCommand());
        int value = getTotalUse();
        if(value != 0 && value != -1)
        {
            if(JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Use " + usePotion.getDisplayName() + " [x" + value + "]", "Inventory Potion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0)
            {
                if(player.useItem("Potion", usePotion, value, isInv));
                    LaunchUseItemMenu.frame.dispose();
            }
        }
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
            System.err.println("[InvPotionMenu] [SellMenu] Error Parse Integer");
            arg0.printStackTrace();
        }
        return value;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == backButton)
        {
            LaunchUseItemMenu.frame.dispose();
        }
        else
        {
            if(isInv)
                actionIsInv(e);
            setName();
            repaint();
        }
    }
}
