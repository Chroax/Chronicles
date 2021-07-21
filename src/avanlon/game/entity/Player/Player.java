package avanlon.game.entity.Player;

import avanlon.framework.resources.Textures;
import avanlon.framework.resources.Items;
import avanlon.game.entity.Entities;
import avanlon.game.entity.Monster;
import avanlon.game.items.Armor;
import avanlon.game.items.Item;
import avanlon.game.items.Weapon;

import javax.swing.*;
import java.util.Locale;
import java.util.Random;

public class Player extends Entities
{
    private int dungeonLevel;
    private int HPBuff;
    private int MPBuff;
    private int magDefBuff;
    private int phyDefBuff;
    private int magAttBuff;
    private int phyAttBuff;
    private int critBuff;
    private int moveSpeedBuff;
    private int gold;
    private int exp;
    private int baseExp;
    private int level;
    private int crit;
    private int baseCrit;
    private int pointSkill;
    private String playerClass;
    private Weapon myWeapon;
    private Armor myArmor;
    private Skill [] mySkill;
    public Inventory myInventory;

    public Player(String name, int HP, int MP, int magDef, int phyDef, int movSpeed, int crit, int magAtt, int phyAtt, String jobClass, int maxSkillEquip, int dungeonLevel)
    {
        super(name, HP, MP, magDef, phyDef, movSpeed, magAtt, phyAtt);
        this.HPBuff = 0;
        this.MPBuff = 0;
        this.magDefBuff = 0;
        this.phyDefBuff = 0;
        this.magAttBuff = 0;
        this.phyAttBuff = 0;
        this.critBuff = 0;
        this.moveSpeedBuff = 0;
        this.crit = crit;
        this.baseCrit = crit;
        this.gold = 100;
        this.exp = 0;
        this.pointSkill = 3;
        this.baseExp = 150;
        this.level = 1;
        this.playerClass = jobClass;
        this.mySkill = new Skill[maxSkillEquip];
        this.myInventory = new Inventory(20);
        this.dungeonLevel = dungeonLevel;
    }

    public String getPlayerClass()
    {
        return this.playerClass;
    }
    public int getLevel()
    {
        return this.level;
    }
    public int getGold()
    {
        return this.gold;
    }
    public int getBaseExp()
    {
        return this.baseExp;
    }
    public int getExp()
    {
        return this.exp;
    }
    public int getCrit()
    {
        return this.crit;
    }
    public int getPointSkill()
    {
        return this.pointSkill;
    }
    public Weapon getMyWeapon()
    {
        return this.myWeapon;
    }
    public Armor getMyArmor()
    {
        return this.myArmor;
    }
    public int getDungeonLevel()
    {
        return this.dungeonLevel;
    }

    public void plusDungeonLevel()
    {
        this.dungeonLevel += 1;
        if(this.dungeonLevel > 3)
            this.dungeonLevel = 3;
    }
    public void minPointSkill()
    {
        this.pointSkill -= 1;
        if (this.pointSkill < 0)
            this.pointSkill = 0;
    }
    public void equipWeapon(Weapon weapon)
    {
        if(this.myWeapon == null) {
        }
        else
        {
            this.magAttBuff -= myWeapon.getMagAttack();
            this.phyAttBuff -= myWeapon.getPhyAttack();
            this.phyDefBuff -= myWeapon.getPhyDef();
            myInventory.addItems("Weapon", myWeapon, 1);
        }
        addWeaponBuff(weapon);
    }

    private void addWeaponBuff(Weapon weapon)
    {
        this.myWeapon = weapon;
        this.magAttBuff += myWeapon.getMagAttack();
        this.phyAttBuff += myWeapon.getPhyAttack();
        this.phyDefBuff += myWeapon.getPhyDef();
    }

