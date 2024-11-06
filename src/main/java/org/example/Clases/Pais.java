package org.example.Clases;




import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity(name = "paises")
public class Pais {

    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nombre;
    //private ArrayList<Provincia> provincias;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public ArrayList<Provincia> getProvincias() {
//        return provincias;
//    }

//    public void setProvincias(ArrayList<Provincia> provincias) {
//        this.provincias = provincias;
//    }

//    public Pais(String nombre, ArrayList<Provincia> provincias) {
//        this.nombre = nombre;
//        this.provincias = provincias;
//    }
}
