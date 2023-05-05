import javax.swing.*;
import java.awt.*;

public class imagenDeFondo extends JPanel{

    ImageIcon imagen;
    public imagenDeFondo(){
    }
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("resources/42.jpg"));
        g.drawImage(imagen.getImage(),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
