package DAO;

import java.sql.SQLException;
import java.util.List;

// O stand for (object)
public interface DAO<O> {
    O get(int id) throws SQLException;
    List<O> getAll() throws SQLException;
    Boolean save(O o) throws SQLException;
    Boolean update(O o) throws SQLException;
    Boolean delete(int id) throws SQLException;
}
