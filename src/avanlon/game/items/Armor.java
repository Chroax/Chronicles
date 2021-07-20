package avanlon.game.items;


public class Armor extends Item
{
    private int magDef;
    private int phyDef;
    private String type;

    public Armor(String name, String rarity, String displayName, int buyPrice, int magDef, int phyDef, String type)
    {
        super(name, rarity, displayName, "MDef : " + magDef + "  |  PDef : " + phyDef, buyPrice);
        this.magDef = magDef;
        this.phyDef = phyDef;
        this.type = type;
    }

    public int getMagDef()
    {
        return magDef;
    }

    public int getPhyDef()
    {
        return phyDef;
    }

    public String getType()
    {
        return type;
    }
}
