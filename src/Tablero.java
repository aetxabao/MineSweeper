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
        // TODO: limpiarTablero
    }

    public boolean hayBombaEn(int fila, int columna) {
        return bombero.hayBombaEn(fila,columna);
    }

    public void calculaBombasVecinas(int fila, int columna) {
        // TODO: calculaBombasVecinas
    }

    public void descubreBombas() {
        // TODO: descubreBombas
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
