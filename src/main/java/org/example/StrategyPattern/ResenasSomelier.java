package org.example.StrategyPattern;

import org.example.Clases.Vino;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResenasSomelier implements IEstrategiaGeneracionReporte {


    @Override
    public List<List<Object>> buscarVinosConResenaEnPeriodo(Date fechaInicio, Date fechaFin, ArrayList<Vino> vinos) {
        ArrayList<Object> vinosSeleccionados = new ArrayList<>();
        ArrayList<String> infoBodegas = new ArrayList<>();
        List<List<Object>> arrayDatosVinos = new ArrayList<>();
        for (int i = 0; i < vinos.size(); i++) {
            Boolean tieneResenaValidas = vinos.get(i).tenesResenaDeTipoEnPeriodo(fechaInicio, fechaFin);

            if (tieneResenaValidas) {
                String nombre = vinos.get(i).getNombre();
                Double precio = vinos.get(i).getPrecio();
                ArrayList<String> infoBodega = vinos.get(i).buscarInfoBodega();
                // System.out.println("InfBodegas: " + infoBodega);
                String descVarietal = vinos.get(i).buscarVarietal();

                //Luego de determinar que el vino tiene reseñas validas, calcula el promedio de puntaje de reseñas.
                //VER QUE NO ES IGAUL A LA SOLUCION
                double promedio = vinos.get(i).calcularPuntajeSommelierPromedio(fechaInicio, fechaFin);

                //AGREGAR VINO AL ARRAY DE SELECCIONADOS
                ArrayList<Object> datosVinoSeleccionado = new ArrayList<>();
                datosVinoSeleccionado.add(promedio);
                datosVinoSeleccionado.add(nombre);
                datosVinoSeleccionado.add(precio);
                datosVinoSeleccionado.addAll(infoBodega);
                datosVinoSeleccionado.add(descVarietal);

                arrayDatosVinos.add(datosVinoSeleccionado);
                // System.out.println("Datos del vino seleccionado: " + datosVinoSeleccionado);
            }

        }
        return arrayDatosVinos;

    }

}
