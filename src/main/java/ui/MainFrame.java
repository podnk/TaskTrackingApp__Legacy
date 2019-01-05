package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MainFrame extends JFrame
{
    private Border loweredetched;

    private String[] taskTypes = {"Requirement", "Bug", "Task"};

    private JComboBox tastTypesList;

    private JLabel recNumLabl = null;
    private JLabel recTypeLabl = null;
    private JLabel commentLabl = null;

    private JTextField recNumField = null;
    private JTextField recTypeField = null;
    private JTextField commentField = null;

    private JButton nextButton = null;
    private JButton prevButton = null;
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
        }
        catch (Exception componentsEx)
        {
            System.out.println("Components initialization error");
        }

        try
        {
            initFrame();
        }
        catch (Exception frameEx)
        {
            System.out.println("Frame initialization error");
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
        Font consolasFont = new Font("Consolas",0,14);
//        Font calibriFont = new Font("Calibri",0,14);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        // Creating components
        {
            tastTypesList = new JComboBox(taskTypes);

            recNumLabl = new JLabel("Номер:");
            recTypeLabl = new JLabel("Тип:");
            commentLabl = new JLabel("Комментарий:");

            recNumField = new JTextField("recNumField");
            recTypeField = new JTextField("recTypeField");
            commentField = new JTextField("commentField");

            nextButton = new JButton("Next");
            prevButton = new JButton("Prev");
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
            recNumLabl.setBounds(10,15,100,20);
            recNumLabl.setFont(consolasFont);

            recTypeLabl.setBounds(10,45,100,20);
            recTypeLabl.setFont(consolasFont);

            commentLabl.setBounds(10,75,100,20);
            commentLabl.setFont(consolasFont);

            recNumField.setBounds(110,10,100,25);
//            recNumField.setFont(calibriFont);

            recTypeField.setBounds(110,40,100,25);
//            recTypeField.setFont(calibriFont);

            commentField.setBounds(110,70,100,25);
//            commentField.setFont(calibriFont);

            saveButton.setBounds(5,5,100,35);
            nextButton.setBounds(105,5,100,35);
            cancelButton.setBounds(205,5,100,35);

            fieldsPanel.setBounds(10,10,250,200);
            fieldsPanel.setBorder(loweredetched);

            listPanel.setBounds(270,10,300,350);
            listPanel.setBorder(loweredetched);

            buttonsPanel.setBounds(135,385,310,45);
            buttonsPanel.setBorder(loweredetched);
        }

        // Adding components
        {
            fieldsPanel.add(recNumLabl);
            fieldsPanel.add(recTypeLabl);
            fieldsPanel.add(commentLabl);
            fieldsPanel.add(recNumField);
            fieldsPanel.add(recTypeField);
            fieldsPanel.add(commentField);

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