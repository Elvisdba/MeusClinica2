/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.dao.ConsultaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ConsultaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ConsultaDelegado {
    
    private final JPanel contenedor;
    private final ConsultaDao consultadao;

    public ConsultaDelegado(JPanel contenedor) {
        //asignacion inicial el valor de las constantes
        this.contenedor = contenedor;
        this.consultadao = new ConsultaDao();
    }
    public void insertarConsulta(ConsultaVo ConsultaVo){
        try {
            this.consultadao.insertar(ConsultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    }public void editarConsulta(ConsultaVo ConsultaVo){
            try {
                this.consultadao.editar(ConsultaVo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);

            }
    }
    
    public List<ConsultaVo> consultarConsultas(){
        List<ConsultaVo> listaConsultas;
        try {
         listaConsultas = this.consultadao.consultar();
        } catch (Exception e) {
            listaConsultas = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    return listaConsultas;
    }
    
    public ConsultaVo consultarConsulta(int id){
        ConsultaVo ConsultaVo;
        try {
            ConsultaVo = this.consultadao.consultar(id);
        } catch (Exception e) {
            ConsultaVo = new ConsultaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
        return ConsultaVo;
    
}
   
    
}
