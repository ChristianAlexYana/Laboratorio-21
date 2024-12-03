class Soldado {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;


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

  
}