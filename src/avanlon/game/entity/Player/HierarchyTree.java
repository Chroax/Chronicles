package avanlon.game.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HierarchyTree
{
    private HashMap <Integer, Skill> skills = new HashMap<>();
    public Skill root;

    public void readDataAndCreateMap(String[] lines)
    {
        Skill skill = null;
        for (String strLine : lines)
        {
            String[] values = strLine.split(" ");
            int status = 0;
            String skillId = "", rootId = "", name = "", displayName = "", description = "";
            for (int i = 0; i < values.length; i++)
            {
                if(values[i].equals("|"))
                {
                    status = 1;
                    continue;
                }
                else if (values[i].equals("?"))
                {
                    status = 2;
                    continue;
                }
                else if (values[i].equals(">"))
                {
                    status = 3;
                    continue;
                }

                if(i == 0)
                    skillId += values[i];
                else if(status == 0)
                    name += values[i] + " ";
                else if(status == 1)
                    displayName += values[i] + " ";
                else if(status == 2)
                    description += values[i] + " ";
                else if(status == 3 && i == values.length-1)
                    rootId += values[i];
            }
            if (!rootId.isBlank())
                skill = new Skill(name, displayName, description, rootId, skillId);
            else
                skill = new Skill(name, displayName, description, "0", skillId);

            skills.put(skill.skillId, skill);

            if (skill.rootId == 0)
                root = skill;
        }
    }

    public void buildHierarchyTree(Skill root)
    {
        java.util.List<Skill> subs = getSubsById(root.skillId);

        root.subordinates = subs;

        if (subs.size() == 0)
            return;
        for (Skill em : subs)
            buildHierarchyTree(em);
    }

    private java.util.List<Skill> getSubsById(int rootId)
    {
        java.util.List<Skill> subs = new ArrayList<>();

        for (Skill em : skills.values())
        {
            if (em.rootId == rootId)
                subs.add(em);
        }

        return subs;
    }

    public void printHierarchyTree(Skill root, int level)
    {
        for (int i = 0; i < level; i++)
            System.out.print("\t");

        System.out.println(root.displayName);

        List <Skill> subs = root.subordinates;

        for (Skill em : subs)
            printHierarchyTree(em, level+1);
    }

    public Skill findSkill(int id)
    {
        return skills.get(id);
    }

    public Skill findSkill(int id, int rootId)
    {
        return skills.get(id);
    }
}
