package org.example.StrategyPattern;

import org.example.Clases.Vino;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResenasSomelier implements IEstrategiaBusquedaVinos{
    List<List<Object>> arrayDatosVinos = new ArrayList<>();
    Date fechaInicio;
    Date fechaFin;
    @Override
    public List<List<Object>> buscarVinosConResena(ArrayList<Vino> vinos) {
        ArrayList<Object> vinosSeleccionados = new ArrayList<>();
        ArrayList<String> infoBodegas = new ArrayList<>();
        for (int i = 0; i < vinos.size(); i++) {
            Boolean tieneResenaValidas = vinos.get(i).tenesResenaDeTipoEnPeriodo(this.fechaInicio, this.fechaFin);

            if (tieneResenaValidas) {
                String nombre = vinos.get(i).getNombre();
                Double precio = vinos.get(i).getPrecio();
                ArrayList<String> infoBodega = vinos.get(i).buscarInfoBodega();
                // System.out.println("InfBodegas: " + infoBodega);
                String descVarietal = vinos.get(i).buscarVarietal();

                //Luego de determinar que el vino tiene reseñas validas, calcula el promedio de puntaje de reseñas.
                //VER QUE NO ES IGAUL A LA SOLUCION
                double promedio = vinos.get(i).calcularPuntajeSommelierPromedio(this.fechaInicio, this.fechaFin);

                //AGREGAR VINO AL ARRAY DE SELECCIONADOS
                ArrayList<Object> datosVinoSeleccionado = new ArrayList<>();
                datosVinoSeleccionado.add(promedio);
                datosVinoSeleccionado.add(nombre);
                datosVinoSeleccionado.add(precio);
                datosVinoSeleccionado.addAll(infoBodega);
                datosVinoSeleccionado.add(descVarietal);

                this.arrayDatosVinos.add(datosVinoSeleccionado);
                // System.out.println("Datos del vino seleccionado: " + datosVinoSeleccionado);
            }
        }
        return this.arrayDatosVinos;
    }
}
