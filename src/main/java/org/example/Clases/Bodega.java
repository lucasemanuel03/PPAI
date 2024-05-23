package org.example.Clases;

import java.util.ArrayList;

public class Bodega {
    // Atributos
    private String coordenadasUbicacion;
    private String descripcion;
    private String historia;
    private String nombre;
    private String periodoActualizacion;
    private RegionVitivinicola region;

    // Constructor
    public Bodega(String coordenadasUbicacion, String descripcion, String historia, String nombre, String periodoActualizacion, RegionVitivinicola region) {
        this.coordenadasUbicacion = coordenadasUbicacion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.nombre = nombre;
        this.periodoActualizacion = periodoActualizacion;
        this.region = region;
    }

    //METODOS DEL DOMINIO
    public ArrayList<String> obtenerRegionYPais(){
        ArrayList<String> regionYPais = new ArrayList<>();
        String region = this.region.getNombre();
        String pais = this.region.obtenerPais();

        regionYPais.add(region);
        regionYPais.add(pais);

        return regionYPais;

    }

    // Métodos getter y setter
    public String getCoordenadasUbicacion() {
        return coordenadasUbicacion;
    }

    public void setCoordenadasUbicacion(String coordenadasUbicacion) {
        this.coordenadasUbicacion = coordenadasUbicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeriodoActualizacion() {
        return periodoActualizacion;
    }

    public void setPeriodoActualizacion(String periodoUpdate) {
        this.periodoActualizacion = periodoUpdate;
    }

    public RegionVitivinicola getRegion() {
        return region;
    }

    public void setRegion(RegionVitivinicola regionVitivinicola) {
        this.region = regionVitivinicola;
    }

    // Método toString para representar la clase Bodega como cadena
    @Override
    public String toString() {
        return "Bodega{" +
                "coordenadasUbicacion='" + coordenadasUbicacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", historia='" + historia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", periodoUpdate='" + periodoActualizacion + '\'' +
                '}';
    }

/*
    public static void main(String[] args) {
        // Crear una instancia de Bodega
        Bodega bodega = new Bodega("40.7128° N, 74.0060° W", "Bodega en Nueva York", "Fundada en 1920", "Bodega Central", "2023-01-01");

        // Imprimir la información de la bodega
        System.out.println(bodega);

        // Modificar algunos atributos usando setters
        bodega.setDescripcion("Bodega histórica en el centro de Nueva York");
        bodega.setPeriodoActualizacion("2024-05-21");

        // Imprimir la información actualizada de la bodega
        System.out.println(bodega);
    }

*/
}