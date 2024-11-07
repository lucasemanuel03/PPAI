package org.example.DAO;

import org.example.Clases.Bodega;
import org.example.Clases.Provincia;
import org.example.Clases.RegionVitivinicola;

import javax.swing.plaf.synth.Region;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RegionVitivinicolaDAO implements EntidadesDAO{
    private Connection conn;
    public RegionVitivinicolaDAO(Connection conn){
        this.conn = conn;
    }

    public ArrayList<RegionVitivinicola> getAllConProvincia(ArrayList<Provincia> provincias) throws SQLException {
        ArrayList<RegionVitivinicola> regionVitivinicolas = new ArrayList<RegionVitivinicola>();
        String query = "SELECT * FROM regionesVitivinicolas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int id_provincia = rs.getInt("id_provincia");
                Provincia provincia = provincias.get(id_provincia - 1);

                regionVitivinicolas.add(new RegionVitivinicola(nombre, descripcion, provincia));
            }
        }
        return regionVitivinicolas;
    }
    @Override
    public ArrayList<RegionVitivinicola> getAll() throws SQLException {
        return null;
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
