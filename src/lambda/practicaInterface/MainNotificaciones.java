package lambda.practicaInterface;

import lambda.practicaInterface.Interface.Contrato;
import lambda.practicaInterface.Service.CentroNotificaciones;
import lambda.practicaInterface.Service.EmailNotificacion;
import lambda.practicaInterface.Service.PushNotificacion;
import lambda.practicaInterface.Service.SmsNotificacion;

import java.util.Scanner;

public class MainNotificaciones {
    static CentroNotificaciones c1 = new CentroNotificaciones();
    static EmailNotificacion e1 = new EmailNotificacion("Miguel@");
    static PushNotificacion p1 = new PushNotificacion("DAMapp");
    static SmsNotificacion s1 = new SmsNotificacion("Vodafone");
    static Contrato[] arr = {e1,p1,s1};

    static boolean registrarEmail(){

        return c1.registrarCanal(e1);

    }
    static boolean registrarSMS(){
        return c1.registrarCanal(s1);
    }
    static boolean registrarPush(){
        return c1.registrarCanal(p1);
    }

    static void listarCanales(){
       c1.listarCanal(arr);
    }

    static void enviarTodos(){
                                    // Cambiar esto para probar los demas
       if(c1.enviarTodos("Miguel@","Hola") == -1){
           System.out.println("Error, no hay ningún canal registrado");
       } else {
           System.out.println("Mensaje enviado correctamente");
           System.out.println(c1.enviarTodos("Miguel@", "Hola"));
       }
    }

    static void mostrarEmail(){
        c1.mostrarCanalesEmail();
    }
    static void menu(){
        int op = 0;
        Scanner rd = new Scanner(System.in);


        do{
            System.out.println("1.Registrar Email");
            System.out.println("2.Registrar SMS");
            System.out.println("3.Registrar Push");
            System.out.println("4.Listar canales");
            System.out.println("5.Enviar notificacion a todos");
            System.out.println("6.Mostrar solo Email");
            System.out.println("0.Salir");
            op = rd.nextInt();

            switch (op){
                case 1:
                    if(registrarEmail()) {
                        System.out.println("Creado correctamente");
                    } else{
                        System.out.println("No se ha podido crear");
                    }
                    break;
                case 2:
                    if(registrarSMS()) {
                        System.out.println("Creado correctamente");
                    } else{
                        System.out.println("No se ha podido crear");
                    }
                    break;
                case 3:
                    if(registrarPush()) {
                        System.out.println("Creado correctamente");
                    } else{
                        System.out.println("No se ha podido crear");
                    }
                    break;

                case 4:
                    listarCanales();
                    break;
                case 5:
                    enviarTodos();
                    break;
                case 6:
                    mostrarEmail();
                    break;

                default:
                    System.out.println("Error");
            }


        } while (op != 0);
        System.out.println("Hasta luego!");

    }
    static void main(String[] args) {
        menu();


    }
}
