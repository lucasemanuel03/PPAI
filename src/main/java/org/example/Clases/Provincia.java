package org.example.Clases;

import java.lang.reflect.Array;

public class Provincia {
    private String nombre;
    private RegionVitivinicola[] regionVitivinicolas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RegionVitivinicola[] getRegionVitivinicolas() {
        return regionVitivinicolas;
    }

    public void setRegionVitivinicolas(RegionVitivinicola[] regionVitivinicolas) {
        this.regionVitivinicolas = regionVitivinicolas;
    }

    public Provincia(String nombre, RegionVitivinicola[] regionVitivinicolas) {
        this.nombre = nombre;
        this.regionVitivinicolas = regionVitivinicolas;
    }
}
