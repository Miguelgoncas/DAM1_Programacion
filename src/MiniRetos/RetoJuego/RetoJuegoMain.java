package RetoJuego;

import RetoJuego.Method.PlayerMethod;
import RetoJuego.Model.Player;
import RetoJuego.Service.PlayerService;

public class RetoJuegoMain {
    public static void main(String[] args) {
        // Crear un jugador, quitar vida,30-40, comprobar esta vivo
        // Quitar 60 vida y comprobar si esta vivo

        // Definimos jugador
        Player player = new Player("Miguel" ,  100);

        // Definimos servicio que maneja al jugador
        PlayerService PlayerService = new PlayerService(player);

        // Mostramos datos jugador
        System.out.println("Jugador " + player.getName() + " con vida inicial de: " + player.getHealth());

        // Hacemos daño y comprobamos vida
        PlayerService.recibirDanio(player , 35);
        System.out.println("¿El jugador esta vivo? " + (PlayerService.estaVivo(player) ? "Sí" : "No") );

        // Volvemos a hacer daño y comprobamos vida
        PlayerService.recibirDanio(player , 80);
        System.out.println("¿El jugador esta vivo? " + (PlayerService.estaVivo(player) ? "Sí" : "No") );


    }
}
