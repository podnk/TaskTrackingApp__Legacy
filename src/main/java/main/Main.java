package main;

import db.DbConnection;
import org.apache.log4j.Logger;
import ui.MainFrame;

import javax.swing.*;

public class Main
{
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            log.info("Look&Feel is initialized successfully");
        }
        catch (Exception e)
        {
            System.out.println("Look and Feel is not set");
            log.error("Look and Feel is not set");
        }

        MainFrame mainFrame = new MainFrame("Main Frame");
        log.info("Main frame has been created successfully");

        DbConnection.Connect();
    }
}