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
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

/**
 *
 * @author windeveloper
 */
public class gestionEntidadesCliente implements Serializable {
    ArrayList <Articulo> listaArticulos;
    ArrayList <Zona> listaZonas;
    ArrayList <Sector> listaSectores;
    ArrayList <Cliente> listaClientes;
    ArrayList <Comercial> listaComerciales;
    private static EntityManager em;
    
    public gestionEntidadesCliente(EntityManager em){
        this.listaArticulos = new ArrayList();
        this.listaZonas = new ArrayList();
        this.listaSectores = new ArrayList();
        this.listaClientes = new ArrayList();
        this.listaClientes = new ArrayList();
        this.em = em;
    }
    
    public void insertarClientes(Cliente c){
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public void modificarClietnes(Cliente c){
        try{
            em.getTransaction().begin();
            c = em.merge(c);
            em.getTransaction().commit();
        }
        catch(EntityNotFoundException e){
            e.getMessage();
        }
    }
    
    public void eliminarClientes(int id){
        Cliente cliente = null;
        em.getTransaction().begin();
        try {
            cliente = em.getReference(Cliente.class, id);
            cliente.getIdCliente();
        } 
        catch (EntityNotFoundException e) {
            e.getMessage(); 
        }
        em.remove(cliente);
        em.getTransaction().commit();
    }
    
    public Cliente obtenerClientePorID(int id){
        return em.find(Cliente.class, id);
    } 
    
    public Cliente obtenerClientePorNIF(String nif){
        Query q1 = em.createNamedQuery("Client.clientPerNif", Cliente.class);
        q1.setParameter("nif", nif);
        return (Cliente) q1.getSingleResult();
    }
    
    public List<Cliente> obtenerClientePorNombre(String nom){
        StringBuilder param = new StringBuilder();
        Query q2 = em.createNamedQuery("Client.clientsPerNom", Cliente.class);
        param.append("%");
        param.append(nom);
        param.append("%");
        q2.setParameter("nom", param.toString());
        return q2.getResultList();
    }
    
    public List<Cliente> obtenerClientePorSector(Sector s){
        Query q3 = em.createNamedQuery("Client.clientsDUnSector", Cliente.class);
        //q3.setParameter("sector", Sector.getIdSector());
        return q3.getResultList();
    }
    
    public static void Main(String []args){
        gestionEntidadesCliente gec = new gestionEntidadesCliente(em);
    }
}
