package org.example.DAO;

import org.example.Clases.Bodega;
import org.example.Clases.Pais;
import org.example.Clases.Provincia;
import org.example.Clases.RegionVitivinicola;

import javax.swing.plaf.synth.Region;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProvinciaDAO implements EntidadesDAO{
    private Connection conn;
    public ProvinciaDAO(Connection conn){
        this.conn = conn;
    }

    public ArrayList<Provincia> getAllConPaises(ArrayList<Pais> paises) throws SQLException {
        ArrayList<Provincia> provincias = new ArrayList<Provincia>();
        String query = "SELECT * FROM provincias";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                int id_pais = rs.getInt("id_pais");
                String nombre = rs.getString("nombre");
                Pais pais = paises.get(id_pais - 1);

                provincias.add(new Provincia(nombre, pais));
            }
        }
        return provincias;
    }
    @Override
    public ArrayList<Provincia> getAll() throws SQLException {
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