    public void equipArmor(Armor armor)
    {
        if (this.myArmor != null) {
            this.magDefBuff -= myArmor.getMagDef();
            this.phyDefBuff -= myArmor.getPhyDef();
            myInventory.addItems("Armor", myArmor, 1);
        }
        this.myArmor = armor;
        this.magDefBuff += myArmor.getMagDef();
        this.phyDefBuff += myArmor.getPhyDef();
    }
    public void addSkill(Skill skill, int slot)
    {
        if(slot >= 0 && slot <= mySkill.length-1)
        {
            skill.unLocked = true;
            skill.used = true;
            skill.skillSlotId = slot;
            mySkill[slot] = skill;
        }
        else
            JOptionPane.showMessageDialog(null, "[AddSkill] [Player] [Entity] Your input is invalid", "Add Skill", JOptionPane.WARNING_MESSAGE);
    }
    public void removeSkill(Skill skill, int slot)
    {
        if(skill.used)
        {
            skill.used = false;
            mySkill[skill.skillSlotId] = null;
        }
        else if(slot >= 0 && slot <= mySkill.length-1)
        {
            if (mySkill[slot] != null)
            {
                mySkill[slot].used = false;
                mySkill[slot] = null;
            }
        }
        else
            JOptionPane.showMessageDialog(null, "[RemoveSkill] [Player] [Entity] Your input is invalid ", "Add Skill", JOptionPane.WARNING_MESSAGE);
    }
    public Skill usedSkill(String name)
    {
        for (Skill skill : mySkill) {
            if (skill.getDisplayName().equals(name))
                return skill;
        }
        return null;
    }
    public void showMySkill()
    {
        String skillList = "";
        for (int i = 0; i < mySkill.length; i++)
        {
            if (mySkill[i] != null)
                skillList += i + 1 + ". " + mySkill[i].getDisplayName()  + "\n    Desc : " + mySkill[i].getDescription() + "\n";
            else
                skillList += i + 1 + ". None" + "\n    Desc : " + "\n";
        }
        JOptionPane.showMessageDialog(null, skillList, "My Skill List", JOptionPane.PLAIN_MESSAGE);
    }

