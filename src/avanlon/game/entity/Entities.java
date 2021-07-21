package avanlon.game.entity;

public class Entities
{
    protected final String name;
    protected int HP;
    protected int HPMax;
    protected int MP;
    protected int MPMax;
    protected int magDef;
    protected int baseMagDef;
    protected int PhysicalDef;
    protected int basePhysicalDef;
    protected int magAtt;
    protected int baseMagAtt;
    protected int PhysicalAtt;
    protected int basePhysicalAtt;
    protected int movSpeed;
    protected int baseMovSpeed;

    public Entities(String name, int HP, int MP, int magDef, int PhysicalDef, int movSpeed, int magAtt, int PhysicalAtt)
    {
        this.name = name;
        this.HP = HP;
        this.HPMax = HP;
        this.MP = MP;
        this.MPMax = MP;
        this.magDef = magDef;
        this.baseMagDef = magDef;
        this.phyDef = phyDef;
        this.basePhyDef = phyDef;
        this.movSpeed = movSpeed;
        this.baseMovSpeed = movSpeed;
        this.magAtt = magAtt;
        this.baseMagAtt = magAtt;
        this.phyAtt = phyAtt;
        this.basePhyAtt = phyAtt;
    }

    public String getName()
    {
        return this.name;
    }
    public int getHPMax()
    {
        return this.HPMax;
    }
    public int getHP()
    {
        return this.HP;
    }
    public int getMPMax()
    {
        return this.MPMax;
    }
    public int getMP()
    {
        return this.MP;
    }
    public int getMagDef()
    {
        return this.magDef;
    }
    public int getPhyDef()
    {
        return this.phyDef;
    }
    public int getMagAtt()
    {
        return this.magAtt;
    }
    public int getPhyAtt()
    {
        return this.phyAtt;
    }
    public int getMovSpeed()
    {
        return this.movSpeed;
    }
}
