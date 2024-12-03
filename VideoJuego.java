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

class Mapa {
    private String[][] tablero = new String[10][10];
    private String territorio;
    private Random random = new Random();

    public Mapa() {
        String[] territorios = {"bosque", "campo abierto", "montaña", "desierto", "playa"};
        this.territorio = territorios[random.nextInt(territorios.length)];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = "__";
            }
        }
    }

    public String getTerritorio() {
        return territorio;
    }

    public void posicionarSoldados(Ejercito ejercito, boolean usarArrayList) {
        int soldadosPosicionados = 0;
        for (Soldado soldado : ejercito.getSoldados()) {
            int x, y;
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (!tablero[x][y].equals("__"));

            tablero[x][y] = soldado.getNombre();
            soldado.setPosicion(x, y);
            soldadosPosicionados++;
        }
    }

    public void mostrarTablero() {
        System.out.println("Estado del tablero:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%-6s", tablero[i][j]);
            }
            System.out.println();
        }
    }
}


public class VideoJuego {
    public static void main(String[] args) {
        Random random = new Random();
        String[] reinos = {"Inglaterra", "Francia", "Castilla-Aragón", "Moros", "Sacro Imperio Romano Germánico"};

        int reino1Index, reino2Index;
        do {
            reino1Index = random.nextInt(reinos.length);
            reino2Index = random.nextInt(reinos.length);
        } while (reino1Index == reino2Index);

        String reino1 = reinos[reino1Index];
        String reino2 = reinos[reino2Index];

        Ejercito ejercito1 = new Ejercito(reino1);
        Ejercito ejercito2 = new Ejercito(reino2);

        int cantidadEjercito1 = random.nextInt(10) + 1;
        int cantidadEjercito2 = random.nextInt(10) + 1;

        ejercito1.generarSoldados(cantidadEjercito1, 1);
        ejercito2.generarSoldados(cantidadEjercito2, 2);

        Mapa mapa = new Mapa();
        System.out.println("Territorio generado: " + mapa.getTerritorio());

        ejercito1.aplicarBeneficioPorTerritorio(mapa.getTerritorio());
        ejercito2.aplicarBeneficioPorTerritorio(mapa.getTerritorio());

        mapa.posicionarSoldados(ejercito1, false);
        mapa.posicionarSoldados(ejercito2, true);

        mapa.mostrarTablero();

        System.out.println("Resumen de los Ejércitos:");
        System.out.println("Ejército 1: " + reino1);
        mostrarResumenEjercito(ejercito1);
        System.out.println("Ejército 2: " + reino2);
        mostrarResumenEjercito(ejercito2);

        double vidaTotalEjercito1 = calcularVidaTotal(ejercito1);
        double vidaTotalEjercito2 = calcularVidaTotal(ejercito2);
        double totalVida = vidaTotalEjercito1 + vidaTotalEjercito2;

        double probabilidadEjercito1 = (vidaTotalEjercito1 / totalVida) * 100;
        double probabilidadEjercito2 = (vidaTotalEjercito2 / totalVida) * 100;

        System.out.printf("Ejército 1: %s: %.0f de vida total con %.2f%% de probabilidad de victoria",
                reino1, vidaTotalEjercito1, probabilidadEjercito1);
        System.out.printf("\nEjército 2: %s: %.0f de vida total con %.2f%% de probabilidad de victoria",
                reino2, vidaTotalEjercito2, probabilidadEjercito2);

        double aleatorio = random.nextDouble() * 100;
        String ganador = aleatorio <= probabilidadEjercito1 ? reino1 : reino2;

        System.out.printf("\nEl ganador es el ejército de: %s.", ganador);
        System.out.printf("\nYa que al generar los porcentajes de probabilidad de victoria "
                + "\nbasada en los niveles de vida de sus soldados y aplicando un experimento "
                + "\naleatorio salió vencedor. (Aleatorio generado: %.2f)", aleatorio);
    }

    public static void mostrarResumenEjercito(Ejercito ejercito) {
        int espadachines = 0, arqueros = 0, caballeros = 0, lanceros = 0;
        for (Soldado soldado : ejercito.getSoldados()) {
            if (soldado instanceof Espadachin) espadachines++;
            else if (soldado instanceof Arquero) arqueros++;
            else if (soldado instanceof Caballero) caballeros++;
            else if (soldado instanceof Lancero) lanceros++;
        }
        System.out.println("Cantidad total de soldados creados: " + ejercito.getSoldados().size());
        System.out.println("Espadachines: " + espadachines);
        System.out.println("Arqueros: " + arqueros);
        System.out.println("Caballeros: " + caballeros);
        System.out.println("Lanceros: " + lanceros);
    }

    public static double calcularVidaTotal(Ejercito ejercito) {
        return ejercito.getSoldados().stream().mapToDouble(Soldado::getVida).sum();
    }
}