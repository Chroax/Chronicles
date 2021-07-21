package avanlon;

import avanlon.framework.Engine;
import avanlon.framework.resources.Items;
import avanlon.framework.resources.Monsters;
import avanlon.framework.resources.Skills;
import avanlon.framework.resources.Textures;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run()
            {
                Textures.init();
                new Skills();
                new Items();
                new Monsters();
                Engine.init();
                Engine.start();
            }
        });
    }
}
