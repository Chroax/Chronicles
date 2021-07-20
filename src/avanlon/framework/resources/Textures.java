package avanlon.framework.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Textures
{
    private static HashMap<String, BufferedImage> spritesScreen;
    private static HashMap<String, BufferedImage> spritesEntities;
    private static HashMap<String, BufferedImage> spritesWeapon;
    private static HashMap<String, BufferedImage> spritesArmor;
    private static HashMap<String, BufferedImage> spritesPotion;
    private static HashMap<String, BufferedImage> spritesIcon;
    private static HashMap<String, BufferedImage> spritesSkill;


    public static void init()
    {
        spritesScreen = new HashMap<>();
        spritesEntities = new HashMap<>();
        spritesWeapon = new HashMap<>();
        spritesArmor = new HashMap<>();
        spritesPotion = new HashMap<>();
        spritesIcon = new HashMap<>();
        spritesSkill = new HashMap<>();

        File folderScreen = new File("res/textures/Screen");
        File folderEntities = new File("res/textures/Entities");
        File folderWeapon = new File("res/textures/Weapon");
        File folderArmor = new File("res/textures/Armor");
        File folderPotion = new File("res/textures/Potion");
        File folderIcon = new File("res/textures/Icon");
        File folderSkill = new File("res/textures/Skill");

        putFile(folderScreen, "Screen");
        putFile(folderEntities, "Entities");
        putFile(folderWeapon, "Weapon");
        putFile(folderArmor, "Armor");
        putFile(folderPotion, "Potion");
        putFile(folderIcon, "Icon");
        putFile(folderSkill, "Skill");

        System.out.println("[Utils][Textures]: Finished reading sprite files");
    }

    private static void putFile(File folder, String type)
    {
        if(type.equals("Screen"))
        {
            for(File file : folder.listFiles())
            {
                try
                {
                    spritesScreen.put(file.getName().replaceAll(".png", ""), ImageIO.read(file));
                }
                catch (IOException e)
                {
                    System.err.println("[Utils][Textures]: Exception reading "+file.getName());
                }
            }
        }

        else if (type.equals("Entities"))
        {
            for(File file : folder.listFiles())
            {
                try
                {
                    spritesEntities.put(file.getName().replaceAll(".png", ""), ImageIO.read(file));
                }
                catch (IOException e)
                {
                    System.err.println("[Utils][Textures]: Exception reading "+file.getName());
                }
            }
        }

        else if (type.equals("Weapon"))
        {
            for(File file : folder.listFiles())
            {
                try
                {
                    spritesWeapon.put(file.getName().replaceAll(".png", ""), ImageIO.read(file));
                }
                catch (IOException e)
                {
                    System.err.println("[Utils][Textures]: Exception reading "+file.getName());
                }
            }
        }

        else if (type.equals("Armor"))
        {
            for(File file : folder.listFiles())
            {
                try
                {
                    spritesArmor.put(file.getName().replaceAll(".png", ""), ImageIO.read(file));
                }
                catch (IOException e)
                {
                    System.err.println("[Utils][Textures]: Exception reading "+file.getName());
                }
            }
        }

        else if (type.equals("Potion"))
        {
            for(File file : folder.listFiles())
            {
                try
                {
                    spritesPotion.put(file.getName().replaceAll(".png", ""), ImageIO.read(file));
                }
                catch (IOException e)
                {
                    System.err.println("[Utils][Textures]: Exception reading "+file.getName());
                }
            }
        }

        else if (type.equals("Icon"))
        {
            for(File file : folder.listFiles())
            {
                try
                {
                    spritesIcon.put(file.getName().replaceAll(".png", ""), ImageIO.read(file));
                }
                catch (IOException e)
                {
                    System.err.println("[Utils][Textures]: Exception reading "+file.getName());
                }
            }
        }

        else if (type.equals("Skill"))
        {
            for(File file : folder.listFiles())
            {
                try
                {
                    spritesSkill.put(file.getName().replaceAll(".png", ""), ImageIO.read(file));
                }
                catch (IOException e)
                {
                    System.err.println("[Utils][Textures]: Exception reading "+file.getName());
                }
            }
        }
    }

    public static BufferedImage getSprite(String name, String type)
    {
        BufferedImage sprite = switch (type)
                {
                    case "Screen" -> spritesScreen.get(name);
                    case "Entities" -> spritesEntities.get(name);
                    case "Weapon" -> spritesWeapon.get(name);
                    case "Armor" -> spritesArmor.get(name);
                    case "Potion" -> spritesPotion.get(name);
                    case "Icon" -> spritesIcon.get(name);
                    case "Skill" -> spritesSkill.get(name);
                    default -> null;
                };

        if(sprite != null)
            return sprite;
        else
            return spritesSkill.get("error");
    }
}
