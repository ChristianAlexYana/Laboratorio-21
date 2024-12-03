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

class Arquero extends Soldado {
    private int flechas;

    public Arquero(String nombre, int vida) {
        super(nombre, vida, 7, 3);
        this.flechas = new Random().nextInt(10) + 10;
    }
    public void dispararFlecha() {
        if (flechas > 0) {
            flechas--;
            System.out.println(getNombre() + " dispara una flecha. Flechas restantes: " + flechas);
        } else {
            System.out.println(getNombre() + " no tiene flechas.");
        }
    }

    public int getFlechas() {
        return flechas;
    }
}

class Caballero extends Soldado {
    private String arma;
    private boolean montado;

    public Caballero(String nombre, int vida) {
        super(nombre, vida, 13, 7);
        this.arma = "espada";
        this.montado = false;
    }
    public void montar() {
        if (!montado) {
            montado = true;
            arma = "lanza";
            System.out.println(getNombre() + " monta y cambia su arma a " + arma + ".");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            arma = "espada";
            System.out.println(getNombre() + " desmonta y cambia su arma a " + arma + ".");
        }
    }

    public String getArma() {
        return arma;
    }

    public boolean estaMontado() {
        return montado;
    }

    public void envestir() {
        int golpes = montado ? 3 : 2;
        System.out.println(getNombre() + " realiza una envestida con " + golpes + " golpes.");
    }
}

class Lancero extends Soldado {
    private int longitudLanza;

    public Lancero(String nombre, int vida) {
        super(nombre, vida, 5, 10);
        this.longitudLanza = new Random().nextInt(3) + 2;
    }

    public void schiltrom() {
        System.out.println(getNombre() + " está en formación schiltrom.");
    }

    public int getLongitudLanza() {
        return longitudLanza;
    }
}
class Ejercito {
    private String reino;
    private ArrayList<Soldado> soldados;

    public Ejercito(String reino) {
        this.reino = reino;
        this.soldados = new ArrayList<>();
    }

    public void generarSoldados(int cantidad, int tipoEjercito) {
        Random rand = new Random();
        for (int i = 1; i <= cantidad; i++) {
            Soldado soldado;
            int tipoSoldado = rand.nextInt(4);
            String nombre = tipoEjercito + ":";

            switch (tipoSoldado) {
                case 0:
                    soldado = new Espadachin(nombre + "E" + i, rand.nextInt(3) + 8);
                    break;
                case 1:
                    soldado = new Arquero(nombre + "A" + i, rand.nextInt(3) + 3);
                    break;
                case 2:
                    soldado = new Caballero(nombre + "C" + i, rand.nextInt(3) + 10);
                    break;
                default:
                    soldado = new Lancero(nombre + "L" + i, rand.nextInt(3) + 5);
                    break;
            }

            soldados.add(soldado);
        }
    }

    public void aplicarBeneficioPorTerritorio(String territorio) {
        for (Soldado s : soldados) {
            if ((reino.equals("Inglaterra") && territorio.equals("bosque")) ||
                (reino.equals("Francia") && territorio.equals("campo abierto")) ||
                (reino.equals("Castilla-Aragón") && territorio.equals("montaña")) ||
                (reino.equals("Moros") && territorio.equals("desierto")) ||
                (reino.equals("Sacro Imperio Romano Germánico") &&
                    (territorio.equals("bosque") || territorio.equals("playa") || territorio.equals("campo abierto")))) {
                s.incrementarVida(1);
            }
        }
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public String getReino() {
        return reino;
    }
}
