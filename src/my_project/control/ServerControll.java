package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.BinarySearchTree;
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
        System.out.println("Erstelle Server mit Port: " + port);
    }

    public void erstelleClient(String serverIP, int serverPort){
        System.out.println("Erstelle Client mit Server: " + serverIP + ", auf: " + serverPort);
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
        System.out.println(weiterzuleitendeNachricht);
        tC.send(key + "$" +weiterzuleitendeNachricht);
    }

    public String codeVigenere(String message,String keys){
        System.out.println("Länge: "+message.length());
        String chiffrierterText = "";
        char[] tmp = message.toCharArray();
        char[] temp = keys.toCharArray();
        List<Character> key = new List<>();
        System.out.println("");
        for (int i = 0; i < temp.length; i++){
            key.append(temp[i]);
        }
        key.toFirst();
        for (int i = 0; i < tmp.length; i++){
            if (!key.hasAccess()) key.toFirst();
            System.out.println(i+": "+key.getContent());
            chiffrierterText += code(Character.toString(tmp[i]),key.getContent());
            key.next();
        }
        return chiffrierterText;
    }

    public String code(String plaintext, char k){
        int key = (int) k-97;
        String ciphertext = "";
        plaintext = plaintext.toLowerCase(); //Alles in Kleinbuchstaben umwandeln
        for(int i=0; i<plaintext.length(); i++){
            //Buchstaben verschieben und an Geheimtext haengen
            char next = plaintext.charAt(i);
            ciphertext = ciphertext + shift(next, key);
        }
        return ciphertext;
    }

    public char shift(char letter, int shift){
        //Buchstaben als Zahl behandeln
        if(letter>='a' && letter <='z'){ //Sonderzeichen nicht veraendern
            letter += shift;
            while(letter > 'z'){
                letter -= 26;
            }
        }
        return letter;
    }

    public String decode(String ciphertext, char k){
        int key = (int) k-97;
        String decoded = "";
        ciphertext = ciphertext.toLowerCase(); //Alles in Kleinbuchstaben umwandeln
        for(int i=0; i<ciphertext.length(); i++){
            //Jeden Buchstaben verschieben und zwar um (26-Schluessel(key)) Stellen
            //und an entschluesselten Text anhaengen
            char next = ciphertext.charAt(i);
            decoded = decoded + shift(next, 26-key);
        }
        return decoded;
    }

    public String decodeV(String ciphertext, String keys){
        String dechiffrierterText = "";
        char[] tmp = ciphertext.toCharArray();
        char[] temp = keys.toCharArray();
        List<Character> key = new List<>();
        System.out.println("");
        for (int i = 0; i < temp.length; i++){
            key.append(temp[i]);
        }
        key.toFirst();
        for (int i = 0; i < tmp.length; i++){
            if (!key.hasAccess()) key.toFirst();
            System.out.println(i+": "+key.getContent());
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
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getArtV() {
        return artV;
    }
}
