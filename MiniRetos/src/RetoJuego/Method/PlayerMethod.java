package RetoJuego.Method;

import RetoJuego.Model.Player;

public interface PlayerMethod {
    boolean estaVivo(Player player);
    void recibirDanio(Player player, int cantidad);


}
