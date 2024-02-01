package Utils;

import java.sql.*;

public class User extends com.ceica.Modelos.ModeloBase {
    private int iduser;
    private String username;
    private String password;
    private Rol rol;

    public User() {
    }

    @Override
    protected String getNombreTabla() {
        return null;
    }
    @Override
    protected Object createObjectFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}


