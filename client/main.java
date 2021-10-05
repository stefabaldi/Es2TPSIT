import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class main
{
    public static void main( String[] args ) throws IOException
    {
        String ipAddress = "";      
        String porta = "";          
        
        System.out.println("Inserire Indirizzo IP: ");
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ipAddress = br.readLine();  
        
        System.out.println("Inserire Porta Server");  

        porta = br.readLine();  

        client client = new client(ipAddress, Integer.valueOf(porta));
        
        client.Connetti();
        client.Comunica();
    }
}
