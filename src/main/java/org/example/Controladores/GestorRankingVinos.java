package org.example.Controladores;


import org.example.interfaz.PantallaRankingVinos;

import java.util.Date;

public class GestorRankingVinos {

    // Atributos
    Date fechaDesde;
    Date fechaHasta;
    String tipoResenaSeleccionado;
    String tipoVisualizacionSeleccionado;

    //Métodos

    //Del Dominio
    public void opcionGenerarRankingVinos(PantallaRankingVinos pantalla){
        pantalla.solicitarSelFechaDesdeYHasta(this);
        System.out.println("Llego al gestor");
        System.out.println("fechaAtributo: " + getFechaDesde());


    }


    public void tomarSelFechaDesdeYHasta(Date fechaDesde, Date fechaHasta, PantallaRankingVinos pantalla) //verificar si hay que ingresar la pantalla también
    {
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);
        System.out.println("Se ejecuto el tomarSel");

        //Llamada a la pantalla para que muestre los tipos de reseñas
        if (fechaDesde != null && fechaHasta != null){
            pantalla.solicitarSelTipoResena(this);
            System.out.println("Se ejucto el if");
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
            System.out.println("correcto!");
        }
    }

    public void tomarConfirmacionGenReporte(PantallaRankingVinos pantalla){

        System.out.println("Confirmacion tomada en el gestor!");

    }

    public void cancelarCU(PantallaRankingVinos pantalla){
        //Cierra la ventana
        pantalla.dispose();
    }


    //GETTERS AND SETTERS
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
}
