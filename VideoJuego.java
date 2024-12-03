import java.util.*;

class Soldado {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int posX;
    private int posY;

    public Soldado(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public int getVida() {
        return vida;
    }

    public void incrementarVida(int cantidad) {
        this.vida += cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin(String nombre, int vida) {
        super(nombre, vida, 10, 8);
        this.longitudEspada = new Random().nextInt(3) + 1;
    }

    public void crearMuroEscudos() {
        System.out.println(getNombre() + " está creando un muro de escudos.");
    }
    public int getLongitudEspada() {
        return longitudEspada;
    }

}