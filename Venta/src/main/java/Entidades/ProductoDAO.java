/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    //Listo los productos que estan en la sucursal central 
    @Override
    public List listaCentral() {
        List<Producto> lista = new ArrayList<>();
        String sucursal = "SC1";
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE inventario.sucursal = '" + sucursal + "'";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(5));
                p.setCodigo(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(8));
                p.setSucural(rs.getString(6));
                lista.add(p);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    public Producto BuscarProductoNorte(String cod) {
        Producto prod = new Producto();
        String sucursal = "SN2";
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE codigo_producto=? AND inventario.sucursal = '" + sucursal + "'";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                prod.setNombre(rs.getString("nombreProducto"));
                prod.setPrecio(rs.getDouble("precio_unidad"));
                prod.setStock(rs.getInt("stock"));
                prod.setCodigo(rs.getString("codigo_producto"));

            }

        } catch (Exception e) {
        }
        return prod;
    }

    public Producto BuscarProductoCentral(String cod) {
        Producto prod = new Producto();
        String sucursal = "SC1";
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE codigo_producto=? AND inventario.sucursal = '" + sucursal + "'";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                prod.setNombre(rs.getString("nombreProducto"));
                prod.setPrecio(rs.getDouble("precio_unidad"));
                prod.setStock(rs.getInt("stock"));
                prod.setCodigo(rs.getString("codigo_producto"));

            }

        } catch (Exception e) {
        }
        return prod;
    }

      public Producto BuscarProductoSur(String cod) {
        Producto prod = new Producto();
        String sucursal = "SS3";
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE codigo_producto=? AND inventario.sucursal = '" + sucursal + "'";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                prod.setNombre(rs.getString("nombreProducto"));
                prod.setPrecio(rs.getDouble("precio_unidad"));
                prod.setStock(rs.getInt("stock"));
                prod.setCodigo(rs.getString("codigo_producto"));

            }

        } catch (Exception e) {
        }
        return prod;
    }
     
    //Agrego productos a la base de datos 
    @Override
    public boolean agregar(Object[] o) {
        String sql = "INSERT INTO controlventas.producto (codigo_producto,nombreProducto,descripcion,precio_unidad)VALUES(?,?,?,?)";
        try {

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[1]);
            ps.setObject(2, o[2]);
            ps.setObject(3, o[3]);
            ps.setObject(4, o[4]);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return true;
    }

    public boolean AgregarInventario(Object[] o) {
        String sql = "INSERT INTO controlventas.inventario (sucursal,producto,stock)VALUES(?,?,?)";
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

    @Override
    public boolean actualizar(Object[] o) {
        String sql = "UPDATE controlventas.producto set nombreProducto=?, descripcion=?, precio_unidad=? WHERE codigo_producto=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[1]);
            ps.setObject(2, o[2]);
            ps.setObject(3, o[3]);
            ps.setObject(4, o[0]);

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return true;
    }

    public boolean actualizarInventario(Object[] o) {
        String sql = "UPDATE controlventas.inventario set sucursal=?, producto=?, stock=? WHERE idInventario=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[1]);
            ps.setObject(2, o[2]);
            ps.setObject(3, o[3]);
            ps.setObject(4, o[0]);

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listaSur() {
         List<Producto> lista = new ArrayList<>();
        String sucursal = "SS3";
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE inventario.sucursal = '" + sucursal + "'";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(5));
                p.setCodigo(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(8));
                p.setSucural(rs.getString(6));
                lista.add(p);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public List listaNorte() {
        List<Producto> lista = new ArrayList<>();
        String sucursal = "SN2";
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE inventario.sucursal = '" + sucursal + "'";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(5));
                p.setCodigo(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(8));
                p.setSucural(rs.getString(6));
                lista.add(p);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public List listaBodega() {
        List<Producto> lista = new ArrayList<>();
        String sucursal = "BD1";
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE inventario.sucursal = '" + sucursal + "'";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(5));
                p.setCodigo(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(8));
                p.setSucural(rs.getString(6));
                lista.add(p);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    //metodo para listar los productos mas vendidos 
    public List MasVendidos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT producto.codigo_producto, producto.nombreproducto, "
                + "SUM(detalleventa.cantidad) FROM controlventas.detalleventa JOIN controlventas.producto "
                + "ON detalleventa.idprod = producto.codigo_producto GROUP BY producto.codigo_producto, "
                + "producto.nombreproducto ORDER BY SUM(detalleventa.cantidad)DESC LIMIT 10";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                
                p.setCodigo(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setStock(rs.getInt(3));
                lista.add(p);
            }

        } catch (Exception e) {
        }
        return lista;
    }

    public Producto BuscarProducto(String cod, String sucursal) {
        Producto prod = new Producto();
        Inventario ven = new Inventario();
        String sql = "SELECT *FROM controlventas.producto JOIN controlventas.inventario "
                + "ON producto.codigo_producto = inventario.producto WHERE codigo_producto=? AND inventario.sucursal = ?";

        /*String sql = "SELECT *FROM controlventas.producto WHERE codigo_producto=? AND "
                + "sucursal =?";*/
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            ps.setString(2, sucursal);
            rs = ps.executeQuery();

            if (rs.next()) {
                prod.setNombre(rs.getString("nombreProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getDouble("precio_unidad"));
                prod.setSucural(rs.getString("sucursal"));
                prod.setStock(rs.getInt("stock"));

            }

        } catch (Exception e) {
        }
        return prod;
    }
}
