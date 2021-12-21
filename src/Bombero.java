import java.util.Random;

public class Bombero {

    private Random random;
    private Posicion[] posiciones;
    private int total;

    public Bombero(int max){
        // TODO: Bombero
    }

    public Posicion getPosicion(int i){
        // TODO: getPosicion
        return null;
    }

    public boolean hayBombaEn(int fila, int columna) {
        // TODO: hayBombaEn
        return false;
    }

    public void ponerBombas(int numFilas, int numColumnas, int numBombas) {
        if (numBombas >= numFilas*numColumnas){
            todoSonBombas(numFilas, numColumnas);
        }else if(numBombas >= numFilas * numColumnas / 2){
            todoSonBombas(numFilas, numColumnas);
            eliminarBombas(numFilas * numColumnas - numBombas);
        }else{
            ponerAlgunasBombas(numFilas, numColumnas, numBombas);
        }
    }

    private void ponerAlgunasBombas(int numFilas, int numColumnas, int numBombas) {
        // TODO: ponerAlgunasBombas
    }

    private void todoSonBombas(int numFilas, int numColumnas){
        // TODO: todoSonBombas
    }

    private void eliminarBombas(int n){
        // TODO: eliminarBombas
    }

    private void eliminarBomba(){
        // TODO: eliminarBomba
    }

    public String toString() {
        String s = "[";
        if (total > 0){
            s += posiciones[0].toString();
        }
        for (int i = 1; i < total; i++) {
            s += ", " + posiciones[i].toString();

        }
        s += "]";
        return s;
    }

}
