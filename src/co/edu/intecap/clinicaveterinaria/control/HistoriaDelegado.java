/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.dao.HistoriaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.HistoriaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class HistoriaDelegado {
    
    private final JPanel contenedor;
    private final HistoriaDao historiadao;

    public HistoriaDelegado(JPanel contenedor) {
        //asignacion inicial el valor de las constantes
        this.contenedor = contenedor;
        this.historiadao = new HistoriaDao();
    }
    public void insertarCliente(HistoriaVo historiaVo){
        try {
            this.historiadao.insertar(historiaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    }public void editarCliente(HistoriaVo historiaVo){
            try {
                this.historiadao.editar(historiaVo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);

            }
    }
    
    public List<HistoriaVo> consultarClientes(){
        List<HistoriaVo> listaClientes;
        try {
         listaClientes = this.historiadao.consultar();
        } catch (Exception e) {
            listaClientes = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    return listaClientes;
    }
    
    public HistoriaVo consultarCliente(int id){
        HistoriaVo historiaVo;
        try {
            historiaVo = this.historiadao.consultar(id);
        } catch (Exception e) {
            historiaVo = new HistoriaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
        return historiaVo;
    
}
   
    
}
