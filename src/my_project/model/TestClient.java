package my_project.model;

import KAGO_framework.model.abitur.netz.Client;

public class TestClient extends Client {

    public TestClient(String serverIP, int serverPort){
        super(serverIP,serverPort);
    }
    @Override
    public void processMessage(String pMessage) {

    }
}
