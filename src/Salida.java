public class Salida {

    public void pinta(int[][] matriz) {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;
        System.out.print("    ");
        for (int j = 0; j < numColumnas; j++) {
            System.out.printf(" %d  ", j);
        }
        System.out.println();
        System.out.print("   |");
        for (int j = 0; j < numColumnas; j++) {
            System.out.print("---|");
        }
        System.out.println();
        for (int i = 0; i < numFilas; i++) {
            System.out.printf(" %d |", i);
            for (int j = 0; j < numColumnas; j++) {
                if (matriz[i][j] == V.TAPADO){
                    System.out.print("   |");
                }else if (matriz[i][j] == V.BOMBA){
                    System.out.print(" X |");
                }else{
                    System.out.printf(" %d |", matriz[i][j]);
                }
            }
            System.out.println();
            System.out.print("   |");
            for (int j = 0; j < numColumnas; j++) {
                System.out.print("---|");
            }
            System.out.println();
        }
    }

}
