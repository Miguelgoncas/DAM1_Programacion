package practicaInterface;

import practicaInterface.Interfacee.Contrato;

import java.util.ArrayList;

public class CentroNotificaciones {

    private ArrayList<Contrato> canales;

    public CentroNotificaciones(){

         this.canales = new ArrayList<>();
    }

    public boolean registrarCanal(Contrato n){
        if(n == null) return false;
        if(this.canales == null) this.canales = new ArrayList<>();
        this.canales.add(n);
        return true;
    }

    public int enviarTodos(String destinatario, String mensaje){
        int contador = 0;
        if(this.canales.isEmpty())  return -1;
        for(Contrato c1 : canales){
            if(c1.enviar(destinatario, mensaje)){
                contador++;
            }
        }
        return contador;
    }

    public void listarCanal(Contrato[] c){
        if(this.canales == null || this.canales.isEmpty()){
            System.out.println("No hay canales registrados");
            return;
        }
        for (Contrato c1 : canales) {
            System.out.println(c1.toString());
        }
    }

    public void mostrarCanalesEmail(){
        if(this.canales == null || this.canales.isEmpty()){
            System.out.println("No hay canales registrados");
            return;
        }
     for(Contrato c : canales)  {
         if(c instanceof EmailNotificacion){
             System.out.println(c);
         }
     }

    }

}
