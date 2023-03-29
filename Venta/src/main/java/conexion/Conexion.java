/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author UsuarioA
 */
public class Conexion {

    public static Connection dbConnection;
    public static String url = "jdbc:postgresql://localhost:5432/venta";
    public static  String usuario = "admin1";
    public static  String clave = "admin1234";

    public static Connection Conectar() {

        try {
            dbConnection = DriverManager.getConnection(url, usuario, clave);
            return dbConnection;
        } catch (Exception e) {
            System.err.println("Error al conectar con la base de datos");
            return null;
        }

    }
}

