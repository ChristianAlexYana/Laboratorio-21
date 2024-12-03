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
