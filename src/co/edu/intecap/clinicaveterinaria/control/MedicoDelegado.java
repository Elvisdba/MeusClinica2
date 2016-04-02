/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.dao.MedicoDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.MedicoVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class MedicoDelegado {
    
    private final JPanel contenedor;
    private final MedicoDao Medicodao;

    public MedicoDelegado(JPanel contenedor) {
        //asignacion inicial el valor de las constantes
        this.contenedor = contenedor;
        this.Medicodao = new MedicoDao();
    }
    public void insertarMedico(MedicoVo MedicoVo){
        try {
            this.Medicodao.insertar(MedicoVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    }public void editarMedico(MedicoVo MedicoVo){
            try {
                this.Medicodao.editar(MedicoVo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);

            }
    }
    
    public List<MedicoVo> consultarMedicos(){
        List<MedicoVo> listaMedicos;
        try {
         listaMedicos = this.Medicodao.consultar();
        } catch (Exception e) {
            listaMedicos = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    return listaMedicos;
    }
    
    public MedicoVo consultarMedico(int id){
        MedicoVo MedicoVo;
        try {
            MedicoVo = this.Medicodao.consultar(id);
        } catch (Exception e) {
            MedicoVo = new MedicoVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
        return MedicoVo;
    
}
   
    
}
