package Modelo;

import Controlador.PersistanceController;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return em;
    }/*La parte de "validar", solo la tendra la clase Java "EmpleadoDAO" ya 
    que este es el que se valida en el area del login, mientras que "ClienteDAO",
    y "ProductoDAO" no lo tendrán*/

    
    //Listar Empleado
    public List<Empleado> getListaEmpleados() {
        return PersistanceController.buscarPorClase(Empleado.class);
    }

    //Guardar Empleado 
    public boolean guardarEmpleado(Empleado empleado) {
        return PersistanceController.guardar(empleado);
    }

    //Editar Empleado
    public Empleado getEditarEmpleado(int idEmpleado) {
        return (Empleado) PersistanceController.buscarPorId(Empleado.class, idEmpleado);
    }

    //Actualizar Empleado
    public boolean actualizarEmpleado(Empleado empleado) {
        return PersistanceController.actualizar(empleado);
    }
    
    //Eliminar Empleado
    public boolean eliminarEmpleado(int idEmpleado) {
        return PersistanceController.<Empleado>eliminarPorId(idEmpleado, Empleado.class);
    }
    
}
