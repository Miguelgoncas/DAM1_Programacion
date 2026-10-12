package SegundoDAM.AccesoDatos.serializable.ejercicios;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Ejercicio3 {
    static void main(String[] args) {
        menu();
    }

    static void menu(){

        File agendaF = new File("C:\\Users\\migue\\Desktop\\Programacion\\Java\\1Prog\\src\\SegundoDAM\\AccesoDatos\\serializable\\ejercicios\\agenda.dat");
        List<Persona> agenda = cargarAgenda(agendaF);
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"0. Salir\n" +
                    "1. Introducir personas. \n 2. Mostrar personas \n 3. Buscar personas"));

            switch (opcion){
                case 1:
                    introducirPersona(agenda, agendaF);
                    break;
                case 2:
                    mostrarPersonas(agenda, agendaF);
                    break;
                case 3:
                    buscarPersonas(agenda, agendaF);
                    break;
                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"Opción no valida");

            }
        } while (opcion != 0);
    }

    // Creamos persona y guardamos fichero
    static void introducirPersona(List<Persona> agenda, File agendaF){
        // Añadimos los atributos de la persona
        String nombre = JOptionPane.showInputDialog(null, "Introduce un nombre");
        String email = JOptionPane.showInputDialog(null,"Introduce un email");
        int nacimiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce año de nacimiento"));
        Persona p1 = new Persona(nombre,email,nacimiento);
        agenda.add(p1);
        // Método para guardar a la perona recien creada
        guardarAgenda(agenda,agendaF);
        JOptionPane.showMessageDialog(null, "Persona guardada!");

    }

    // Escribir en el fichero, usamos con serializar
    static void guardarAgenda(List<Persona> agenda, File f) {
        try  {
            ObjectOutputStream serializador = new ObjectOutputStream(new FileOutputStream(f));
            serializador.writeObject(agenda);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la agenda: " + e.getMessage());
        }
    }

    // Mostramos todas las personas
    static void mostrarPersonas(List<Persona> agenda, File agendaF) {
        // Si está vacia volvemos
        if(comprobrarAgenda(agenda))
            return;

        try {
            ObjectInputStream deserializador = new ObjectInputStream(new FileInputStream(agendaF));

            List<Persona> ang = (ArrayList<Persona>) deserializador.readObject();

            for (int i = 0; i < ang.size(); i++) {
                JOptionPane.showMessageDialog(null, ang.get(i).toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    // Busca por nombre
    static void buscarPersonas(List<Persona> agenda, File agendaF) {
        if(comprobrarAgenda(agenda))
            return;

        String busqueda = JOptionPane.showInputDialog(null, "Introduce el nombre a buscar");
        if (busqueda == null) {
            JOptionPane.showMessageDialog(null,"Nombre no válido");
            return;
        }

        try {
            ObjectInputStream deserializador = new ObjectInputStream(new FileInputStream(agendaF));
            List<Persona> ang = (ArrayList<Persona>) deserializador.readObject();

            String texto = "";
            for (Persona p : agenda) {
                if (p.getNombre().toLowerCase().contains(busqueda))
                    texto += p + "\n";

            }
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna persona");
            } else {
                JOptionPane.showMessageDialog(null, texto);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    static boolean comprobrarAgenda(List<Persona> agenda){
        if (agenda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La agenda está vacía");
            return true;
        }
        return false;
    }

    static List<Persona> cargarAgenda(File agendaF) {
        if (!agendaF.exists()) {
            return new ArrayList<>();
        }
        try  {
            ObjectInputStream deserializador = new ObjectInputStream(new FileInputStream(agendaF));
            return (List<Persona>) deserializador.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer la agenda: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}





