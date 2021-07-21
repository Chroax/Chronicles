package avanlon.framework.resources;

import avanlon.game.entity.Player.HierarchyTree;

public class Skills
{
    public static HierarchyTree treePaladin;
    public static HierarchyTree treeWizard;
    public static HierarchyTree treeArcher;

    private static final String[] paladinSkills =
            {
                    "1 SKILL_PALADIN_1 | Sword Mastery ? Player gets bonus +5% Physical Attack >",
                    "2 SKILL_PALADIN_2 | Hard Hit ? Player gives damage equals to 120% of Physical Attack > 1",
                    "3 SKILL_PALADIN_3 | Astute ? Enemy Physical Defense decreased by 10% > 1",
                    "4 SKILL_PALADIN_4 | Trigger Slash ? Enemy Physical Attack decreased by 12% > 2",
                    "5 SKILL_PALADIN_5 | Rampage ? Player gets bonus +10% Physical Attack > 2",
                    "6 SKILL_PALADIN_6 | Blood Slash ? Player gives damage equals to 130% of Physical Attack > 2",
                    "7 SKILL_PALADIN_7 | Fire Pierce ? Enemy MP decreased by 8% > 4",
                    "8 SKILL_PALADIN_8 | Sonic Blade ? Player gives damage equals to 80% of Magic Attack > 4",
                    "9 SKILL_PALADIN_9 | Spiral Air ? Enemy Movement Speed decreased by 10% > 4",
                    "10 SKILL_PALADIN_10 | War Cry ? Player gets bonus +15% HP > 5",
                    "11 SKILL_PALADIN_11 | Rage Sword ? Player gets bonus +20% Physical Attack > 6",
                    "12 SKILL_PALADIN_12 | Sword Tempest ? Player gives damage equals to 150% of Physical Attack > 6",
                    "13 SKILL_PALADIN_13 | Berserk ? Player gets bonus +10% Movement Speed > 3",
                    "14 SKILL_PALADIN_14 | Bulk Up ? Player gets bonus +12% Physical Attack > 3",
                    "15 SKILL_PALADIN_15 | Parry ? Player gets bonus +10% Physical Defense > 3",
                    "16 SKILL_PALADIN_16 | Knight's Will ? Player gets bonus +20% MP > 13",
                    "17 SKILL_PALADIN_17 | Defense Up ? Player gets bonus +15% Magic Defense > 13",
                    "18 SKILL_PALADIN_18 | Fareth ? Player gets bonus +15% Physical Defense > 13",
                    "19 SKILL_PALADIN_19 | Sword Mastery 2 ? Player gets bonus +6% Critical Rate Up >",
                    "20 SKILL_PALADIN_20 | Skull Sacrifice ? Player gets bonus +30% HP >",
                    "21 SKILL_PALADIN_21 | Frost Slash ? Enemy Movement Speed decreased by 20% > 14",
                    "22 SKILL_PALADIN_22 | Final Light ? Player gives damage equals to 200% of Magic Attack > 14",
                    "23 SKILL_PALADIN_23 | Bleeding Sword ? Enemy Physical Defense decreased by 20% > 14",
                    "24 SKILL_PALADIN_24 | Bless ? Player gets bonus +20% HP > 9",
                    "25 SKILL_PALADIN_25 | Water Protection ? Player gets bonus +25% Magic Defense > 9"
            };

    private static final String[] wizardSkills =
            {
                    "1 SKILL_PALADIN_1 | Magic Mastery ? Player gets bonus +5% Magic Attack >",
                    "2 SKILL_PALADIN_2 | Magic Hammer ? Player gives damage equals to 120% of Magic Attack > 1",
                    "3 SKILL_PALADIN_3 | Magic Shine ? Enemy Movement Speed decreased by 5% > 1",
                    "4 SKILL_PALADIN_4 | Magic Scale ? Player gets bonus +10% Physical Defense > 2",
                    "5 SKILL_PALADIN_5 | Fire Blast ? Player gives damage equals to 140% of Mag Attack > 2",
                    "6 SKILL_PALADIN_6 | Fire Orb ? Player gets bonus +10% Critical Rate Up > 2",
                    "7 SKILL_PALADIN_7 | Fire Statue ? Player gets bonus +10% Mag Defense > 4",
                    "8 SKILL_PALADIN_8 | Magic Storm ? Player gives damage equals to 150% of Mag Attack > 4",
                    "9 SKILL_PALADIN_9 | Magic Shot ? Enemy MP decreased by 15% > 4",
                    "10 SKILL_PALADIN_10 | Hydro Gun ? Player gives damage equals to 160% of Mag Attack > 5",
                    "11 SKILL_PALADIN_11 | Tsunami ? Player gets bonus +15% MP > 6",
                    "12 SKILL_PALADIN_12 | Water Glaive ? Player gets bonus +15% Mag Attack > 6",
                    "13 SKILL_PALADIN_13 | Magic Boots ? Player gets bonus +10% Movement Speed > 3",
                    "14 SKILL_PALADIN_14 | Magic Sound ? Enemy HP decreased by 10% > 3",
                    "15 SKILL_PALADIN_15 | Magic Beam ? Player gives damage equals to 130% of Mag Attack > 3",
                    "16 SKILL_PALADIN_16 | Defense Up ? Player gets bonus +15% Physical Defense > 13",
                    "17 SKILL_PALADIN_17 | Magic Ghost ? Player gets bonus +15% Mag Defense > 13",
                    "18 SKILL_PALADIN_18 | Magic Harmony ? Player gets bonus +20% MP > 13",
                    "19 SKILL_PALADIN_19 | Magic Mastery 2 ? Player gets bonus +10% Mag Attack >",
                    "20 SKILL_PALADIN_20 | Magic Bless ? Player gets bonus +10% HP >",
                    "21 SKILL_PALADIN_21 | Crystal Gem ? Enemy Movement Speed decreased by 20% > 14",
                    "22 SKILL_PALADIN_22 | Frost Edge ? Enemy Mag Defense decreased by 20% > 14",
                    "23 SKILL_PALADIN_23 | Magic Finale ? Player gives damage equals to 180% of Mag Attack> 14",
                    "24 SKILL_PALADIN_24 | Magic Burst ? Player gives damage equals to 170% of Mag Attack > 9",
                    "25 SKILL_PALADIN_25 | Soul Of Destiny ? Enemy Hp decreased by 30% > 9"
            };

