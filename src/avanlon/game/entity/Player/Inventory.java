package avanlon.game.entity.Player;

import avanlon.framework.resources.Items;
import avanlon.game.items.Armor;
import avanlon.game.items.Item;
import avanlon.game.items.Weapon;

import javax.swing.*;
import java.util.*;

public class Inventory
{
    private int maxCapacity;
    private int capacity;
    private final Hashtable <Weapon, Integer> invWeaponList = new Hashtable<>();
    private final Hashtable <Armor, Integer> invArmorList = new Hashtable<>();
    private final Hashtable <Item, Integer> invPotionList = new Hashtable<>();

    public Inventory(int capacity)
    {
        this.maxCapacity = capacity;
        this.capacity = 0;
        addItems("Weapon", Items.MAJESTY, 3);
        addItems("Armor", Items.BRIGANDINE_ARMOR, 3);
        addItems("Potion", Items.HEALING_POTION, 3);
    }

    public int addItems(String type, Object item, int total)
    {
        if (this.capacity + total > this.maxCapacity)
        {
            JOptionPane.showMessageDialog(null,"Not Enough Capacity", "Inventory Message", JOptionPane.PLAIN_MESSAGE);
            return -1;
        }
        else
        {
            this.capacity += total;
            switch (type)
            {
                case "Weapon" -> {
                    Weapon weapon = (Weapon) item;
                    JOptionPane.showMessageDialog(null,weapon.getDisplayName() + " [x" + total +  "] added to Inventory", "Inventory Message", JOptionPane.PLAIN_MESSAGE);
                    addWeapon(weapon, total);
                }
                case "Armor" -> {
                    Armor armor = (Armor) item;
                    JOptionPane.showMessageDialog(null,armor.getDisplayName() + " [x" + total + "] added to Inventory", "Inventory Message", JOptionPane.PLAIN_MESSAGE);
                    addArmor(armor, total);
                }
                case "Potion" -> {
                    Item potion = (Item) item;
                    JOptionPane.showMessageDialog(null,potion.getDisplayName() + " [x" + total + "] added to Inventory", "Inventory Message", JOptionPane.PLAIN_MESSAGE);
                    addPotion(potion, total);
                }
            }
            return 0;
        }
    }

    private void addWeapon(Weapon weapon, int total)
    {
        if(this.invWeaponList.get(weapon) == null)
            this.invWeaponList.put(weapon, total);
        else
        {
            total += this.invWeaponList.get(weapon);
            this.invWeaponList.put(weapon, total);

        }
    }

    private void addArmor(Armor armor, int total)
    {
        if(this.invArmorList.get(armor) == null)
            this.invArmorList.put(armor, total);
        else
        {
            total += this.invArmorList.get(armor);
            this.invArmorList.put(armor, total);
        }
    }

    private void addPotion(Item potion, int total)
    {
        if(this.invPotionList.get(potion) == null)
            this.invPotionList.put(potion, total);
        else
        {
            total += this.invPotionList.get(potion);
            this.invPotionList.put(potion, total);
            System.out.println("Total " + potion.getDisplayName() + " in Inventory : " + invPotionList.get(potion));
        }
    }

    public void useItem(String type, Object item, int total)
    {
        switch (type)
        {
            case "Weapon" -> {
                Weapon weapon = (Weapon) item;
                if (this.invWeaponList.get(weapon) == null)
                    JOptionPane.showMessageDialog(null,"You Dont Have " + weapon.getDisplayName(), "Inventory Message", JOptionPane.WARNING_MESSAGE);
                else if (total > this.invWeaponList.get(weapon))
                    JOptionPane.showMessageDialog(null,"You only have " + this.invWeaponList.get(weapon), "Inventory Message", JOptionPane.WARNING_MESSAGE);
                else
                {
                    this.capacity -= total;
                    int used = this.invWeaponList.get(weapon) - total;
                    if (used == 0)
                        this.invWeaponList.remove(weapon);
                    JOptionPane.showMessageDialog(null,"You used " + weapon.getDisplayName() + " [x" + total + "]", "Inventory Message", JOptionPane.WARNING_MESSAGE);
                }
            }
            case "Armor" -> {
                Armor armor = (Armor) item;
                if (this.invArmorList.get(armor) == null)
                    JOptionPane.showMessageDialog(null,"You Dont Have " + armor.getDisplayName(), "Inventory Message", JOptionPane.WARNING_MESSAGE);
                else if (total > this.invArmorList.get(armor))
                    JOptionPane.showMessageDialog(null,"You only have " + this.invArmorList.get(armor), "Inventory Message", JOptionPane.WARNING_MESSAGE);
                else
                {
                    this.capacity -= total;
                    int used = this.invArmorList.get(armor) - total;
                    if (used == 0)
                        this.invArmorList.remove(armor);
                    JOptionPane.showMessageDialog(null,"You used " + armor.getDisplayName() + " [x" + total + "]", "Inventory Message", JOptionPane.WARNING_MESSAGE);
                }
            }
            case "Potion" -> {
                Item potion = (Item) item;
                if (this.invPotionList.get(potion) == null)
                    JOptionPane.showMessageDialog(null,"You Dont Have " + potion.getDisplayName(), "Inventory Message", JOptionPane.WARNING_MESSAGE);
                else if (total > this.invPotionList.get(potion))
                    JOptionPane.showMessageDialog(null,"You only have " + this.invPotionList.get(potion), "Inventory Message", JOptionPane.WARNING_MESSAGE);
                else
                {
                    this.capacity -= total;
                    int used = this.invPotionList.get(potion) - total;
                    if (used == 0)
                        this.invPotionList.remove(potion);
                    JOptionPane.showMessageDialog(null,"You used " + potion.getDisplayName() + " [x" + total + "]", "Inventory Message", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        if(this.capacity < 0)
            capacity = 0;
    }

    public int getMaxCapacity()
    {
        return this.maxCapacity;
    }

    public int getCapacity()
    {
        return this.capacity;
    }

    public void addCapacity(int add)
    {
        this.maxCapacity += add;
    }

    public Hashtable <Weapon, Integer> getInvWeaponList()
    {
        return invWeaponList;
    }
    public Hashtable <Armor, Integer> getInvArmorList()
    {
        return invArmorList;
    }
    public Hashtable <Item, Integer> getInvPotionList()
    {
        return invPotionList;
    }
}
