package org.example.interfaz;
import org.example.Controladores.GestorRankingVinos;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PantallaRankingVinos extends JFrame{

    // ATRIBUTOS
    private JPanel panelPrincipal = new JPanel();
    private JPanel panelTitulo = new JPanel();
    private JPanel panelContenido = new JPanel();
    private JPanel panelSelResena = new JPanel();
    private JLabel titulo = new JLabel("BON VINO", SwingConstants.CENTER);
    private JLabel subtitulo = new JLabel(":: Ranking de Vinos ::", SwingConstants.CENTER);

    //Componentes a mostar en el habilitar ventana
    private JTextField lblFechaDesde = new JTextField("01-01-2000", 20);
    private JTextField lblFechaHasta = new JTextField("01-01-2000", 20);
    private JLabel lblTextFechaDesde = new JLabel("Fecha Inicio: ");
    private JLabel lblTextFechaHasta = new JLabel("Fecha de Fin: ");
    private JButton btnAceptar = new JButton("Aceptar");
    private JButton btnSelectResena = new JButton("Seleccionar");
    private JButton btnSelectTipoVisualizacion = new JButton("Seleccionar");
    private JButton btnConfirmar = new JButton("CONFIRMAR");
    private JButton btnCancelar = new JButton("Cancelar");

    //Pedir Opciones
    private JComboBox<String> comboOpcResena;
    private JLabel lblTextOpcResena = new JLabel("Seleccione un Tipo de Reseña: ");
    private JComboBox<String> comboOpcVisualizacion;
    private JLabel lblTextOpcVisualizacion = new JLabel("Seleccione un Tipo de Visualización: ");


    //METODOS

    public void opcionGenerarRankingVinos(GestorRankingVinos gestor){
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
        panelContenido.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));


        //AÑADIR PANELES
        // Paneles al Principal
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelContenido, BorderLayout.CENTER);
        panelPrincipal.add(btnCancelar, BorderLayout.SOUTH); // CAMBIAR DESPUÉS
        //principal a la Ventana
        add(panelPrincipal);


    };

    public void solicitarSelFechaDesdeYHasta(GestorRankingVinos gestor){
        panelContenido.add(lblTextFechaDesde);
        panelContenido.add(lblFechaDesde);
        panelContenido.add(lblTextFechaHasta);
        panelContenido.add(lblFechaHasta);
        panelContenido.add(btnAceptar);

        System.out.println("Llego a add componentes");

        // Al clickear el btnAceptar Toma las fechas
        btnAceptar.addActionListener(e -> {
            Date fechaDesde = tomarSelFechaDesde();
            Date fechaHasta = tomarSelFechaHasta();


            System.out.println("fechaFormatoFecha desde: " + fechaDesde);
            System.out.println("fechaFormatoFecha hasta: " + fechaHasta);

            boolean validate = validarPeriodo(fechaDesde, fechaHasta);
            System.out.println(validate);

            // Mensaje al gestor para que tome las fechas
            gestor.tomarSelFechaDesdeYHasta(fechaDesde, fechaHasta, this);
            System.out.println("pantalla despues de opcGenerar: " + gestor.getFechaDesde());

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

    public void solicitarSelTipoResena(GestorRankingVinos gestor){
        panelContenido.removeAll();

        //Anadir combo opciones resena
        String[] tiposResena = {"Reseñas Normales", "Reseñas de Sommelier", "Reseñas de Amigos"};
        comboOpcResena = new JComboBox<>(tiposResena);

        panelContenido.add(lblTextOpcResena);
        panelContenido.add(comboOpcResena);
        panelContenido.add(btnSelectResena);

        //Evento click boton AceptarReseña
        btnSelectResena.addActionListener(e -> {
            String tipoResena = tomarTipoResena();
            System.out.println("El tipo de reseña elegido es: " + tipoResena);

            //Mensaje al gestor
            gestor.tomarSelTipoResena(tipoResena, this);

        });

        panelContenido.revalidate();
        panelContenido.repaint();

    };

    public String tomarTipoResena(){
        String opcTipoResena = comboOpcResena.getSelectedItem().toString();
        return opcTipoResena;
    };

    public void solicitarSelTipoVisualizacion(GestorRankingVinos gestor){

        String[] tipoVisualizaciones = {"PDF", "Por Pantalla", "Archivo Excel"};
        comboOpcResena = new JComboBox<>(tipoVisualizaciones);

        panelContenido.add(lblTextOpcVisualizacion);
        panelContenido.add(comboOpcResena);
        panelContenido.add(btnSelectTipoVisualizacion);

        //Evento click boton AceptarReseña
        btnSelectTipoVisualizacion.addActionListener(e -> {
            String tipoVisualizacion = tomarSelTipoVisualizacion();
            System.out.println("El tipo de Visualizacion elegido es: " + tipoVisualizacion);

            //Mensaje al gestor
            gestor.tomarSelTipoVisualizacion(tipoVisualizacion, this);

        });

        panelContenido.revalidate();
        panelContenido.repaint();

    }
    public String tomarSelTipoVisualizacion(){
        return comboOpcResena.getSelectedItem().toString();
    }
    public void solicitarConfirmacionGenReporte(GestorRankingVinos gestor){
        panelContenido.add(btnConfirmar);

        tomarConfirmacionGenReporte(gestor);

        panelContenido.revalidate();
        panelContenido.repaint();

    };
    public void tomarConfirmacionGenReporte(GestorRankingVinos gestor){
        btnConfirmar.addActionListener(e -> {
            gestor.tomarConfirmacionGenReporte(this);
        });

    }


}
