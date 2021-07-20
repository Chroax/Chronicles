package avanlon.game.entity.Player;

import java.util.List;

public class Skill
{
    protected String name;
    protected String displayName;
    protected String description;
    protected boolean unLocked;
    protected boolean used;
    protected int rootId;
    protected int skillId;
    protected int skillSlotId;
    protected List<Skill> subordinates;

    Skill(String name, String displayName, String description, String rootId, String skillId)
    {
        this.skillId = Integer.parseInt(skillId);
        this.rootId = Integer.parseInt(rootId);
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.unLocked = false;
        this.used = false;
        this.skillSlotId = -1;
    }

    public String getName()
    {
        return this.name;
    }
    public String getDisplayName()
    {
        return this.displayName;
    }
    public String getDescription()
    {
        return this.description;
    }
    public boolean isUnLocked()
    {
        return unLocked;
    }
    public boolean isUsed()
    {
        return used;
    }
    public String getSkillId()
    {
        return String.valueOf(this.skillId);
    }
    public String getRootId() {
        return String.valueOf(this.rootId);
    }
    public int getSkillSlotId()
    {
        return this.skillSlotId;
    }

    public void unlockSkill(boolean unLocked)
    {
        this.unLocked = unLocked;
    }
}
