package org.example.Controladores;


import org.example.interfaz.PantallaRankingVinos;

import java.util.Date;

public class Gestor {

    // Atributos
    Date fechaDesde;
    Date fechaHasta;

    //Métodos

    //Del Dominio
    public void opcionGenerarRankingVinos(PantallaRankingVinos pantalla){
        pantalla.solicitarSelFechaDesdeYHasta();
        System.out.println("Llego al gestor");

    }


    public void tomarSelFechaDesdeYHasta(Date fechaDesde, Date fechaHasta) //verificar si hay que ingresar la pantalla también
    {
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);
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
}
