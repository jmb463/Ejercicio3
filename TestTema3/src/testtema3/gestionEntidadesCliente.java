/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtema3;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author windeveloper
 */
public class gestionEntidadesCliente implements Serializable {
    private static EntityManager em;
    private static EntityManagerFactory emf;
    
    public gestionEntidadesCliente(EntityManager em){
        this.em = em;
    }
    
    public void insertarClientes(Cliente c){
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }
        catch(PersistenceException e){
            System.out.println("No se pudo insertar el cliente por: " + e.getMessage());
        }
        
    }
    
    public void modificarClietnes(Cliente c, int id){
        try{
            em.getTransaction().begin();
            Cliente cm = em.getReference(Cliente.class, id); //cm = cliente modificado
            cm.setNif(c.getNif());
            cm.setNombre(c.getNombre());
            em.getTransaction().commit();
        }
        catch(EntityNotFoundException e){
            System.out.println("No se puedo realizar la modificación del cliente por: " + e.getMessage());
        }
    }
    
    public void eliminarClientes(int id){
        try {
            em.getTransaction().begin();
            em.remove(em.getReference(Cliente.class, id));
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("No se puedo eliminar el cliente por: " + e.getMessage());
        }
    }
    
    public Cliente obtenerClientePorID(int id){
        return em.find(Cliente.class, id);
    } 
    
    public Cliente obtenerClientePorNIF(String nif){
        Query q1 = em.createNamedQuery("Cliente.nif", Cliente.class);
        q1.setParameter("nif", nif);
        return (Cliente) q1.getSingleResult();
    }
    
    public List<Cliente> obtenerClientePorNombre(String nombre){
        Query q2 = em.createNamedQuery("Cliente.nombre", Cliente.class);
        q2.setParameter("nombre", "%" + nombre + "%");
        return q2.getResultList();
    }
    
    public List<Cliente> obtenerClientePorSector(Sector sector){
        Query q3 = em.createNamedQuery("Cliente.sector", Cliente.class);
        q3.setParameter("sector", sector.getIdSector());
        return q3.getResultList();
    }
    
    public static void Main(String []args){
        emf = Persistence.createEntityManagerFactory("actividad3");
        em = emf.createEntityManager();
        
        gestionEntidadesCliente gec = new gestionEntidadesCliente(em);
    }
}
