package my_project.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Steuerungsfenster {
    private JFrame fenster;
    private JButton serverButton;
    private JButton clientButton;
    private JPanel ASC;

    public Steuerungsfenster() {
        fenster = new JFrame("Startfenster zu Ngre Server und Joli-Client");
        fenster.setContentPane(ASC);
        serverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

}
