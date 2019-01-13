/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtema3;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author windeveloper
 */
@Entity
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames="nif") //Pone la columna nif como unique constraint)
})
@NamedQueries({ //Conseguimos realizar queries predefinidas
    @NamedQuery(name="Cliente.sector", query= "SELECT c FROM Cliente c WHERE c.sector.idSector=:sector"),
    @NamedQuery(name="Cliente.nif", query= "SELECT c FROM Cliente c WHERE c.nif=:nif"),
    @NamedQuery(name="Cliente.nombre", query= "SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre")
})

public class Cliente implements Serializable{
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)//indica que la primary será usada como identificador
    private int idCliente;
    @Column(length=15) //No ponemos varchar porque el programa ya trata a los strings como varchar.
    private String nif;
    @Column(name="DENOMINACIO",length=120)
    private String nombre;
    @ManyToOne //Añadimos foreign keys
    private Sector sector;
    @ManyToOne
    private Zona zona;
    
    public Cliente(String nif,String nombre){
        this.nif = nif;
        this.nombre = nombre;
    }
    
    public Cliente(){
        
    }
    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }    
    
}
