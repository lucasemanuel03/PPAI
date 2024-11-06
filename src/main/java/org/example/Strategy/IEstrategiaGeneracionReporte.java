package org.example.Strategy;

import org.example.Clases.Vino;
import org.example.Controladores.GestorRankingVinos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IEstrategiaGeneracionReporte {

    public default List<List<Object>> buscarVinosConResenaEnPeriodo(Date fechaDesde, Date fechaHasta, ArrayList<Vino> vinos, GestorRankingVinos gestorRankingVinos) {

        return null;
    }
    public default void probarEstrategia(){

    }
}
