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


        //PantallaPrueba pantallaPrueba = new PantallaPrueba();
        // pantallaPrueba.setVisible(true);

        //prueba Vinos

        PantallaExcel excel = new PantallaExcel();
        String[] test ={"Nicolas", "Lucas"};
        excel.generarExcel(test);
        PantallaRankingVinos pantallaRanking = new PantallaRankingVinos();
        pantallaRanking.setVisible(true);
        GestorRankingVinos gestor = new GestorRankingVinos();
        pantallaRanking.opcionGenerarRankingVinos(gestor);


    }



}
