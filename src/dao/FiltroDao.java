/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Filtro;
//import sun.util.logging.PlatformLogger;

/**
 *
 * @author LN710Q
 */
public class FiltroDao implements metodos<Filtro> {

    private static final String SQL_INSERT = "INSERT INTO productos (codigo, precio, nombre, cantidad, tipo, disponibilidad) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE productos SET precio = ?, nombre = ?, cantidad = ?, tipo = ?, disponibilidad = ? WHERE codigo = ?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE codigo = ?";
    private static final String SQL_READ = "SELECT * FROM productos WHERE codigo = ?";
    private static final String SQL_READALL = "SELECT * FROM productos";
    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(Filtro g) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, g.getCodigo());
            ps.setDouble(2, g.getPrecio());
            ps.setString(3, g.getNombre());
            ps.setInt(4, g.getCantidad());
            ps.setString(5, g.getTipo());
            ps.setBoolean(6, true);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Filtro c) {
        PreparedStatement ps;
        try {
            System.out.println(c.getCodigo());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setDouble(1, c.getPrecio());
            ps.setString(2,c.getNombre());
            ps.setInt(3, c.getCantidad());
            ps.setString(4, c.getTipo());
            ps.setBoolean(5, c.getDisponibilidad());
            ps.setString(6, c.getCodigo());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Filtro read(Object key) {
        Filtro f = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                f = new Filtro(rs.getInt(1), rs.getString(3), rs.getDouble(6), rs.getString(2), rs.getInt(5), rs.getString(4), rs.getBoolean(7));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return f;

    }

    @Override
    public ArrayList<Filtro> readAll() {
        ArrayList<Filtro> all = new ArrayList();
        Statement s;
        ResultSet rs;

        try {
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);

            while (rs.next()) {
                all.add(new Filtro(rs.getInt(1),rs.getString(3), rs.getDouble(6), rs.getString(2), rs.getInt(5), rs.getString(4), rs.getBoolean(7)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }

}
