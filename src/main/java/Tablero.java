import java.util.Random;

public class Tablero {

    private char[][] matriz;

    public Tablero() {
        matriz = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = '~';
            }
        }
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public boolean colocarBarco(int fila, int columna, int tamaño, boolean horizontal) {

        // Comprobar que el barco entre en el tablero
        if (horizontal) {
            if (columna + tamaño > 5) {
                return false;
            }
        } else {
            if (fila + tamaño > 5) {
                return false;
            }
        }

        // Comprobar que no haya otro barco
        for (int i = 0; i < tamaño; i++) {

            int f = fila;
            int c = columna;

            if (horizontal) {
                c += i;
            } else {
                f += i;
            }

            if (matriz[f][c] == 'B') {
                return false;
            }
        }

        // Colocar el barco
        for (int i = 0; i < tamaño; i++) {

            int f = fila;
            int c = columna;

            if (horizontal) {
                c += i;
            } else {
                f += i;
            }

            matriz[f][c] = 'B';
        }

        return true;
    }

    public boolean recibirDisparo(int fila, int columna) {

        if (matriz[fila][columna] == 'B') {
            matriz[fila][columna] = 'X';
            return true;
        }

        if (matriz[fila][columna] == '~') {
            matriz[fila][columna] = 'O';
        }

        return false;
    }

    public boolean yaDisparo(int fila, int columna) {
        return matriz[fila][columna] == 'X'
                || matriz[fila][columna] == 'O';
    }

    public boolean quedanBarcos() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (matriz[i][j] == 'B') {
                    return true;
                }
            }
        }

        return false;
    }

    public void mostrarTablero(boolean ocultarBarcos) {

        System.out.println("  1 2 3 4 5");

        for (int i = 0; i < 5; i++) {

            System.out.print((char) ('A' + i) + " ");

            for (int j = 0; j < 5; j++) {

                char valor = matriz[i][j];

                if (ocultarBarcos && valor == 'B') {
                    System.out.print("~ ");
                } else {
                    System.out.print(valor + " ");
                }
            }

            System.out.println();
        }
    }
}