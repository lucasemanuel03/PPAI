package org.example.interfaz;
import org.example.Clases.Vino;
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
    private JLabel titulo = new JLabel("BON VINO", SwingConstants.CENTER);
    private JLabel subtitulo = new JLabel(":: Ranking TOP 10 de Vinos ::", SwingConstants.CENTER);

    //Componentes a mostar en el habilitar ventana
    private JTextField lblFechaDesde = new JTextField("01-01-2000", 20);
    private JTextField lblFechaHasta = new JTextField("01-01-2000", 20);
    private JLabel lblTextFechaDesde = new JLabel("Fecha Inicio: ");
    private JLabel lblTextFechaHasta = new JLabel("Fecha de Fin: ");
    private JLabel lblTextGenArchivo = new JLabel("Archivo Excel Generado!");
    private JButton btnAceptar = new JButton("Aceptar");
    private JButton btnSelectResena = new JButton("Seleccionar");
    private JButton btnSelectTipoVisualizacion = new JButton("Seleccionar");
    private JButton btnConfirmar = new JButton("CONFIRMAR");
    private JButton btnCancelar = new JButton("Cancelar");

    //Pedir Opciones
    private JComboBox<String> comboOpcResena;
    private JLabel lblTextOpcResena = new JLabel("Seleccione un Tipo de Reseña: ");
    private JLabel lblTextOpcVisualizacion = new JLabel("Seleccione un Tipo de Visualización: ");
    private final Object lock = new Object(); // Objeto de bloque


    //METODOS

    public void opcionGenerarRankingVinos(GestorRankingVinos gestor, ArrayList<Vino> vinos, PantallaExcel pantallaExcel){
        habilitarVentana(gestor);
        gestor.opcionGenerarRankingVinos(this, vinos, pantallaExcel);

    };
    public void habilitarVentana(GestorRankingVinos gestor){
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

        btnCancelar.addActionListener(e -> {
            gestor.cancelarCU(this);
            System.out.println("CASO DE USO FINALIZADO POR CANCELACIÓN");
        });

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
            synchronized (lock) {
                lock.notify();
            }

        });

        // Esperar hasta que se libere el objeto de bloqueo
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
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

        // String[] tipoVisualizaciones = {"PDF", "Por Pantalla", "Archivo Excel"};
        String[] tipoVisualizaciones = gestor.getTipoVisualizaciones();
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
            panelContenido.add(lblTextGenArchivo);
            panelContenido.revalidate();
            panelContenido.repaint();
            System.out.println(gestor.getPrimeros10Vinos());
        });

    }

    public void informarGeneracionArchivo(){
        panelContenido.add(lblTextGenArchivo);

    }

    public void informarNoHayVinosEnPeriodo() {
        // Funcion que activa una ventana emergente informando que no hay vinos con reseñas en periodo

        String mensaje = "NO se encontraron vinos con Reseñas en ese periodo";
        int respuesta = JOptionPane.showOptionDialog(this,
                mensaje,
                "Mensaje",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Aceptar"},
                "Aceptar");

        // Si se hace clic en "Aceptar" se cierra la aplicación.
        if (respuesta == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }


}
