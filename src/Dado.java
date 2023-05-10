import javax.swing.*;
import java.util.Random;


public class Dado {
    private String[] caras = {"42", "Meeple", "Nave Espacial", "Superhéroe", "Corazón", "Dragón"};
    private String caraActual,caraContraria,caraAuxiliar;
    private JButton boton;
    private ImageIcon imagenDeDado;
    private Random random = new Random();
    public Dado(){
    }

    //se le da un valor a el dado
    public void lanzar() {
        //le doy un valor a la cara actual
        int numero = random.nextInt(6);
        caraActual = caras[numero];
    }

    //se obtiene la cara contraria del dado
    public String getCaraContaria(){
        //Determino cual es la cara contraria que corresponde a la cara Actual
        switch (caraActual){
            case "42": caraContraria = "Corazon";
            case "Corazón": caraContraria = "42";
            case "Dragón": caraContraria = "Superhéroe";
            case "Superhéroe": caraContraria = "Dragon";
            case "Nave Espacial": caraContraria = "Meeple";
            case "Meeple": caraContraria = "Nave Espacial";
        }
        return caraContraria;
    }

    //cambia el lado de la cara del dado a su cara contraria
    public void cambiarCara(){
        caraAuxiliar = caraContraria;
        caraContraria = caraActual;
        caraActual = caraAuxiliar;
    }

    //se le asigna una cara-imagen a un dado
    public ImageIcon obtenerImagenDado(){

        if (this.getCaraActual()=="42"){
            imagenDeDado = new ImageIcon(getClass().getResource("resources/42.jpg"));
        }
        else if (this.getCaraActual()=="Corazón") {
            imagenDeDado = new ImageIcon(getClass().getResource("resources/Corazon.jpg"));
        }
        else if (this.getCaraActual()=="Meeple") {
            imagenDeDado = new ImageIcon(getClass().getResource("resources/Meeple.jpg"));
        }
        else if (this.getCaraActual()=="Dragón") {
            imagenDeDado = new ImageIcon(getClass().getResource("resources/Dragon.jpg"));
        }
        else if (this.getCaraActual()=="Superhéroe") {
            imagenDeDado = new ImageIcon(getClass().getResource("resources/Super heroe.jpg"));
        }
        else if (this.getCaraActual()=="Nave Espacial") {
            imagenDeDado = new ImageIcon(getClass().getResource("resources/Cohete.jpg"));
        }

        return imagenDeDado;
    }

    //convierte la imagen de el dado un boton
    public JButton convertirABoton(){
        boton = new JButton();
        boton.setIcon(this.obtenerImagenDado());
        return boton;
    }

    public JButton getBoton(){
        return boton;
    }

    public String getCaraActual(){
        return caraActual;
    }

    public String getCaraContraria(){
        return caraContraria;
    }

    public String setCaraActual(String cara){
        caraActual = cara;
        return caraActual;
    }


}
