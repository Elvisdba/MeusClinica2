package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.dao.MascotaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.MascotaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author capacitaciones
 */
public class MascotaDelegado {
    //atributos de clase que son constantes (su valor como objeto mo puede cambiar)
    private final JFrame contenedor;
    private final MascotaDao mascotadao;

    public MascotaDelegado(JFrame contenedor) {
        //asignacion inicial el valor de las constantes
        this.contenedor = contenedor;
        this.mascotadao = new MascotaDao();
    }
    public void insertarMascota(MascotaVo mascotaVo){
        try {
            this.mascotadao.insertar(mascotaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    }public void editarMascota(MascotaVo mascotaVo){
            try {
                this.mascotadao.editar(mascotaVo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);

            }
    }
    
    public List<MascotaVo> consultarMascotas(){
        List<MascotaVo> listaMascotas;
        try {
         listaMascotas = this.mascotadao.consultar();
        } catch (Exception e) {
            listaMascotas = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    return listaMascotas;
    }
    
    public MascotaVo consultarMascota(int id){
        MascotaVo mascotaVo;
        try {
            mascotaVo = this.mascotadao.consultar(id);
        } catch (Exception e) {
            mascotaVo = new MascotaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
        return mascotaVo;
    }
}
