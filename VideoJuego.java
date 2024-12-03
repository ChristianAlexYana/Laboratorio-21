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
