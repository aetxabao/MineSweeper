public class Juego {

    private Tablero tablero;
    private Entrada entrada;
    private Salida salida;

    private int numFilas;
    private int numColumnas;
    private int numBombas;

    public void run() {
        inicio();
        gameLoop();
        fin();
    }

    private void inicio() {
        entrada = new Entrada();
        salida = new Salida();
        numFilas = entrada.leerEntero("Numero de filas", 2, 10);
        numColumnas = entrada.leerEntero("Numero de columnas", 2, 10);
        numBombas = entrada.leerEntero("Numero de bombas", 2, numFilas*numColumnas);
        tablero = new Tablero(numFilas, numColumnas, numBombas);
        pinta();
    }

    private void gameLoop() {
        int fila, columna;
        while ( !tablero.finalizado() ) {

            fila = entrada.leerEntero("Numero de fila", 0, numFilas-1);
            columna = entrada.leerEntero("Numero de columna", 0, numColumnas-1);

            if (tablero.hayBombaEn(fila,columna)){
                tablero.descubreBombas();
            }else{
                tablero.calculaBombasVecinas(fila,columna);
            }

            pinta();
        }
    }

    private void fin() {
        if (tablero.estanDescubiertasTodasLasNoBombas()){
            System.out.println("Enhorabuena, has ganado. FIN.");
        }else{
            System.out.println("Lo sentimos, has perdido. FIN.");
        }
    }

    private void pinta() {
        salida.pinta(tablero.getMatriz());
    }

}
