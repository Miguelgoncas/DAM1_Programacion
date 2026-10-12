package SegundoDAM.AccesoDatos.serializable.ejercicios;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    static void main(String[] args) {
        menu();
    }

    static void menu(){
        File videojuegoF = new File("C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\serializable\\ejercicios\\videojuego.dat");
        List<Videojuego> videojuegos = cargarJuego(videojuegoF);

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. Introducir juego. \n 2. Mostrar juegos. \n 3. Modificar juegos"));

            switch (opcion){
                case 1:
                    introducirJuego(videojuegos, videojuegoF);
                    break;
                case 2:
                    mostrarJuego(videojuegos, videojuegoF);
                    break;
                case 3:
                    modificarJuego(videojuegos, videojuegoF);
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opción no valida");
            }

        }while(opcion != 0);

    }

    static boolean comprobrarLista(List<Videojuego> videojuegos){
        if (videojuegos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay juegos");
            return true;
        }
        return false;
    }

    static void serializar(List<Videojuego> videojuegos, File videojuegoF){
        try  {
            ObjectOutputStream serializador = new ObjectOutputStream(new FileOutputStream(videojuegoF));
            serializador.writeObject(videojuegos);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el videojuego: " + e.getMessage());
        }

    }

    static void deserializar(List<Videojuego> videojuegos, File videojuegoF){
        try {
            ObjectInputStream deserializador = new ObjectInputStream(new FileInputStream(videojuegoF));

            videojuegos = (ArrayList<Videojuego>) deserializador.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void introducirJuego(List<Videojuego> videojuegos, File videojuegoF){
        // Deserializamos antes de añadir un juego
        //deserializar(videojuegos, videojuegoF);
        String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del videojuego");
        String genero = JOptionPane.showInputDialog(null, "Introduce el genero del videojuego");
        String plataforma = JOptionPane.showInputDialog(null, "Introduce la plataforma del videojuego");
        String descripcion = JOptionPane.showInputDialog(null, "Introduce la descripción del videojuego");
        int anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el año de salida del juego"));
        Videojuego v1 = new Videojuego(nombre,genero,plataforma,descripcion,anio);
        videojuegos.add(v1);
        // Serialiamos y añadimos los juegos
        serializar(videojuegos, videojuegoF);
    }

    static void mostrarJuego(List<Videojuego> videojuegos, File videojuegoF){
        // Compruebo y si la lista está vacia no continuo
        if(comprobrarLista(videojuegos))
            return;

        //deserializar(videojuegos, videojuegoF);
        for( Videojuego v : videojuegos){
            JOptionPane.showMessageDialog(null, v.toString());
        }


    }

    static void modificarJuego(List<Videojuego> videojuegos, File videojuegoF){
        if (videojuegos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay juegos");
            return;
        }
        //deserializar(videojuegos, videojuegoF);
        modificarNombre(videojuegos, videojuegoF);
    }


    // Cada vez que se inicia el programa se carga el array desde el fichero
    static List<Videojuego> cargarJuego(File videojuegoF){
        if(!videojuegoF.exists())
            return new ArrayList<>();

        try {
            ObjectInputStream deserializador = new ObjectInputStream(new FileInputStream(videojuegoF));
            return (List<Videojuego>) deserializador.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void modificarNombre(List<Videojuego> videojuegos, File videojuegoF){
        //deserializar(videojuegos, videojuegoF);
        JOptionPane.showMessageDialog(null, "Que juego quieres modificar?");
        mostrarJuego(videojuegos,videojuegoF);

        String nombre = JOptionPane.showInputDialog(null,"Escribe el nombre");
        String nombreCambiar = JOptionPane.showInputDialog(null,"Introduce el nuevo nombre");
        boolean encontrado = false;

        for( int i = 0; i < videojuegos.size(); i ++){
            if (videojuegos.get(i).getNombre().equalsIgnoreCase(nombre) && !encontrado){
                videojuegos.get(i).setNombre(nombreCambiar);
                encontrado = true;
            }
        }

        if (encontrado) {
            serializar(videojuegos, videojuegoF);
            JOptionPane.showMessageDialog(null, "Nombre modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningún juedo con ese nombre");
        }

    }

}
