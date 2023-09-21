package DAOimplementation;
import DAO.DAO;
import DTO.User;

import java.sql.SQLException;

public interface UserDAO extends DAO<User> {
    Boolean login(User user) throws SQLException;
}