package org.example.Clases;

public class Bodega {
    // Atributos
    private String coordenadasUbicacion;
    private String descripcion;
    private String historia;
    private String nombre;
    private String periodoUpdate;

    // Constructor
    public Bodega(String coordenadasUbicacion, String descripcion, String historia, String nombre, String periodoUpdate) {
        this.coordenadasUbicacion = coordenadasUbicacion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.nombre = nombre;
        this.periodoUpdate = periodoUpdate;
    }

    // Métodos getter y setter

    // Getter y setter para coordenadasUbicacion
    public String getCoordenadasUbicacion() {
        return coordenadasUbicacion;
    }

    public void setCoordenadasUbicacion(String coordenadasUbicacion) {
        this.coordenadasUbicacion = coordenadasUbicacion;
    }

    // Getter y setter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter y setter para historia
    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    // Getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para periodoUpdate
    public String getPeriodoUpdate() {
        return periodoUpdate;
    }

    public void setPeriodoUpdate(String periodoUpdate) {
        this.periodoUpdate = periodoUpdate;
    }

    // Método toString para representar la clase Bodega como cadena
    @Override
    public String toString() {
        return "Bodega{" +
                "coordenadasUbicacion='" + coordenadasUbicacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", historia='" + historia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", periodoUpdate='" + periodoUpdate + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Crear una instancia de Bodega
        Bodega bodega = new Bodega("40.7128° N, 74.0060° W", "Bodega en Nueva York", "Fundada en 1920", "Bodega Central", "2023-01-01");

        // Imprimir la información de la bodega
        System.out.println(bodega);

        // Modificar algunos atributos usando setters
        bodega.setDescripcion("Bodega histórica en el centro de Nueva York");
        bodega.setPeriodoUpdate("2024-05-21");

        // Imprimir la información actualizada de la bodega
        System.out.println(bodega);
    }
}
