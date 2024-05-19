package org.example.interfaz;

import org.example.Controladores.Gestor;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PantallaRankingVinos extends JFrame{

    // ATRIBUTOS
    JPanel panelPrincipal = new JPanel();
    JPanel panelTitulo = new JPanel();
    JPanel panelContenido = new JPanel();
    JLabel titulo = new JLabel("BON VINO", SwingConstants.CENTER);
    JLabel subtitulo = new JLabel(":: Ranking de Vinos ::", SwingConstants.CENTER);

    //Componentes a mostar en el habilitar ventana
    JTextField lblFechaDesde = new JTextField("01-01-2000", 20);
    JTextField lblFechaHasta = new JTextField("01-01-2000", 20);
    JTextField campoTexto = new JTextField(20);
    JButton btnAceptar = new JButton("Aceptar");
    JButton btnCancelar = new JButton("Cancelar");


    //METODOS

    public void opcionGenerarRankingVinos(Gestor gestor){
        habilitarVentana();
        System.out.println("Llego opcGenerar pantalla");
        gestor.opcionGenerarRankingVinos(this);

    };
    public void habilitarVentana(){
        // Configuración de la ventana
        setTitle("Mi Ventana con Título y Subtítulo");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        panelPrincipal.setLayout(new BorderLayout());
        panelTitulo.setLayout(new GridLayout(2, 1)); // 2 filas, 1 columna

        // Crear y añadir título
        titulo.setFont(new Font("Arial", Font.BOLD, 35));
        panelTitulo.add(titulo);

        // Crear y añadir subtítulo
        subtitulo.setFont(new Font("Arial", Font.ITALIC, 20));
        panelTitulo.add(subtitulo);

        // Crear panel para otros componentes
        panelContenido.setLayout(new FlowLayout());


        //AÑADIR PANELES
        // Paneles al Principal
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelContenido, BorderLayout.CENTER);
        //principal a la Ventana
        add(panelPrincipal);

    };

    public void solicitarSelFechaDesdeYHasta(){
        panelContenido.add(lblFechaDesde);
        panelContenido.add(lblFechaHasta);
        panelContenido.add(btnAceptar);
        panelContenido.add(btnCancelar);

        System.out.println("Llego a add componentes");

        // Al clickear el btnAceptar Toma las fechas
        btnAceptar.addActionListener(e -> {
            Date fechaDesde = tomarSelFechaDesde();
            Date fechaHasta = tomarSelFechaHasta();
            System.out.println("fechaFormatoFecha desde: " + fechaDesde);
            System.out.println("fechaFormatoFecha hasta: " + fechaHasta);

            boolean validate = validarPeriodo(fechaDesde, fechaHasta);
            System.out.println(validate);
        });

        // Actualizar el contenido de la ventana
        //panelContenido.revalidate();
        //panelContenido.repaint();

    };

    public Date tomarSelFechaDesde() {
        String fechaTexto = lblFechaDesde.getText();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fecha = formato.parse(fechaTexto);
            return fecha;
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // O manejar el error de otra forma, como lanzar una excepción personalizada
        }
    }


    public Date tomarSelFechaHasta() {
        String fechaTexto = lblFechaHasta.getText();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fecha = formato.parse(fechaTexto);
            return fecha;
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // O manejar el error de otra forma, como lanzar una excepción personalizada
        }
    }

    public boolean validarPeriodo(Date fechaDesde, Date fechaHasta){

        if (fechaDesde.before(fechaHasta)) {
            System.out.println("La fecha es correcta");
            return true;
        }
        System.out.println("La fecha no es correcta");
        return false;
    };


}
