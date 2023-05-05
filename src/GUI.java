import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class GUI extends JFrame {

    private JButton lanzar;
    private imagenDeFondo fondo;

    private JPanel contenedorDadosActivos, contenedorDadosInactivos, contenedorTarjetaPuntiacion, contenedorDadosUtilizados, contenedor1, contenedor2;
    public GUI(){
        initGui();

        this.setTitle("Craps");
        this.setSize(1100, 700);
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initGui(){

        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        Dado dado3 = new Dado();
        Dado dado4 = new Dado();
        Dado dado5 = new Dado();
        Dado dado6 = new Dado();
        Dado dado7 = new Dado();
        Dado dado8 = new Dado();
        Dado dado9 = new Dado();
        Dado dado10 = new Dado();

        lanzar = new JButton("lanzar");
        fondo = new imagenDeFondo();

        contenedor1 = new JPanel();
        contenedor1.setSize(1000,340);
        contenedor1.setOpaque(false);

        contenedor2 = new JPanel();
        contenedor2.setSize(1000,340);
        contenedor2.setOpaque(false);

        contenedorDadosActivos = new JPanel();
        contenedorDadosActivos.setOpaque(false);
        contenedorDadosActivos.setPreferredSize(new Dimension(500,300));
        contenedorDadosActivos.setBorder(BorderFactory.createTitledBorder("MIS DADOS ACTIVOS"));

        contenedorDadosInactivos = new JPanel();
        contenedorDadosInactivos.setOpaque(false);
        contenedorDadosInactivos.setPreferredSize(new Dimension(500,300));
        contenedorDadosInactivos.setBorder(BorderFactory.createTitledBorder("DADOS INACTIVOS"));

        contenedorTarjetaPuntiacion = new JPanel();
        contenedorTarjetaPuntiacion.setOpaque(false);
        contenedorTarjetaPuntiacion.setPreferredSize(new Dimension(500,300));
        TitledBorder borde = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "TARJETA DE PUNTUACION");
        borde.setTitleColor(Color.magenta);
        contenedorTarjetaPuntiacion.setBorder(borde);

        contenedorDadosUtilizados= new JPanel();
        contenedorDadosUtilizados.setOpaque(false);
        contenedorDadosUtilizados.setPreferredSize(new Dimension(500,300));
        contenedorDadosUtilizados.setBorder(BorderFactory.createTitledBorder("DADOS UTILIZADOS"));

        contenedorDadosActivos.add(lanzar);

        contenedor1.add(contenedorDadosActivos, BorderLayout.WEST);
        contenedor1.add(contenedorDadosInactivos, BorderLayout.EAST);
        contenedor2.add(contenedorTarjetaPuntiacion,BorderLayout.WEST);
        contenedor2.add(contenedorDadosUtilizados,BorderLayout.EAST);
        this.setContentPane(fondo);
        this.add(contenedor1,BorderLayout.NORTH);
        this.add(contenedor2, BorderLayout.SOUTH);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI myGui = new GUI();
            }
        });
    }

}