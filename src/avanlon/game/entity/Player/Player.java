package avanlon.game.entity.Player;

import avanlon.framework.resources.Textures;
import avanlon.game.entity.Entities;
import avanlon.game.items.Armor;
import avanlon.game.items.Weapon;

import javax.swing.*;
import java.awt.*;

public class Player extends Entities
{
    private int HPBuff;
    private int MPBuff;
    private int magDefBuff;
    private int phyDefBuff;
    private int magAttBuff;
    private int phyAttBuff;
    private int gold;
    private int exp;
    private int baseExp;
    private int playerClass;
    private int level;
    private int crit;
    private int pointSkill;
    private Weapon myWeapon;
    private Armor myArmor;
    private Skill [] mySkill;
    public Inventory myInventory;

    public Player(String name, int HP, int MP, int magDef, int phyDef, int movSpeed, int crit, int magAtt, int phyAtt, int id, int maxSkillEquip)
    {
        super(name, HP, MP, magDef, phyDef, movSpeed, magAtt, phyAtt);
        this.HPBuff = 0;
        this.MPBuff = 0;
        this.magDefBuff = 0;
        this.phyDefBuff = 0;
        this.magAttBuff = 0;
        this.phyAttBuff = 0;
        this.crit = crit;
        this.gold = 50000;
        this.exp = 0;
        this.pointSkill = 3;
        this.baseExp = 150;
        this.level = 1;
        this.playerClass = id;
        this.mySkill = new Skill[maxSkillEquip];
        this.myInventory = new Inventory(20);
    }

    public int getPlayerClass()
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
    public void minPointSkill()
    {
        this.pointSkill -= 1;
        if (this.pointSkill < 0)
            this.pointSkill = 0;
    }
    public void equipWeapon(Weapon weapon)
    {
        if(this.myWeapon == null)
        {
            addWeaponBuff(weapon);
        }
        else
        {
            this.magAttBuff -= myWeapon.getMagAttack();
            this.phyAttBuff -= myWeapon.getPhyAttack();
            this.phyDefBuff -= myWeapon.getPhyDef();
            addWeaponBuff(weapon);
        }
        addBuff();
    }

    private void addWeaponBuff(Weapon weapon)
    {
        this.myWeapon = new Weapon(weapon.getName(), weapon.getRarity(), weapon.getDisplayName(), weapon.getDescription(), weapon.getBuyPrice(), weapon.getMagAttack(), weapon.getPhyAttack(), weapon.getPhyDef(), weapon.getWeaponClass(), weapon.getType());
        this.magAttBuff += myWeapon.getMagAttack();
        this.phyAttBuff += myWeapon.getPhyAttack();
        this.phyDefBuff += myWeapon.getPhyDef();
    }

    public void equipArmor(Armor armor)
    {
        if(this.myArmor == null)
        {
            this.myArmor = new Armor(armor.getName(), armor.getRarity(), armor.getDisplayName(), armor.getBuyPrice(), armor.getMagDef(), armor.getPhyDef(), armor.getType());
            this.magDefBuff += myArmor.getMagDef();
            this.phyDefBuff += myArmor.getPhyDef();
        }
        else
        {
            this.magDefBuff -= myArmor.getMagDef();
            this.phyDefBuff -= myArmor.getPhyDef();
            this.myArmor = new Armor(armor.getName(), armor.getRarity(), armor.getDisplayName(), armor.getBuyPrice(), armor.getMagDef(), armor.getPhyDef(), armor.getType());
            this.magDefBuff += myArmor.getMagDef();
            this.phyDefBuff += myArmor.getPhyDef();
        }
        addBuff();
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
        for (int i = 0; i < mySkill.length; i++)
        {
            if(mySkill[i].getDisplayName().equals(name))
                return mySkill[i];
        }
        return null;
    }
    public void showMySkill()
    {
        String skillList = "";
        for (int i = 0; i < mySkill.length; i++)
        {
            if (mySkill[i] != null)
                skillList += i + 1 + ". " + mySkill[i].getDisplayName() /*+ mySkill[i].getDescription()*/ + "\n";
            else
                skillList += i + 1 + ". None" + "\n";
        }
        JOptionPane.showMessageDialog(null, skillList, "My Skill List", JOptionPane.PLAIN_MESSAGE);
    }

    public void addSkillYesOrNo(Skill skill)
    {
        String skillList = "";
        for (int i = 0; i < mySkill.length; i++)
        {
            if (mySkill[i] != null)
                skillList += i + 1 + ". " + mySkill[i].getDisplayName() /*+ mySkill[i].getDescription()*/ + "\n";
            else
                skillList += i + 1 + ". None" + "\n";
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
    public void addGold(int gold)
    {
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

    public void addBuff()
    {
        this.magDef = this.baseMagDef + magDefBuff;
        this.phyDef = this.basePhyDef + phyDefBuff;
        this.magAtt = this.baseMagAtt + magAttBuff;
        this.phyAtt = this.basePhyAtt + phyAttBuff;
    }
}
