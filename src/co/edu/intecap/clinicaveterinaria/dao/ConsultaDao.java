/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ConsultaVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author capacitaciones
 */
public class ConsultaDao extends Conexion implements GenericoDao<ConsultaVo>{

    @Override
    public void insertar(ConsultaVo object) {
    PreparedStatement sentencia = null;
        
        try {
        conectar();
        //crear consulta de la insersion
        String sql = "insert into consulta(fecha, motivo, descripcion, estado, id_medico, id_historia) values(?,?,?,?,?.?)";
        sentencia=cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //asignar parametros a la insersion
        sentencia.setDate(1, object.getFecha());
        sentencia.setString(2, object.getMotivo());
        sentencia.setString(3, object.getDescripcion());
        sentencia.setString(4, object.getEstado());
        sentencia.setInt(5, object.getIdMedico());
        sentencia.setInt(5, object.getIdHistoria());
        //ejecutar la insersion
        sentencia.executeUpdate();
        //obtener llave de registro de la consulta
        ResultSet rs = sentencia. getGeneratedKeys();
        if (rs.next()){
            object.setIdConsulta(rs.getInt(1));
            
        }
        } catch (Exception e) {
        e.printStackTrace(System.err);
        } finally{
        desconectar();
        }        
    }

    @Override
    public void editar(ConsultaVo object) {
        PreparedStatement sentencia;
        try {
            conectar();
            //crear string del sql de actualizacion
            String sql = "update consulta set id_consulta = ?, fecha = ?, motivo = ?, descripcion = ?, estado = ?, id_medico = ?, id_historia = ?, id_consulta = ?"; 
            sentencia = cnn.prepareStatement(sql);
            sentencia.setInt(1, object.getIdConsulta());
            sentencia.setDate(2, object.getFecha());
            sentencia.setString(3, object.getMotivo());
            sentencia.setString(4, object.getDescripcion());
            sentencia.setString(5, object.getEstado());
            sentencia.setInt(6, object.getIdMedico());
            sentencia.setInt(7, object.getIdHistoria());
            sentencia.setInt(8, object.getIdConsulta());
            //ejecutar la actualizacion
            sentencia.executeUpdate();
        } catch (Exception e) {
        e.printStackTrace(System.err);
        }finally{
            desconectar();
        }
    }

    @Override
    public List<ConsultaVo> consultar() {
        PreparedStatement sentencia;
        List<ConsultaVo> lista = new ArrayList<>();
        try {
            conectar();
            //consulta de todos los registros de la tabla
            String sql = "select * from consulta";
            sentencia = cnn.prepareStatement(sql);
            // obtener los registros de la tabla.
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                ConsultaVo consulta = new ConsultaVo();
                //obtener el id de la mascota del cursor y asignarlo al atributo idMacota de un objeto de la clase mascotaVo
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setFecha(rs.getDate("fecha"));
                consulta.setMotivo(rs.getString("motivo"));
                consulta.setDescripcion(rs.getString("descripcion"));
                consulta.setEstado(rs.getString("estado"));
                consulta.setIdMedico(rs.getInt("id_medico"));
                consulta.setIdHistoria(rs.getInt("id_historia"));
                lista.add(consulta);
            }   
        } catch (Exception e) {
        e.printStackTrace(System.err);
        }finally{
            desconectar();
        }
        return lista;
    }

    @Override
    public ConsultaVo consultar(int id) {
    return null;
    }
    
}
