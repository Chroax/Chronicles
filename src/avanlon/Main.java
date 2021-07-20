package avanlon;

import avanlon.framework.Engine;
import avanlon.framework.resources.Items;
import avanlon.framework.resources.Skills;
import avanlon.framework.resources.Textures;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        int a = 6 / 4;
        System.out.println(a);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run()
            {
                Textures.init();
                new Skills();
                new Items();
                Engine.init();
                Engine.start();
            }
        });
    }
}
