package avanlon.framework.resources;

import avanlon.game.entity.Monster;

import java.util.ArrayList;
import java.util.List;

public class Monsters
{
    public static List <Monster> monsterDungeonCave;
    public static List <Monster> monsterDungeonForest;
    public static List <Monster> monsterDungeonCastle;

    public static final Monster ANTI_EYE = new Monster("ANTI_EYE", 300, 200, 40, 20, 10, 50, 35, 40, 25, 1);
    public static final Monster BLOOD_LETTER = new Monster("BLOOD_LETTER", 280, 180, 22, 15, 15, 30, 60, 35, 30, 1);
    public static final Monster BLUE_DEMON = new Monster("BLUE_DEMON", 500, 250, 40, 30, 18, 70, 40, 55, 40, 2);
    public static final Monster BOAR = new Monster("BOAR", 400, 180, 25, 25, 25, 50, 50, 20, 45, 2);
    public static final Monster DARK_MAGIC = new Monster("DARK_MAGIC", 550, 300, 20, 30, 15, 65, 30, 65, 40, 3);
    public static final Monster DEMON_KNIGHT = new Monster("DEMON_KNIGHT", 720, 250, 50, 50, 25, 20, 90, 80, 50, 4);
    public static final Monster DUELYST = new Monster("DUELYST", 450, 230, 30, 30, 20, 30, 60, 60, 45, 3);
    public static final Monster ELECTRIC_MAN = new Monster("ELECTRIC_MAN", 680, 250, 40, 45, 25, 85, 35, 70, 55, 4);
    public static final Monster FIRE_DRAGON = new Monster("FIRE_DRAGON", 650, 250, 40, 40, 30, 40, 80, 75, 50, 4);
    public static final Monster FLO_LION = new Monster("FLO_LION", 850, 300, 50, 50, 35, 40, 100, 85, 60, 5);
    public static final Monster NATURAL_SWORDSMAN = new Monster("NATURAL_SWORDSMAN", 800, 300, 50, 40, 30, 45, 110, 90, 65, 5);
    public static final Monster POISON_WARRIOR = new Monster("POISON_WARRIOR",1000, 400, 55, 60, 40, 50, 125, 100, 80, 6);
    public static final Monster ROBOT = new Monster("ROBOT", 1200, 450, 60, 70, 30, 45, 138, 105, 105, 7);
    public static final Monster ROD_WARRIOR = new Monster("ROD_WARRIOR", 1300, 300, 65, 65, 50, 50, 160, 100, 110, 7);
    public static final Monster SKELETON = new Monster("SKELETON", 1500, 400, 70, 85, 60, 60, 150, 145, 145, 8);
    public static final Monster TOXICITY = new Monster("TOXICITY", 1550, 500, 80, 80, 50, 180, 70, 165, 150, 8);
    public static final Monster UNICORN = new Monster("UNICORN", 2000, 600, 100, 90, 70, 240, 90, 215, 200, 9);
    public static final Monster WOLF = new Monster("WOLF", 3000, 800, 120, 120, 80, 100, 300, 400, 400, 10);

    public Monsters()
    {
        monsterDungeonCave = new ArrayList<>();
        monsterDungeonForest = new ArrayList<>();
        monsterDungeonCastle = new ArrayList<>();

        monsterDungeonCave.add(ANTI_EYE);
        monsterDungeonCave.add(BLOOD_LETTER);
        monsterDungeonCave.add(BLUE_DEMON);
        monsterDungeonCave.add(BOAR);
        monsterDungeonCave.add(DARK_MAGIC);
        monsterDungeonCave.add(DEMON_KNIGHT);

        monsterDungeonForest.add(BOAR);
        monsterDungeonForest.add(DUELYST);
        monsterDungeonForest.add(ELECTRIC_MAN);
        monsterDungeonForest.add(FIRE_DRAGON);
        monsterDungeonForest.add(FLO_LION);
        monsterDungeonForest.add(NATURAL_SWORDSMAN);
        monsterDungeonForest.add(POISON_WARRIOR);

        monsterDungeonCastle.add(FIRE_DRAGON);
        monsterDungeonCastle.add(DARK_MAGIC);
        monsterDungeonCastle.add(DEMON_KNIGHT);
        monsterDungeonCastle.add(ROD_WARRIOR);
        monsterDungeonCastle.add(SKELETON);
        monsterDungeonCastle.add(TOXICITY);
        monsterDungeonCastle.add(UNICORN);
        monsterDungeonCastle.add(ROBOT);
        monsterDungeonCastle.add(WOLF);
    }
}
