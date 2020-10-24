package my_project.model;

import KAGO_framework.model.abitur.netz.Client;
import my_project.control.ServerControll;

public class TestClient extends Client {

    private ServerControll sC;

    public TestClient(String serverIP, int serverPort, ServerControll sC){
        super(serverIP,serverPort);
        this.sC = sC;
        System.out.println("Erstelle Client mit Server: " + serverIP + " auf Port: " + serverPort);
        System.out.println("Client wurde erstellt.");
        System.out.println("----------------------------------------------");
        System.out.println("******Kommunikationsbereit******");
    }
    @Override

    public void processMessage(String pMessage) {
        sC.empfangeneNachrichtTransferieren(pMessage);
    }
}
