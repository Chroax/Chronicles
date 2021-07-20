package avanlon.framework;

import avanlon.framework.gamestates.GameStateManager;
import avanlon.framework.gui.WindowManager;
import avanlon.game.states.TitleScreen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class Engine
{
    private static GameStateManager gameStateManager;

    private static WindowManager windowManager;
    private static Timer timer;

    public static void init()
    {
        gameStateManager = new GameStateManager();
        windowManager = new WindowManager();
        timer = new Timer(1, new MainGameLoop());
    }

    public static void start()
    {
        gameStateManager.stackState(new TitleScreen(gameStateManager));
        windowManager.addPanel(new GameScreen());
        windowManager.addKeyListener(new Keyboard());
        windowManager.addMouseListener(new Mouse());
        windowManager.createWindow();
        timer.start();
    }

    private static class MainGameLoop implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            gameStateManager.loop();
        }

    }

    private static class GameScreen extends JPanel
    {

        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            gameStateManager.paint(g);
            repaint();
        }
    }

    private static class Keyboard implements KeyListener
    {

        @Override
        public void keyPressed(KeyEvent key) {
            gameStateManager.keyPressed(key.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent key) {
            gameStateManager.keyReleased(key.getKeyCode());
        }

        @Override
        public void keyTyped(KeyEvent arg0) {}

    }

    private static class Mouse implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
