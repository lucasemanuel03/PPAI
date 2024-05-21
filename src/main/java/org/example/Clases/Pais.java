package org.example.Clases;

public class Pais {
    private String nombre;
    private Provincia[] provincias;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia[] getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincia[] provincias) {
        this.provincias = provincias;
    }

    public Pais(String nombre, Provincia[] provincias) {
        this.nombre = nombre;
        this.provincias = provincias;
    }
}
