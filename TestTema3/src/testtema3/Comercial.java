/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtema3;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author windeveloper
 */
@Entity
public class Comercial implements Serializable{
    @Id
    @Column(length=15)
    private int idComercial;
    @Column(length=175)
    private String nombre;
    @OneToOne
    private Zona zona;

    public int getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(int idComercial) {
        this.idComercial = idComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
}