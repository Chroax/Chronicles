package avanlon.game.states;

import avanlon.framework.gamestates.GameState;
import avanlon.framework.gamestates.GameStateManager;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Player.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PlayMenu extends GameState
{
    private Player player;

    private String[] optionsMenu;
    private static final String DUNGEON = "Dungeon";
    private static final String CHARACTER = "Character";
    private static final String MERCHANT = "Merchant";
    private static final String EXIT = "Exit Game";
    private int selected;
    private int zoomLevel;

    public PlayMenu(GameStateManager manager, int playerClass)
    {
        super(manager);
        int totalMaxSkill = 4;
        this.optionsMenu = new String[] {DUNGEON, CHARACTER, MERCHANT, EXIT};
        this.selected = 0;
        this.zoomLevel = 2;
        switch (playerClass)
        {
            case 0 -> player = new Player("Player", 250, 100, 100, 100, 100, 60, 0, 150, 0, totalMaxSkill);
            case 1 -> player = new Player("Player", 225, 200, 20, 50, 75, 40, 100, 0, 1, totalMaxSkill);
            case 2 -> player = new Player("Player", 200, 100, 30, 40, 300, 100, 50, 75, 2, totalMaxSkill);
        }
    }

    public PlayMenu(GameStateManager manager, Player player)
    {
        super(manager);
        this.optionsMenu = new String[] {DUNGEON, CHARACTER, MERCHANT, EXIT};
        this.selected = 0;
        this.zoomLevel = 2;
        this.player = player;
    }

    @Override
    protected void loop() {
    }

    @Override
    protected void paint(Graphics graphics)
    {
        BufferedImage sprite = Textures.getSprite("HOMESCREEN", "Screen");
        graphics.drawImage(sprite, 0, 0, sprite.getWidth()/zoomLevel, sprite.getHeight()/zoomLevel, null);

       renderPlayMenuTitle(graphics);
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
                    case DUNGEON:
                        super.gameStateManager.stackState(new PlayState(gameStateManager, player));
                        break;
                    case CHARACTER:
                        super.gameStateManager.stackState(new CharacterMenu(gameStateManager, player));
                        break;
                    case MERCHANT:
                        super.gameStateManager.stackState(new MerchantMenu(gameStateManager, player));
                        break;
                    case EXIT:
                        System.exit(0);
                        break;
                }
                break;
        }
    }

    public void renderPlayMenuTitle(Graphics graphics)
    {
        graphics.setFont(new Font("Dialog", Font.BOLD, 40));
        graphics.setColor(Color.WHITE);
        for(int i=0;i<this.optionsMenu.length;i++)
        {
            if(i==this.selected)
                graphics.setColor(Color.GREEN);
            else
                graphics.setColor(Color.WHITE);
            graphics.drawString(this.optionsMenu[i], 20, 50 + i * 40);
        }
    }

    @Override
    protected void keyReleased(int keyCode) {}
}
