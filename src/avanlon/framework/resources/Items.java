package avanlon.framework.resources;

import avanlon.game.items.Armor;
import avanlon.game.items.Item;
import avanlon.game.items.Weapon;

import java.util.Hashtable;

public class Items
{
    public static Hashtable <String, Item> potions = new Hashtable<>();
    public static Hashtable <String, Armor> armors = new Hashtable<>();
    public static Hashtable <String, Weapon> weapons = new Hashtable<>();
    
    public static final Item HEALING_POTION = new Item("HEALING_POTION", "Common", "Heal Potion", "Restore 100 HP", 50);
    public static final Item MP_POTION = new Item("MP_POTION", "Common", "MP Potion", "Restore 50 MP", 50);
    public static final Item FOCUS_POTION = new Item("FOCUS_POTION", "Common", "Focus Potion", "Plus 2 Crit", 75);
    public static final Item RAGE_POTION = new Item("RAGE_POTION", "Common", "Rage Potion", "Plus 5 for Both Att", 100);
    public static final Item RAPID_POTION = new Item("RAPID_POTION", "Common", "Rapid Potion", "Plus 1 MovSpeed", 75);
    public static final Item SHIELD_POTION = new Item("SHIELD_POTION", "Common", "Shield Potion", "Plus 1 for Both Def", 100);

    public static final Armor BASIC_ARMOR = new Armor("BASIC_ARMOR", "", "Basic Armor", 0, 0, 0, "Heavy Armor");
    public static final Armor LEATHER_ARMOR = new Armor("LEATHER_ARMOR", "Common", "Leather Armor", 100, 30, 0, "Heavy Armor");
    public static final Armor WARRIOR_ARMOR = new Armor("WARRIOR_ARMOR", "Common", "Warrior Armor", 200, 45, 0, "Heavy Armor");
    public static final Armor BRIGANDINE_ARMOR = new Armor("BRIGANDINE_ARMOR", "Rare", "Brigandine Armor", 450, 0, 65, "Heavy Armor");
    public static final Armor ICE_LOYS = new Armor("ICE_LOYS", "Rare", "Ice Loys", 450, 65, 0, "Cloak");
    public static final Armor SYNCTO = new Armor("SYNCTO", "Epic", "Syncto", 600, 100, 0, "Cloak");
    public static final Armor EMERALD_CLOAK = new Armor("EMERALD_CLOAK", "Epic", "Emerald Cloak", 750, 120, 0, "Cloak");
    public static final Armor CRYSTAL_ARMOR = new Armor("CRYSTAL_ARMOR", "Legendary", "Crystal Armor", 1050, 150, 150, "Heavy Armor");

    public static final Weapon ARCANITE = new Weapon("ARCANITE", "Legendary", "Arcanite", "PAtt : 150", 1100, 0, 150, 0, "Paladin", "Long Sword");
    public static final Weapon ARMAGEDDON = new Weapon("ARMAGEDDON", "Epic", "Armageddon", "PAtt : 90", 800, 0, 90, 0, "Paladin", "Long Sword");
    public static final Weapon GUILDOM = new Weapon("GUILDOM", "Epic", "Guildom", "PAtt : 75", 600, 0, 80, 0, "Paladin", "Long Sword");
    public static final Weapon RAPHIER = new Weapon("RAPHIER", "Rare", "Raphier", "PAtt : 55", 300, 0, 55, 0, "Paladin", "Long Sword");
    public static final Weapon SKYFALL = new Weapon("SKYFALL", "Common", "Sky Fall", "PAtt : 30", 100, 0, 30, 0, "Paladin", "Long Sword");
   public static final Weapon MAJESTY = new Weapon("MAJESTY", "Rare", "Majesty", "PAtt : 30  |  PDeff : 50", 300, 0, 30, 50, "Paladin", "Sword and Shield");

