package org.example;

import org.example.Controladores.GestorRankingVinos;
import org.example.interfaz.PantallaRankingVinos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        //PantallaPrueba pantallaPrueba = new PantallaPrueba();
        // pantallaPrueba.setVisible(true);

        //prueba Vinos


        PantallaRankingVinos pantallaRanking = new PantallaRankingVinos();
        pantallaRanking.setVisible(true);
        GestorRankingVinos gestor = new GestorRankingVinos();
        pantallaRanking.opcionGenerarRankingVinos(gestor);


    }



}
