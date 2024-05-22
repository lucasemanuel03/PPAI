package org.example.Modelos;

public class Varietal {
    private String descripcion;
    private String porcentajeComposicion;

    public Varietal(String descripcion, String porcentajeComposicion) {
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPorcentajeComposicion() {
        return porcentajeComposicion;
    }

    public void setPorcentajeComposicion(String porcentajeComposicion) {
        this.porcentajeComposicion = porcentajeComposicion;
    }
}
