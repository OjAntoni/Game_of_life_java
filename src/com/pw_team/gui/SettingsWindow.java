package com.pw_team.gui;

import com.pw_team.files.FileChecker;
import com.pw_team.logics.OptionConstants;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SettingsWindow extends JFrame{

    private JButton button = new JButton("Apply");
    private JTextField input = new JTextField("",20);
    private JLabel label = new JLabel("Input file:");
    private JTextField input2 = new JTextField("",20);
    private JLabel label2 = new JLabel("Output file:");
    private JRadioButton option1 = new JRadioButton("First nieghbourhood");
    private JRadioButton option2 = new JRadioButton("Second nieghbourhood");
    private JCheckBox check = new JCheckBox("No input file", true);
    private String fileInputPath;
    private String fileOutputPath;
    private int option;
    private boolean withoutFile;

    public SettingsWindow(){
        super("Settings");
        this.setBounds(100,100,300,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        container.add(label);
        container.add(input);
        container.add(label2);
        container.add(input2);
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        container.add(option1);
        option1.setSelected(true);
        container.add(option2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
        setVisible(true);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
           fileInputPath = input.getText();
            System.out.println(fileInputPath);
           fileOutputPath = input2.getText();
            System.out.println(fileOutputPath+"in ActionListener");
           option = option1.isSelected() ? OptionConstants.OPTION_ONE : OptionConstants.OPTION_TWO;
           withoutFile = check.isSelected();
           if(!withoutFile) {
               while (true) {
                   try {
                       if(fileInputPath!=null)
                           FileChecker.checkForCurrency(fileInputPath);
                       break;
                   } catch (Exception e) {
                       JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                       fileInputPath = null;
                       withoutFile = true;

                   }
               }
           }
           setVisible(false);
           GameWindow gameWindow = new GameWindow(fileInputPath, fileOutputPath, option, withoutFile);
           javax.swing.SwingUtilities.invokeLater(gameWindow);
        }
    }


}
