package org.example.StrategyPattern;

import org.example.Clases.Vino;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResenasAmigos implements IEstrategiaGeneracionReporte {
    @Override
    public List<List<Object>> buscarVinosConResenaEnPeriodo(Date fechaDesde, Date fechaHasta, ArrayList<Vino> vinos) {
        return null;
    }
}
