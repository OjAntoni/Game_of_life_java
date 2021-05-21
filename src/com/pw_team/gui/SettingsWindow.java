package com.pw_team.gui;

import com.pw_team.logics.OptionConstants;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SettingsWindow extends JFrame{

    private JButton button = new JButton("Apply");
    private JTextField input = new JTextField("",20);
    private JLabel label = new JLabel("Input file:");
    private JRadioButton option1 = new JRadioButton("First nieghbourhood");
    private JRadioButton option2 = new JRadioButton("Second nieghbourhood");
    private JCheckBox check = new JCheckBox("No input file", true);
    private String filePath;
    private int option;
    private boolean withoutFile;

    public SettingsWindow(){
        super("Settings");
        this.setBounds(100,100,300,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        container.add(option1);
        option1.setSelected(true);
        container.add(option2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
           filePath = input.getText();
           option = option1.isSelected() ? OptionConstants.OPTION_ONE : OptionConstants.OPTION_TWO;
           withoutFile = check.isSelected();
           setVisible(false);
           GameWindow gameWindow = new GameWindow();
           javax.swing.SwingUtilities.invokeLater(gameWindow);
        }
    }


}
