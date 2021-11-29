package it.itismeucci;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        SSocket server = new SSocket(6789);
        
        server.connetti();
        server.comunica();
    }
}
