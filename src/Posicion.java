public class Posicion {

    private int fila;
    private int columna;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean equals(int fila, int columna) {
        return this.fila == fila && this.columna == columna;
    }

    public String toString() {
        return "{fila:" + this.fila + ",columna:" + this.columna + "}";
    }

}