import java.util.Random;

public class Maquina {

    private Tablero tablero;
    private Random random;

    public Maquina() {
        tablero = new Tablero();
        random = new Random();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void colocarBarcosAleatoriamente() {

        int[] tamaños = {3, 2, 1};

        for (int tamaño : tamaños) {

            boolean colocado = false;

            while (!colocado) {

                int fila = random.nextInt(5);
                int columna = random.nextInt(5);

                boolean horizontal = random.nextBoolean();

                colocado = tablero.colocarBarco(
                        fila,
                        columna,
                        tamaño,
                        horizontal
                );
            }
        }
    }

    public boolean disparar(Tablero tableroEnemigo) {

        int fila;
        int columna;

        do {
            fila = random.nextInt(5);
            columna = random.nextInt(5);

        } while (tableroEnemigo.yaDisparo(fila, columna));

        boolean acierto = tableroEnemigo.recibirDisparo(fila, columna);

        System.out.println(
                "La máquina disparó a "
                + (char) ('A' + fila)
                + (columna + 1)
        );

        if (acierto) {
            System.out.println("¡La máquina acertó!");
        } else {
            System.out.println("La máquina falló.");
        }

        return acierto;
    }
}