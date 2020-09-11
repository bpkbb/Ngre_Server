package my_project.model;

import KAGO_framework.model.abitur.netz.Server;

public class TestServer extends Server {

    public TestServer(int port){
        super(port);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {

    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {

    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }
}
