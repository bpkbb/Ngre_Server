package my_project.model;

import KAGO_framework.model.abitur.netz.Client;
import my_project.control.ServerControll;

public class TestClient extends Client {

    private ServerControll sC;

    public TestClient(String serverIP, int serverPort, ServerControll sC){
        super(serverIP,serverPort);
        this.sC = sC;
    }
    @Override

    public void processMessage(String pMessage) {
        sC.empfangeneNachrichtTransferieren(pMessage);
    }


}
