package my_project.control;

import my_project.view.Anwenderinterface;
import my_project.view.ClientInterface;

public class ViewControll {
    private Anwenderinterface a;
    private ClientInterface client;

    public ViewControll() {
        a = new Anwenderinterface();
        client = new ClientInterface();
    }
}
