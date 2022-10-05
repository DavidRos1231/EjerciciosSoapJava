package mx.edu.utez.soapclient.Clients;
import utez.RFCServiceService;
import utez.Service;
import java.util.Scanner;

public class RFCClient {
    public static void main(String[] args) {
        System.out.println("QUe desea hacer \n1.-RFC\n2.-NumeroAleatorio\n3.-SinVocales");
        Scanner sc=new Scanner(System.in);
        RFCServiceService service= new RFCServiceService();
        Service port=service.getServicePort();
        String response;
        switch (Integer.parseInt(sc.nextLine())){
            case 1:
                System.out.println("Ingresa tu nombre");
                String name=sc.nextLine();
                System.out.println("Ingresa tu apellido paterno");
                String last=sc.nextLine();
                System.out.println("Ingresa tu apelido materno");
                String mid=sc.nextLine();
                System.out.println("Ingresa tu dia de nacimiento");
                String dia=sc.nextLine();
                System.out.println("Ingresa tu Mes de nacimiento (En numero)");
                String mes=sc.nextLine();
                System.out.println("Ingresa tu año de naciemiento");
                String ano=sc.nextLine();
                response=port.rfcgen(name,mid,last,ano,mes,dia);
                System.out.println(response);
                break;
            case 2:
                do {
                    System.out.println("Coloca un numero");
                    response=port.reponseMessage(sc.nextInt());
                    System.out.println(response);
                }while (response.charAt(0)=='I');
                break;
            case 3:
                System.out.println("Escribe una frase");
                response=port.sinvocales(sc.nextLine());
                System.out.println(response);
                break;
        }


    }
}