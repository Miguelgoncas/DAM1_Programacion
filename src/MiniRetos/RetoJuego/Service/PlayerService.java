package RetoJuego.Service;

import RetoJuego.Method.PlayerMethod;
import RetoJuego.Model.Player;

import java.util.Random;

public class PlayerService implements PlayerMethod {
    Random rd = new Random();

    public PlayerService(Player player) {
    }

    @Override
    public  boolean estaVivo(Player player) {
    if( player.getHealth() > 0)
        return true;

        return false;
    }

    @Override
    public void recibirDanio(Player player , int cantidad) {
        int nuevaSalud = player.getHealth() - cantidad;
        player.setHealth(nuevaSalud);
        System.out.println("Auch, me has quitado " + cantidad);
    }

}
