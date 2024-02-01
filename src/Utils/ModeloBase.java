package com.ceica.Modelos;

import com.sun.source.tree.BreakTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class ModeloBase {
    private static final String CONFIG_FILE = "config.properties";
    protected static String URL;
    protected static String USUARIO;
    protected static String PASSWORD;

    static {
        cargarConfiguracion();
    }

    private static void cargarConfiguracion() {
        Properties propiedades = new Properties();
        try (FileInputStream entrada = new FileInputStream(CONFIG_FILE)) {
            propiedades.load(entrada);
            URL = propiedades.getProperty("db.url");
            USUARIO = propiedades.getProperty("db.usuario");
            PASSWORD = propiedades.getProperty("db.pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método abstracto para obtener el nombre de la tabla
    protected abstract String getNombreTabla();

    // Métodos para CRUD

    public boolean insertar(String sql, Object... parametros) {
        sql="insert into "+getNombreTabla()+" "+sql;
        return  ejecutarQuery(sql,parametros);

    }

    public boolean actualizar(String sql, Object... parametros) {
        sql = "update  " + getNombreTabla() + " set " + sql;
        return ejecutarQuery(sql, parametros);
    }

    public boolean borrar(String sql, Object... parametros) {
        sql="delete from "+getNombreTabla()+" where "+sql;
        return ejecutarQuery(sql, parametros);
    }

    // Método para leer datos de la base de datos

    protected List<Object> leer(String sql,Object...parametros){
        List<Object> objectList= new ArrayList<>();
        try{
            Connection conexion = DriverManager.getConnection(URL,USUARIO,PASSWORD);
            PreparedStatement preparedStatement=conexion.prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    // Método genérico para ejecutar consultas SQL
    private boolean ejecutarQuery(String sql, Object... parametros) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            // Establecer los valores de los parámetros
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            if (preparedStatement.executeUpdate() > 0) {
                return true;

            } else {
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    protected abstract Object createObjectFromResultSet(ResultSet resultSet) throws SQLException;
}

