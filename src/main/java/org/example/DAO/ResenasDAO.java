package org.example.DAO;

import org.example.Clases.Bodega;
import org.example.Clases.Resena;
import org.example.Clases.Vino;

import javax.swing.plaf.synth.Region;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ResenasDAO implements EntidadesDAO{

    private Connection conn;
    public ResenasDAO(Connection conn){
        this.conn = conn;
    }
    public ArrayList<Resena> getAllConVinos(ArrayList<Vino> vinos) throws SQLException {
        ArrayList<Resena> resenas = new ArrayList<Resena>();
        String query = "SELECT * FROM resenas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                String comentario = rs.getString("comentario");
                boolean esPremium = false;
                if(Objects.equals(rs.getString("esPremium"),"true")){
                    esPremium = true;
                }
                String fechaResenaStr = rs.getString("fechaResena");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = sdf.parse(fechaResenaStr);
                double puntaje = rs.getDouble("puntaje");
                int id_vino = rs.getInt("id_vino");
                Vino vino = vinos.get(id_vino - 1);

                resenas.add(new Resena(comentario, esPremium, fecha, puntaje, vino));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return resenas;
    }
    @Override
    public ArrayList<Resena> getAll() throws SQLException {
        ArrayList<Resena> resenas = new ArrayList<Resena>();
        String query = "SELECT * FROM resenas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                String comentario = rs.getString("comentario");
                boolean esPremium = false;
                if(Objects.equals(rs.getString("coordenadasUbicacion"),"true")){
                    esPremium = true;
                }
                String fechaResenaStr = rs.getString("fechaResena");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = sdf.parse(fechaResenaStr);
                double puntaje = rs.getDouble("puntaje");


                resenas.add(new Resena(comentario, esPremium, fecha, puntaje, null));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return resenas;
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
