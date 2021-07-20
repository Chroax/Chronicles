package avanlon.framework.resources;

import avanlon.game.entity.Player.HierarchyTree;

public class Skills
{
    public static HierarchyTree treePaladin;
    public static HierarchyTree treeWizard;
    public static HierarchyTree treeArcher;

    private static final String[] paladinSkills =
            {
                    "1 SKILL_PALADIN_1 | Paralysis Shot ? Hai >",
                    "2 SKILL_PALADIN_2 | Blood Drop ? Hai > 1",
                    "3 SKILL_PALADIN_3 | Poison Shot ? Hai > 1",
                    "4 SKILL_PALADIN_4 | Bulls Eye ? Hai > 2",
                    "5 SKILL_PALADIN_5 | Def Shot ? Hai > 2",
                    "6 SKILL_PALADIN_6 | Long Shot ? Hai > 2",
                    "7 SKILL_PALADIN_7 | Defend ? Hai > 4",
                    "8 SKILL_PALADIN_8 | Multi Shot 1 ? Hai > 4",
                    "9 SKILL_PALADIN_9 | Shot Buff ? Hai > 4",
                    "10 SKILL_PALADIN_10 | Fatal Shot ? Hai > 5",
                    "11 SKILL_PALADIN_11 | Claw Shot ? Hai > 6",
                    "12 SKILL_PALADIN_12 | Focus Shot ? Hai > 6",
                    "13 SKILL_PALADIN_13 | Devil Shot ? Hai > 3",
                    "14 SKILL_PALADIN_14 | Weapon Up ? Hai > 3",
                    "15 SKILL_PALADIN_15 | Piercing Shot ? Hai > 3",
                    "16 SKILL_PALADIN_16 | Target Shot ? Hai > 13",
                    "17 SKILL_PALADIN_17 | Dodge Shot ? Hai > 13",
                    "18 SKILL_PALADIN_18 | Meteor Shot ? Hai > 13",
                    "19 SKILL_PALADIN_19 | Crit Up ? Hai >",
                    "20 SKILL_PALADIN_20 | Multi Shot 2 ? Hai >",
                    "21 SKILL_PALADIN_21 | Heart Shot ? Hai > 14",
                    "22 SKILL_PALADIN_22 | Fire Long Shot ? Hai > 14",
                    "23 SKILL_PALADIN_23 | Sleep Shot ? Hai > 14",
                    "24 SKILL_PALADIN_24 | Snipe ? Hai > 9",
                    "25 SKILL_PALADIN_25 | Heart Up ? Hai > 9"
            };

    private static final String[] wizardSkills =
            {
                    "1 SKILL_WIZARD_1 | Paralysis Shot ? Hai >",
                    "2 SKILL_WIZARD_2 | Blood Drop ? Hai > 1",
                    "3 SKILL_WIZARD_3 | Poison Shot ? Hai > 1",
                    "4 SKILL_WIZARD_4 | Bulls Eye ? Hai > 2",
                    "5 SKILL_WIZARD_5 | Def Shot ? Hai > 2",
                    "6 SKILL_WIZARD_6 | Long Shot ? Hai > 2",
                    "7 SKILL_WIZARD_7 | Defend ? Hai > 4",
                    "8 SKILL_WIZARD_8 | Multi Shot 1 ? Hai > 4",
                    "9 SKILL_WIZARD_9 | Shot Buff ? Hai > 4",
                    "10 SKILL_WIZARD_10 | Fatal Shot ? Hai > 5",
                    "11 SKILL_WIZARD_11 | Claw Shot ? Hai > 6",
                    "12 SKILL_WIZARD_12 | Focus Shot ? Hai > 6",
                    "13 SKILL_WIZARD_13 | Devil Shot ? Hai > 3",
                    "14 SKILL_WIZARD_14 | Weapon Up ? Hai > 3",
                    "15 SKILL_WIZARD_15 | Piercing Shot ? Hai > 3",
                    "16 SKILL_WIZARD_16 | Target Shot ? Hai > 13",
                    "17 SKILL_WIZARD_17 | Dodge Shot ? Hai > 13",
                    "18 SKILL_WIZARD_18 | Meteor Shot ? Hai > 13",
                    "19 SKILL_WIZARD_19 | Crit Up ? Hai >",
                    "20 SKILL_WIZARD_20 | Multi Shot 2 ? Hai >",
                    "21 SKILL_WIZARD_21 | Heart Shot ? Hai > 14",
                    "22 SKILL_WIZARD_22 | Fire Long Shot ? Hai > 14",
                    "23 SKILL_WIZARD_23 | Sleep Shot ? Hai > 14",
                    "24 SKILL_WIZARD_24 | Snipe ? Hai > 9",
                    "25 SKILL_WIZARD_25 | Heart Up ? Hai > 9"
            };

    private static final String[] archerSkills =
            {
                    "1 SKILL_ARCHER_1 | Paralysis Shot ? Hai >",
                    "2 SKILL_ARCHER_2 | Blood Drop ? Hai > 1",
                    "3 SKILL_ARCHER_3 | Poison Shot ? Hai > 1",
                    "4 SKILL_ARCHER_4 | Bulls Eye ? Hai > 2",
                    "5 SKILL_ARCHER_5 | Def Shot ? Hai > 2",
                    "6 SKILL_ARCHER_6 | Long Shot ? Hai > 2",
                    "7 SKILL_ARCHER_7 | Defend ? Hai > 4",
                    "8 SKILL_ARCHER_8 | Multi Shot 1 ? Hai > 4",
                    "9 SKILL_ARCHER_9 | Shot Buff ? Hai > 4",
                    "10 SKILL_ARCHER_10 | Fatal Shot ? Hai > 5",
                    "11 SKILL_ARCHER_11 | Claw Shot ? Hai > 6",
                    "12 SKILL_ARCHER_12 | Focus Shot ? Hai > 6",
                    "13 SKILL_ARCHER_13 | Devil Shot ? Hai > 3",
                    "14 SKILL_ARCHER_14 | Weapon Up ? Hai > 3",
                    "15 SKILL_ARCHER_15 | Piercing Shot ? Hai > 3",
                    "16 SKILL_ARCHER_16 | Target Shot ? Hai > 13",
                    "17 SKILL_ARCHER_17 | Dodge Shot ? Hai > 13",
                    "18 SKILL_ARCHER_18 | Meteor Shot ? Hai > 13",
                    "19 SKILL_ARCHER_19 | Crit Up ? Hai >",
                    "20 SKILL_ARCHER_20 | Multi Shot 2 ? Hai >",
                    "21 SKILL_ARCHER_21 | Heart Shot ? Hai > 14",
                    "22 SKILL_ARCHER_22 | Fire Long Shot ? Hai > 14",
                    "23 SKILL_ARCHER_23 | Sleep Shot ? Hai > 14",
                    "24 SKILL_ARCHER_24 | Snipe ? Hai > 9",
                    "25 SKILL_ARCHER_25 | Heart Up ? Hai > 9"
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
