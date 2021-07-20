package avanlon.framework.gui;

import avanlon.framework.resources.Items;
import avanlon.framework.resources.Textures;
import avanlon.game.items.Armor;
import avanlon.game.items.Item;
import avanlon.game.items.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Enumeration;
import java.util.Hashtable;

public class MiniPanel extends JPanel implements MouseListener
{
    JLabel [] labels;
    private final boolean [] selected;
    private Hashtable objectItem;
    private int size;
    private String type;

    public MiniPanel(int x, int y, int size, Hashtable objectItem, String type)
    {
        this.setBounds(x, y, 300, 340);
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.labels = new JLabel[size];
        this.selected = new boolean[size];

        this.objectItem = objectItem;
        this.type = type;
        this.size = size;

        addButton();
    }

    private void addButton()
    {
        int x2 = 10, y2 = 10;
        for (int i = 0; i < size ; i++)
        {
            this.labels[i] = new JLabel();
            this.labels[i].setBounds(x2, y2, 280,72);
            this.labels[i].addMouseListener(this);
            this.labels[i].setBackground(Color.RED);
            this.labels[i].setOpaque(true);

            this.selected[i] = false;

            y2 += 82;
        }
        setLabelName();
        for (JLabel label : labels)
            this.add(label);

    }

    private void setLabelName()
    {
        int i = 0;
        if (type.equals("Weapon"))
        {
            Enumeration <Weapon> item = objectItem.keys();
            while (item.hasMoreElements())
            {
                Weapon weapon = item.nextElement();
                this.labels[i].setName(weapon.getName());
                i++;
            }
        }
        else if (type.equals("Armor")) {
            Enumeration <Armor> item = objectItem.keys();
            while (item.hasMoreElements())
            {
                Armor armor = item.nextElement();
                this.labels[i].setName(armor.getName());
                i++;
            }
        }
        else if (type.equals("Potion"))
        {
            Enumeration <Item> item = objectItem.keys();
            while (item.hasMoreElements())
            {
                Item potion = item.nextElement();
                this.labels[i].setName(potion.getName());
                i++;
            }
        }
    }

//    public void paint(Graphics graphics)
//    {
//        super.paint(graphics);
//
//        int i = 0;
//        Graphics2D graphics2D = (Graphics2D) graphics;
//        graphics2D.setColor(Color.WHITE);
//        for (JLabel label : labels)
//        {
//            if(selected[i])
//                graphics2D.setStroke(new BasicStroke(3));
//            else
//                graphics2D.setStroke(new BasicStroke(1));
//            graphics2D.drawRoundRect(label.getX(), label.getY(), label.getWidth(), label.getHeight(), 10, 10);
//            graphics2D.drawRoundRect(label.getX(), label.getY(), label.getHeight(), label.getHeight(), 10, 10);
//
//            graphics2D.setFont(new Font("Dialog", Font.BOLD, 13));
//            BufferedImage sprite = null;
//            if(type.equals("Weapon"))
//            {
//                sprite = Textures.getSprite(label.getName(), "Weapon");
//                Weapon weapon = Items.weapons.get(label.getName());
//                graphics2D.drawString(weapon.getDisplayName() + " [" + weapon.getRarity() + "]", label.getX()+77, label.getY()+15);
//                graphics2D.drawString("Type : " + weapon.getType(), label.getX()+77, label.getY()+32);
//                graphics2D.drawString( "Class : " + weapon.getWeaponClass(), label.getX()+77, label.getY()+47);
//                graphics2D.drawString(weapon.getDescription(), label.getX()+77, label.getY()+62);
//                graphics2D.drawString("X" + objectItem.get(weapon), label.getX()+250, label.getY()+15);
//            }
//            else if (type.equals("Armor"))
//            {
//                sprite = Textures.getSprite(label.getName(), "Armor");
//                Armor armor = Items.armors.get(label.getName());
//                graphics2D.drawString(armor.getDisplayName() + " [" + armor.getRarity() + "]", label.getX()+77, label.getY()+15);
//                graphics2D.drawString("Type : " + armor.getType(), label.getX()+77, label.getY()+32);
//                graphics2D.drawString(armor.getDescription(), label.getX()+77, label.getY()+47);
//                graphics2D.drawString("X" + objectItem.get(armor), label.getX()+250, label.getY()+15);
//            }
//            else if (type.equals("Potion"))
//            {
//                sprite = Textures.getSprite(label.getName(), "Potion");
//                Item potion = Items.potions.get(label.getName());
//                graphics2D.drawString(potion.getDisplayName() + " [" + potion.getRarity() + "]", label.getX()+77, label.getY()+15);
//                graphics2D.drawString(potion.getDescription(), label.getX()+77, label.getY()+32);
//                graphics2D.drawString("X" + objectItem.get(potion), label.getX()+250, label.getY()+15);
//            }
//            if(sprite != null)
//                graphics2D.drawImage(sprite, label.getX() + 11, label.getY() + 10,sprite.getWidth()/3, sprite.getHeight()/3, null);
//            i++;
//        }
//    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        JLabel label = (JLabel) e.getSource();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
//        if(e.getSource() == labels[0])
//            selected[0] = true;
//        else if(e.getSource() == labels[1])
//            selected[1] = true;
//        else if(e.getSource() == labels[2])
//            selected[2] = true;
//        else if(e.getSource() == labels[3])
//            selected[3] = true;
//        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
//        if(e.getSource() == labels[0])
//            selected[0] = false;
//        else if(e.getSource() == labels[1])
//            selected[1] = false;
//        else if(e.getSource() == labels[2])
//            selected[2] = false;
//        else if(e.getSource() == labels[3])
//            selected[3] = false;
//        repaint();
    }
}
