package practicaInterface.Service;

import practicaInterface.Interface.Contrato;

public class SmsNotificacion implements Contrato {
    private String proveedor;



    public SmsNotificacion(String proveedor){
        this.proveedor = proveedor;
    }


    @Override
    public boolean enviar(String destinatario, String mensaje) {
        if(destinatario.length() != 9)  return false;
        for(int i = 0 ; i < destinatario.length(); i++){
            char c = destinatario.charAt(i);

            if(!(c >= 48 && c<= 57)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String nombreCanal() {
        return "Sms";
    }

    @Override
    public String toString() {
        return proveedor;
    }
}
