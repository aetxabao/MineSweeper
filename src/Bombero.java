import java.util.Random;

public class Bombero {

    private Random random;
    private Posicion[] posiciones;
    private int total;

    public Bombero(int max){
        random = new Random();
        posiciones = new Posicion[max];
        total = 0;
    }

    public Posicion getPosicion(int i){
        return (i<total)?posiciones[i]:null;
    }

    public boolean hayBombaEn(int fila, int columna) {
        for (int i = 0; i < total; i++) {
            if (posiciones[i].equals(fila,columna)){
                return true;
            }
        }
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
        int fila, columna;
        total = 0;
        while (total<numBombas) {
            fila = random.nextInt(numFilas);
            columna = random.nextInt(numColumnas);
            if (!hayBombaEn(fila,columna)){
                posiciones[total] = new Posicion(fila, columna);
                total++;
            }
        }
    }

    private void todoSonBombas(int numFilas, int numColumnas){
        total = 0;
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                posiciones[total] = new Posicion(i,j);
                total++;
            }
        }
    }

    private void eliminarBombas(int n){
        for (int i = 0; i < n; i++) {
            eliminarBomba();
        }
    }

    private void eliminarBomba(){
        if (total>0){
            int x = random.nextInt(total);
            for (int i = x+1; i < total; i++) {
                posiciones[i-1] = posiciones[i];
            }
            posiciones[total-1] = null;
            total--;
        }
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
