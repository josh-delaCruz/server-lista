package it.itismeucci;

import java.io.*;
import java.net.*;

public class SSocket {
     
    protected int porta; //porta
    protected ServerSocket server; //Il server socket aspetterà l'arrivo dei client (del client)
    protected Socket client; //il socket del client
    
    //lettura e invio dati
    private BufferedReader input; //qui si riceverà ciò verrà inviato dal client
    private DataOutputStream output; //inviare i dati al client
    protected gestioneLista lista;
    
    public SSocket(int porta) {
        this.porta = porta;
        try {
            server = new ServerSocket(porta);
            lista = new gestioneLista();
        } catch (IOException ex) { System.out.println("Errore nell'inizializzazione del server\n" + ex.getMessage() ); }
    }
    
    public void connetti(){
        
        try {
            System.out.println("Server in attesa dell'arrivo di un client...");
            client = server.accept();
            System.out.println("Client arrivato: " + client.toString());
            
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new DataOutputStream(client.getOutputStream());
            
        } catch (IOException ex) {
            System.out.println("Errore nella connessione" + ex.getMessage());  
        }
        
    }
    
    public void comunica(){
        String messaggio = "";
        System.out.println("Inizio comunicazione");
        
        
        try {
            output.writeBytes("Connessione effettuata" + '\n');
            for(;;){
                output.writeBytes("Inserisci la nota da memorizzare o digita LISTA per visualizzare le note salvate" + '\n');
                messaggio = input.readLine();
                
                if(messaggio.equals("LISTA")){
                    output.writeBytes(lista.stampaLista() + '\n');
                }else{
                    lista.addElem(messaggio);
                    output.writeBytes("Nota salvata" + '\n');
                }
                
                
            }
        } catch (IOException ex) { 
            System.out.println("Errore nella comunicazione" + ex.getMessage()); 
             
        }

    }
    
}

