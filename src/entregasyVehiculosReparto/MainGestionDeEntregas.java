package entregasyVehiculosReparto;

import entregasyVehiculosReparto.envios.Envio;
import entregasyVehiculosReparto.envios.EnvioEstandar;
import entregasyVehiculosReparto.envios.EnvioRefrigerado;
import entregasyVehiculosReparto.envios.EnvioUrgente;
import entregasyVehiculosReparto.model.Dron;
import entregasyVehiculosReparto.model.Furgoneta;
import entregasyVehiculosReparto.model.MotoReparto;
import entregasyVehiculosReparto.model.Vehiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class MainGestionDeEntregas {
    static Scanner rd = new Scanner(System.in);
    static ArrayList<Vehiculo> vehiculo = new ArrayList<>();
    static ArrayList<Envio> envio = new ArrayList<>();
    static int op = 0;

    static boolean crearEnvioEstandar(){
        System.out.println("Ingrese código de envío:");
        String codigo = rd.next();
        System.out.println("Ingrese distancia en km:");
        double distanciaKm = rd.nextDouble();
        System.out.println("Ingrese peso en kg:");
        double pesoKg = rd.nextDouble();
        System.out.println("Ingrese destino:");
        String destino = rd.next();
        Envio e1 = new EnvioEstandar(codigo, distanciaKm, pesoKg, destino);

        if(comprobarCodigoEnvio(codigo)) return false;

        envio.add(e1);
        return true;
    }

    static boolean crearEnvioUrgente(){
        System.out.println("Ingrese código de envío:");
        String codigo = rd.next();
        System.out.println("Ingrese distancia en km:");
        double distanciaKm = rd.nextDouble();
        System.out.println("Ingrese peso en kg:");
        double pesoKg = rd.nextDouble();
        System.out.println("Ingrese destino:");
        String destino = rd.next();
        System.out.println("Es prioridad alta? (true/false):");
        boolean prioridad = rd.nextBoolean();
        Envio e1 = new EnvioUrgente(codigo, distanciaKm, pesoKg, destino, prioridad);

        if(comprobarCodigoEnvio(codigo)) return false;

        envio.add(e1);
        return true;
    }

    static boolean crearEnvioRefrigerado(){
        System.out.println("Ingrese código de envío:");
        String codigo = rd.next();
        System.out.println("Ingrese distancia en km:");
        double distanciaKm = rd.nextDouble();
        System.out.println("Ingrese peso en kg:");
        double pesoKg = rd.nextDouble();
        System.out.println("Ingrese destino:");
        String destino = rd.next();
        Envio e1 = new EnvioRefrigerado(codigo, distanciaKm, pesoKg, destino);

        if(comprobarCodigoEnvio(codigo)) return false;

        envio.add(e1);
        return true;
    }
    static void altaEnvio(){
        op = 0;
        System.out.println("Registrar nuevo envío");
        System.out.println("=================");
        System.out.println("Seleccione el tipo de envío:");
        System.out.println("1. Estándar");
        System.out.println("2. Urgente");
        System.out.println("3. Refrigerado");
        op = rd.nextInt();
        switch (op){
            case 1:
                System.out.println("Registrar Envío Estándar");
                if (crearEnvioEstandar()) {
                    System.out.println("Envío estándar registrado exitosamente");
                } else {
                    System.out.println("Error al registrar el envío, es posible que el código ya esté registrado.");
                }
                break;
            case 2:
                System.out.println("Registrar Envío Urgente");
                if (crearEnvioUrgente()) {
                    System.out.println("Envío urgente registrado exitosamente");
                } else {
                    System.out.println("Error al registrar el envío, es posible que el código ya esté registrado.");
                }
                break;
            case 3:
                System.out.println("Registrar Envío Refrigerado");
                if (crearEnvioRefrigerado()) {
                    System.out.println("Envío refrigerado registrado exitosamente");
                } else {
                    System.out.println("Error al registrar el envío, es posible que el código ya esté registrado.");
                }
                break;
            default:
                System.out.println("Opción no válida, intente de nuevo.");
        }
    }
    static void listarVehiculosDisponibles(){
        if(vehiculo.isEmpty()){
            System.out.println("No hay vehículos registrados.");
            return;
        }
        System.out.println("Vehículos disponibles:");
        for (Vehiculo v : vehiculo) {
            if (v.getDisponible()) {
                System.out.println(("El vehiculo " + vehiculo +
                        " esta " + ((v.getDisponible()) ? "Disponible" : "No disponible")));
            }
        }
    }
    static void listarEnviosPendientes(){
        if(envio.isEmpty()){
            System.out.println("No hay envíos registrados.");
            return;
        }
        System.out.println("Envíos pendientes:");
        for (Envio e : envio) {
            System.out.println(e + " euros");
        }
    }

    static void listarCosteTotalEnvios(){
        if(envio.isEmpty()){
            System.out.println("No hay envíos registrados.");
            return;
        }
        double costeTotal = 0;
        for (Envio e : envio) {
            costeTotal += e.calcularCoste();
        }
        System.out.println("Coste total de envíos: " + costeTotal + " euros");
    }

    static boolean crearFurgo(){
        System.out.println("Ingrese matrícula:");
        String matricula = rd.next();
        System.out.println("Ingrese capacidad en kg:");
        double capacidadKg = mayorCero();
        System.out.println("Ingrese consumo base (litros/100km):");
        double consumeBase = mayorCero();
        System.out.println("Es refrigerada? (true/false):");
        boolean refrigerada = rd.nextBoolean();
        Furgoneta f1 = new Furgoneta(matricula, capacidadKg, consumeBase, refrigerada);

        if(comprobarMatricula(matricula)) return false;

        vehiculo.add(f1);
        return true;
    }

    static double mayorCero(){
        int num = 0;
        do{
            num = rd.nextInt();
            if(num < 0)
                System.out.println("Número no válido, intruzca un número mayor o igual a cero:");
        } while (num < 0);
        return num;
    }
    static boolean crearMoto(){
        System.out.println("Ingrese matrícula:");
        String matricula = rd.next();
        System.out.println("Ingrese capacidad en kg:");
        double capacidadKg = mayorCero();
        System.out.println("Ingrese consumo base (litros/100km):");
        double consumeBase = mayorCero();
        System.out.println("Que cilindrada tiene la moto?");
        int cilindrada = rd.nextInt();
        MotoReparto m1 = new MotoReparto(matricula, capacidadKg, consumeBase, cilindrada);

        if(comprobarMatricula(matricula)) return false;


        vehiculo.add(m1);
        return true;
    }

    static boolean crearDron(){
        System.out.println("Ingrese matrícula:");
        String matricula = rd.next();
        System.out.println("Ingrese capacidad en kg:");
        double capacidadKg = mayorCero();
        System.out.println("Ingrese consumo base (kWh/100km):");
        double consumeBase = mayorCero();
        System.out.println("Cuanta autonomia tiene el dron?");
        double autonomia = rd.nextDouble();
        System.out.println("Cuanto peso puede llevar el dron?");
        double pesoMax = mayorCero();
        System.out.println("Cuanta energía tiene?");
        double energia = mayorCero();
        Dron d1 = new Dron(matricula, capacidadKg, consumeBase, autonomia, pesoMax, energia);

        if(comprobarMatricula(matricula)) return false;

        vehiculo.add(d1);
        return true;
    }
    static boolean comprobarMatricula(String matricula){
        for(Vehiculo v : vehiculo){
            if(v.getMatricula().equals(matricula)){
                return true;
            }
        }
        return false;
    }

    static boolean comprobarCodigoEnvio(String codigo){
        for(Envio e : envio){
            if(e.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    static void altaVehiculo(){
        op = 0;
        System.out.println("Registrar nuevo vehiculo de reparto");
        System.out.println("=================");
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Furgoneta");
        System.out.println("2. Moto");
        System.out.println("3. Dron");
        op = rd.nextInt();
        switch (op){
            case 1:
                System.out.println("Registrar Furgoneta");
                if (crearFurgo()) {
                    System.out.println("Furgoneta registrada exitosamente");
                } else {
                    System.out.println("Error al registrar la furgoneta, es posible que la matricula ya esté registrada.");
                }
                break;
            case 2:
                System.out.println("Registrar Moto");
                    if (crearMoto()) {
                        System.out.println("Moto registrada exitosamente");
                    } else {
                        System.out.println("Error al registrar la moto, es posible que la matricula ya esté registrada.");
                    }
                break;
            case 3:
                System.out.println("Registrar Dron");
                    if (crearDron()) {
                        System.out.println("Dron registrado exitosamente");
                    } else {
                        System.out.println("Error al registrar el dron, es posible que la matricula ya esté registrada.");
                    }
                break;
            default:
                System.out.println("Opción no válida, intente de nuevo.");
        }
    }
    static void asignarEnvioAVehiculo() {
        if (envio.isEmpty()) {
            System.out.println("No hay envíos registrados.");
            return;
        }
        if (vehiculo.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        System.out.println("Ingrese el código del envío a asignar:");
        listarEnviosPendientes();
        String codigo = rd.next();
        Envio envioSeleccionado = null;
        for (Envio e : envio) {
            if (e.getCodigo().equals(codigo)) {
                envioSeleccionado = e;
                break;
            }
        }
        if (envioSeleccionado == null) {
            System.out.println("Código de envío no encontrado.");
            return;
        }
        System.out.println("Ingrese la matrícula del vehículo para asignar el envío:");
        listarVehiculosDisponibles();
        String matricula = rd.next();
        Vehiculo vehiculoSeleccionado = null;
        for (Vehiculo v : vehiculo) {
            if (v.getMatricula().equals(matricula)) {
                vehiculoSeleccionado = v;
                break;
            }
        }
        if (vehiculoSeleccionado == null) {
            System.out.println("Matrícula de vehículo no encontrada.");
            return;
        }
        if (asignarEnvioAVehiculo(envioSeleccionado, vehiculoSeleccionado)) {
            System.out.println("Envío asignado exitosamente.");
        } else {
            System.out.println("No se pudo asignar el envío al vehículo. Verifique la compatibilidad y disponibilidad.");
        }
    }

     static boolean asignarEnvioAVehiculo(Envio e, Vehiculo v) {
         if (e instanceof EnvioRefrigerado) {
             if (v instanceof Furgoneta) {
                 if (((Furgoneta) v).getRefrigerada()) {
                     System.out.println("Envío " + e.getCodigo() + " asignado a vehículo " + v.getMatricula());
                     v.setDisponible(false);
                     return true;
                 }
             }
         }
         if (e instanceof EnvioUrgente) {
             if (v instanceof MotoReparto) {
                 System.out.println("Envío " + e.getCodigo() + " asignado a vehículo " + v.getMatricula());
                 v.setDisponible(false);
                 return true;
             }
         }
         if (e instanceof EnvioEstandar) {
             if (v instanceof Furgoneta || v instanceof MotoReparto || v instanceof Dron) {
                 System.out.println("Envío " + e.getCodigo() + " asignado a vehículo " + v.getMatricula());
                 v.setDisponible(false);
                 return true;

             }
         }
         return false;
     }

    static void mostrarVehiculoMasRentable(){
        if(vehiculo.isEmpty()){
            System.out.println("No hay vehículos registrados.");
            return;
        }
        Vehiculo masRentable = vehiculo.get(0);
        for (Vehiculo v : vehiculo) {
            if (v.costePorKm() < masRentable.costePorKm()) {
                masRentable = v;
            }
        }
        System.out.println("El vehículo más rentable es: " + masRentable);
    }

    static void notificacion(){
        if(envio.isEmpty()){
            System.out.println("No hay envíos registrados.");
            return;
        }
        System.out.println("Ingrese el código del envío para enviar la notificación:");
        String codigo = rd.next();
        Envio envioSeleccionado = null;
        for (Envio e : envio) {
            if (e.getCodigo().equals(codigo)) {
                envioSeleccionado = e;
                break;
            }
        }
        if (envioSeleccionado == null) {
            System.out.println("Código de envío no encontrado.");
            return;
        }
        System.out.println("Seleccione el método de notificación:");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        int metodo = rd.nextInt();
        switch (metodo) {
            case 1:
                enviarNotificacion(envioSeleccionado, "email");
                return;
            case 2:
                enviarNotificacion(envioSeleccionado, "sms");
                return;
            default:
                System.out.println("Opción no válida, intente de nuevo.");
        }
    }

    static void enviarNotificacion(Envio e, String metodo){
        if(metodo.equalsIgnoreCase("email")){
            System.out.println("Enviando notificación por Email para el envío " + e.getCodigo());
        } else if(metodo.equalsIgnoreCase("sms")){
            System.out.println("Enviando notificación por SMS para el envío " + e.getCodigo());
        } else {
            System.out.println("Método de notificación no válido. Use 'Email' o 'SMS'.");
        }
    }

    public static void menu(){
        System.out.println("=== Gestión de Entregas === \n");
        do{
            op = 0;
            System.out.println("1. Registrar nuevo vehiculo de reparto (Furgoneta/Moto/Dron)");
            System.out.println("2. Alta envio (Estándar/Urgente/Refrigerado)");
            System.out.println("3. Listar vehiculos disponibles");
            System.out.println("4. Listar envios pendientes");
            System.out.println("5. Listar coste total de envíos");
            System.out.println("6. Asignar envío a vehículo (validando comptibilidad");
            System.out.println("7. Enviar notificación de estado (Email o SMS)");
            System.out.println("8. Mostrar vehículo más rentable (menor coste por km)");
            System.out.println("0. Salir");
            op = rd.nextInt();
            switch (op){
                case 1:
                    altaVehiculo();
                    break;
                case 2:
                    altaEnvio();
                    break;
                case 3:
                    listarVehiculosDisponibles();
                    break;
                case 4:
                    listarEnviosPendientes();
                    break;
                case 5:
                    listarCosteTotalEnvios();
                    break;
                case 6:
                    asignarEnvioAVehiculo();
                    break;
                case 7:
                    notificacion();
                    break;
                case 8:
                    mostrarVehiculoMasRentable();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }while(op != 0);


    }
    public static void main(String[] args) {
        menu();

    }
}
