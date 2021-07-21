package avanlon.game.states.mainstates;

import avanlon.framework.gamestates.GameState;
import avanlon.framework.gamestates.GameStateManager;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Textures;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MainMenu extends GameState
{
    private String[] optionsMenu;
    private static final String PALADIN = "Paladin";
    private static final String WIZARD = "Wizard";
    private static final String ARCHER = "Archer";
    private int selected;
    private int zoomLevel;

    public MainMenu(GameStateManager manager) {
        super(manager);
        this.optionsMenu = new String[] {PALADIN, WIZARD, ARCHER};
        this.selected = 0;
        this.zoomLevel = 2;
    }

    @Override
    protected void loop() {
    }

    @Override
    protected void paint(Graphics graphics)
    {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);

        graphics.setFont(new Font("Dialog", Font.BOLD, 40));
        graphics.setColor(Color.WHITE);
        graphics.drawString("Please Choose Your Class", 80, 130);
        for(int i=0;i<this.optionsMenu.length;i++)
        {
            if(i==this.selected)
                graphics.setColor(Color.GREEN);
            else
                graphics.setColor(Color.WHITE);
            graphics.drawString(optionsMenu[i], 80, 330 + i * 40);
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
                    case PALADIN:
                        super.gameStateManager.stackState(new PlayMenu(gameStateManager, 0));
                        break;
                    case WIZARD:
                        super.gameStateManager.stackState(new PlayMenu(gameStateManager, 1));
                        break;
                    case ARCHER:
                        super.gameStateManager.stackState(new PlayMenu(gameStateManager, 2));
                        break;
                }
                break;
        }
    }

    public void renderPlayer(Graphics graphics)
    {
        BufferedImage sprite = switch (this.selected)
                {
                    case 0 -> Textures.getSprite("PALADIN", "Entities");
                    case 1-> Textures.getSprite("WIZARD", "Entities");
                    case 2-> Textures.getSprite("ARCHER", "Entities");
                    default -> null;
                };
        graphics.drawImage(sprite, 500, 150, sprite.getWidth()*zoomLevel, sprite.getHeight()*zoomLevel, null);
    }

    @Override
    protected void keyReleased(int keyCode) {}
}
