/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ClienteVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author capacitaciones
 */
public class ClienteDao extends Conexion implements GenericoDao<ClienteVo>{

    @Override
    public void insertar(ClienteVo object) {
        
        
        PreparedStatement sentencia = null;
        
        try {
        conectar();
        //crear consulta de la insersion
        String sql = "insert into cliente( nombre, correo, telefono, estado) values(?,?,?,?)";
        sentencia=cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //asignar parametros a la insersion
        sentencia.setString(1, object.getNombre());
        sentencia.setString(2, object.getCorreo());
        sentencia.setString(3, object.getTelefono());
        sentencia.setBoolean(4, object.isEstado());    
        //ejecutar la insersion
        sentencia.executeUpdate();
        //obtener llave de registro del cliente
        ResultSet rs = sentencia. getGeneratedKeys();
        if (rs.next()){
            object.setIdCliente(rs.getInt(1));
            
        }
        } catch (Exception e) {
        e.printStackTrace(System.err);
        } finally{
        desconectar();
        }
    }

    @Override
    public void editar(ClienteVo object) {
        
   PreparedStatement sentencia;
        try {
            conectar();
            //crear string del sql de actualizacion
            String sql = "update cliente set id_cliente = ?, nombre = ?, correo = ?, telefono = ?, estado = ?"; 
            sentencia = cnn.prepareStatement(sql);
            sentencia.setInt(1, object.getIdCliente());
            sentencia.setString(2, object.getNombre());
            sentencia.setString(3, object.getCorreo());
            sentencia.setString(4, object.getTelefono());
            sentencia.setBoolean(5, object.isEstado());  
            sentencia.setInt(6, object.getIdCliente());
            //ejecutar la actualizacion
            sentencia.executeUpdate();
        } catch (Exception e) {
        e.printStackTrace(System.err);
        }finally{
            desconectar();
        }
    }

    @Override
    public List<ClienteVo> consultar() {
        PreparedStatement sentencia;
        List<ClienteVo> lista = new ArrayList<>();
        try {
            conectar();
            //consulta de todos los registros de la tabla
            String sql = "select * from cliente";
            sentencia = cnn.prepareStatement(sql);
            // obtener los registros de la tabla.
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                ClienteVo cliente = new ClienteVo();
                cliente.setIdCliente(rs.getInt("id_mascota"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getBoolean("estado"));
                lista.add(cliente);
            }   
        } catch (Exception e) {
        }finally{
            desconectar();
        }
        return lista;
    }

    @Override
    public ClienteVo consultar(int id) {
        PreparedStatement sentencia;
        ClienteVo obj = new ClienteVo();
        try {
            conectar();
            //consulta de un registro de la tabla según la llave
            //primaria
            String sql = "select * from cliente where id_cliente = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setInt(1, id);
            // obtener los registros de la tabla.
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                //obtener el id del cliente del cursor y asignarlo al atributo idCliente de un objeto de la clase ClienteVo
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setNombre(rs.getString("nombre"));
                obj.setCorreo(rs.getString("correo"));
                obj.setTelefono(rs.getString("Telefono"));
                obj.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
        e.printStackTrace(System.err);
        }finally{
            desconectar();
        }
        return obj;
    }

}
