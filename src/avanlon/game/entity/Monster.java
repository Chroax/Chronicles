package avanlon.game.entity;

public class Monster extends Entities
{
    private int HPDeBuff;
    private int MPDeBuff;
    private int DefDeBuff;
    private int attDeBuff;
    private int movSpeedDeBuff;
    private int goldDrop;
    private int expDrop;
    private int level;

    public Monster(String name, int HP, int MP, int magDef, int phyDef, int movSpeed, int magAtt, int phyAtt, int expDrop, int goldDrop, int level)
    {
        super(name, HP, MP, magDef, phyDef, movSpeed, magAtt, phyAtt);
        this.HPDeBuff = 0;
        this.MPDeBuff = 0;
        this.DefDeBuff = 0;
        this.attDeBuff = 0;
        this.movSpeedDeBuff = 0;
        this.expDrop = expDrop;
        this.goldDrop = goldDrop;
        this.level = level;
    }
}
