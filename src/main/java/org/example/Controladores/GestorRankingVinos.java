package org.example.Controladores;

import org.example.Clases.*;
import org.example.interfaz.PantallaExcel;
import org.example.interfaz.PantallaRankingVinos;

import java.util.*;

public class    GestorRankingVinos {

    // Atributos
    Date fechaInicio;
    Date fechaFin;
    String[] tipoVisualizaciones = {"PDF", "Por Pantalla", "Archivo Excel"};
    String tipoResenaSeleccionado;
    String tipoVisualizacionSeleccionado;
    boolean confirmacionGeneracion;
    List<List<Object>> arrayDatosVinos = new ArrayList<>();
    List<List<Object>> primeros10Vinos = new ArrayList<>();

    //Métodos

    //Del Dominio
    public void opcionGenerarRankingVinos(PantallaRankingVinos pantalla, ArrayList<Vino> vinos, PantallaExcel pantallaExcel){
        pantalla.solicitarSelFechaDesdeYHasta(this);

        if(fechaInicio != null && fechaFin != null) {
            buscarVinosConResenaEnPeriodo(vinos, pantalla);
            // ordenarVinos();
        }

        ordenarVinos();

        //Se genera el excel
        pantallaExcel.generarExcel(this.primeros10Vinos);

        //Mensaje a la pantalla para que informe la generación del archivo
        if(confirmacionGeneracion){
            pantalla.informarGeneracionArchivo();
        }
    }

    public void tomarSelFechaDesdeYHasta(Date fechaDesde, Date fechaHasta, PantallaRankingVinos pantalla) //verificar si hay que ingresar la pantalla también
    {
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);

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
    public void buscarVinosConResenaEnPeriodo(ArrayList<Vino> vinos, PantallaRankingVinos pantalla){
        ArrayList<Object> vinosSeleccionados = new ArrayList<>();
        ArrayList<String> infoBodegas = new ArrayList<>();
        for (int i = 0; i < vinos.size(); i++) {
            Boolean tieneResenaValidas = vinos.get(i).tenesResenaDeTipoEnPeriodo(this.fechaInicio, this.fechaFin);

            if (tieneResenaValidas) {
                String nombre = vinos.get(i).getNombre();
                Double precio = vinos.get(i).getPrecio();
                ArrayList<String> infoBodega = vinos.get(i).buscarInfoBodega();
                // System.out.println("InfBodegas: " + infoBodega);
                String descVarietal = vinos.get(i).buscarVarietal();

                //Luego de determinar que el vino tiene reseñas validas, calcula el promedio de puntaje de reseñas.
                //VER QUE NO ES IGAUL A LA SOLUCION
                double promedio = vinos.get(i).calcularPuntajeSommelierPromedio(this.fechaInicio, this.fechaFin);

                //AGREGAR VINO AL ARRAY DE SELECCIONADOS
                ArrayList<Object> datosVinoSeleccionado = new ArrayList<>();
                datosVinoSeleccionado.add(promedio);
                datosVinoSeleccionado.add(nombre);
                datosVinoSeleccionado.add(precio);
                datosVinoSeleccionado.addAll(infoBodega);
                datosVinoSeleccionado.add(descVarietal);

                this.arrayDatosVinos.add(datosVinoSeleccionado);
                // System.out.println("Datos del vino seleccionado: " + datosVinoSeleccionado);
            }

            }

        // ALTERNATIVA : NO hay vinos con reseñas en periodo
        if (this.arrayDatosVinos.isEmpty()){
            System.out.println("No hay vions en Periodo");
            pantalla.informarNoHayVinosEnPeriodo();
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
                return valor2.compareTo(valor1); // Ordena de mayor a menor
            }

        });
        setPrimeros10Vinos( this.arrayDatosVinos.subList(0, Math.min(this.arrayDatosVinos.size(), 10)));
        // System.out.println("Lista Ordenada: " + this.arrayDatosVinos);
    };


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
        return fechaInicio;
    }

    public Date getFechaHasta() {
        return fechaFin;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaInicio = fechaDesde;
    }

    public void setFechaHasta(Date fechaFin) {
        this.fechaFin = fechaFin;
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
