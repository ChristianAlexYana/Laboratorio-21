import java.util.*;

abstract class Soldado {
    private String nombre;
    private int puntosVida;
    private int fila;
    private int columna;
    private int ataque;
    private int defensa;

    public Soldado(String nombre, int puntosVida, int ataque, int defensa, int fila, int columna) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.fila = fila;
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    @Override
    public String toString() {
        return nombre + " Vida: " + puntosVida + ", Ataque: " + ataque + ", Defensa: " + defensa +
               ", Posición: [" + fila + ", " + columna + "]";
    }
}
