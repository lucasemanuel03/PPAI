package org.example.persistencia;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "provincias")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToMany(mappedBy = "regiones", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<RegionVitivinicola> regionVitivinicolas;
    @ManyToOne
    @JoinColumn(name = "id_pais")
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
    public Provincia(){

    }
}
