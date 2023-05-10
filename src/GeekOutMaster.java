/**
 *
 */
import java.util.ArrayList;

public class GeekOutMaster {

    private Dado dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private ArrayList<Dado> dadosActivos = new ArrayList<Dado>();
    private ArrayList<Dado> dadosInactivos = new ArrayList<Dado>();
    private ArrayList<Dado> dadosUtilizados = new ArrayList<Dado>();

    private int puntos=0;

    public GeekOutMaster(){
        this.crearDados();
        this.iniciarArreglos();
    }



    //Funcion que me ayudara a sumar los puntos obtenidos en cada turno
    public int acumuladorPuntos(int unosPuntos){
        puntos =  puntos + unosPuntos;
        return puntos;
    }

    public void crearDados(){
        dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
        dado4 = new Dado();
        dado5 = new Dado();
        dado6 = new Dado();
        dado7 = new Dado();
        dado8 = new Dado();
        dado9 = new Dado();
        dado10 = new Dado();

    }

    public void iniciarArreglos(){
        dadosActivos.add(dado1);
        dadosActivos.add(dado2);
        dadosActivos.add(dado3);
        dadosActivos.add(dado4);
        dadosActivos.add(dado5);
        dadosActivos.add(dado6);
        dadosActivos.add(dado7);

        dadosInactivos.add(dado8);
        dadosInactivos.add(dado9);
        dadosInactivos.add(dado10);
    }


    //Lanza todos los dados que existe en la lista dados activos y en la lista de dados inactivos
    public void lanzarDados(){
        for (int i =0; i < dadosActivos.size(); i++ ) {
            (dadosActivos.get(i)).lanzar();
        }

        for (int i =0; i < dadosInactivos.size(); i++ ){
            (dadosInactivos.get(i)).lanzar();
        }
    }

    public ArrayList<Dado> getDadosActivos(){
        return dadosActivos;
    }

    public ArrayList<Dado> getDadosInactivos(){
        return dadosInactivos;
    }

    public ArrayList<Dado> getDadosUtilizados(){
        return dadosUtilizados;
    }

    public void agregarDado(ArrayList<Dado> unArreglo, Dado unDado)
    {
        unArreglo.add(unDado);
    }

    public void eliminarDado(ArrayList<Dado> unArreglo, Dado dadoAeliminar){
        unArreglo.remove(dadoAeliminar);
    }



}