package org.example.Modelos;
import java.util.ArrayList;
import java.lang.reflect.Array;
import org.example.Modelos.Resena;

public class Vino {
    // Atributos
    private int anada;
    private String imagenEtiqueta;
    private String nombre;
    private String notaCataBodega;
    private double precio;
    private ArrayList<Resena> resenas;

    public int getAnada() {
        return anada;
    }

    public void setAnada(int anada) {
        this.anada = anada;
    }

    public String getImagenEtiqueta() {
        return imagenEtiqueta;
    }

    public void setImagenEtiqueta(String imagenEtiqueta) {
        this.imagenEtiqueta = imagenEtiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotaCataBodega() {
        return notaCataBodega;
    }

    public void setNotaCataBodega(String notaCataBodega) {
        this.notaCataBodega = notaCataBodega;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Constructor
    public Vino(int anada, String imagenEtiqueta, String nombre, String notaCataBodega, double precio, ArrayList<Resena> resenas) {
        this.anada = anada;
        this.imagenEtiqueta = imagenEtiqueta;
        this.nombre = nombre;
        this.notaCataBodega = notaCataBodega;
        this.precio = precio;
        this.resenas = resenas;
    }
    public Vino(int anada, String imagenEtiqueta, String nombre, String notaCataBodega, double precio) {
        this.anada = anada;
        this.imagenEtiqueta = imagenEtiqueta;
        this.nombre = nombre;
        this.notaCataBodega = notaCataBodega;
        this.precio = precio;
    }

    public ArrayList<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(ArrayList<Resena> resenas) {
        this.resenas = resenas;
    }
    // Metodos del dominio
    public Boolean tenesResenaDeTipoEnPeriodo(){
        return false;
    }
//    public String[] buscarInfoBodega(){
//        ;
//    }
//    public String buscarVarietal(){
//
//    }
    public float calcularPuntajePromedio(ArrayList<Float> lista) {
        if (lista == null || lista.isEmpty()) {
            return 0;  // Retornar 0 si la lista es nula o está vacía
        }

        float suma = 0;
        for (Float numero : lista) {
            suma += numero;
        }

        return suma / lista.size();
    }
    public void calcularPuntajeSommelierPromedio(){
//        ArrayList<Float> puntajes = new ArrayList<>();
//        for (int i = 0; i< resenas.size(); i++){
//            Boolean sosDePeriodo = resenas.get(i).sosDePeriodo();
//            Boolean sosDeSommelier = resenas.get(i).sosDeSommelier();
//            if (sosDePeriodo && sosDeSommelier){
//                puntajes.add(resenas.get(i).getPuntaje());
//            }
//        }
//        float promedio = calcularPuntajePromedio(puntajes);
    }

}



   /* public static void main(String[] args) {
        // Crear una instancia de Vino
        Vino vino = new Vino(2020, "imagen.png", "Vino Tinto", "Notas de frutas rojas y especias", 15.99);

        // Imprimir la información del vino
        System.out.println(vino);

        // Modificar algunos atributos usando setters
        vino.setNotaCataBodega("Notas de frutas maduras y especias");
        vino.setPrecio(17.99);

        // Imprimir la información actualizada del vino
        System.out.println(vino);
    }

    */

