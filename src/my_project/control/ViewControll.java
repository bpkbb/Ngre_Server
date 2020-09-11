package my_project.control;

import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.netz.Client;
import my_project.view.Anwenderinterface;
import my_project.view.ClientInterface;
import my_project.view.Steuerungsfenster;

public class ViewControll {
    private Anwenderinterface a;
    private ClientInterface i;
    private List<ClientInterface> clientListe;
     private Steuerungsfenster s;
     private ServerControll sC;

    public ViewControll(ServerControll serverControll) {
        sC = serverControll;
        clientListe = new List<>();
        a = new Anwenderinterface(this);
        s = new Steuerungsfenster(this);
    }


    public void setServerOn(){
        a.setFensterVisible(true);
    }

    public void setClientOn(){
        clientListe.append(new ClientInterface(this));
    }

    public void erstellenServer(int port){
        sC.einenServerHinzufuegen(port);
    }

    public void erstelleClient(String serverIP, int serverPort){
        sC.erstelleClient(serverIP, serverPort);
    }

   public void leiteMessageWeiter(String s){
        a.updateNachrichten(s);
       clientListe.toFirst();
       while(clientListe.hasAccess()){
            clientListe.getContent().updateNachrichten(s);
            clientListe.next();
       }
   }

   private void setzeListAuf(Client s){
    }



}
