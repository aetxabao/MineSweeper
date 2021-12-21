import java.util.Scanner;

public class Entrada {

    private Scanner teclado;

    public Entrada() {
        teclado = new Scanner(System.in);
    }

    public int leerEntero(String txt, int min, int max) {
        int v = -1;
        while (v < min || v > max) {
            System.out.printf("%s [%d-%d]: ", txt, min, max);
            v = teclado.nextInt();
        }
        teclado.nextLine();
        return v;
    }

}
