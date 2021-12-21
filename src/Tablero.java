public class Tablero {

    private int numFilas;
    private int numColumnas;
    private int[][] matriz;
    private int numBombas;
    private Bombero bombero;
    private int descubiertos;
    private boolean bombasDescubiertas;

    public Tablero(int numFilas, int numColumnas, int numBombas){
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numBombas = Math.min(numBombas, numFilas*numColumnas);
        matriz = new int[numFilas][numColumnas];
        limpiarTablero();
        bombero = new Bombero(numFilas*numColumnas);
        bombero.ponerBombas(numFilas, numColumnas, numBombas);
        descubiertos = 0;
        bombasDescubiertas = false;
    }

    public int[][] getMatriz(){
        return matriz;
    }

    private void limpiarTablero(){
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                matriz[i][j] = V.TAPADO;
            }
        }
    }

    public boolean hayBombaEn(int fila, int columna) {
        return bombero.hayBombaEn(fila,columna);
    }

    public void calculaBombasVecinas(int fila, int columna) {
        int n = 0;
        for(int i=fila-1;i<=fila+1;i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (    (i >= 0) && (i <= numFilas - 1) &&
                        (j >= 0) && (j <= numColumnas - 1) &&
                        hayBombaEn(i, j)     ) {
                    n++;
                }
            }
        }
        matriz[fila][columna] = n;
        descubiertos++;
    }

    public void descubreBombas() {
        Posicion posicion;
        for (int i = 0; i < numBombas; i++) {
            posicion = bombero.getPosicion(i);
            matriz[posicion.getFila()][posicion.getColumna()] = V.BOMBA;
        }
        bombasDescubiertas = true;
    }

    public boolean estanDescubiertasTodasLasNoBombas() {
        return descubiertos + numBombas == numFilas * numColumnas;
    }

    public boolean haDescubiertoBombas() {
        return bombasDescubiertas;
    }

    public boolean finalizado() {
        return estanDescubiertasTodasLasNoBombas() || haDescubiertoBombas();
    }

}
