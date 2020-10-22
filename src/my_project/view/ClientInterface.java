package my_project.view;

import my_project.control.ViewControll;
import my_project.model.TestClient;

import javax.swing.*;
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
    private JButton closeButton;
    private JButton ceaserButton;
    private JButton vigenereButton;
    private JTextField keyFeld;
    private ViewControll vC;
    private TestClient myClient;

    public ClientInterface(ViewControll vC){
        this.vC = vC;
        frame = new JFrame("Joli-Client");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
        frame.setBounds(600,300,400,300);

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

                }else{
                    vC.leiteNachrichtAnServer(nameTextField.getText() + ": " + messageField.getText());
                }

            }
        });
        ceaserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyFeld.getText().equals("")){

                }else{
                    vC.setArtV(1);
                    vC.setKey(keyFeld.getText());
                }
            }
        });
        vigenereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyFeld.getText().equals("")){

                }else{
                    vC.setArtV(2);
                    vC.setKey(keyFeld.getText());
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
    }

    public String getMessage(){
        return messageField.getText();
    }
}
