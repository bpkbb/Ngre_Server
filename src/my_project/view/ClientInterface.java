package my_project.view;

import my_project.control.ViewControll;
import my_project.model.TestClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientInterface {
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField nameTextField;
    private JTextField remoteIPText;
    private JTextField portTextField;
    private JButton connectButton;
    private JTextField messageField;
    private JButton sendButton;
    private JTextPane receivedField;
    private JButton caeserButton;
    private JButton vigenereButton;
    private JTextField keyFeld;
    private JLabel kFeld;
    private ViewControll vC;
    private TestClient myClient;

    public ClientInterface(ViewControll vC){
        this.vC = vC;
        frame = new JFrame("Joli-Client");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
        receivedField.setAutoscrolls(true);
        //frame.setBounds(600,300,400,300);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(remoteIPText.getText() != null && portTextField != null && nameTextField.getText() != null){
                    try{
                        vC.erstelleClient(remoteIPText.getText(), Integer.parseInt(portTextField.getText()));
                    }catch(NumberFormatException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (vC.getArtV() == 0){
                    JOptionPane.showMessageDialog(null,"Wir mussten festellen, dass Sie vergaßen eine Verschlüsselungsmethode zu wählen. Wir bitten Sie diesen Fehler zu beheben.");
                }else{
                    vC.leiteNachrichtAnServer(nameTextField.getText() + ": " + messageField.getText());
                }

            }
        });

        caeserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyFeld.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Wir mussten festellen, dass Sie vergaßen einen Schlüssel anzugeben. Wir bitten Sie diesen Fehler zu beheben.");
                }else if (keyFeld.getText().length() == 1){
                    vC.setArtV(1);
                    vC.setKey(keyFeld.getText());
                    caeserButton.setBackground(Color.RED);
                    vigenereButton.setBackground(Color.WHITE);
                    kFeld.setText(keyFeld.getText());
                    keyFeld.setText("");
                    passeFensterAn();
                }else{
                    JOptionPane.showMessageDialog(null,"Wir mussten festellen, dass Sie einen Schlüssel wählten, der mit Ihrer Verschlüsselungsart nicht kompatibel ist. Wir bitten Sie eines davon zu verändern.");
                }
            }
        });

        vigenereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyFeld.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Wir mussten festellen, dass Sie vergaßen einen Schlüssel anzugeben. Wir bitten Sie diesen Fehler zu beheben.");
                }else{
                    vC.setArtV(2);
                    vC.setKey(keyFeld.getText());
                    vigenereButton.setBackground(Color.RED);
                    caeserButton.setBackground(Color.WHITE);
                    kFeld.setText(keyFeld.getText());
                    keyFeld.setText("");
                    passeFensterAn();
                }
            }
        });
    }

    public void setFensterVisible(boolean b){
        frame.setVisible(b);
    }

    public void updateNachrichten(String s){
        receivedField.setText(receivedField.getText()+ "\n" + s);
        messageField.setText(null);
        messageField.grabFocus();
    }

    private void passeFensterAn(){
        frame.pack();
    }

    public String getMessage(){
        return messageField.getText();
    }
}
