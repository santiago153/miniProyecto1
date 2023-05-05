/**
 *
 */
class JuegoGeek {
    private Dado[] dadosActivos = new Dado[7];
    private Dado[] dadosInactivos = new Dado[3];
    private Dado[] dadosUtilizados = new Dado[10];
    private int puntos;


    /**
     *
     */
    public JuegoGeek() {
        for (int i = 0; i < 7; i++) {
            dadosActivos[i] = new Dado();
        }
        for (int i = 0; i < 3; i++) {
            dadosInactivos[i] = new Dado();
        }
        puntos = 0;
    }
    /**
     *
     */
    public void jugarTurno() {
        boolean turnoTerminado = false;
        while (!turnoTerminado) {
            for (Dado dado : dadosActivos) {
                if (dado != null) {
                    String cara = dado.getCaraActual();
                    if (cara.equals("42")) {
                        puntos++;
                        moverDado(dadosActivos, dadosUtilizados, dado);
                    } else if (cara.equals("Meeple")) {
                        relanzarDado(dadosActivos);
                        moverDado(dadosActivos, dadosUtilizados, dado);
                    } else if (cara.equals("Nave Espacial")) {
                        enviarDado(dadosActivos, dadosInactivos);
                        moverDado(dadosActivos, dadosUtilizados, dado);
                    } else if (cara.equals("Superhéroe")) {
                        voltearDado(dadosActivos);
                        moverDado(dadosActivos, dadosUtilizados, dado);
                    } else if (cara.equals("Corazón")) {
                        tomarDado(dadosInactivos, dadosActivos);
                        moverDado(dadosActivos, dadosUtilizados, dado);
                    } else if (cara.equals("Dragón")) {
                        if (esUltimoDadoActivo(dadosActivos)) {
                            puntos = 0;
                            turnoTerminado = true;
                            break;
                        }
                    }
                }
            }
            if (!turnoTerminado) {
                turnoTerminado = true;
                for (Dado dado : dadosActivos) {
                    if (dado != null) {
                        String cara = dado.getCaraActual();
                        if (!cara.equals("Dragón") && !cara.equals("Nave Espacial")) {
                            turnoTerminado = false;
                            break;
                        }
                    }
                }
            }
        }
    }


    /**
     *
     */
    private void moverDado(Dado[] desde, Dado[] hasta, Dado dado) {
        for (int i = 0; i < desde.length; i++) {
            if (desde[i] == dado) {
                desde[i] = null;
                break;
            }
        }
        for (int i = 0; i < hasta.length; i++) {
            if (hasta[i] == null) {
                hasta[i] = dado;
                break;
            }
        }
    }


    /**
     *
     */
    private void relanzarDado(Dado[] dados) {
        for (Dado dado : dados) {
            if (dado != null) {
                dado.lanzar();
                break;
            }
        }
    }

    /**
     *
     */
    private void enviarDado(Dado[] desde, Dado[] hasta) {
        for (int i = 0; i < desde.length; i++) {
            if (desde[i] != null) {
                moverDado(desde, hasta, desde[i]);
                break;
            }
        }
    }

    /**
     *
     */
    private void voltearDado(Dado[] dados) {
        for (Dado dado : dados) {
            if (dado != null) {
                String caraActual = dado.getCaraActual();
                if (caraActual.equals("42")) {
                    caraActual = "Dragón";
                } else if (caraActual.equals("Meeple")) {
                    caraActual = "Nave Espacial";
                } else if (caraActual.equals("Nave Espacial")) {
                    caraActual = "Meeple";
                } else if (caraActual.equals("Superhéroe")) {
                    caraActual = "Corazón";
                } else if (caraActual.equals("Corazón")) {
                    caraActual = "Superhéroe";
                } else if (caraActual.equals("Dragón")) {
                    caraActual = "42";
                }
                break;
            }
        }
    }

    /**
     *
     */
    private void tomarDado(Dado[] desde, Dado[] hasta) {
        for (int i = 0; i < desde.length; i++) {
            if (desde[i] != null) {
                moverDado(desde, hasta, desde[i]);
                break;
            }
        }
    }

    /**
     *
     */
    private boolean esUltimoDadoActivo(Dado[] dados) {
        int contador = 0;
        for (Dado dado : dados) {
            if (dado != null) {
                contador++;
            }
        }
        return contador == 1;
    }

    /**
     *
     */
    public int getPuntos() {

        return puntos;
    }
}

/**
 *
 */
class Juego {
    public static void main(String[] args) {
        JuegoGeek juego1 = new JuegoGeek();
        JuegoGeek juego2 = new JuegoGeek();
        for (int i = 0; i < 5; i++) {
            juego1.jugarTurno();
            juego2.jugarTurno();
        }
        int puntos1 = juego1.getPuntos();
        int puntos2 = juego2.getPuntos();
        System.out.println("Jugador 1: " + puntos1 + " puntos");
        System.out.println("Jugador 2: " + puntos2 + " puntos");
        if (puntos1 > puntos2) {
            System.out.println("¡Gana el Jugador 1!");
        } else if (puntos2 > puntos1) {
            System.out.println("¡Gana el Jugador 2!");
        } else {
            System.out.println("¡Empate!");
        }
    }
}