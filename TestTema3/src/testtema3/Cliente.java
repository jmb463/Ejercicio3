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
    @NamedQuery(name="Client.clientsDUnSector", query= "SELECT c " + "FROM Cliente c " + "WHERE c.sector.id=:sector"),
    @NamedQuery(name="Client.clientPerNif", query= "SELECT c " + "FROM Cliente c " + "WHERE c.nif=:nif"),
    @NamedQuery(name="Client.clientsPerNom", query= "SELECT c " + "FROM Cliente c " + "WHERE c.nom like :nom")
})

public class Cliente implements Serializable{
    @Id 
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int idCliente;
    @Column(length=15) //No ponemos varchar porque el programa ya trata a los strings como varchar.
    private String nif;
    @Column(name="DENOMINACIO",length=120)
    private String nombre;
    
    
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
    
    public void insertCliente(){
        
    }
    
}
