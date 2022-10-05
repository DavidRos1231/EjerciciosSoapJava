package mx.edu.utez.soapclient.Clients;
import utez.Service;
import utez.RFCServiceService;
import java.util.Scanner;
public class SoapClient {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        RFCServiceService service= new RFCServiceService();
        Service port=service.getServicePort();
        System.out.println("Escribe una frase");
        String response=port.sinvocales(sc.nextLine());
        System.out.println(response);
    }
}
