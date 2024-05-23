package org.example.Controladores;

import org.example.Clases.*;
import org.example.interfaz.InterfazExcel;
import org.example.interfaz.PantallaRankingVinos;

import java.util.*;

public class GestorRankingVinos {

    // Atributos
    Date fechaDesde;
    Date fechaHasta;
    String[] tipoVisualizaciones = {"PDF", "Por Pantalla", "Archivo Excel"};
    String tipoResenaSeleccionado;
    String tipoVisualizacionSeleccionado;
    boolean confirmacionGeneracion;
    List<List<Object>> arrayDatosVinos = new ArrayList<>();
    List<List<Object>> primeros10Vinos = new ArrayList<>();

    //Métodos

    //Del Dominio
    public void opcionGenerarRankingVinos(PantallaRankingVinos pantalla, ArrayList<Vino> vinos, InterfazExcel interfazExcel){
        pantalla.solicitarSelFechaDesdeYHasta(this);
        if(fechaDesde != null && fechaHasta != null) {
            buscarVinosConResenaEnPeriodo(vinos);
            // ordenarVinos();
        }

        ordenarVinos();

        //Mensaje a la interfazExcel para que genere el archivo
        interfazExcel.generarArchivoExcel(this.primeros10Vinos);

        //Mensaje a la pantalla para que informe la generación del archivo
        pantalla.informarGeneracionArchivo();
    }


    public void tomarSelFechaDesdeYHasta(Date fechaDesde, Date fechaHasta, PantallaRankingVinos pantalla) //verificar si hay que ingresar la pantalla también
    {
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);
        // System.out.println("Se ejecuto el tomarSel");

        //Llamada a la pantalla para que muestre los tipos de reseñas
        if (fechaDesde != null && fechaHasta != null){
            pantalla.solicitarSelTipoResena(this);

        }
    }

    public void tomarSelTipoResena(String tipoResena, PantallaRankingVinos pantalla){
        setTipoResenaSeleccionado(tipoResena);

        if(tipoResenaSeleccionado != null){
            pantalla.solicitarSelTipoVisualizacion(this);
        }
    }

    public void tomarSelTipoVisualizacion(String tipoVisualizacion, PantallaRankingVinos pantalla){
        setTipoVisualizacionSeleccionado(tipoVisualizacion);

        if (tipoVisualizacionSeleccionado != null){
            pantalla.solicitarConfirmacionGenReporte(this);
            // System.out.println("correcto!");
        }
    }

    public void tomarConfirmacionGenReporte(PantallaRankingVinos pantalla){

        setConfirmacionGeneracion(true);

        System.out.println("Confirmacion tomada en el gestor!");
       // this.buscarVinosConResenaEnPeriodo();


    }

    public void cancelarCU(PantallaRankingVinos pantalla){
        //Cierra la ventana
        pantalla.dispose();
    }
    public void buscarVinosConResenaEnPeriodo(ArrayList<Vino> vinos){
        ArrayList<Object> vinosSeleccionados = new ArrayList<>();
        ArrayList<String> infoBodegas = new ArrayList<>();
        for (int i = 0; i < vinos.size(); i++) {
            Boolean tieneResenaValidas = vinos.get(i).tenesResenaDeTipoEnPeriodo(this.fechaDesde, this.fechaHasta);

            if (tieneResenaValidas) {
                String nombre = vinos.get(i).getNombre();
                Double precio = vinos.get(i).getPrecio();
                ArrayList<String> infoBodega = vinos.get(i).buscarInfoBodega();
                System.out.println("InfBodegas: " + infoBodega);
                String descVarietal = vinos.get(i).buscarVarietal();
                // Pendiente ver como guardar los datos

                //Luego de determinar que el vino tiene reseñas validas, calcula el promedio de puntaje de reseñas.
                //VER QUE NO ES IGAUL A LA SOLUCION
                double promedio = vinos.get(i).calcularPuntajeSommelierPromedio(this.fechaDesde, this.fechaHasta);

                //AGREGAR VINO AL ARRAY DE SELECCIONADOS
                ArrayList<Object> datosVinoSeleccionado = new ArrayList<>();
                datosVinoSeleccionado.add(promedio);
                datosVinoSeleccionado.add(nombre);
                datosVinoSeleccionado.add(precio);
                datosVinoSeleccionado.addAll(infoBodega);
                datosVinoSeleccionado.add(descVarietal);

                this.arrayDatosVinos.add(datosVinoSeleccionado);
                System.out.println("Datos del vino seleccionado: " + datosVinoSeleccionado);
            }

            }

    }

    public void ordenarVinos(){
        Collections.sort(this.arrayDatosVinos, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> lista1, List<Object> lista2) {
                // Convertir el primer elemento de cada sublista a Double para comparar
                Double valor1 = (Double) lista1.get(0);
                Double valor2 = (Double) lista2.get(0);
                // Comparar los valores
                return valor1.compareTo(valor2);
            }

    });
        // setea los el atributo con los primeros 10 vinos del ranking
        setPrimeros10Vinos( this.arrayDatosVinos.subList(0, Math.min(this.arrayDatosVinos.size(), 10)));
    }


    //GETTERS AND SETTERS


    public boolean isConfirmacionGeneracion() {
        return confirmacionGeneracion;
    }

    public void setConfirmacionGeneracion(boolean confirmacionGeneracion) {
        this.confirmacionGeneracion = confirmacionGeneracion;
    }

    public List<List<Object>> getArrayDatosVinos() {
        return arrayDatosVinos;
    }

    public void setArrayDatosVinos(List<List<Object>> arrayDatosVinos) {
        this.arrayDatosVinos = arrayDatosVinos;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getTipoResenaSeleccionado() {
        return tipoResenaSeleccionado;
    }

    public void setTipoResenaSeleccionado(String tipoResenaSeleccionado) {
        this.tipoResenaSeleccionado = tipoResenaSeleccionado;
    }

    public String getTipoVisualizacionSeleccionado() {
        return tipoVisualizacionSeleccionado;
    }

    public void setTipoVisualizacionSeleccionado(String tipoVisualizacionSeleccionado) {
        this.tipoVisualizacionSeleccionado = tipoVisualizacionSeleccionado;
    }

    public String[] getTipoVisualizaciones() {
        return tipoVisualizaciones;
    }

    public void setTipoVisualizaciones(String[] tipoVisualizaciones) {
        this.tipoVisualizaciones = tipoVisualizaciones;
    }

    public void setPrimeros10Vinos(List<List<Object>> primeros10Vinos) {
        this.primeros10Vinos = primeros10Vinos;
    }

    public List<List<Object>> getPrimeros10Vinos() {
        return primeros10Vinos;
    }
}
