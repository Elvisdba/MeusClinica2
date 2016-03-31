
package co.edu.intecap.clinicaveterinaria.modelo.vo;


import java.sql.Date;

/**
 *
 * @author capacitaciones
 */
public class HistoriaVo {
    
    
    private Date fechaApertura;
    private Date fechaCierre;
    private int idHistoria;
    private boolean estado;
    private int idMascota;

    /**
     * @return the fechaApertura
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * @param fechaApertura the fechaApertura to set
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * @return the fechaCierre
     */
    public Date getFechaCierre() {
        return fechaCierre;
    }

    /**
     * @param fechaCierre the fechaCierre to set
     */
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    /**
     * @return the idHistoria
     */
    public int getIdHistoria() {
        return idHistoria;
    }

    /**
     * @param idHistoria the idHistoria to set
     */
    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the idMascota
     */
    public int getIdMascota() {
        return idMascota;
    }

    /**
     * @param idMascota the idMascota to set
     */
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
    
}