    public static final Weapon DAWN_BREAKER = new Weapon("DAWN_BREAKER", "Legendary", "Dawn Breaker", "MAtt : 170", 1150, 170, 0, 0, "Wizard", "Staff");
    public static final Weapon DEMENTIAL = new Weapon("DEMENTIAL", "Common", "Demential", "MAtt : 35", 100, 35, 0, 0, "Wizard", "Staff");
    public static final Weapon NECROFOZ = new Weapon("NECROFOZ", "Epic", "Necrofoz", "MAtt : 75", 600, 80, 0, 0, "Wizard", "Staff");
    public static final Weapon FROST_STEAM = new Weapon("FROST_STEAM", "Epic", "Frost Steam", "MAtt : 90", 800, 95, 0, 0, "Wizard", "Staff");
    public static final Weapon REQUIEM = new Weapon("REQUIEM", "Common", "Requiem", "MAtt : 45", 200, 45, 0, 0, "Wizard", "Staff");
    public static final Weapon SOUL_EATER = new Weapon("SOUL_EATER", "Rare", "Soul Eater", "MAtt : 60", 350, 60, 0, 0, "Wizard", "Staff");

    public static final Weapon AERO_TAIL = new Weapon("AERO_TAIL", "Common", "Aero Tail", "PAtt : 20  |  MAtt : 10", 150, 10, 20, 0, "Archer", "Bow");
    public static final Weapon DRAGON_SLAYER = new Weapon("DRAGON_SLAYER", "Legendary", "Dragon Slayer", "PAtt : 100  |  MAtt : 100", 1300, 100, 100, 0, "Archer", "Bow");
    public static final Weapon WYVISH = new Weapon("WYVISH", "Epic", "Wyvish", "PAtt : 50  |  MAtt : 45", 600, 45, 50, 0, "Archer", "Bow");
    public static final Weapon VENOMBINE = new Weapon("VENOMBINE", "Rare", "Venombine", "PAtt : 30  |  MAtt : 30", 300, 30, 30, 0, "Archer", "Cross Bow");
    public static final Weapon SQUIRM = new Weapon("SQUIRM", "Common", "Squirm", "PAtt : 20  |  MAtt : 20", 150, 20, 10, 0, "Archer", "Cross Bow");
    public static final Weapon WAR_LASH = new Weapon("WAR_LASH", "Epic", "War Lash", "PAtt : 45  |  MAtt : 50", 600, 50, 45, 0, "Archer", "Cross Bow");
    
    public Items()
    {
        potions.put(HEALING_POTION.getName(), HEALING_POTION);
        potions.put(MP_POTION.getName(), MP_POTION);
        potions.put(FOCUS_POTION.getName(), FOCUS_POTION);
        potions.put(RAGE_POTION.getName(), RAGE_POTION);
        potions.put(RAPID_POTION.getName(), RAPID_POTION);
        potions.put(SHIELD_POTION.getName(), SHIELD_POTION);

        armors.put(LEATHER_ARMOR.getName(), LEATHER_ARMOR);
        armors.put(WARRIOR_ARMOR.getName(), WARRIOR_ARMOR);
        armors.put(BRIGANDINE_ARMOR.getName(), BRIGANDINE_ARMOR);
        armors.put(ICE_LOYS.getName(), ICE_LOYS);
        armors.put(SYNCTO.getName(), SYNCTO);
        armors.put(EMERALD_CLOAK.getName(), EMERALD_CLOAK);
        armors.put(CRYSTAL_ARMOR.getName(), CRYSTAL_ARMOR);

        weapons.put(ARCANITE.getName(), ARCANITE);
        weapons.put(ARMAGEDDON.getName(), ARMAGEDDON);
        weapons.put(GUILDOM.getName(), GUILDOM);
        weapons.put(RAPHIER.getName(), RAPHIER);
        weapons.put(SKYFALL.getName(), SKYFALL);
        weapons.put(MAJESTY.getName(), MAJESTY);
        weapons.put(DAWN_BREAKER.getName(), DAWN_BREAKER);
        weapons.put(DEMENTIAL.getName(), DEMENTIAL);
        weapons.put(NECROFOZ.getName(), NECROFOZ);
        weapons.put(FROST_STEAM.getName(), FROST_STEAM);
        weapons.put(REQUIEM.getName(), REQUIEM);
        weapons.put(SOUL_EATER.getName(), SOUL_EATER);
        weapons.put(AERO_TAIL.getName(), AERO_TAIL);
        weapons.put(DRAGON_SLAYER.getName(), DRAGON_SLAYER);
        weapons.put(WYVISH.getName(), WYVISH);
        weapons.put(VENOMBINE.getName(), VENOMBINE);
        weapons.put(SQUIRM.getName(), SQUIRM);
        weapons.put(WAR_LASH.getName(), WAR_LASH);
    }
}
