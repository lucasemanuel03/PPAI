package org.example;

import org.example.Clases.*;
import org.example.Controladores.GestorRankingVinos;
import org.example.interfaz.PantallaRankingVinos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //CREACIÓN DE DATOS
        //FECHAS
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JANUARY,1);
        Date fecha1 = calendar.getTime();

        calendar.set(2024, Calendar.JANUARY,1);
        Date fecha2 = calendar.getTime();


        //CREACION DE REGIONES
        RegionVitivinicola region1 = new RegionVitivinicola("Zona Centro-Oeste", "Desc Zona Centro-Oeste");
        RegionVitivinicola region2 = new RegionVitivinicola("Zona Noreste", "Desc Zona noreste");

        //CREACION ARRAY REGIONES
        ArrayList<RegionVitivinicola> regiones1 = new ArrayList<>();
        ArrayList<RegionVitivinicola> regiones2 = new ArrayList<>();
        regiones2.add(region2);
        regiones1.add(region1);


        //CRACIÓN PROVINCIAS
        Provincia mendoza = new Provincia("Mendoza", regiones1);
        Provincia laRioja = new Provincia("La Rioja", regiones2);

        //CREACION ARRAY PROVINCIAS
        ArrayList<Provincia> provincias = new ArrayList<>();
        provincias.add(mendoza);
        provincias.add(laRioja);

        //CREACION DE PAISES
        Pais pais1 = new Pais("Argentina", provincias);

        //ASOCIAR PROVINCIA A REGION
        region1.setProvincia(mendoza);
        region2.setProvincia(laRioja);

        // ASOCIAR PAIS A PROVINCIA
        mendoza.setPais(pais1);
        laRioja.setPais(pais1);


        //CREACIÓN DE BODEGAS
        Bodega bodega1 = new Bodega("5354689-465896", "Bodega Familiar", "Historia de la bodega1", "Bodega Lopez", "2023-2024", region1);
        Bodega bodega2 = new Bodega("5354689-465800", "Bodega Regional", "Historia de la bodega2", "Bodega Regional", "2023-2024", region2);

        // LISTA RESENAS PARA VINOS
        ArrayList<Resena> resenasVino1 = new ArrayList<>();
        ArrayList<Resena> resenasVino2 = new ArrayList<>();
        ArrayList<Resena> resenasVino3 = new ArrayList<>();
        ArrayList<Resena> resenasVino4 = new ArrayList<>();
        ArrayList<Resena> resenasVino5 = new ArrayList<>();
        ArrayList<Resena> resenasVino6 = new ArrayList<>();
        ArrayList<Resena> resenasVino7 = new ArrayList<>();

        //CREACION DE VARIETALES
        Varietal varietal1 = new Varietal("Malbec", 80.0);
        Varietal varietal2 = new Varietal("Cabernet", 84.0);

        //VINOS CREADOS
        Vino vino1 = new Vino(2015, "/imagen1.png", "Gran Reserva 2015", "Aroma a frutos rojos con notas de madera y especias.", 2500.0, bodega1, resenasVino1, varietal1);
        Vino vino2 = new Vino(2017, "/imagen2.png", "Gran Vino Mendoza", "Aroma a frutos rojos con notas de madera y especias.", 3500.0, bodega1, resenasVino2, varietal2);
        Vino vino3 = new Vino(2019, "/imagen3.png", "Vino Regional 2019", "Aroma a frutos rojos con notas de madera y especias.", 2000.0, bodega2, resenasVino3, varietal1);
        Vino vino4 = new Vino(2020, "/imagen4.png", "Vino Nacional", "Aroma a frutos rojos con notas de madera y especias.", 1500.0, bodega1, resenasVino4, varietal1);
        Vino vino5 = new Vino(2023, "/imagen5.png", "Merlot Clásico", "Aroma a frutos rojos con notas de madera y especias.", 1300.0, bodega2, resenasVino5, varietal2);
        Vino vino6 = new Vino(2018, "/imagen6.png", "Vino de La Rioja", "Aroma a frutos rojos con notas de madera y especias.", 6000.0, bodega2, resenasVino6, varietal1);
        Vino vino7 = new Vino(2020, "/imagen7.png", "San Juan Reserva", "Aroma a frutos rojos con notas de madera y especias.", 3000.0, bodega1, resenasVino7, varietal2);

        //RESEÑAS
        Resena resena1 = new Resena("Excelente cuerpo y final prolongado.", false, fecha1,7.7, vino1);
        Resena resena2 = new Resena("Excelente cuerpo y final prolongado.", false, fecha1,5.7, vino1);
        Resena resena3 = new Resena("Excelente cuerpo y final prolongado.", false, fecha1,8.8, vino1);
        Resena resena4 = new Resena("Excelente cuerpo y final prolongado.", true, fecha1,6.7, vino2);
        Resena resena5 = new Resena("Excelente cuerpo y final prolongado.", false, fecha1,7.2, vino2);
        Resena resena6 = new Resena("Excelente cuerpo y final prolongado.", true, fecha1,8.9, vino3);
        Resena resena7 = new Resena("Excelente cuerpo y final prolongado.", true, fecha2,9.7, vino3);
        Resena resena8 = new Resena("Excelente cuerpo y final prolongado.", false, fecha2,9.1, vino4);

        //AÑADIR RESEÑAS A VINOS
        resenasVino1.add(resena1);
        resenasVino1.add(resena2);
        resenasVino1.add(resena3);
        resenasVino2.add(resena4);
        resenasVino2.add(resena5);
        resenasVino3.add(resena6);
        resenasVino3.add(resena7);
        resenasVino4.add(resena8);


        //CREAR ARRAY VINOS
        ArrayList<Vino> vinos = new ArrayList<>();
        vinos.add(vino1);
        vinos.add(vino2);
        vinos.add(vino3);
        vinos.add(vino4);
        vinos.add(vino5);
        vinos.add(vino6);
        vinos.add(vino7);


        // System.out.println("RESEÑAS DE VINO" + vino1.getNombre() + vino1.getResenas());

        // INICIO DEL CU

        PantallaRankingVinos pantallaRanking = new PantallaRankingVinos();
        pantallaRanking.setVisible(true);
        GestorRankingVinos gestor = new GestorRankingVinos();
        pantallaRanking.opcionGenerarRankingVinos(gestor, vinos);


    }



}
