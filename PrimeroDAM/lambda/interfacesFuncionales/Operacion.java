package lambda.interfacesFuncionales;

/**
 * Interfaz funcional propia.
 *
 * @FunctionalInterface es opcional pero recomendable: el compilador
 * dará error si accidentalmente añades un segundo método abstracto.
 *
 * Solo puede tener UN método abstracto (aquí: calcular).
 * Puede tener métodos default o static sin problema.
 */
@FunctionalInterface
public interface Operacion {

    // El único método abstracto — aquí es donde va la lambda
    double calcular(double a, double b);

    // Método default permitido: no rompe la regla del único abstracto
    default void mostrarResultado(double a, double b) {
        System.out.println("Resultado: " + calcular(a, b));
    }
}
