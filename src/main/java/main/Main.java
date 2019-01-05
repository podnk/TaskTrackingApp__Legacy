package main;

import ui.MainFrame;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e)
        {
            System.out.println("Look and Feel not set");
        }

        MainFrame mainFrame = new MainFrame("Main Frame");
    }
}