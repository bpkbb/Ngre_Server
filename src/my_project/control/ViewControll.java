package my_project.control;

import my_project.view.Anwenderinterface;
import my_project.view.ClientInterface;
import my_project.view.Steuerungsfenster;

public class ViewControll {
    private Anwenderinterface a;
    private ClientInterface i;
     private Steuerungsfenster s;
     private ServerControll sC;

    public ViewControll(ServerControll serverControll) {
        sC = serverControll;
        a = new Anwenderinterface(this);
        s = new Steuerungsfenster(this);
        i = new ClientInterface(this);
    }


    public void setServerOn(){
        a.setFensterVisible(true);
    }

    public void setClientOn(){
        i.setFensterVisible(true);
    }

    public void erstellenServer(int port){
        sC.einenServerHinzufuegen(port);
    }

    public void erstelleClient(String serverIP, int serverPort){
        sC.erstelleClient(serverIP, serverPort);
    }

    public void sendMessage (String s){
        sC.sendMessage(s);
    }
}
