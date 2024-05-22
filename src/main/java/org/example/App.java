package org.example;

import org.example.Controladores.GestorRankingVinos;
import org.example.interfaz.PantallaExcel;
import org.example.interfaz.PantallaPrueba;
import org.example.interfaz.PantallaRankingVinos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //test excel
//        PantallaExcel excel = new PantallaExcel();
//        String[] test ={"Nicolas", "Lucas"};
//        excel.generarExcel(test);

        GestorRankingVinos gestor = new GestorRankingVinos();

        PantallaRankingVinos pantallaRanking = new PantallaRankingVinos();
        pantallaRanking.setVisible(true);

        pantallaRanking.opcionGenerarRankingVinos(gestor);

    }



}
