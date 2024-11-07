package org.example.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EntidadesDAO<T> {

    ArrayList<T> getAll() throws SQLException;
    T getById() throws SQLException;
    void delete() throws SQLException;
    void udpate() throws SQLException;
    void save() throws SQLException;

}
