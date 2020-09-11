package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.BinarySearchTree;
import my_project.model.TestServer;


public class ServerControll {
    private ViewControll vC;
    private TestServer ts;

    public ServerControll(){
        vC = new ViewControll(this);
    }

    public void einenServerHinzufuegen(int port){
        ts = new TestServer(port);
    }

}
