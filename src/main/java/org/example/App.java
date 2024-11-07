package org.example;


import org.example.Clases.*;
import org.example.Controladores.GestorRankingVinos;
import org.example.DAO.*;
import org.example.interfaz.PantallaExcel;
import org.example.interfaz.PantallaRankingVinos;



import java.sql.*;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        PantallaRankingVinos pantallaRanking = new PantallaRankingVinos();
        pantallaRanking.setVisible(true);
        GestorRankingVinos gestor = new GestorRankingVinos();
        PantallaExcel pantallaExcel = new PantallaExcel();


        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:vinos.db");
            System.out.println("funcionop");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from paises");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getInt("id_pais"));
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Pais> paises = null;
        ArrayList<Provincia> provincias = null;
        ArrayList<RegionVitivinicola> regionVitivinicolas = null;
        ArrayList<Bodega> bodegas = null;
        ArrayList<Vino> vinos = null;
        ArrayList<Resena> resenas = null;
        ArrayList<Varietal> varietales = null;


        try {
            conn = DriverManager.getConnection("jdbc:sqlite:vinos.db");
            System.out.println("funcionop");
            //Paises
            PaisDAO paisDAO = new PaisDAO(conn);
            paises = paisDAO.getAll();

            //Provincias
            ProvinciaDAO provinciaDAO = new ProvinciaDAO(conn);
            provincias = provinciaDAO.getAllConPaises(paises);

            //RegionVitivinicola
            RegionVitivinicolaDAO regionVitivinicolaDAO = new RegionVitivinicolaDAO(conn);
            regionVitivinicolas = regionVitivinicolaDAO.getAllConProvincia(provincias);

            //Bodegas
            BodegaDAO bodegaDAO = new BodegaDAO(conn);
            bodegas = bodegaDAO.getAllConRegion(regionVitivinicolas);

            //Vinos Sin relaciones
            VinosDAO vinosDAO = new VinosDAO(conn);
            vinos = vinosDAO.getAll();

            //Resenas con Vinos
            ResenasDAO resenasDAO = new ResenasDAO(conn);
            resenas = resenasDAO.getAllConVinos(vinos);
            //Varietales
            VarietalDAO varietalDAO = new VarietalDAO(conn);
            varietales = varietalDAO.getAll();

            //Crear las relaciones con Vino
            vinos = vinosDAO.CrearRelacionesVino(vinos, resenas,bodegas, varietales);

            System.out.println(vinos.get(1).getResenas().get(1).getFechaResena());

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pantallaRanking.opcionGenerarRankingVinos(gestor, vinos, pantallaExcel);
    }

}
