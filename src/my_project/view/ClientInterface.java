package my_project.view;

import javax.swing.*;

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

    public ClientInterface(){
        frame = new JFrame("Joli-Client");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(600,300,400,300);
    }

    public void setFensterVisible(boolean b){

    }
}
