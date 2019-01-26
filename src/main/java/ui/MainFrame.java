package ui;

import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MainFrame extends JFrame
{
    private static final Logger log = Logger.getLogger(MainFrame.class);

    private Border loweredetched;

    private String[] taskTypes = {"Task", "Requirement", "Bug"};

    private JComboBox tastTypesList;

    private JLabel recNumLabl = null;
    private JLabel recTypeLabl = null;
    private JLabel commentLabl = null;

    private JTextField recNumField = null;
    private JTextField commentField = null;

    private JButton nextButton = null;
//    private JButton prevButton = null;
    private JButton cancelButton = null;
    private JButton saveButton = null;

    private JPanel mainPanel = null;
    private JPanel buttonsPanel = null;
    private JPanel fieldsPanel = null;
    private JPanel listPanel = null;

    public MainFrame(String title)
    {
        super(title);

        try
        {
            initComponents();
            log.info("Components are initialized successfully");
        }
        catch (Exception componentsEx)
        {
            System.out.println("Components initialization error");
            log.error("Components initialization error");
        }

        try
        {
            initFrame();
        }
        catch (Exception frameEx)
        {
            System.out.println("Frame initialization error");
            log.error("Frame initialization error");
        }

    }

    private void initFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 480);
        setMinimumSize(new Dimension(600,480));
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void initComponents()
    {
        // Размер кнопок по умолчанию
        Font consolasFont = new Font("Consolas", Font.PLAIN,14);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        // Creating components
        {
            tastTypesList = new JComboBox(taskTypes);

            recNumLabl = new JLabel("Номер:");
            recTypeLabl = new JLabel("Тип:");
            commentLabl = new JLabel("Комментарий:");

            recNumField = new JTextField();
            commentField = new JTextField();

            nextButton = new JButton("Next");
//            prevButton = new JButton("Prev");
            cancelButton = new JButton("Cancel");
            saveButton = new JButton("Save");

            mainPanel = new JPanel();
            fieldsPanel = new JPanel();
            buttonsPanel = new JPanel();
            listPanel = new JPanel();
        }

        //Убрали менеджер размещения
        mainPanel.setLayout(null);
        fieldsPanel.setLayout(null);
        buttonsPanel.setLayout(null);
        listPanel.setLayout(null);

        //  Coordinates and prefs
        {
            recNumLabl.setBounds(20,35,100,20);
            recNumLabl.setFont(consolasFont);

            recTypeLabl.setBounds(20,65,100,20);
            recTypeLabl.setFont(consolasFont);

            commentLabl.setBounds(20,95,120,20);
            commentLabl.setFont(consolasFont);

            recNumField.setBounds(135,30,100,25);

            tastTypesList.setBounds(135,60,100,25);

            commentField.setBounds(135,90,100,25);


            saveButton.setBounds(10,10,100,33);
            nextButton.setBounds(110,10,100,33);
            cancelButton.setBounds(210,10,100,33);

            fieldsPanel.setBounds(10,10,250,150);
            fieldsPanel.setBorder(loweredetched);

            listPanel.setBounds(270,10,300,350);
            listPanel.setBorder(loweredetched);

            buttonsPanel.setBounds(130,385,320,51);
            buttonsPanel.setBorder(loweredetched);
        }

        // Adding components
        {
            fieldsPanel.add(recNumLabl);
            fieldsPanel.add(recTypeLabl);
            fieldsPanel.add(commentLabl);
            fieldsPanel.add(recNumField);
            fieldsPanel.add(commentField);
            fieldsPanel.add(tastTypesList);

            buttonsPanel.add(nextButton);
            buttonsPanel.add(saveButton);
            buttonsPanel.add(cancelButton);

            mainPanel.add(buttonsPanel);
            mainPanel.add(fieldsPanel);
            mainPanel.add(listPanel);
        }

        add(mainPanel);
    }
}