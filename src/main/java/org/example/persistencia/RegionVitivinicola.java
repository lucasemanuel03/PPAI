package org.example.persistencia;

import jakarta.persistence.*;

@Entity
@Table(name = "regionesVitivinicolas")
public class RegionVitivinicola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

    public RegionVitivinicola(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public RegionVitivinicola(){

    }

    //METODOS DEL DOMINIO
    public String obtenerPais(){
        String pais = this.provincia.obtenerPais();
        return pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
