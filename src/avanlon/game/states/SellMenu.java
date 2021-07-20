package avanlon.game.states;

import avanlon.framework.gamestates.GameState;
import avanlon.framework.gamestates.GameStateManager;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Player.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class SellMenu extends GameState
{
    Player player;
    private String[] optionsMenu;
    private static final String WEAPON = "Weapon";
    private static final String ARMOR = "Armor";
    private static final String POTION = "Potion";
    private static final String BACK = "Back";
    private int selected;
    private int zoomLevel;

    public SellMenu(GameStateManager manager, Player player)
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

        BufferedImage sprites = Textures.getSprite("MERCHANT", "Icon");
        graphics.drawImage(sprites, 600, 100, sprites.getWidth()*zoomLevel, sprites.getHeight()*zoomLevel, null);

        graphics.setColor(Color.WHITE);
        graphics.drawRoundRect(565, 65, 370, 370, 10, 10);

        graphics.setFont(new Font("Dialog", Font.BOLD, 35));
        graphics.drawString("MERCHANT", 400, 50);

        graphics.setFont(new Font("Dialog", Font.BOLD, 75));
        for(int i=0;i<this.optionsMenu.length;i++)
        {
            if(i==this.selected)
                graphics.setColor(Color.GREEN);
            else
                graphics.setColor(Color.WHITE);
            graphics.drawString(this.optionsMenu[i], 60, 180 + i * 100);
        }
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
                switch (this.optionsMenu[selected]) {
                    case WEAPON:
                        new LaunchSellWeapon(player, false);
                        WindowManager.frame.setVisible(false);
                        break;
                    case ARMOR:
                        new LaunchSellArmor(player, false);
                        WindowManager.frame.setVisible(false);
                        break;
                    case POTION:
                        new LaunchSellPotion(player, false);
                        WindowManager.frame.setVisible(false);
                        break;
                    case BACK:
                        super.gameStateManager.stackState(new PlayMenu(gameStateManager, player));
                        break;
                }
                break;
        }
    }
    @Override
    protected void keyReleased(int keyCode) {}
}
