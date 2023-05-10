import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {

    private int clicslanzar=0;
    private GeekOutMaster juego;

    private JPanel contenedorDadosActivos;
    private JPanel contenedorDadosInactivos;
    private JPanel contenedorDadosUtilizados;

    public GUI(){
        initGui();

        this.setTitle("Craps");
        this.setSize(1100, 700);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initGui(){


        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("resources/tablaDePuntuacion.png"));
        JLabel labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 500, 300);



        juego = new GeekOutMaster();

        JButton lanzar = new JButton("lanzar");

        ImagenDeFondo fondo = new ImagenDeFondo();

        JPanel contenedor1 = new JPanel();
        contenedor1.setSize(1000,340);
        contenedor1.setOpaque(false);

        JPanel contenedor2 = new JPanel();
        contenedor2.setSize(1000,340);
        contenedor2.setOpaque(false);

        contenedorDadosActivos = new JPanel();
        contenedorDadosActivos.setOpaque(false);
        contenedorDadosActivos.setPreferredSize(new Dimension(500,300));
        contenedorDadosActivos.setBorder(BorderFactory.createTitledBorder("MIS DADOS ACTIVOS"));
        //contenedorDadosActivos.setLayout(null);
        /*contenedorDadosActivos.add(dado1.convertirABoton());
         */


        contenedorDadosInactivos = new JPanel();
        contenedorDadosInactivos.setOpaque(false);
        contenedorDadosInactivos.setPreferredSize(new Dimension(500,300));
        contenedorDadosInactivos.setBorder(BorderFactory.createTitledBorder("DADOS INACTIVOS"));
        /*contenedorDadosInactivos.add(dado8.convertirABoton());
         */


        JPanel contenedorTarjetaPuntiacion = new JPanel();
        //contenedorTarjetaPuntiacion.setLayout(null);
        contenedorTarjetaPuntiacion.setOpaque(false);
        contenedorTarjetaPuntiacion.setPreferredSize(new Dimension(500,300));
        TitledBorder borde = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "TARJETA DE PUNTUACION");
        borde.setTitleColor(Color.magenta);
        contenedorTarjetaPuntiacion.setBorder(borde);
        contenedorTarjetaPuntiacion.add(labelFondo);


        contenedorDadosUtilizados= new JPanel();
        contenedorDadosUtilizados.setOpaque(false);
        contenedorDadosUtilizados.setPreferredSize(new Dimension(500,300));
        contenedorDadosUtilizados.setBorder(BorderFactory.createTitledBorder("DADOS UTILIZADOS"));

        //Esto sucede a el presionar por privera vez el boton lanzar  (se agregan los dados a el panel de activos)
        lanzar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clicslanzar+=1;
                if (clicslanzar==1) {
                    juego.lanzarDados();
                    //Se agregan y se muestran los dados en el panel de dados activos
                    for (int i = 0; i < (juego.getDadosActivos()).size(); i++) {
                        Dado unDado = (juego.getDadosActivos()).get(i);
                        JButton unBoton = unDado.convertirABoton();
                        //JButton unBoton = ((juego.getDadosActivos()).get(i)).convertirABoton();
                        contenedorDadosActivos.add(unBoton);
                        contenedorDadosActivos.revalidate();
                        contenedorDadosActivos.repaint();


                        String cara = unDado.getCaraActual();
                        //agrego un listener a cada boton de dado creado
                        //(((juego.getDadosActivos()).get(i)).getBoton()).addActionListener(new ActionListener() {
                        unBoton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                // Mover el botón del primer panel al segundo panel
                                contenedorDadosActivos.remove(unBoton);
                                contenedorDadosUtilizados.add(unBoton);

                                // Actualizar la interfaz gráfica de usuario
                                contenedorDadosActivos.revalidate();
                                contenedorDadosActivos.repaint();
                                contenedorDadosUtilizados.revalidate();
                                contenedorDadosUtilizados.repaint();


                                if (contenedorDadosUtilizados.getComponentCount() == 7) {
                                    Component[] botones = contenedorDadosUtilizados.getComponents();
                                    for (Component boton : botones) {
                                        contenedorDadosUtilizados.remove(boton);
                                        contenedorDadosActivos.add(boton);
                                    }

                                    // Actualizar la interfaz gráfica de usuario
                                    contenedorDadosActivos.revalidate();
                                    contenedorDadosActivos.repaint();
                                    contenedorDadosUtilizados.revalidate();
                                    contenedorDadosUtilizados.repaint();



                                }
                            }
                        });

                    }
                    //Se agregan y se muestran los dados en el panel de Dados inactivos
                    for (int i = 0; i < (juego.getDadosInactivos()).size(); i++) {
                        contenedorDadosInactivos.add(((juego.getDadosInactivos()).get(i)).convertirABoton());
                        contenedorDadosInactivos.revalidate();
                        contenedorDadosInactivos.repaint();
                    }
                }
            }
        });

        //contenedorDadosActivos.setLayout(new FlowLayout());
        contenedorDadosActivos.add(lanzar);
        //lanzar.setBounds(100,100,100,1000);

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