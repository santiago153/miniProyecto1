import java.awt.*;
import javax.swing.*;

class ImagenDeFondo extends JPanel{

    ImageIcon imagen;
    public ImagenDeFondo(){
    }
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("resources/fondo.jpg"));
        g.drawImage(imagen.getImage(),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
