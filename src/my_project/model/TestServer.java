package my_project.model;

import KAGO_framework.model.abitur.netz.Server;
import my_project.control.ServerControll;

public class TestServer extends Server {

    private ServerControll sC;

    public TestServer(int port, ServerControll sC){
        super(port);
        this.sC = sC;
        System.out.println("Ein Server mit dem Port " + port + " wurde erstellt.");
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {

    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        sC.leiteMessageWeiter(pMessage);
        sendToAll(pMessage);
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }
}
