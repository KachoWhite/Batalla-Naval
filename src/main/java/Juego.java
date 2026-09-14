import java.util.Scanner;

public class Juego {

    private Jugador jugador;
    private Maquina maquina;
    private Scanner teclado;

    public Juego() {
        jugador = new Jugador("Agustin");
        maquina = new Maquina();
        teclado = new Scanner(System.in);
    }

    public void iniciarJuego() {

        System.out.println("================================");
        System.out.println("       BATALLA NAVAL");
        System.out.println("================================");

        System.out.println("\nColocá tus barcos:");

        jugador.colocarBarcos();

        System.out.println("\nLa máquina está colocando sus barcos...");
        maquina.colocarBarcosAleatoriamente();

        System.out.println("\n¡Todos los barcos fueron colocados!");

        while (true) {

            turnoJugador();

            if (!maquina.getTablero().quedanBarcos()) {
                System.out.println("\n¡GANASTE!");
                break;
            }

            turnoMaquina();

            if (!jugador.getTablero().quedanBarcos()) {
                System.out.println("\n¡LA MÁQUINA GANÓ!");
                break;
            }
        }
    }

    private void turnoJugador() {

        System.out.println("\n================================");
        System.out.println("           TU TURNO");
        System.out.println("================================");

        System.out.println("\nTu tablero:");
        jugador.getTablero().mostrarTablero(false);

        System.out.println("\nTablero enemigo:");

        maquina.getTablero().mostrarTablero(true);

        System.out.print("\nElegí una fila (A-E): ");
        char letra = teclado.next().toUpperCase().charAt(0);

        System.out.print("Elegí una columna (1-5): ");
        int columna = teclado.nextInt();

        int fila = letra - 'A';
        int col = columna - 1;

        if (fila < 0 || fila >= 5 || col < 0 || col >= 5) {
            System.out.println("Coordenadas inválidas.");
            return;
        }

        if (maquina.getTablero().yaDisparo(fila, col)) {
            System.out.println("Ya disparaste a esa posición.");
            return;
        }

        boolean acierto =
                maquina.getTablero().recibirDisparo(fila, col);

        if (acierto) {
            System.out.println("¡ACERTASTE!");
        } else {
            System.out.println("Fallaste.");
        }
    }

    private void turnoMaquina() {

        System.out.println("\n================================");
        System.out.println("         TURNO DE LA MÁQUINA");
        System.out.println("================================");

        maquina.disparar(jugador.getTablero());

        System.out.println("\nTu tablero después del disparo:");

        jugador.getTablero().mostrarTablero(false);
    }
}