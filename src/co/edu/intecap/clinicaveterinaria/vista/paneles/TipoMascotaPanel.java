package co.edu.intecap.clinicaveterinaria.vista.paneles;

import co.edu.intecap.clinicaveterinaria.control.TipoMascotaDelegado;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author capacitaciones
 */
public class TipoMascotaPanel extends javax.swing.JPanel {

    /**
     * Creates new form TipoMascotaPanel
     */
    public TipoMascotaPanel() {
        initComponents();
        configurarTabla();
        llenarTabla(new TipoMascotaDelegado(this).consultarTipoMascotas(), modelo);
        this.tipoMascotaVo = new TipoMascotaVo();
    }
    
    private DefaultTableModel modelo;
    private final TipoMascotaVo tipoMascotaVo;
    
  
    /**
     *     metodo para obtener valores de la GUI y registrar un nuevo TipoMascota
     */
    private void registrarTipoMascota(){
        //asignar nombre del tipo de mascota
        tipoMascotaVo.setNombre(txtNombre.getText());
        tipoMascotaVo.setEstado(cbxEstado.isSelected());
        new TipoMascotaDelegado(this).insertarTipoMascota(tipoMascotaVo);
        //mensaje de confirmacion de registro
        JOptionPane.showMessageDialog(this, "Tipo de Mascota Registrado", "Registro de Datos", JOptionPane.INFORMATION_MESSAGE);
        refrescarTabla();
        limpiarCampos();
    }
    
    /**
     * carga una lista de tipos de mascota desde la base de datos a la tabla de la GUI
     * @param listaTipoMascota Lista de tipos de mascota de la base de datos
     * @param modelo Modelo de tabla con la estructura de los datos a cargar
     */
    private void llenarTabla(List<TipoMascotaVo> listaTipoMascota,DefaultTableModel modelo){
        for (TipoMascotaVo tipoMascotaVo : listaTipoMascota) {
            Object [] fila = new Object [3];
            fila[0] = tipoMascotaVo.getIdTipoMascota();
            fila[1] = tipoMascotaVo.getNombre();
            fila[2] = tipoMascotaVo.isEstado();
            modelo.addRow(fila);
        }
        tblTipoMascota.updateUI();
    }
    /**
     * actualiza la informacion de la tabla cada vez que se realiza un registro
     */
    private void refrescarTabla(){
        modelo.setRowCount(0);
        List<TipoMascotaVo> listaMascotas = new TipoMascotaDelegado(this).consultarTipoMascotas();
        llenarTabla(listaMascotas, modelo);
    }
    private void limpiarCampos() {
        txtNombre.setText("");
        cbxEstado.setSelected(false);
    }
    
    /**
     * permite establecer los parametros iniciales de una tabla
     */
    private void configurarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Mascota");
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");
        tblTipoMascota.setModel(modelo);
        tblTipoMascota.getSelectionModel().addListSelectionListener(tableListener);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cbxEstado = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoMascota = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Estado:");

        cbxEstado.setText("Activo");
        cbxEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tblTipoMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTipoMascota);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxEstado))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.registrarTipoMascota();
        
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    ListSelectionListener tableListener = new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (tblTipoMascota.getSelectedRow() > -1) {
                //aquí se castea el Object que devuelve tblTipoMascota, al poner (int) en frente se le fuerza a devolver un entero
                //se obtiene el id de la fila seleccionada en la tabla
                int id = (int)tblTipoMascota.getValueAt(tblTipoMascota.getSelectedRow(), 0);
                //consultar en la base de datos por ese id seleccionado y guardar el resultado seleccionado en un nuevo 
                //objeto de TipoMascotaVo
                TipoMascotaVo tMvo = new TipoMascotaDelegado(TipoMascotaPanel.this).consultarTipoMascota(id);
                // asignar los valores obtenidos de la consulta de la constante
                tipoMascotaVo.setNombre(tMvo.getNombre());
                tipoMascotaVo.setIdTipoMascota(tMvo.getIdTipoMascota());
                tipoMascotaVo.setEstado(tMvo.isEstado());
                
                llenarCampos();
            }
        }
    };
    
    private void llenarCampos(){
        txtNombre.setText(tipoMascotaVo.getNombre());
        cbxEstado.setSelected(tipoMascotaVo.isEstado());
    } 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblTipoMascota;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
