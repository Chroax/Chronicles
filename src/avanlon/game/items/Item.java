package avanlon.game.items;

public class Item
{
    protected String name;
    protected String displayName;
    protected String description;
    protected String rarity;
    protected int buyPrice;
    protected int sellPrice;

    public Item(String name, String rarity, String displayName, String description, int buyPrice)
    {
        this.name = name;
        this.rarity = rarity;
        this.displayName = displayName;
        this.description = description;
        this.buyPrice = buyPrice;
        this.sellPrice = (int) (buyPrice * 0.65);
    }

    public String getName()
    {
        return name;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getDescription()
    {
        return description;
    }

    public String getRarity()
    {
        return rarity;
    }

    public int getBuyPrice()
    {
        return buyPrice;
    }

    public int getSellPrice()
    {
        return sellPrice;
    }
}
