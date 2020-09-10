package my_project.control;

import my_project.view.Anwenderinterface;
import my_project.view.ClientInterface;
import my_project.view.Steuerungsfenster;

public class ViewControll {
    private Anwenderinterface a;
    private ClientInterface i;
     private Steuerungsfenster s;

    public ViewControll() {
        a = new Anwenderinterface();
        s = new Steuerungsfenster(this);
        i = new ClientInterface();
    }

    public void setServerOn(){
        a.setFensterVisible(true);
    }

    public void setClientOn(){
        i.setFensterVisible(true);
    }
}
