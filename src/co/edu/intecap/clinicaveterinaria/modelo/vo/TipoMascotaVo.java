/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.vo;

/**
 *
 * @author capacitaciones
 */
public class TipoMascotaVo {
    private int idTipoMascota;
    private String Nombre;
    private boolean estado;

    /**
     * @return the idTipoMascota
     */
    public int getIdTipoMascota() {
        return idTipoMascota;
    }

    
    public void setIdTipoMascota(int idTipoMascota) {
        this.idTipoMascota = idTipoMascota;
    }

   
    public String getNombre() {
        return Nombre;
    }

   
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