    private static final String[] archerSkills =
            {
                    "1 SKILL_ARCHER_1 | Paralysis Shot ? Enemy Movement Speed decreased by 5% >",
                    "2 SKILL_ARCHER_2 | Blood Drop ? Enemy HP decreased by 8% > 1",
                    "3 SKILL_ARCHER_3 | Poison Shot ? Enemy Physical Defense decreased by 7% > 1",
                    "4 SKILL_ARCHER_4 | Bulls Eye ? Player gives damage equals to 110% of Physical Attack > 2",
                    "5 SKILL_ARCHER_5 | Def Shot ? Player gets bonus +10% Physical Defense > 2",
                    "6 SKILL_ARCHER_6 | Long Shot ? Player gives damage equals to 120% of Physical Attack > 2",
                    "7 SKILL_ARCHER_7 | Defend Up ? Player gets bonus +15% Physical Defense > 4",
                    "8 SKILL_ARCHER_8 | Multi Shot 1 ? Player gives damage equals to 140% of Physical Attack > 4",
                    "9 SKILL_ARCHER_9 | Shot Buff ? Player gets bonus +14% Critical Rate Up > 4",
                    "10 SKILL_ARCHER_10 | Fatal Shot ? Enemy Physical Defense decreased by 15% > 5",
                    "11 SKILL_ARCHER_11 | Claw Shot ? Enemy HP decreased by 10% > 6",
                    "12 SKILL_ARCHER_12 | Focus Shot ? Player gets bonus +15% Critcal Rate Up > 6",
                    "13 SKILL_ARCHER_13 | Devil Shot ? Player gives damage equals to 130% of Physical Attack > 3",
                    "14 SKILL_ARCHER_14 | Weapon Up ? Player gets bonus +10% Physical Attack > 3",
                    "15 SKILL_ARCHER_15 | Piercing Shot ? Player gives damage equals to 150% of Phy Attack > 3",
                    "16 SKILL_ARCHER_16 | Target Shot ? Enemy HP decreased by 15% > 13",
                    "17 SKILL_ARCHER_17 | Dodge Shot ? Player gets bonus +15% Movement Speed > 13",
                    "18 SKILL_ARCHER_18 | Meteor Shot ? Player gives damage equals to 170% of Phy Attack > 13",
                    "19 SKILL_ARCHER_19 | Crit Up ? Player gets bonus +10% Critical Rate Up >",
                    "20 SKILL_ARCHER_20 | Multi Shot 2 ? Player gets bonus +10% Phy Attack >",
                    "21 SKILL_ARCHER_21 | Heart Shot ? Enemy MP decreased by 20% > 14",
                    "22 SKILL_ARCHER_22 | Fire Long Shot ? Player gives damage equals to 190% of Phy Attack > 14",
                    "23 SKILL_ARCHER_23 | Sleep Shot ? Enemy Phy Defense decreased by 15% > 14",
                    "24 SKILL_ARCHER_24 | Snipe ? Player gives damage equals to 180% of Phy Attack > 9",
                    "25 SKILL_ARCHER_25 | Heart Up ? Player gets bonus +20% HP > 9"
            };

    public Skills()
    {
        treePaladin = new HierarchyTree();
        treeWizard = new HierarchyTree();
        treeArcher = new HierarchyTree();

        treePaladin.readDataAndCreateMap(paladinSkills);
        treePaladin.buildHierarchyTree(treePaladin.root);

        treeWizard.readDataAndCreateMap(wizardSkills);
        treeWizard.buildHierarchyTree(treeWizard.root);

        treeArcher.readDataAndCreateMap(archerSkills);
        treeArcher.buildHierarchyTree(treeArcher.root);
    }

}
