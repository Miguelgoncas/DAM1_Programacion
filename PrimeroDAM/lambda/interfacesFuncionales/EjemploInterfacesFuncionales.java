package lambda.interfacesFuncionales;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Las interfaces funcionales son interfaces con UN SOLO método abstracto.
 * Permiten usar expresiones lambda y referencias a métodos en su lugar.
 *
 * Java ya tiene muchas predefinidas en java.util.function:
 *   - Function<T, R>   → recibe T, devuelve R
 *   - Predicate<T>     → recibe T, devuelve boolean
 *   - Consumer<T>      → recibe T, no devuelve nada (void)
 *   - Supplier<T>      → no recibe nada, devuelve T
 *   - UnaryOperator<T> → recibe T, devuelve T  (Function<T,T> simplificado)
 *   - BiFunction<T,U,R>→ recibe T y U, devuelve R
 */
public class EjemploInterfacesFuncionales {

    public static void main(String[] args) {

        // ─── 1. FUNCTION<T, R> ───────────────────────────────────────────────
        // Transforma un valor de tipo T en otro de tipo R.
        // Método que se implementa: R apply(T t)

        Function<String, Integer> longitudPalabra = palabra -> palabra.length();
        System.out.println("Longitud de 'Hola': " + longitudPalabra.apply("Hola")); // 4

        // También podemos encadenar funciones con andThen():
        // primero calcula la longitud, luego multiplica por 2
        Function<String, Integer> dobleDeLongitud = longitudPalabra.andThen(n -> n * 2);
        System.out.println("Doble longitud de 'Hola': " + dobleDeLongitud.apply("Hola")); // 8


        // ─── 2. PREDICATE<T> ─────────────────────────────────────────────────
        // Evalúa una condición sobre T y devuelve true/false.
        // Método que se implementa: boolean test(T t)

        Predicate<Integer> esMayorDeEdad = edad -> edad >= 18;
        System.out.println("¿25 es mayor de edad? " + esMayorDeEdad.test(25)); // true
        System.out.println("¿15 es mayor de edad? " + esMayorDeEdad.test(15)); // false

        // Podemos combinar predicados con and(), or(), negate()
        Predicate<Integer> esMenorDe65 = edad -> edad < 65;
        Predicate<Integer> edadLaboral = esMayorDeEdad.and(esMenorDe65);
        System.out.println("¿40 en edad laboral? " + edadLaboral.test(40)); // true
        System.out.println("¿70 en edad laboral? " + edadLaboral.test(70)); // false

        // Uso típico: filtrar listas
        List<String> nombres = Arrays.asList("Ana", "Borja", "Carmen", "David");
        Predicate<String> nombreLargo = nombre -> nombre.length() > 4;
        nombres.stream()
               .filter(nombreLargo)
               .forEach(n -> System.out.println("Nombre largo: " + n));


        // ─── 3. CONSUMER<T> ──────────────────────────────────────────────────
        // Recibe un valor y hace algo con él, pero NO devuelve nada.
        // Método que se implementa: void accept(T t)

        Consumer<String> saludar = nombre -> System.out.println("Hola, " + nombre + "!");
        saludar.accept("Miguel"); // Hola, Miguel!

        // Uso típico: recorrer una lista con forEach
        nombres.forEach(saludar);

        // andThen() encadena dos consumers: primero uno, luego otro
        Consumer<String> despedir = nombre -> System.out.println("Adiós, " + nombre + "!");
        Consumer<String> saludarYDespedir = saludar.andThen(despedir);
        saludarYDespedir.accept("Elena");


        // ─── 4. SUPPLIER<T> ──────────────────────────────────────────────────
        // No recibe nada y devuelve un valor de tipo T (es un "proveedor").
        // Método que se implementa: T get()

        Supplier<String> mensajeBienvenida = () -> "Bienvenido al sistema";
        System.out.println(mensajeBienvenida.get());

        // Útil para crear objetos de forma perezosa (lazy)
        Supplier<Producto> nuevoProducto = () -> new Producto("Teclado", 49.99);
        Producto p = nuevoProducto.get();
        System.out.println("Producto creado: " + p);


        // ─── 5. UNARYOPERATOR<T> ─────────────────────────────────────────────
        // Como Function<T,T>: recibe y devuelve el mismo tipo.
        // Método que se implementa: T apply(T t)

        UnaryOperator<String> aMayusculas = texto -> texto.toUpperCase();
        System.out.println(aMayusculas.apply("hola mundo")); // HOLA MUNDO

        // Útil con List.replaceAll() para transformar todos los elementos
        List<String> palabras = Arrays.asList("java", "lambda", "stream");
        palabras.replaceAll(aMayusculas);
        System.out.println(palabras); // [JAVA, LAMBDA, STREAM]


        // ─── 6. BIFUNCTION<T, U, R> ──────────────────────────────────────────
        // Como Function pero recibe DOS parámetros de tipos distintos.
        // Método que se implementa: R apply(T t, U u)

        BiFunction<String, Double, Producto> crearProducto =
                (nombre, precio) -> new Producto(nombre, precio);

        Producto monitor = crearProducto.apply("Monitor", 299.99);
        System.out.println("Creado con BiFunction: " + monitor);


        // ─── 7. INTERFAZ FUNCIONAL PROPIA ────────────────────────────────────
        // Puedes crear tus propias interfaces funcionales con @FunctionalInterface.
        // Solo necesitan tener UN método abstracto.

        Operacion suma   = (a, b) -> a + b;
        Operacion resta  = (a, b) -> a - b;
        Operacion multi  = (a, b) -> a * b;

        System.out.println("10 + 3 = " + suma.calcular(10, 3));
        System.out.println("10 - 3 = " + resta.calcular(10, 3));
        System.out.println("10 * 3 = " + multi.calcular(10, 3));
    }
}
