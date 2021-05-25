package com.pw_team.gui;

import com.pw_team.filler.Density;
import com.pw_team.filler.FileGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Generator extends JFrame {
    private final JTextField filenameText = new JTextField("generatedFile.txt", 20);
    private final JComboBox<String> density = new JComboBox<>(Density.getAllDesnsities());
    private final JComboBox<Integer> size = new JComboBox<>(getAvaliableSizes());
    private final JComboBox<Integer> width = new JComboBox<>(getAvaliavleWidth());
    private final JComboBox<Integer> height = new JComboBox<>(getAvaliavleHeight());
    private final JComboBox<Integer> sleepms = new JComboBox<>(getAvaliavleSleepms());
    private final JButton cancel = new JButton("cancel");
    private final JButton ok = new JButton("ok");
    private static JFrame father;


    public Generator(){
        super("File Creator");
        this.setBounds(100,100,300,340);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7,2,4,6));
        JLabel label = new JLabel("File name:");
        container.add(label);
        container.add(filenameText);
        container.add(new JLabel("Density:"));
        container.add(density);
        container.add(new JLabel("Size:"));
        container.add(size);
        container.add(new JLabel("Width:"));
        container.add(width);
        container.add(new JLabel("Height:"));
        container.add(height);
        container.add(new JLabel("Sleepms:"));
        container.add(sleepms);
        cancel.addActionListener(new cancelListener());
        container.add(cancel);
        ok.addActionListener(new okListener());
        container.add(ok);
    }

    class cancelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            father.setVisible(true);
            dispose();
        }
    }

    class okListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Integer[] s = getAvaliableSizes();
            Integer[] w = getAvaliavleWidth();
            Integer[] h = getAvaliavleHeight();
            Integer[] sl = getAvaliavleSleepms();
            FileGenerator.generate(filenameText.getText(), Density.getCoef(density.getSelectedIndex()),
                    (int)size.getSelectedItem(), (int)width.getSelectedItem(),
                    (int)height.getSelectedItem(), (int)sleepms.getSelectedItem());
            JOptionPane.showMessageDialog(null, "Your file has been generated successfully",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            father.setVisible(true);
        }
    }
    public static void setFatherFrame(JFrame f){
        father = f;
    }

    private Integer[] getAvaliableSizes(){
        Integer[] sizes = new Integer[20];
        for (int i = 0; i < 20; i++)
            sizes[i]=i+1;
        return sizes;
    }
    private Integer[] getAvaliavleWidth(){
        Integer[] sizes = new Integer[100];
        for (int i = 0; i < 100; i++)
            sizes[i]=i+1;
        return sizes;
    }
    private Integer[] getAvaliavleHeight(){
        Integer[] sizes = new Integer[100];
        for (int i = 0; i < 100; i++)
            sizes[i]=i+1;
        return sizes;
    }
    private Integer[] getAvaliavleSleepms(){
        return new Integer[]{10, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200};
    }

    static class WindowListener implements java.awt.event.WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            father.setVisible(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

}
