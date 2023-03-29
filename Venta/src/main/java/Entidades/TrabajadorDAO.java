
package Entidades;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class TrabajadorDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    //Listo los trabajadores que estan registrados en la base de datos 
    @Override
    public List listaCentral() {
        List<Trabajador> lista = new ArrayList<>();
        String sql = "SELECT *FROM controlpersonal.empleado";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Trabajador t = new Trabajador();
                t.setCodigo(rs.getString(1));
                t.setNombre(rs.getString(2));
                t.setPass(rs.getString(3));
                t.setRol(rs.getInt(4));
                t.setSucursal(rs.getString(5));
                lista.add(t);
            }

        } catch (Exception e) {
        }
        return lista;
    }
    
    //Metodo para consultar los roles que existem y agregarlos a un JComboBox en la vista 
    public void ConsultarRol(JComboBox rol){
        String sql = "SELECT nombrerol FROM controlpersonal.rol";
        
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                rol.addItem(rs.getString("nombrerol"));
            }        
        }catch(SQLException e){
        
        }
    }

    //Metodo para agregar un nuevo trabajador 
    @Override
    public boolean agregar(Object[] o) {
        String sql = "INSERT INTO controlpersonal.empleado VALUES(?,?,?,?,?)";
        try {

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[1]);
            ps.setObject(2, o[2]);
            ps.setObject(3, o[3]);
            ps.setObject(4, o[4]);
            ps.setObject(5, o[5]);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return true;
    }
    
    
    //Metodos que no utilizare en esta clase 
    @Override
    public List listaSur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listaNorte() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listaBodega() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
