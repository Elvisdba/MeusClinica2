/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.dao.TipoMascotaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class TipoMascotaDelegado {
    
    private final JPanel contenedor;
    private final TipoMascotaDao tipomascotadao;

    public TipoMascotaDelegado(JPanel contenedor) {
        //asignacion inicial el valor de las constantes
        this.contenedor = contenedor;
        this.tipomascotadao = new TipoMascotaDao();
    }
    public void insertarTipoMascota(TipoMascotaVo tipomascotaVo){
        try {
            this.tipomascotadao.insertar(tipomascotaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    }public void editarTipoMascota(TipoMascotaVo tipomascotaVo){
            try {
                this.tipomascotadao.editar(tipomascotaVo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);

            }
    }
    
    public List<TipoMascotaVo> consultarTipoMascotas(){
        List<TipoMascotaVo> listaTipoMascotas;
        try {
         listaTipoMascotas = this.tipomascotadao.consultar();
        } catch (Exception e) {
            listaTipoMascotas = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    return listaTipoMascotas;
    }
    
    public TipoMascotaVo consultarTipoMascota(int id){
        TipoMascotaVo tipomascotaVo;
        try {
            tipomascotaVo = this.tipomascotadao.consultar(id);
        } catch (Exception e) {
            tipomascotaVo = new TipoMascotaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
        return tipomascotaVo;
    
}
   
}
