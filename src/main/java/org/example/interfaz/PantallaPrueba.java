package org.example.interfaz;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;


public class PantallaPrueba extends JFrame {

    //atributos prueba
    String fechaDesde = "noDate";
    String fechaHasta = "No Date";
    JPanel panelPrincipal = new JPanel();
    JPanel panelTitulo = new JPanel();
    JLabel titulo = new JLabel("BON VINO", SwingConstants.CENTER);
    JLabel subtitulo = new JLabel("Ranking de Vinos", SwingConstants.CENTER);
    JPanel panelContenido = new JPanel();

    //otros componentes
    JLabel etiqueta = new JLabel("Etiqueta:");

    //COMPONENTES PARA LAS FUNCIONES

    JTextField lblFechaDesde = new JTextField("01-01-2000", 20);
    JTextField lblFechaHasta = new JTextField("01-01-2000", 20);
    JTextField campoTexto = new JTextField(20);
    JButton btnAceptar = new JButton("Aceptar");
    JButton boton = new JButton("Enviar");
    JTextArea areaTexto = new JTextArea(5, 30);

    public PantallaPrueba() {
        // Configuración de la ventana

        setTitle("Mi Ventana con Título y Subtítulo");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        panelPrincipal.setLayout(new BorderLayout());
        panelTitulo.setLayout(new GridLayout(2, 1)); // 2 filas, 1 columna

        // Crear y añadir título

        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        panelTitulo.add(titulo);

        // Crear y añadir subtítulo

        subtitulo.setFont(new Font("Arial", Font.ITALIC, 18));
        panelTitulo.add(subtitulo);

        // Añadir el panel de título al panel principal
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

        // Crear panel para otros componentes

        panelContenido.setLayout(new FlowLayout());

        // Crear y añadir otros componentes


        panelContenido.add(etiqueta);
        panelContenido.add(campoTexto);
        panelContenido.add(boton);
        panelContenido.add(new JScrollPane(areaTexto));

        // Añadir el panel de contenido al panel principal
        panelPrincipal.add(panelContenido, BorderLayout.CENTER);

        // Añadir el panel principal a la ventana
        add(panelPrincipal);

        solicitarSelFechaDesdeYHasta();
        tomarFechas();

        System.out.println("FechaDesde: " + fechaDesde);
        System.out.println("fecha Hasta: " + fechaHasta);


        // Manejar evento del botón
        boton.addActionListener(e -> {
            String texto = campoTexto.getText();
            System.out.println(texto);
            areaTexto.append("Texto ingresado: " + texto + "\n");
            campoTexto.setText(""); // Limpiar el campo de texto
        });
        setVisible(true);

    };

    public void opcionGenerarRankingVinos(){


    }

    public void solicitarSelFechaDesdeYHasta(){
        panelContenido.add(lblFechaDesde);
        panelContenido.add(lblFechaHasta);
        panelContenido.add(btnAceptar);
    }
    public void tomarFechas(){
        btnAceptar.addActionListener(e -> {
            fechaDesde = tomarSelFechaHasta();
            fechaHasta = tomarSelFechaDesde();

            System.out.println("FechaDesde: " + fechaDesde);
            System.out.println("fecha Hasta: " + fechaHasta);

        });
    }
    public String tomarSelFechaDesde(){

        return lblFechaDesde.getText();

    }

    public String tomarSelFechaHasta(){

            String fechaHasta = lblFechaHasta.getText();
            return fechaHasta;

    }

}
