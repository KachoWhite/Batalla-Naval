import java.util.Scanner;

public class Jugador {

    private String nombre;
    private Tablero tablero;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tablero = new Tablero();
    }

    public String getNombre() {
        return nombre;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void colocarBarcos() {

        Scanner teclado = new Scanner(System.in);

        int[] tamaños = {3, 2, 1};

        for (int i = 0; i < tamaños.length; i++) {

            boolean colocado = false;

            while (!colocado) {

                System.out.println("\nColocando barco de tamaño " + tamaños[i]);

                System.out.print("Fila (A-E): ");
                char letra = teclado.next().toUpperCase().charAt(0);

                System.out.print("Columna (1-5): ");
                int columna = teclado.nextInt();

                System.out.print("Horizontal (H) o Vertical (V): ");
                char direccion = teclado.next().toUpperCase().charAt(0);

                int fila = letra - 'A';
                int col = columna - 1;

                if (fila >= 0 && fila < 5 &&
                    col >= 0 && col < 5) {

                    boolean horizontal = direccion == 'H';

                    colocado = tablero.colocarBarco(
                            fila,
                            col,
                            tamaños[i],
                            horizontal
                    );

                    if (!colocado) {
                        System.out.println("Posición inválida.");
                    } else {
                        System.out.println("Barco colocado.");
                        tablero.mostrarTablero(false);
                    }

                } else {
                    System.out.println("Coordenadas inválidas.");
                }
            }
        }
    }
}