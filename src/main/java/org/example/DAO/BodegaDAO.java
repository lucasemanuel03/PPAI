package org.example.DAO;

import org.example.Clases.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BodegaDAO implements EntidadesDAO{
    private Connection conn;
    public BodegaDAO(Connection conn){
        this.conn = conn;
    }

    public ArrayList<Bodega> getAllConRegion(ArrayList<RegionVitivinicola> regionVitivinicolas) throws SQLException {
        ArrayList<Bodega> bodegas = new ArrayList<Bodega>();
        String query = "SELECT * FROM bodegas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                String historia = rs.getString("historia");
                String coordenadasUbicacion = rs.getString("coordenadasUbicacion");
                String periodoActualizacion = rs.getString("periodoActualizacion");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int id_region = rs.getInt("id_region");
                RegionVitivinicola region = regionVitivinicolas.get(id_region - 1);

                bodegas.add(new Bodega(coordenadasUbicacion, descripcion, historia, nombre, periodoActualizacion, region));
            }
        }
        return bodegas;
    }
    @Override
    public ArrayList<Bodega> getAll() throws SQLException {
        ArrayList<Bodega> bodegas = new ArrayList<Bodega>();
        String query = "SELECT * FROM bodegas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                String historia = rs.getString("historia");
                String coordenadasUbicacion = rs.getString("coordenadasUbicacion");
                String periodoActualizacion = rs.getString("periodoActualizacion");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                RegionVitivinicola region = null;

                bodegas.add(new Bodega(coordenadasUbicacion, descripcion, historia, nombre, periodoActualizacion, null));
            }
        }
        return bodegas;
    }

    @Override
    public Object getById() throws SQLException {
        return null;
    }

    @Override
    public void delete() throws SQLException {

    }

    @Override
    public void udpate() throws SQLException {

    }

    @Override
    public void save() throws SQLException {

    }
}
