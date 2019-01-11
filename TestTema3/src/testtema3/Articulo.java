/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtema3;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;


/**
 *
 * @author windeveloper
 */

@Entity //Define que es una tabla
@Table(name="TARTICLES") //Cambiamos el nombre de la tabla a TARTICLES
public class Articulo implements Serializable{
    @Id //Defineix que es un identificador
    @GeneratedValue(strategy=GenerationType.TABLE)//Genera una clave primária por defecto que se autoincrementa (Mirar punto 2.5.2 del documento)
    private int idArticlo;
    @Column(length=150) //Define que es una columna y que su longitud máxima es de 150 palabras
    private String descripcion; 

    public int getIdArticlo() {
        return idArticlo;
    }

    public void setIdArticlo(int idArticlo) {
        this.idArticlo = idArticlo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
