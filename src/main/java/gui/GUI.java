package gui;

import javax.swing.*;

import main.FileReader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//grafinis interfacas, reikia pasirinkti kortu kombinaciju faila, grazina laimetoja ir rezultata.
public class GUI
{
    public GUI(){}

    public void fileChooser(){
        JFrame frame=new JFrame("IBAN");
        frame.setVisible(true);
        frame.setSize(250,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label=new JLabel("Select action:");
        JPanel panel=new JPanel();
        frame.add(panel);
        panel.add(label);

        JButton button1=new JButton("Failo tikrinimas");

        panel.add(button1);

        button1.addActionListener(new Action1());
    }

    static class Action1 implements ActionListener {
        public void actionPerformed (ActionEvent e){
            JFrame frame2=new JFrame("Done");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(frame2);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                FileReader fileReader = new FileReader(selectedFile.getAbsolutePath(), selectedFile.getName());
                JOptionPane.showMessageDialog(null,"Player1 has won "+fileReader.getWinner()+" hands");
            }
        }
    }
}