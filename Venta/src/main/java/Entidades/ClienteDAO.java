package Entidades;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Como los clientes estan registrados en todas las sucursales, independientemente de donde se registren, listare solo una vez.
public class ClienteDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listaCentral() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT *FROM controlventas.cliente";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNit(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setDireccion(rs.getString(3));
                lista.add(c);
            }

        } catch (Exception e) {
        }
        return lista;
    }   
    
    //Metodo para agregar un cliente a la tabla dentro de la base de datos 
    @Override
    public boolean agregar(Object[] o) {
        String sql = "INSERT INTO controlventas.cliente VALUES(?,?,?)";
        try {

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[1]);
            ps.setObject(2, o[2]);
            ps.setObject(3, o[3]);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return true;
    }

    //Metodo para buscar un clinte y poder realizar una venta.
    public Cliente BuscarCliente(String nit) {
        Cliente cliente = new Cliente();

        String sql = "SELECT *FROM controlventas.cliente WHERE nit=?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, nit);
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));

            }

        } catch (Exception e) {
        }
        return cliente;
    }

    //Metodo para actualizar la informacion del cliente. 
    @Override
    public boolean actualizar(Object[] o) {
        String sql = "UPDATE controlventas.cliente set nombre=?, direccion=? WHERE nit=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[1]);
            ps.setObject(2, o[2]);
            ps.setObject(3, o[0]);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return true;
    }
    
    
    
    
      //Metodos de la clase Interface, que no utilizare por ahora. 
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
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
