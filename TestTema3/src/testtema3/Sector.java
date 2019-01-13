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

/**
 *
 * @author windeveloper
 */
@Entity 
public class Sector implements Serializable{
    @Id
    @Column(length=30)
    private int idSector;
    @Column(length=100)
    private String descripcion;
    
    @ManyToMany(mappedBy="Sector", fetch=FetchType.LAZY)
    private List <Articulo> articulos; //Recuperar de forma diferida
    
    public Sector(int idSector, String descripcion){
        this.idSector = idSector;
        this.descripcion = descripcion;
    }
    
    public Sector(){
        
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
