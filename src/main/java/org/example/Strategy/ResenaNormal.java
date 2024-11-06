package org.example.Strategy;

import org.example.Clases.Vino;
import org.example.Controladores.GestorRankingVinos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResenaNormal implements IEstrategiaGeneracionReporte{
    @Override
    public List<List<Object>> buscarVinosConResenaEnPeriodo(Date fechaDesde, Date fechaHasta, ArrayList<Vino> vinos, GestorRankingVinos gestorRankingVinos) {
        return IEstrategiaGeneracionReporte.super.buscarVinosConResenaEnPeriodo(fechaDesde, fechaHasta, vinos, gestorRankingVinos);
    }
}
