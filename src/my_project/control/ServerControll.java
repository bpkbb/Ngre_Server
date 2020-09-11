package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.BinarySearchTree;
import my_project.model.TestClient;
import my_project.model.TestServer;


public class ServerControll {
    private ViewControll vC;
    private TestServer ts;
    private TestClient tC;

    public ServerControll(){
        vC = new ViewControll(this);
    }

    public void einenServerHinzufuegen(int port){
        System.out.println("Erstelle Server mit Port: " + port);
        ts = new TestServer(port);

    }

    public void erstelleClient(String serverIP, int serverPort){
        System.out.println("Erstelle Client mit Server: " + serverIP + ", auf: " + serverPort);
        tC= new TestClient(serverIP, serverPort);

    }

    public void sendMessage(String s){
        tC.send(s);
    }

}
