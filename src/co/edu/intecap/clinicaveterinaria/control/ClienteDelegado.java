package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.dao.ClienteDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ClienteVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ClienteDelegado {
    private final JPanel contenedor;
    private final ClienteDao clientedao;

    public ClienteDelegado(JPanel contenedor) {
        //asignacion inicial el valor de las constantes
        this.contenedor = contenedor;
        this.clientedao = new ClienteDao();
    }
    public void insertarCliente(ClienteVo clienteVo){
        try {
            this.clientedao.insertar(clienteVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    }public void editarCliente(ClienteVo clienteVo){
            try {
                this.clientedao.editar(clienteVo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);

            }
    }
    
    public List<ClienteVo> consultarClientes(){
        List<ClienteVo> listaClientes;
        try {
         listaClientes = this.clientedao.consultar();
        } catch (Exception e) {
            listaClientes = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
    return listaClientes;
    }
    
    public ClienteVo consultarCliente(int id){
        ClienteVo clienteVo;
        try {
            clienteVo = this.clientedao.consultar(id);
        } catch (Exception e) {
            clienteVo = new ClienteVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "error en insercion", JOptionPane.ERROR_MESSAGE);
        }
        return clienteVo;
    
}
   
    }
