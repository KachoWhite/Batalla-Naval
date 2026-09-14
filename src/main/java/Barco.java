public class Barco {

    private String nombre;
    private int tamaño;
    private int impactos;

    public Barco(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.impactos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void recibirImpacto() {
        impactos++;
    }

    public boolean estaHundido() {
        return impactos >= tamaño;
    }
}