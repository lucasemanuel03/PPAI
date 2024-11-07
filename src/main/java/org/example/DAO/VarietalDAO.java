package org.example.DAO;

import org.example.Clases.Bodega;
import org.example.Clases.Varietal;

import javax.swing.plaf.synth.Region;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VarietalDAO implements EntidadesDAO{
    private Connection conn;
    public VarietalDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Varietal> getAll() throws SQLException {
        ArrayList<Varietal> varietales = new ArrayList<Varietal>();
        String query = "SELECT * FROM varietales";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                String descripcion = rs.getString("descripcion");
                double porcentajeComposicion = rs.getDouble("porcentajeComposicion");

                varietales.add(new Varietal(descripcion, porcentajeComposicion));
            }
        }
        return varietales;
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
