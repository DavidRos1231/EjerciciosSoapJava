package mx.edu.utez.soapclient.Servers;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;
@WebService(name="Service",targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class RFCService {
    Random random=new Random();
    @WebMethod(operationName = "rfcgen")
    public String rfcgen(@WebParam(name="message")String name, String midname, String lastname, String ano, String mes, String dia){
        String regreso="";
        try{
            regreso=regreso+lastname.charAt(0)+lastname.charAt(1)+midname.charAt(0)+name.charAt(0)+ano.charAt(2)+ano.charAt(3)+mes.charAt(0)+mes.charAt(1)+dia.charAt(0)+dia.charAt(1)+(char)(random.nextInt(26) + 'a')+(char)(random.nextInt(26) + 'a')+(char)(random.nextInt(26) + 'a');
        }catch (Exception e){
            regreso ="Error";
        }
        return regreso.toUpperCase();
    }        @WebMethod(operationName = "sinvocales")
    public String sinvocales(@WebParam(name="message")String message){
        for (int i = message.length()-1; i >=0; i--) {
            if(message.charAt(i)=='a'||message.charAt(i)=='e'||message.charAt(i)=='i'||message.charAt(i)=='o'||message.charAt(i)=='u'||message.charAt(i)=='A'||message.charAt(i)=='E'||message.charAt(i)=='I'||message.charAt(i)=='O'||message.charAt(i)=='U'){
                message=message.substring(0,i)+message.substring(i+1);
            }
        }
        return message;
    }

    int num=(int)(Math.random()*10);
    @WebMethod(operationName = "reponseMessage")
    public String responseMessage(@WebParam(name="message")int message){
        return num==message?"Correcto el numero era "+message:"Incorrecto ese no era";
    }

    public static void main(String[] args) {
        System.out.println("Iniciando servidor...");
        Endpoint.publish("http://localhost:8082/Service", new RFCService());
        System.out.println("Espetando peticiones");
    }
}