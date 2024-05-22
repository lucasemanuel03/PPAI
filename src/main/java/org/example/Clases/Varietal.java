package org.example.Clases;

public class Varietal {
    private String descripcion;
    private double porcentajeComposicion;

    public Varietal(String descripcion, double porcentajeComposicion) {
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentajeComposicion() {
        return porcentajeComposicion;
    }

    public void setPorcentajeComposicion(double porcentajeComposicion) {
        this.porcentajeComposicion = porcentajeComposicion;
    }
}
