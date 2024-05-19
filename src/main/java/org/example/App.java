package org.example;

import org.example.Controladores.Gestor;
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
        System.out.println( "Hello World!" );


        //PantallaPrueba pantallaPrueba = new PantallaPrueba();
        // pantallaPrueba.setVisible(true);

        //prueba Vinos


        PantallaRankingVinos pantallaRanking = new PantallaRankingVinos();
        pantallaRanking.setVisible(true);
        Gestor gestor = new Gestor();
        pantallaRanking.opcionGenerarRankingVinos(gestor);


    }



}
