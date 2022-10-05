package mx.edu.utez.soapclient.Clients;
import utez.RFCServiceService;
import utez.Service;
import java.util.Scanner;

public class RFCClient {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        RFCServiceService service= new RFCServiceService();
        Service port=service.getServicePort();
        System.out.println("Ingresa tu nombre");
        String name=sc.nextLine();
        System.out.println("Ingresa tu apellido paterno");
        String last=sc.nextLine();
        System.out.println("Ingresa tu apelido materno");
        String mid=sc.nextLine();
        System.out.println("Ingresa tu año de naciemiento");
        String ano=sc.nextLine();
        System.out.println("Ingresa tu Mes de nacimiento (En numero)");
        String mes=sc.nextLine();
        System.out.println("Ingresa tu dia de nacimiento");
        String dia=sc.nextLine();

        String response=port.rfcgen(name,mid,last,ano,mes,dia);
        System.out.println(response);
    }
}