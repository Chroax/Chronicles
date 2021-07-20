package avanlon.game.items;

public class Weapon extends Item
{
    private int magAttack;
    private int phyAttack;
    private int phyDef;
    private String weaponClass;
    private String type;

    public Weapon(String name, String rarity, String displayName, String description, int buyPrice, int magAttack, int phyAttack, int phyDef, String weaponClass, String type)
    {
        super(name, rarity, displayName, description, buyPrice);
        this.magAttack = magAttack;
        this.phyAttack = phyAttack;
        this.phyDef = phyDef;
        this.weaponClass = weaponClass;
        this.type = type;
    }

    public int getMagAttack() {
        return magAttack;
    }

    public int getPhyAttack() {
        return phyAttack;
    }

    public int getPhyDef() {
        return phyDef;
    }

    public String getWeaponClass() {
        return weaponClass;
    }

    public String getType() {
        return type;
    }
}
