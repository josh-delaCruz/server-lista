package it.itismeucci;

import java.util.ArrayList;

public class gestioneLista {
    ArrayList<String>lista;

    public gestioneLista(){
        lista = new ArrayList<>();
    }

    public void addElem(String in){
        lista.add(in);
    }

    public String stampaLista(){
        String mess = "";
        
        for(String x : lista){
            mess += "-" + x;
        }

        return mess;
    }
}
