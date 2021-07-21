package avanlon.game.entity;

import avanlon.game.entity.Player.Player;

public class Monster extends Entities
{
    private int HPDeBuff;
    private int MPDeBuff;
    private int defDeBuff;
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
        this.defDeBuff = 0;
        this.attDeBuff = 0;
        this.movSpeedDeBuff = 0;
        this.expDrop = expDrop;
        this.goldDrop = goldDrop;
        this.level = level;
    }

    public int getLevel()
    {
        return this.level;
    }
    public int getExpDrop()
    {
        return this.expDrop;
    }
    public int getGoldDrop()
    {
        return this.goldDrop;
    }
    public void changeHPDeBuff(int HPDeBuff)
    {
        this.HPDeBuff = HPDeBuff;
    }
    public void changeMPDeBuff(int MPDeBuff)
    {
        this.MPDeBuff = MPDeBuff;
    }
    public void changeDefDeBuff(int defDeBuff)
    {
        this.defDeBuff = defDeBuff;
    }
    public void changeAttDeBuff(int attDeBuff)
    {
        this.attDeBuff = attDeBuff;
    }
    public void changeMovSpeedDeBuff(int movSpeedDeBuff)
    {
        this.movSpeedDeBuff = movSpeedDeBuff;
    }
    public void giveDamage(Player player)
    {
        int playerMagDeff = player.getMagDef();
        int playerPhyDef = player.getPhyDef();
        int playerSpeed = player.getMovSpeed();
        int totalAtt = (int) (this.magAtt - (0.1 * playerMagDeff) + this.phyAtt - (0.1 * playerPhyDef));
        int dodge = playerSpeed - this.movSpeed + (random.nextInt(150 - playerSpeed));
        if(dodge >= 100)
            totalAtt = 0;
        if(totalAtt > player.getHP())
            player.getDamage(player.getHP());
        else
            player.getDamage(totalAtt);
    }
}
