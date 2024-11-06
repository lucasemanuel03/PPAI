package org.example.StrategyPattern;

import org.example.Clases.Vino;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IEstrategiaBusquedaVinos {
    List<List<Object>> arrayDatosVinos = new ArrayList<>();
    Date fechaInicio = null;
    Date fechaFin = null;
    public List<List<Object>> buscarVinosConResena(ArrayList<Vino> vinos);
    //default  void vinosNoEncontrados();
}
