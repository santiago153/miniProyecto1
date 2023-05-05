import java.util.Random;


public class Dado {
    private String[] caras = {"42", "Meeple", "Nave Espacial", "Superhéroe", "Corazón", "Dragón"};
    private String caraActual,caraContraria;
    private Random random = new Random();
    public Dado(){
    }

    public void lanzar(){
        //le doy un valor a la cara actual
        int numero = random.nextInt(6);
        caraActual = caras[numero];

        //Determino cual es la cara contraria que corresponde a la cara Actual
        switch (caraActual){
            case "42": caraContraria = "Corazon";
            case "Corazon": caraContraria = "42";
            case "Dragon": caraContraria = "Superhéroe";
            case "Superhéroe": caraContraria = "Dragon";
            case "Nave Espacial": caraContraria = "Meeple";
            case "Meeple": caraContraria = "Nave Espacial";
        }
    }

    public String getCaraActual(){
        return caraActual;
    }

    public String getCaraContraria(){
        return caraContraria;
    }

}
