package my_project.model;

import KAGO_framework.model.abitur.netz.Server;
import my_project.control.ServerControll;

public class TestServer extends Server {

    private ServerControll sC;

    public TestServer(int port, ServerControll sC){
        super(port);
        this.sC = sC;
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {

    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        sC.leiteMessageWeiter(pMessage);
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }
}
