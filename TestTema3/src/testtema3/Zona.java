/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtema3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

/**
 *
 * @author windeveloper 
 * prueba de updateo
 */
@Entity
public class Zona implements Serializable{
    @Id
    @Column(length=30)
    private int idZona;
    @Column(length=100)
    private String descripcion;
    @OneToOne
    private Comercial comercial;
    
    @ManyToMany(mappedBy="zona", fetch=FetchType.LAZY)
    @OrderBy(value="nombre")
    private List <Cliente> clientes; //Recuperar de forma diferida ordenada por nombre

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
