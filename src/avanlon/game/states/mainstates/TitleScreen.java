package avanlon.game.states.mainstates;

import avanlon.framework.gamestates.GameState;
import avanlon.framework.gamestates.GameStateManager;
import avanlon.framework.resources.Textures;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class TitleScreen extends GameState
{
    private String[] optionsMenu;
    private static final String ENTER = "Press ENTER to Continue";
    private int selected;
    private int zoomLevel;

    public TitleScreen(GameStateManager manager)
    {
        super(manager);
        this.optionsMenu = new String[] {ENTER};
        this.selected = 0;
        this.zoomLevel = 2;
    }

    @Override
    protected void loop()
    {
    }

    @Override
    protected void paint(Graphics graphics)
    {
        BufferedImage sprite = Textures.getSprite("MAINSCREEN", "Screen");
        graphics.drawImage(sprite, 0, 0, sprite.getWidth()/zoomLevel, sprite.getHeight()/zoomLevel, null);

        renderTitle(graphics);
    }

    @Override
    protected void keyPressed(int keyCode)
    {
        switch(keyCode)
        {
            case KeyEvent.VK_ENTER:
                switch(this.optionsMenu[selected])
                {
                    case ENTER:
                        super.gameStateManager.stackState(new MainMenu(gameStateManager));
                }
                break;
        }
    }

    public void renderTitle(Graphics graphics)
    {
        graphics.setFont(new Font("Dialog", Font.BOLD, 40));
        graphics.setColor(Color.WHITE);
        graphics.drawString(ENTER, 260, 475);
    }

    @Override
    protected void keyReleased(int keyCode) {}
}
