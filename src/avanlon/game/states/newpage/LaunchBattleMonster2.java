package avanlon.game.states.newpage;

import avanlon.framework.gui.WindowManager;
import avanlon.framework.resources.Monsters;
import avanlon.game.entity.Monster;
import avanlon.game.entity.Player.Player;
import avanlon.game.states.dungeonstates.BattleMonster;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class LaunchBattleMonster2
{
    public static JFrame frame = new JFrame();
    public int totalMonster;
    ArrayList<Monster> spawnMob;
    private Random random = new Random();

    public LaunchBattleMonster2(Player player, int totalMonster, int level)
    {
        spawnMob = new ArrayList<>();
        for (int i = 0; i < totalMonster; i++)
        {
            switch (level)
            {
                case 1 ->
                        {
                            Monster monster = Monsters.monsterDungeonCave.get(random.nextInt(Monsters.monsterDungeonCave.size()));
                            spawnMob.add(new Monster(monster.getName(), monster.getHPMax(), monster.getMPMax(), monster.getMagDef(), monster.getPhyDef(), monster.getMovSpeed(), monster.getMagAtt(), monster.getPhyAtt(), monster.getExpDrop(), monster.getGoldDrop(), monster.getLevel()));
                        }
                case 2 ->
                        {
                            Monster monster = Monsters.monsterDungeonForest.get(random.nextInt(Monsters.monsterDungeonForest.size()));
                            spawnMob.add(new Monster(monster.getName(), monster.getHPMax(), monster.getMPMax(), monster.getMagDef(), monster.getPhyDef(), monster.getMovSpeed(), monster.getMagAtt(), monster.getPhyAtt(), monster.getExpDrop(), monster.getGoldDrop(), monster.getLevel()));
                        }
                case 3 ->
                        {
                            Monster monster = Monsters.monsterDungeonCastle.get(random.nextInt(Monsters.monsterDungeonCastle.size()));
                            spawnMob.add(new Monster(monster.getName(), monster.getHPMax(), monster.getMPMax(), monster.getMagDef(), monster.getPhyDef(), monster.getMovSpeed(), monster.getMagAtt(), monster.getPhyAtt(), monster.getExpDrop(), monster.getGoldDrop(), monster.getLevel()));
                        }
            }
        }
        this.totalMonster = totalMonster;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowManager.WIDTH, WindowManager.HEIGHT);
        frame.setLayout(null);
        frame.add(new BattleMonster(player, totalMonster, level, spawnMob));
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
