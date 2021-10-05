

import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;


public class client
{
    private String nomeServer;
    private int portaServer;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaDelServer;
    DataOutput outVersoServer;
    BufferedReader inDalServer;

    public client(String nomeServer, int portaServer) 
    {
        this.nomeServer = nomeServer;
        this.portaServer = portaServer;
    }

    public Socket Connetti()
    {
        System.out.println("2 CLIENT partito in esecuzione ");

        try
        {
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            mioSocket = new Socket(nomeServer, portaServer);

            outVersoServer = new DataOutputStream(mioSocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

        }
        catch(UnknownHostException e)
        {
            System.out.print("Host Sconosciuto");
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore Durante La Connessione");
            System.exit(1);
        }

        return mioSocket;
    }

    public void Comunica()

    {
        try
        {
            System.out.println("4... Inserisci la stringa da trasmettere al server " + '\n');
            stringaUtente = tastiera.readLine();

            System.out.println("5... Invio la stringa al server e attendo");
            outVersoServer.writeBytes(stringaUtente + '\n');

            System.out.println("8 Ho La Risposta Dal Server... ");

            stringaDelServer = inDalServer.readLine();

            System.out.println(stringaDelServer);
            System.out.println("9 CLIENT: Termina Elaborazione E Chiude Connessione");
            mioSocket.close();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore Durante La Connessione");
            System.exit(1);
        }
    }

}
