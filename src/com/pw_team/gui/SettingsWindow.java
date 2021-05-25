package com.pw_team.gui;

import com.pw_team.files.FileChecker;
import com.pw_team.logics.OptionConstants;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SettingsWindow extends JFrame{

    private final JTextField input = new JTextField("",20);
    private final JTextField input2 = new JTextField("",20);
    private final JRadioButton option1 = new JRadioButton("First nieghbourhood");
    private final JCheckBox check = new JCheckBox("No input file", true);

    public SettingsWindow(){
        super("Settings");
        this.setBounds(100,100,350,320);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6,2,4,6));
        JLabel label = new JLabel("Input file:");
        container.add(label);
        container.add(input);
        JLabel label2 = new JLabel("Output file:");
        container.add(label2);
        container.add(input2);
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        JRadioButton option2 = new JRadioButton("Second nieghbourhood");
        group.add(option2);
        container.add(option1);
        option1.setSelected(true);
        container.add(option2);


        JLabel labelFirst = new JLabel();
        labelFirst.setBounds(new Rectangle(0,0,50,50));
        Image firstImage = new ImageIcon("res/first.png").getImage();
        Image modifiedFirstImage = firstImage.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon firstImagefinal = new ImageIcon(modifiedFirstImage);
        labelFirst.setIcon(firstImagefinal);
        container.add(labelFirst);


        JLabel labelSecond = new JLabel();
        labelSecond.setBounds(new Rectangle(0,0,50,50));
        Image secondImage = new ImageIcon("res/second.png").getImage();
        Image modifiedSecondImage = secondImage.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon secondImagefinal = new ImageIcon(modifiedSecondImage);
        labelSecond.setIcon(secondImagefinal);
        container.add(labelSecond);

        container.add(check);
        JButton button = new JButton("Apply");
        button.addActionListener(new ButtonEventListener());
        JButton generateFile = new JButton("Generate file");
        generateFile.addActionListener(new generateButtonListener());
        container.add(generateFile);
        container.add(new JLabel());
        container.add(button);
        setVisible(true);
    }

    class generateButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Generator generator = new Generator();
            generator.addWindowListener(new Generator.WindowListener());
        }
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String fileInputPath = input.getText();
            String fileOutputPath = input2.getText();
            int option = option1.isSelected() ? OptionConstants.OPTION_ONE : OptionConstants.OPTION_TWO;
            boolean withoutFile = check.isSelected();
            if(!withoutFile) {
               while (true) {
                   try {
                       if(fileInputPath !=null)
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
