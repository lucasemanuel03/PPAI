package org.example.Clases;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Provincia {
    private String nombre;
    private ArrayList<RegionVitivinicola> regionVitivinicolas;
    private Pais pais;

    //METODOS DEL DOMINIO

    public String obtenerPais(){
        return this.pais.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<RegionVitivinicola> getRegionVitivinicolas() {
        return regionVitivinicolas;
    }

    public void setRegionVitivinicolas(ArrayList<RegionVitivinicola> regionVitivinicolas) {
        this.regionVitivinicolas = regionVitivinicolas;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Provincia(String nombre, ArrayList<RegionVitivinicola> regionVitivinicolas) {
        this.nombre = nombre;
        this.regionVitivinicolas = regionVitivinicolas;
    }
}
