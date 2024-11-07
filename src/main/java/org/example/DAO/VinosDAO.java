package org.example.DAO;

import org.example.Clases.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class VinosDAO implements EntidadesDAO{

    private Connection conn;
    public VinosDAO(Connection conn){
        this.conn = conn;
    }
    public ArrayList<Vino> CrearRelacionesVino (ArrayList<Vino> vinos, ArrayList<Resena> resenas, ArrayList<Bodega> bodegas, List<Varietal> varietales){
        //varietal bodega hacer array
        ArrayList<Vino> vinost = new ArrayList<Vino>();
        String query = "SELECT * FROM vinos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                int anada = rs.getInt("anada");
                String imagenEtiqueta = rs.getString("imagenEtiqueta");
                String nombre = rs.getString("nombre");
                String notaCataBodega = rs.getString("notaCataBodega");
                double precio = rs.getDouble("precio");
                int id_bodega = rs.getInt("id_bodega");
                Bodega bodega = bodegas.get(id_bodega - 1);
                int id_varietal = rs.getInt("id_varietal");
                Varietal varietal = varietales.get(id_varietal -1);

                //Crear el array de Resenas
                ArrayList<Resena> resenasArray = null;
                String query2 = "SELECT * FROM resenas";
                try (Statement stmt2 = conn.createStatement();
                     ResultSet rs2 = stmt2.executeQuery(query2)){
                    while (rs2.next()){
                        int id_vino = rs2.getInt("id_vino");
                        if (id_vino == rs.getInt("id_vino")){
                            String comentario = rs2.getString("comentario");
                            boolean esPremium = false;
                            if(Objects.equals(rs2.getString("esPremium"),"true")){
                                esPremium = true;
                            }
                            String fechaResenaStr = rs2.getString("fechaResena");
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date fecha = sdf.parse(fechaResenaStr);
                            double puntaje = rs2.getDouble("puntaje");
                            resenas.add(new Resena(comentario, esPremium, fecha, puntaje, vinos.get(id_vino - 1)));
                        }
                    }
                }catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                vinost.add(new Vino(anada, imagenEtiqueta, nombre, notaCataBodega, precio, bodega, resenas, varietal));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vinost;
    }
    @Override
    public ArrayList<Vino> getAll() throws SQLException {
        ArrayList<Vino> vinos = new ArrayList<Vino>();
        String query = "SELECT * FROM vinos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()){
                int anada = rs.getInt("anada");
                String imagenEtiqueta = rs.getString("imagenEtiqueta");
                String nombre = rs.getString("nombre");
                String notaCataBodega = rs.getString("notaCataBodega");
                double precio = rs.getDouble("precio");
                System.out.println(precio);
                Bodega bodega = null;
                ArrayList<Resena> resenas = null;
                Varietal varietal = null;

                vinos.add(new Vino(anada, imagenEtiqueta, nombre, notaCataBodega, precio, bodega, resenas, varietal));
            }
        }
        return vinos;
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
