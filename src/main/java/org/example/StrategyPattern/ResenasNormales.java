package org.example.StrategyPattern;

import org.example.Clases.Vino;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResenasNormales implements IEstrategiaGeneracionReporte {
    @Override
    public List<List<Object>> buscarVinosConResenaEnPeriodo(Date fechaInicio, Date fechaFin, ArrayList<Vino> vinos) {
        return null;
    }
}
