package avanlon.game.states.merchantstates;

import avanlon.framework.gui.MyButton;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Items;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Player.Player;
import avanlon.game.items.Armor;
import avanlon.game.items.Item;
import avanlon.game.items.Weapon;
import avanlon.game.states.newpage.LaunchBuyPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class BuyMenu extends JPanel implements ActionListener
{
    Player player;
    private final MyButton [] buttons;
    private int selected;

    public BuyMenu(Player player)
    {
        this.selected = 0;
        this.player = player;
        this.buttons = new MyButton[35];
        this.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        int x = 100, y = 440, xBuyWeaponPaladin = 260, yBuyWeaponPaladin = 95, xBuyWeaponWizard = 540, yBuyWeaponWizard = 95, xBuyWeaponArcher = 820, yBuyWeaponArcher = 95;
        int xBuyArmor1 = 260, yBuyArmor1 = 95, xBuyArmor2 = 540, yBuyArmor2 = 95, xBuyArmor3 = 820, yBuyArmor3 = 95;
        int xBuyPotion1 = 415, yBuyPotion1 = 95, xBuyPotion2 = 695, yBuyPotion2 = 95;
        for (int i = 0; i < buttons.length; i++)
        {
            if(i == 0)
                this.buttons[i] = new MyButton("Weapon");
            else if(i == 1)
                this.buttons[i] = new MyButton("Armor");
            else if(i == 2)
                this.buttons[i] = new MyButton("Potion");
            else if(i == 3)
                this.buttons[i] = new MyButton("Back");
            else
                this.buttons[i] = new MyButton("Buy");
            this.buttons[i].setFont(new Font("Dialog", Font.BOLD, 15));
            this.buttons[i].setMargin(new Insets(0,0,0,0));
            this.buttons[i].setBorder(null);
            this.buttons[i].setFocusPainted(false);
            this.buttons[i].setForeground(Color.WHITE);
            this.buttons[i].setBackground(Color.BLACK);
            if(i > 3)
                this.buttons[i].setHoverBackgroundColor(Color.WHITE.brighter());
            else
                this.buttons[i].setHoverBackgroundColor(Color.BLACK.brighter());
            this.buttons[i].setPressedBackgroundColor(Color.BLACK);
            this.buttons[i].addActionListener(this);
            if(i < 4)
            {
                this.buttons[i].setBounds(x, y, 60, 20);
                x += 80;
            }
            if(i >= 4 && i <= 9)
            {
                this.buttons[i].setBounds(xBuyWeaponPaladin, yBuyWeaponPaladin, 40, 20);
                yBuyWeaponPaladin += 55;
            }
            if(i >= 10 && i <= 15)
            {
                this.buttons[i].setBounds(xBuyWeaponWizard, yBuyWeaponWizard, 40, 20);
                yBuyWeaponWizard += 55;
            }
            if(i >= 16 && i <= 21)
            {
                this.buttons[i].setBounds(xBuyWeaponArcher, yBuyWeaponArcher, 40, 20);
                yBuyWeaponArcher += 55;
            }
            if(i >= 22 && i <= 24)
            {
                this.buttons[i].setBounds(xBuyArmor1, yBuyArmor1, 40, 20);
                yBuyArmor1 += 105;
            }
            if(i >= 25 && i <= 27)
            {
                this.buttons[i].setBounds(xBuyArmor2, yBuyArmor2, 40, 20);
                yBuyArmor2 += 105;
            }
            if(i == 28)
                this.buttons[i].setBounds(xBuyArmor3, yBuyArmor3, 40, 20);
            if(i >= 29 && i <= 31)
            {
                this.buttons[i].setBounds(xBuyPotion1, yBuyPotion1, 40, 20);
                yBuyPotion1 += 105;
            }
            if(i >= 32)
            {
                this.buttons[i].setBounds(xBuyPotion2, yBuyPotion2, 40, 20);
                yBuyPotion2 += 105;
            }
            if(!WindowManager.openBuyMenu)
            {
                if(i >= 22)
                {
                    this.buttons[i].setOpaque(false);
                    this.buttons[i].setVisible(false);
                    this.buttons[i].setEnabled(false);
                }
            }
            else
            {
                this.buttons[i].setOpaque(false);
                this.buttons[i].setVisible(false);
                this.buttons[i].setEnabled(false);
            }
        }
        
        this.buttons[4].setActionCommand("ARCANITE");
        this.buttons[5].setActionCommand("ARMAGEDDON");
        this.buttons[6].setActionCommand("GUILDOM");
        this.buttons[7].setActionCommand("RAPHIER");
        this.buttons[8].setActionCommand("SKYFALL");
        this.buttons[9].setActionCommand("MAJESTY");
        this.buttons[10].setActionCommand("DAWN_BREAKER");
        this.buttons[11].setActionCommand("DEMENTIAL");
        this.buttons[12].setActionCommand("NECROFOZ");
        this.buttons[13].setActionCommand("FROST_STEAM");
        this.buttons[14].setActionCommand("REQUIEM");
        this.buttons[15].setActionCommand("SOUL_EATER");
        this.buttons[16].setActionCommand("AERO_TAIL");
        this.buttons[17].setActionCommand("DRAGON_SLAYER");
        this.buttons[18].setActionCommand("WYVISH");
        this.buttons[19].setActionCommand("VENOMBINE");
        this.buttons[20].setActionCommand("SQUIRM");
        this.buttons[21].setActionCommand("WAR_LASH");

        this.buttons[22].setActionCommand("LEATHER_ARMOR");
        this.buttons[23].setActionCommand("WARRIOR_ARMOR");
        this.buttons[24].setActionCommand("BRIGANDINE_ARMOR");
        this.buttons[25].setActionCommand("ICE_LOYS");
        this.buttons[26].setActionCommand("SYNCTO");
        this.buttons[27].setActionCommand("EMERALD_CLOAK");
        this.buttons[28].setActionCommand("CRYSTAL_ARMOR");

        this.buttons[29].setActionCommand("HEALING_POTION");
        this.buttons[30].setActionCommand("MP_POTION");
        this.buttons[31].setActionCommand("FOCUS_POTION");
        this.buttons[32].setActionCommand("RAGE_POTION");
        this.buttons[33].setActionCommand("RAPID_POTION");
        this.buttons[34].setActionCommand("SHIELD_POTION");

        for (MyButton button : buttons)
        {
            this.add(button);
        }
    }
    
    public void paint(Graphics graphics)
    {
        super.paint(graphics);

        BufferedImage sprite = Textures.getSprite("GOLD", "Icon");
        BufferedImage sprite2 = Textures.getSprite("INVENTORY", "Icon");
        graphics.drawImage(sprite, 810, 430, sprite.getWidth(), sprite.getHeight(), null);
        graphics.drawImage(sprite2, 810, 470, sprite2.getWidth(), sprite2.getHeight(), null);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Dialog", Font.BOLD, 35));
        graphics.drawString("MERCHANT", 400, 50);

        graphics.setFont(new Font("Dialog", Font.BOLD, 20));
        graphics.setColor(new Color(0xD7B19D));
        graphics.drawString(player.myInventory.getCapacity() + "/" + player.myInventory.getMaxCapacity(), 850, 493);

        graphics.setColor(Color.YELLOW);
        graphics.drawString(String.valueOf(player.getGold()), 850, 453);
        graphics.setColor(Color.WHITE);

        for(int i=0; i < 4; i++)
        {
            if(i == this.selected)
                buttons[i].setForeground(Color.GREEN);
            else
                buttons[i].setForeground(Color.WHITE);
        }

        Graphics2D graphics2D = (Graphics2D) graphics; 
        
        switch (this.selected)
        {
            case 0 ->
                    {
                        int subXPaladin = 100, subYPaladin = 70, subXWizard = 380, subYWizard = 70, subXArcher = 660, subYArcher = 70;
                        Rectangle [] rectanglesPaladin = new Rectangle[6];
                        Rectangle []  rectanglesWizard= new Rectangle[6];
                        Rectangle [] rectanglesArcher = new Rectangle[6];

                        for (int i = 0; i < rectanglesPaladin.length; i++)
                        {
                            rectanglesPaladin[i] = new Rectangle(subXPaladin, subYPaladin, 200, 50);
                            subYPaladin += 55;
                            rectanglesWizard[i] = new Rectangle(subXWizard, subYWizard, 200, 50);
                            subYWizard += 55;
                            rectanglesArcher[i] = new Rectangle(subXArcher, subYArcher, 200, 50);
                            subYArcher += 55;
                        }

                        graphics2D.setStroke(new BasicStroke(1));

                        renderImg(graphics2D, rectanglesPaladin);

                        renderImg(graphics2D, rectanglesWizard);

                        renderImg(graphics2D, rectanglesArcher);

                        subXPaladin = 100; subYPaladin = 70; subXWizard = 380; subYWizard = 70; subXArcher = 660; subYArcher = 70;
                        graphics2D.setColor(Color.YELLOW);

                        BufferedImage[] sprites = new BufferedImage[18];
                        sprites[0] = Textures.getSprite(Items.ARCANITE.getName(), "Weapon");
                        graphics2D.drawImage(sprites[0], subXPaladin+5, subYPaladin+5, sprites[0].getWidth()/4, sprites[0].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.ARCANITE.getBuyPrice()), subXPaladin+110,subYPaladin+30);

                        sprites[1] = Textures.getSprite(Items.ARMAGEDDON.getName(), "Weapon");
                        graphics2D.drawImage(sprites[1], subXPaladin+5, subYPaladin+60, sprites[1].getWidth()/4, sprites[1].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.ARMAGEDDON.getBuyPrice()), subXPaladin+110,subYPaladin+85);

                        sprites[2] = Textures.getSprite(Items.GUILDOM.getName(), "Weapon");
                        graphics2D.drawImage(sprites[2], subXPaladin+5, subYPaladin+115, sprites[2].getWidth()/4, sprites[2].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.GUILDOM.getBuyPrice()), subXPaladin+110,subYPaladin+140);

                        sprites[3] = Textures.getSprite(Items.RAPHIER.getName(), "Weapon");
                        graphics2D.drawImage(sprites[3], subXPaladin+5, subYPaladin+170, sprites[3].getWidth()/4, sprites[3].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.RAPHIER.getBuyPrice()), subXPaladin+110,subYPaladin+195);

                        sprites[4] = Textures.getSprite(Items.SKYFALL.getName(), "Weapon");
                        graphics2D.drawImage(sprites[4], subXPaladin+5, subYPaladin+225, sprites[4].getWidth()/4, sprites[4].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.SKYFALL.getBuyPrice()), subXPaladin+110,subYPaladin+250);

                        sprites[5] = Textures.getSprite(Items.MAJESTY.getName(), "Weapon");
                        graphics2D.drawImage(sprites[5], subXPaladin+5, subYPaladin+280, sprites[5].getWidth()/4, sprites[5].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.MAJESTY.getBuyPrice()), subXPaladin+110,subYPaladin+305);

                        sprites[6] = Textures.getSprite(Items.DAWN_BREAKER.getName(), "Weapon");
                        graphics2D.drawImage(sprites[6], subXWizard+5, subYWizard+5, sprites[6].getWidth()/4, sprites[6].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.DAWN_BREAKER.getBuyPrice()), subXWizard+110,subYWizard+30);

                        sprites[7] = Textures.getSprite(Items.DEMENTIAL.getName(), "Weapon");
                        graphics2D.drawImage(sprites[7], subXWizard+5, subYWizard+60, sprites[7].getWidth()/4, sprites[7].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.DEMENTIAL.getBuyPrice()), subXWizard+110,subYWizard+85);

                        sprites[8] = Textures.getSprite(Items.NECROFOZ.getName(), "Weapon");
                        graphics2D.drawImage(sprites[8], subXWizard+5, subYWizard+115, sprites[8].getWidth()/4, sprites[8].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.NECROFOZ.getBuyPrice()), subXWizard+110,subYWizard+140);

                        sprites[9] = Textures.getSprite(Items.FROST_STEAM.getName(), "Weapon");
                        graphics2D.drawImage(sprites[9], subXWizard+5, subYWizard+170, sprites[9].getWidth()/4, sprites[9].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.FROST_STEAM.getBuyPrice()), subXWizard+110,subYWizard+195);

                        sprites[10] = Textures.getSprite(Items.REQUIEM.getName(), "Weapon");
                        graphics2D.drawImage(sprites[10], subXWizard+5, subYWizard+225, sprites[10].getWidth()/4, sprites[10].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.REQUIEM.getBuyPrice()), subXWizard+110,subYWizard+250);

                        sprites[11] = Textures.getSprite(Items.SOUL_EATER.getName(), "Weapon");
                        graphics2D.drawImage(sprites[11], subXWizard+5, subYWizard+280, sprites[11].getWidth()/4, sprites[11].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.SOUL_EATER.getBuyPrice()), subXWizard+110,subYWizard+305);

                        sprites[12] = Textures.getSprite(Items.AERO_TAIL.getName(), "Weapon");
                        graphics2D.drawImage(sprites[12], subXArcher+5, subYArcher+5, sprites[12].getWidth()/4, sprites[12].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.AERO_TAIL.getBuyPrice()), subXArcher+110,subYArcher+30);

                        sprites[13] = Textures.getSprite(Items.DRAGON_SLAYER.getName(), "Weapon");
                        graphics2D.drawImage(sprites[13], subXArcher+5, subYArcher+60, sprites[13].getWidth()/4, sprites[13].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.DRAGON_SLAYER.getBuyPrice()), subXArcher+110,subYArcher+85);

                        sprites[14] = Textures.getSprite(Items.WYVISH.getName(), "Weapon");
                        graphics2D.drawImage(sprites[14], subXArcher+5, subYArcher+115, sprites[14].getWidth()/4, sprites[14].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.WYVISH.getBuyPrice()), subXArcher+110,subYArcher+140);

                        sprites[15] = Textures.getSprite(Items.VENOMBINE.getName(), "Weapon");
                        graphics2D.drawImage(sprites[15], subXArcher+5, subYArcher+170, sprites[15].getWidth()/4, sprites[15].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.VENOMBINE.getBuyPrice()), subXArcher+110,subYArcher+195);

                        sprites[16] = Textures.getSprite(Items.SQUIRM.getName(), "Weapon");
                        graphics2D.drawImage(sprites[16], subXArcher+5, subYArcher+225, sprites[16].getWidth()/4, sprites[16].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.SQUIRM.getBuyPrice()), subXArcher+110,subYArcher+250);

                        sprites[17] = Textures.getSprite(Items.WAR_LASH.getName(), "Weapon");
                        graphics2D.drawImage(sprites[17], subXArcher+5, subYArcher+280, sprites[17].getWidth()/4, sprites[17].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.WAR_LASH.getBuyPrice()), subXArcher+110,subYArcher+305);
                    }
            case 1 ->
                    {
                        int subXArmor = 100, subYArmor = 70;
                        Rectangle [] rectanglesArmor = new Rectangle[7];

                        makeRectangles(subXArmor, subYArmor, rectanglesArmor, "Armor");

                        renderImg(graphics2D, rectanglesArmor);

                        graphics2D.drawRoundRect(rectanglesArmor[6].x, rectanglesArmor[6].y, rectanglesArmor[6].width, rectanglesArmor[6].height, 10, 10);
                        graphics2D.drawRoundRect(rectanglesArmor[6].x, rectanglesArmor[6].y, 50, rectanglesArmor[6].height, 10, 10);

                        graphics2D.setColor(Color.YELLOW);
                        BufferedImage[] sprites = new BufferedImage[7];
                        sprites[0] = Textures.getSprite(Items.LEATHER_ARMOR.getName(), "Armor");
                        graphics2D.drawImage(sprites[0], subXArmor+5, subYArmor+5, sprites[0].getWidth()/4, sprites[0].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.LEATHER_ARMOR.getBuyPrice()), subXArmor+110,subYArmor+30);

                        sprites[1] = Textures.getSprite(Items.WARRIOR_ARMOR.getName(), "Armor");
                        graphics2D.drawImage(sprites[1], subXArmor+5, subYArmor+110, sprites[1].getWidth()/4, sprites[1].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.WARRIOR_ARMOR.getBuyPrice()), subXArmor+110,subYArmor+135);

                        sprites[2] = Textures.getSprite(Items.BRIGANDINE_ARMOR.getName(), "Armor");
                        graphics2D.drawImage(sprites[2], subXArmor+5, subYArmor+215, sprites[2].getWidth()/4, sprites[2].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.BRIGANDINE_ARMOR.getBuyPrice()), subXArmor+110,subYArmor+240);

                        sprites[3] = Textures.getSprite(Items.ICE_LOYS.getName(), "Armor");
                        graphics2D.drawImage(sprites[3], subXArmor+285, subYArmor+5, sprites[3].getWidth()/4, sprites[3].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.ICE_LOYS.getBuyPrice()), subXArmor+390,subYArmor+30);

                        sprites[4] = Textures.getSprite(Items.SYNCTO.getName(), "Armor");
                        graphics2D.drawImage(sprites[4], subXArmor+285, subYArmor+110, sprites[4].getWidth()/4, sprites[4].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.SYNCTO.getBuyPrice()), subXArmor+390,subYArmor+135);

                        sprites[5] = Textures.getSprite(Items.EMERALD_CLOAK.getName(), "Armor");
                        graphics2D.drawImage(sprites[5], subXArmor+285, subYArmor+215, sprites[5].getWidth()/4, sprites[5].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.EMERALD_CLOAK.getBuyPrice()), subXArmor+390,subYArmor+240);

                        sprites[6] = Textures.getSprite(Items.CRYSTAL_ARMOR.getName(), "Armor");
                        graphics2D.drawImage(sprites[6], subXArmor+565, subYArmor+5, sprites[6].getWidth()/4, sprites[6].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.CRYSTAL_ARMOR.getBuyPrice()), subXArmor+670,subYArmor+30);
                    }

            case 2 ->
                    {
                        int subXPotion = 260, subYPotion = 70;
                        Rectangle [] rectanglesPotion = new Rectangle[6];

                        makeRectangles(subXPotion, subYPotion, rectanglesPotion, "Potion");
                        rectanglesPotion[5] = new Rectangle(subXPotion+280, subYPotion+210, 200, 50);

                        renderImg(graphics2D, rectanglesPotion);

                        graphics2D.setColor(Color.YELLOW);
                        BufferedImage[] sprites = new BufferedImage[6];
                        sprites[0] = Textures.getSprite(Items.HEALING_POTION.getName(), "Potion");
                        graphics2D.drawImage(sprites[0], subXPotion+5, subYPotion+5, sprites[0].getWidth()/4, sprites[0].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.HEALING_POTION.getBuyPrice()), subXPotion+110,subYPotion+30);

                        sprites[1] = Textures.getSprite(Items.MP_POTION.getName(), "Potion");
                        graphics2D.drawImage(sprites[1], subXPotion+5, subYPotion+110, sprites[1].getWidth()/4, sprites[1].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.MP_POTION.getBuyPrice()), subXPotion+110,subYPotion+135);

                        sprites[2] = Textures.getSprite(Items.FOCUS_POTION.getName(), "Potion");
                        graphics2D.drawImage(sprites[2], subXPotion+5, subYPotion+215, sprites[2].getWidth()/4, sprites[2].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.FOCUS_POTION.getBuyPrice()), subXPotion+110,subYPotion+240);

                        sprites[3] = Textures.getSprite(Items.RAGE_POTION.getName(), "Potion");
                        graphics2D.drawImage(sprites[3], subXPotion+285, subYPotion+5, sprites[3].getWidth()/4, sprites[3].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.RAGE_POTION.getBuyPrice()), subXPotion+390,subYPotion+30);

                        sprites[4] = Textures.getSprite(Items.RAPID_POTION.getName(), "Potion");
                        graphics2D.drawImage(sprites[4], subXPotion+285, subYPotion+110, sprites[4].getWidth()/4, sprites[4].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.RAPID_POTION.getBuyPrice()), subXPotion+390,subYPotion+135);

                        sprites[5] = Textures.getSprite(Items.SHIELD_POTION.getName(), "Potion");
                        graphics2D.drawImage(sprites[5], subXPotion+285, subYPotion+215, sprites[5].getWidth()/4, sprites[5].getHeight()/4, null);
                        graphics2D.drawString(String.valueOf(Items.SHIELD_POTION.getBuyPrice()), subXPotion+390,subYPotion+240);
                    }
        }
    }

    private void makeRectangles(int x, int y, Rectangle[] rectangles, String type)
    {
        rectangles[0] = new Rectangle(x, y, 200, 50);
        rectangles[1] = new Rectangle(x, y+105, 200, 50);
        rectangles[2] = new Rectangle(x, y+210, 200, 50);
        rectangles[3] = new Rectangle(x+280, y, 200, 50);
        rectangles[4] = new Rectangle(x+280, y+105, 200, 50);
        rectangles[5] = new Rectangle(x+280, y+210, 200, 50);
        if(type.equals("Armor"))
            rectangles[6] = new Rectangle(x+560, y, 200, 50);
    }

    private void renderImg(Graphics2D graphics2D, Rectangle[] rectangles)
    {
        graphics2D.drawRoundRect(rectangles[0].x, rectangles[0].y, rectangles[0].width, rectangles[0].height, 10, 10);
        graphics2D.drawRoundRect(rectangles[0].x, rectangles[0].y, 50, rectangles[0].height, 10, 10);

        graphics2D.drawRoundRect(rectangles[1].x, rectangles[1].y, rectangles[1].width, rectangles[1].height, 10, 10);
        graphics2D.drawRoundRect(rectangles[1].x, rectangles[1].y, 50, rectangles[1].height, 10, 10);

        graphics2D.drawRoundRect(rectangles[2].x, rectangles[2].y, rectangles[2].width, rectangles[2].height, 10, 10);
        graphics2D.drawRoundRect(rectangles[2].x, rectangles[2].y, 50, rectangles[2].height, 10, 10);

        graphics2D.drawRoundRect(rectangles[3].x, rectangles[3].y, rectangles[3].width, rectangles[3].height, 10, 10);
        graphics2D.drawRoundRect(rectangles[3].x, rectangles[3].y, 50, rectangles[3].height, 10, 10);

        graphics2D.drawRoundRect(rectangles[4].x, rectangles[4].y, rectangles[4].width, rectangles[4].height, 10, 10);
        graphics2D.drawRoundRect(rectangles[4].x, rectangles[4].y, 50, rectangles[4].height, 10, 10);

        graphics2D.drawRoundRect(rectangles[5].x, rectangles[5].y, rectangles[5].width, rectangles[5].height, 10, 10);
        graphics2D.drawRoundRect(rectangles[5].x, rectangles[5].y, 50, rectangles[5].height, 10, 10);
    }

    public void setOpaque()
    {
        if(this.selected == 0)
        {
            for (int i = 4; i < buttons.length; i++)
            {
                if(i <= 21)
                {
                    buttons[i].setEnabled(true);
                    buttons[i].setVisible(true);
                }
                else
                {
                    buttons[i].setEnabled(false);
                    buttons[i].setVisible(false);
                }
            }
        }
        else if(this.selected == 1)
        {
            for (int i = 4; i < buttons.length; i++)
            {
                if(i >= 22 && i <= 28)
                {
                    buttons[i].setEnabled(true);
                    buttons[i].setVisible(true);
                }
                else
                {
                    buttons[i].setEnabled(false);
                    buttons[i].setVisible(false);
                }
            }
        }
        else if(this.selected == 2)
        {
            for (int i = 4; i < buttons.length; i++)
            {
                if(i >= 29 && i <= 34)
                {
                    buttons[i].setEnabled(true);
                    buttons[i].setVisible(true);
                }
                else
                {
                    buttons[i].setEnabled(false);
                    buttons[i].setVisible(false);
                }
            }
        }
        repaint();
    }

    public void buyItems(ActionEvent e)
    {
        if(selected == 0)
        {
            Weapon buyWeapon = Items.weapons.get(e.getActionCommand());
            int value = getTotalBuy();
            if(value != 0 && value != -1)
            {
                if(JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Buy " + buyWeapon.getDisplayName() + " [x" + value + "]", "Buy Weapon", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0)
                {
                    int totalPrice = buyWeapon.getBuyPrice() * value;
                    player.useGold("Weapon", buyWeapon, value, totalPrice);
                }
            }
        }
        else if(selected == 1)
        {
            Armor buyArmor = Items.armors.get(e.getActionCommand());
            int value = getTotalBuy();
            if(value != 0 && value != -1)
            {
                if(JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Buy " + buyArmor.getDisplayName() + " [x" + value + "]", "Buy Armor", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0)
                {
                    int totalPrice = buyArmor.getBuyPrice() * value;
                    player.useGold("Armor", buyArmor, value, totalPrice);
                }
            }
        }
        else if(selected == 2)
        {
            Item buyPotion = Items.potions.get(e.getActionCommand());
            int value = getTotalBuy();
            if(value != 0 && value != -1)
            {
                if(JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Buy " + buyPotion.getDisplayName() + " [x" + value + "]", "Buy Potion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0)
                {
                    int totalPrice = buyPotion.getBuyPrice() * value;
                    player.useGold("Potion", buyPotion, value, totalPrice);
                }
            }
        }
    }

    private int getTotalBuy()
    {
        int value = 0;
        try
        {
            String answer = JOptionPane.showInputDialog("How Many do You want to buy ?", "1");
            if(answer != null)
                value = Integer.parseInt(answer);
        }
        catch (NumberFormatException arg0)
        {
            value = -1;
            System.err.println("[BuyMenu] [States] Error Parse Integer");
            arg0.printStackTrace();
        }
        return value;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == buttons[0])
            selected = 0;
        else if(e.getSource() == buttons[1])
            selected = 1;
        else if(e.getSource() == buttons[2])
            selected = 2;
        else if(e.getSource() == buttons[3])
            selected = 3;
        else
        {
            buyItems(e);
            repaint();
        }
        if(selected >= 0 && selected <= 3)
        {
            if(selected < 3)
                setOpaque();
            else if(selected == 3)
            {
                selected = 0;
                setOpaque();
                WindowManager.openBuyMenu = true;
                LaunchBuyPage.frame.dispose();
                WindowManager.frame.setVisible(true);
            }
        }
    }
}