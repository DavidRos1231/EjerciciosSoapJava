package mx.edu.utez.soapclient.Clients;
import utez.RFCServiceService;
import utez.Service;
import java.util.Scanner;
public class Soapclientnum {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            RFCServiceService service= new RFCServiceService();
            Service port=service.getServicePort();
            System.out.println("Coloca un numero");
            String response=port.reponseMessage(sc.nextInt());
            System.out.println(response);
        }
    }