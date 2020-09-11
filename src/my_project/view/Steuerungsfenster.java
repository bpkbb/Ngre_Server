package my_project.view;

import my_project.control.ViewControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Steuerungsfenster {
    private JButton serverButton;
    private JButton clientButton;
    private JPanel mainPanel;
    private ViewControll vC;
    private JFrame fenster;

    public Steuerungsfenster(ViewControll viewControll) {
        vC = viewControll;

        fenster = new JFrame("Los geht es...");
        fenster.setContentPane(mainPanel);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.pack();
        fenster.setVisible(true);
        fenster.setBounds(300,100,300,150);


        serverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vC.setServerOn();
                fenster.setVisible(true);
            }
        });
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vC.setClientOn();
                fenster.setVisible(true);
            }
        });
    }

}
