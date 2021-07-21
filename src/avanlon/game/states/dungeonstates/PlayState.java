package avanlon.game.states.dungeonstates;

import avanlon.framework.gamestates.GameState;
import avanlon.framework.gamestates.GameStateManager;
import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Textures;
import avanlon.game.entity.Player.Player;
import avanlon.game.states.mainstates.PlayMenu;
import avanlon.game.states.newpage.LaunchBattleMonster;
import avanlon.game.states.newpage.LaunchBattleMonster2;
import avanlon.game.states.newpage.LaunchBattleMonster3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PlayState extends GameState
{
    private Player player;
    private String[] optionsMenu;
    private static final String CAVE = "Cave";
    private static final String FOREST = "Forest";
    private static final String CASTLE = "Castle";
    private static final String BACK = "Back";
    private int selected;
    private int zoomLevel;
    private Random random = new Random();

    public PlayState(GameStateManager manager, Player player)
    {
        super(manager);
        this.optionsMenu = new String[] {CAVE, FOREST, CASTLE, BACK};
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
        BufferedImage sprite = switch (this.optionsMenu[selected])
                {
                    case FOREST -> Textures.getSprite("FORESTSCREEN", "Screen");
                    case CASTLE -> Textures.getSprite("CASTLESCREEN", "Screen");
                    default -> Textures.getSprite("CAVESCREEN", "Screen");
                };
        graphics.drawImage(sprite, 0, 0, sprite.getWidth()/zoomLevel, sprite.getHeight()/zoomLevel, null);
        renderPlayMenuTitle(graphics);
    }

    @Override
    protected void keyPressed(int keyCode)
    {
        switch(keyCode)
        {
            case KeyEvent.VK_UP, KeyEvent.VK_W ->
                    {
                        if(this.selected > 0) this.selected--;
                    }
            case KeyEvent.VK_DOWN, KeyEvent.VK_S ->
                    {
                        if(this.selected < this.optionsMenu.length-1) this.selected++;
                    }
            case KeyEvent.VK_ENTER ->
                    {
                        switch(this.optionsMenu[selected])
                        {
                            case CAVE ->
                                    {
                                        int generateMonster = random.nextInt(3) + 2;
                                        LaunchBattleMonster battleMonster = new LaunchBattleMonster(player, generateMonster, 1);
                                        WindowManager.frame.setVisible(false);
                                    }
                            case FOREST ->
                                    {
                                        if (player.getDungeonLevel() < 2)
                                            JOptionPane.showMessageDialog(null, "Not Yet Unlocked this Forest Dungeon", "Dungeon Message", JOptionPane.WARNING_MESSAGE);
                                        else
                                        {
                                            int generateMonster = random.nextInt(4) + 3;
                                            new LaunchBattleMonster2(player, generateMonster, 2);
                                            WindowManager.frame.setVisible(false);
                                        }
                                    }
                            case CASTLE ->
                                    {
                                        if (player.getDungeonLevel() < 3)
                                            JOptionPane.showMessageDialog(null, "Not Yet Unlocked this Castle Dungeon", "Dungeon Message", JOptionPane.WARNING_MESSAGE);
                                        else
                                        {
                                            int generateMonster = random.nextInt(5) + 4;
                                            new LaunchBattleMonster3(player, generateMonster, 3);
                                            WindowManager.frame.setVisible(false);
                                        }
                                    }
                            case BACK -> super.gameStateManager.stackState(new PlayMenu(gameStateManager, player));
                        }
                    }
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
