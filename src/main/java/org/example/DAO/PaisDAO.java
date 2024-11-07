package org.example.DAO;

import org.example.Clases.Pais;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO implements EntidadesDAO{
    private Connection conn;
    public PaisDAO(Connection conn){
        this.conn = conn;
    }


    @Override
    public ArrayList<Pais> getAll() throws SQLException {
        ArrayList<Pais> paises = new ArrayList<Pais>();
        String query = "SELECT * FROM paises";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                String nombre = rs.getString("nombre");
                paises.add(new Pais(nombre));
            }
        }
        return paises;
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