    public void addSkillYesOrNo(Skill skill)
    {
        String skillList = "";
        for (int i = 0; i < mySkill.length; i++)
        {
            if (mySkill[i] != null)
                skillList += i + 1 + ". " + mySkill[i].getDisplayName()  + "\n    Desc : " + mySkill[i].getDescription() + "\n";
            else
                skillList += i + 1 + ". None" + "\n    Desc : " + "\n";
        }
        int value = JOptionPane.showOptionDialog(null, skillList + "\nADD SKILL ?", "Add Skill to MySkill", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
        if(value == 0)
        {
            try
            {
                int index = Integer.parseInt(JOptionPane.showInputDialog("Choose Skill Index to replace")) - 1;
                removeSkill(skill, index);
                addSkill(skill, index);
                showMySkill();
            }
            catch (NumberFormatException e)
            {
                System.err.println("[Player] [Entity]: Number Format Exception");
                e.printStackTrace();
            }
        }
    }
    public void addGold(String type, Object item, int gold, int total, boolean isInv)
    {
        if(this.myInventory.useItem(type, item, total, isInv))
            this.gold += gold;
    }
    public void useGold(String type, Object item, int total, int gold)
    {
        String [] options = new String[] {"OK"};
        if(this.gold < gold)
            JOptionPane.showOptionDialog(null, "Not Enough Gold", "Buy", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(Textures.getSprite("GOLD", "Icon")), options, 0);
        else
        {
            if(this.myInventory.addItems(type, item, total) == 0)
                this.gold -= gold;
        }
    }
    public boolean useItem(String type, Object item, int total, boolean isInv)
    {
        boolean check = false;
        if(type.equals("Weapon"))
        {
            Weapon weapon = (Weapon) item;
            if(weapon.getWeaponClass().toLowerCase(Locale.ROOT).equals(this.playerClass.toLowerCase(Locale.ROOT)))
            {
                if(this.myInventory.useItem(type, item, total, isInv))
                {
                    equipWeapon(weapon);
                    check = true;
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Doesn't match your job class", "Equip Weapon", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            if(this.myInventory.useItem(type, item, total, isInv))
            {
                switch (type)
                {
                    case "Armor" ->
                            {
                                Armor armor = (Armor) item;
                                equipArmor(armor);
                            }
                    case "Potion" ->
                            {
                                Item potion = (Item) item;
                                switch (potion.getName())
                                {
                                    case "HEALING_POTION" -> this.HPBuff += 100 * total ;
                                    case "MP_POTION" -> this.MPBuff += 50 * total;
                                    case "FOCUS_POTION" -> this.critBuff += 2 * total;
                                    case "RAPID_POTION" -> this.moveSpeedBuff += total;
                                    case "RAGE_POTION" ->
                                            {
                                                this.magAttBuff += 5 * total;
                                                this.phyAttBuff += 5 * total;
                                            }
                                    case "SHIELD_POTION" ->
                                            {
                                                this.magDefBuff += total;
                                                this.phyDefBuff += total;
                                            }
                                }
                            }
                }
                check = true;
            }
        }
        addBuff();
        return check;
    }
    public void addBuff()
    {
        this.magDef = this.baseMagDef + magDefBuff;
        this.phyDef = this.basePhyDef + phyDefBuff;
        this.magAtt = this.baseMagAtt + magAttBuff;
        this.phyAtt = this.basePhyAtt + phyAttBuff;
        this.HP = this.HPMax + HPBuff;
        if (this.HP > this.HPMax)
            this.HP = this.HPMax;
        this.MP = this.MPMax + MPBuff;
        if (this.MP > this.MPMax)
            this.MP = this.HPMax;
        this.movSpeed = this.baseMovSpeed + moveSpeedBuff;
        this.crit = this.baseCrit + critBuff;
    }
    public void giveDamage(Monster monster)
    {
        int monsterMagDeff = monster.getMagDef();
        int monsterPhyDef = monster.getPhyDef();
        int monsterSpeed = monster.getMovSpeed();
        int totalAtt = (int) (this.magAtt - (0.1 * monsterMagDeff) + this.phyAtt - (0.1 * monsterPhyDef));
        int crit = this.crit + (random.nextInt(150 - this.crit));
        if (crit >= 100)
            totalAtt *= 2;
        int dodge = monsterSpeed - this.movSpeed + (random.nextInt(150 - monsterSpeed));
        if(dodge >= 100)
            totalAtt = 0;
        monster.getDamage(Math.min(totalAtt, monster.getHP()));
    }
    public void addExpAndGold(Monster monster)
    {
        int monsterLevel = monster.getLevel();
        int expDrop = monster.getExpDrop();
        int goldDrop = monster.getGoldDrop();
        int diffLevel = this.level - monster.getLevel();
        if(diffLevel == 0)
        {
            this.gold += goldDrop;
            this.exp += expDrop;
        }
        else if(diffLevel < 0)
        {
            goldDrop += Math.abs(diffLevel * (random.nextInt(20)+10));
            expDrop += Math.abs(diffLevel * (random.nextInt(20)+10));
            this.gold += goldDrop;
            this.exp += expDrop;
        }
        else
        {
            goldDrop -= Math.abs(diffLevel * (random.nextInt(5)+5));
            expDrop -= Math.abs(diffLevel * (random.nextInt(5)+5));
            if (goldDrop < 0)
                goldDrop = 0;
            if (expDrop < 0)
                expDrop = 0;
            this.gold += goldDrop;
            this.exp += expDrop;
        }
        if(this.exp > baseExp)
            levelUp();
    }
    public void levelUp()
    {
        while(this.exp >= this.baseExp)
        {
            this.exp -= this.baseExp;
        }
    }
    public void statLevelUp()
    {
        this.level++;
        this.HPMax = this.HPMax + (int) (0.25 * this.HPMax);
        this.MPMax = this.MPMax + (int) (0.08 * this.MPMax);
        this.baseMagDef += 2;
        this.basePhyDef += 3;
        this.baseMovSpeed += 3;
        this.baseCrit += 2;
        this.baseExp = baseExp + (int) (1.5 * baseExp);

        switch (this.playerClass)
        {
            case "PALADIN" -> basePhyAtt += 3;
            case "WIZARD" -> baseMagAtt += 4;
            case "ARCHER" ->
                    {
                        basePhyAtt += 2;
                        baseMagAtt += 2;
                    }
        }
        this.pointSkill += 3;

        addBuff();
    }
}
