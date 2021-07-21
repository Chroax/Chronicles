package avanlon.game.states.charachterstates;

import avanlon.framework.gamestates.GameState;
import avanlon.framework.gamestates.GameStateManager;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Player.Player;
import avanlon.game.states.newpage.LaunchInvArmor;
import avanlon.game.states.newpage.LaunchInvPotion;
import avanlon.game.states.newpage.LaunchInvWeapon;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class InventoryMenu extends GameState
{
    Player player;
    private String[] optionsMenu;
    private static final String WEAPON = "Weapon";
    private static final String ARMOR = "Armor";
    private static final String POTION = "Potion";
    private static final String BACK = "Back";
    private int selected;
    private int zoomLevel;

    public InventoryMenu(GameStateManager manager, Player player)
    {
        super(manager);
        this.optionsMenu = new String[] {WEAPON, ARMOR, POTION, BACK};
        this.selected = 0;
        this.zoomLevel = 2;
        this.player = player;
    }

    @Override
    protected void loop() {}

    @Override
    protected void paint(Graphics graphics)
    {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
        graphics.setColor(Color.WHITE);
        graphics.drawRoundRect(50, 110, 400, 250, 10, 10);
        graphics.setFont(new Font("Dialog", Font.BOLD, 35));
        graphics.drawString("My Character", 400, 50);

        graphics.setFont(new Font("Dialog", Font.BOLD, 25));
        graphics.drawString("Name : " + player.getName() + "       Level : " + player.getLevel(), 60, 140);
        graphics.drawString("HP : " + player.getHP() + "\\" + player.getHPMax() + "         MP : " + player.getMP() + "\\" + player.getMPMax(), 60, 180);
        graphics.drawString("MagDef : " + player.getMagDef() + "        PhyDef : " + player.getPhyDef(), 60, 220);
        graphics.drawString("MagAtt : " + player.getMagAtt() + "             PhyAtt : " + player.getPhyAtt(), 60, 260);
        if(player.getMyWeapon() != null)
            graphics.drawString("Weapon : " + player.getMyWeapon().getDisplayName(), 60, 300);
        else
            graphics.drawString("Weapon : Fist", 60, 300);
        if(player.getMyArmor() != null)
            graphics.drawString("Armor : " + player.getMyArmor().getDisplayName(), 60, 340);
        else
            graphics.drawString("Armor : Basic Armor", 60, 340);

        graphics.setFont(new Font("Dialog", Font.BOLD, 25));
        for(int i=0;i<this.optionsMenu.length;i++)
        {
            if(i==this.selected)
                graphics.setColor(Color.GREEN);
            else
                graphics.setColor(Color.WHITE);
            graphics.drawString(this.optionsMenu[i], 20, 420 + i * 40);
        }
        renderPlayer(graphics);
    }

    @Override
    protected void keyPressed(int keyCode)
    {
        switch(keyCode)
        {
            case KeyEvent.VK_UP, KeyEvent.VK_W:
                if(this.selected > 0) this.selected--;
                break;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S:
                if(this.selected < this.optionsMenu.length-1) this.selected++;
                break;
            case KeyEvent.VK_ENTER:
                switch(this.optionsMenu[selected])
                {
                    case WEAPON:
                        new LaunchInvWeapon(player, true);
                        WindowManager.frame.setVisible(false);
                        break;
                    case ARMOR:
                        new LaunchInvArmor(player, true);
                        WindowManager.frame.setVisible(false);
                        break;
                    case POTION:
                        new LaunchInvPotion(player, true);
                        WindowManager.frame.setVisible(false);
                        break;
                    case BACK:
                        super.gameStateManager.stackState(new CharacterMenu(gameStateManager, player));
                        break;
                }
                break;
        }
    }

    public void renderPlayer(Graphics graphics)
    {
        BufferedImage sprite = Textures.getSprite(player.getPlayerClass(), "Entities");
        graphics.drawImage(sprite, 500, 80, sprite.getWidth()*zoomLevel, sprite.getHeight()*zoomLevel, null);
        renderGoldAndExp(graphics);
    }
    public void renderGoldAndExp(Graphics graphics)
    {
        BufferedImage sprite = Textures.getSprite("GOLD", "Icon");
        BufferedImage sprite2 = Textures.getSprite("EXP", "Icon");
        graphics.drawImage(sprite, 60, 60, sprite.getWidth(), sprite.getHeight(), null);
        graphics.drawImage(sprite2, 570, 390, sprite2.getWidth()/4, sprite2.getHeight()/4, null);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("Dialog", Font.BOLD, 25));
        graphics.drawString(String.valueOf(player.getGold()), 100, 85);
        graphics.setColor(Color.GREEN);
        graphics.drawString(player.getExp() + " / " + player.getBaseExp(), 620, 423);
        renderWeapon(graphics);
    }
    public void renderWeapon(Graphics graphics)
    {
        BufferedImage sprite;
        BufferedImage sprite2;
        if(player.getMyWeapon() != null)
            sprite = Textures.getSprite(player.getMyWeapon().getName(), "Weapon");
        else
            sprite = Textures.getSprite("FIST", "Weapon");
        if(player.getMyArmor() != null)
            sprite2 = Textures.getSprite(player.getMyArmor().getName(), "Armor");
        else
            sprite2 = Textures.getSprite("BASIC_ARMOR", "Armor");
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Dialog", Font.BOLD, 25));
        graphics.drawString("Weapon", 800, 100);
        graphics.drawImage(sprite, 810, 110, sprite.getWidth()/2, sprite.getHeight()/2, null);
        graphics.drawString("Armor", 810, 250);
        graphics.drawImage(sprite2, 800, 260, (sprite2.getWidth()*2/3), (sprite2.getHeight()*2/3), null);
    }
    @Override
    protected void keyReleased(int keyCode) {}
}
