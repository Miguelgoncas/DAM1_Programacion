import javax.swing.*;

public class HolaMundo {
    public static void main(String[] args) {

        String numeroStr = JOptionPane.showInputDialog(null,"Ingresa un número entero");
        int numero = 0;
        try{
             numero = Integer.parseInt(numeroStr);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error, introduce un número entero");
            main(args);
            System.exit(0);
        }

        System.out.println("numero  " + numero);


        String mensaje = "\nPerfecto!";
        JOptionPane.showMessageDialog(null, mensaje);


    }
}
