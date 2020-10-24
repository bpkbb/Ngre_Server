package my_project.control;

import KAGO_framework.model.abitur.datenstrukturen.List;
import my_project.model.TestClient;
import my_project.model.TestServer;

public class ServerControll {
    private ViewControll vC;
    private TestServer ts;
    private TestClient tC;
    private List<TestClient> testClient;
    private int artV;
    private String key;

    public ServerControll(){
        vC = new ViewControll(this);
        artV = 0;
    }

    public void einenServerHinzufuegen(int port){
        ts = new TestServer(port, this);
    }

    public void erstelleClient(String serverIP, int serverPort){
        tC =new TestClient(serverIP, serverPort, this);
    }

    public void leiteMessageWeiter(String s){
        vC.leiteMessageWeiter(s);
    }

    public void leiteNachrichtAnServer(String s){
        String weiterzuleitendeNachricht = "";
        if (artV == 1){
            weiterzuleitendeNachricht = code(s,key.charAt(0));
        }else if (artV == 2){
            weiterzuleitendeNachricht = codeVigenere(s,key);
        }
        System.out.println("Die Nachricht: *" + s + "* wird verschlüsselt(" + key + ") übermittelt.");
        System.out.println("*");
        tC.send(key + "$" +weiterzuleitendeNachricht);
    }

    public String codeVigenere(String message,String keys){
        String chiffrierterText = "";
        char[] tmp = message.toCharArray();
        char[] temp = keys.toCharArray();
        List<Character> key = new List<>();
        for (int i = 0; i < temp.length; i++){
            key.append(temp[i]);
        }
        key.toFirst();
        for (int i = 0; i < tmp.length; i++){
            if (!key.hasAccess()) key.toFirst();
            chiffrierterText += code(Character.toString(tmp[i]),key.getContent());
            key.next();
        }
        return chiffrierterText;
    }

    public String code(String message, char k){
        int key = (int) k-65;
        String verschluesselteNachricht = "";
        //message = message.toLowerCase();
        for(int i=0; i<message.length(); i++){
            char next = message.charAt(i);
            verschluesselteNachricht = verschluesselteNachricht + verschiebe1(next, key);
        }
        return verschluesselteNachricht;
    }

    public char verschiebe(char buchstabe, int key){
        if(buchstabe>='a' && buchstabe <='z'){
            buchstabe += key;
            while(buchstabe > 'z'){
                buchstabe -= 26;
            }
        }
        return buchstabe;
    }

    public char verschiebe1(char buchstabe, int key){
        if(buchstabe>='A' && buchstabe <='z'){
            buchstabe += key;
            while(buchstabe > 'z'){
                buchstabe -= 58;
            }
        }
        return buchstabe;
    }

    public String decode(String ciphertext, char k){
        int key = (int) k-65;
        String decoded = "";
        //ciphertext = ciphertext.toLowerCase();
        for(int i=0; i<ciphertext.length(); i++){
            char next = ciphertext.charAt(i);
            decoded = decoded + verschiebe1(next, 58-key);
        }
        return decoded;
    }

    public String decodeV(String ciphertext, String keys){
        String dechiffrierterText = "";
        char[] tmp = ciphertext.toCharArray();
        char[] temp = keys.toCharArray();
        List<Character> key = new List<>();
        for (int i = 0; i < temp.length; i++){
            key.append(temp[i]);
        }
        key.toFirst();
        for (int i = 0; i < tmp.length; i++){
            if (!key.hasAccess()) key.toFirst();
            dechiffrierterText += decode(Character.toString(tmp[i]),key.getContent());
            key.next();
        }
        return dechiffrierterText;
    }

    public void empfangeneNachrichtTransferieren(String message){
        String[] tmp = message.split("\\$");
        if (tmp[0].length()>1){
            vC.anzeigeClientAktualisieren(decodeV(tmp[1],tmp[0]));
        }else{
            vC.anzeigeClientAktualisieren(decode(tmp[1],tmp[0].charAt(0)));
        }
    }

    public void setArtV(int artV) {
        this.artV = artV;
        System.out.println("------------------------------------------");
        System.out.println("Verschlüsselungsart wurde verändert.");
    }

    public void setKey(String key) {
        this.key = key;
        System.out.println("Schlüssel wurde verändert.");
        System.out.println("------------------------------------------");
    }

    public int getArtV() {
        return artV;
    }
}
