/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Entreprise;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mbuffa
 */
@Stateless
@LocalBean
public class GestionnaireEntreprise {

 @PersistenceContext
 private EntityManager em;
 
 
    public void create(Entreprise e) {
      em.persist(e);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    // Creer une entreprise
    
    // rechercher une entreprise
    
    // renvoyer toutes les entreprises
    
}
