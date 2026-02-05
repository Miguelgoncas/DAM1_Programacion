import java.util.Scanner;

public class MainCurso {
    static Scanner rd = new Scanner(System.in);
    static Curso curso;
    static void menu(){
        int op = 0;
        do{
            System.out.println("Bienvenido a este curso!");
            System.out.println("Que quieres hacer");
            System.out.println("1. Crear un curso");
            System.out.println("2. Añadir modulos al curso");
            System.out.println("3. Matricular alumno");
            System.out.println("4. Poner notas");
            System.out.println("5. Mostrar Alumnos");
            op = rd.nextInt();
            switch (op){
                case 1:
                    if(crearCurso()){
                        System.out.println("Curso creado correctamente!");
                    }
                    break;
                case 2:
                    if(agregarModulo()){
                        System.out.println("Módulo añadido correctamente");
                    } else {
                        System.out.println("No se ha podido añadir tu curso");
                    }
                    break;
                case 3:
                    if(matriAlum()){
                        System.out.println("Alumno matriculado!");
                    } else {
                        System.out.println("Error, no se ha podido matricular al alumno");
                    }
                    break;
                case 4:
                    if(ponerNotas()){
                        System.out.println("Nota añadida");
                    } else{
                        System.out.println("No se ha podido agregar la nota");
                    }
                    break;
                case 5:
                    if(mostrarAlum()){
                        System.out.println(curso.listarAlumnos());
                        System.out.println();
                    } else {
                        System.out.println("Error");
                    }


                default:
                    System.out.println("Número no válido");

            }

        }while (op != 7);
    }
    static boolean mostrarAlum(){
        if(curso != null){
            return true;
        }
        System.out.println("Primero crea el curso");
        return false;
    }

    static boolean ponerNotas(){

        if (curso == null) {
            System.out.println("Primero crea el curso");
            return false;
        }

        if (!curso.hayAlumnos()) {
            System.out.println("No hay alumnos matriculados");
            return false;
        }

        System.out.println("A quien quieres ponerle la nota? Añadir DNI");
        System.out.println(curso.listarAlumnos());

        String dni = rd.next();

        Alumno alumno = curso.buscarAlumno(dni);
        if (alumno == null) {
            System.out.println("El alumno no existe");
            return false;
        }

        System.out.println("En que módulo quieres ponerle nota?");
        System.out.println(curso.listarModulos());

        Modulo modulo;
        String mod;

        do {
            mod = rd.next();
            modulo = curso.buscarModulo(mod);

            if (modulo == null) {
                System.out.println("El módulo no existe");
            }
        } while (modulo == null);

        System.out.println("Que nota?");
        double nota;

        do {
            nota = rd.nextDouble();
        } while (nota < 0 || nota > 10);

        alumno.setNotas(modulo.getNombre(), nota);
        System.out.println("Nota puesta correctamente");

        return true;
    }



    static boolean matriAlum(){
        if(curso !=null){
            System.out.println("Como se llama tu alumno?");
            String nombre = rd.next();
            System.out.println("Cual es su DNI?");
            String dni = rd.next();
            Alumno a1 = new Alumno(nombre, dni);
            if(curso.matricularAlumno(a1)){
                return true;
            }
            return false;
        }
        System.out.println("Primero crear el curso!");
        return false;

    }

    static boolean agregarModulo(){
        if(curso != null){
            System.out.println("Nombre de tu módulo");
            String nombre = rd.next();
            System.out.println("Cuantas horas lectivas tiene el módulo");
            int horas = rd.nextInt();
            System.out.println("Quién imparte el módulo");
            String profesor = rd.next();
            Modulo m1 = new Modulo( nombre,  horas,  profesor);
            if(curso.agregarModulo(m1)){
                return true;
            }
            return false;
        }
        System.out.println("Primero crea el curso!");
        return false;

    }

    static boolean crearCurso(){
        System.out.println("Como se llama tu curso?");
        String nombre = rd.next();
        System.out.println("Quién es el tutor?");
        String tutor = rd.next();
        curso= new Curso(nombre, tutor);
        return true;
    }


    static void main(String[] args) {
        menu();
    }
}
