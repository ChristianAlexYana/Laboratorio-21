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
class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin(String nombre, int puntosVida, int fila, int columna, int longitudEspada) {
        super(nombre, puntosVida, 10, 8, fila, columna);
        this.longitudEspada = longitudEspada;
    }

    @Override
    public String toString() {
        return super.toString() + ", Longitud de espada: " + longitudEspada;
    }
}
class Caballero extends Soldado {
    private String armaActual;
    private boolean montado;

    public Caballero(String nombre, int puntosVida, int fila, int columna) {
        super(nombre, puntosVida, 13, 7, fila, columna);
        this.armaActual = "Espada";
        this.montado = true;
    }

    public void alternarArma() {
        this.armaActual = this.armaActual.equals("Espada") ? "Lanza" : "Espada";
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            armaActual = "Espada";
        }
    }

    public void montar() {
        if (!montado) {
            montado = true;
            armaActual = "Lanza";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Arma: " + armaActual + ", Montado: " + montado;
    }
}
class Lancero extends Soldado {
    private int longitudLanza;

    public Lancero(String nombre, int puntosVida, int fila, int columna, int longitudLanza) {
        super(nombre, puntosVida, 5, 10, fila, columna);
        this.longitudLanza = longitudLanza;
    }

    @Override
    public String toString() {
        return super.toString() + ", Longitud de lanza: " + longitudLanza;
    }
}
class Mapa {
    private String[][] tablero;
    private String tipoTerritorio;

    public Mapa(int size, String tipoTerritorio) {
        this.tablero = new String[size][size];
        this.tipoTerritorio = tipoTerritorio;
    }

    public String getTipoTerritorio() {
        return tipoTerritorio;
    }

    public void mostrarTablero() {
        for (String[] fila : tablero) {
            for (String celda : fila) {
                System.out.print((celda == null ? "." : celda) + " ");
            }
            System.out.println();
        }
    }

    public void colocarSoldado(Soldado soldado) {
        tablero[soldado.getFila()][soldado.getColumna()] = soldado.getNombre();
    }
}
