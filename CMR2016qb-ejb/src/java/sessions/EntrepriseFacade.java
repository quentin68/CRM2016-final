/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Entreprise;
import entities.Interaction;
import entities.InteractionCoupTelephone;
import entities.InteractionEmail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mbuffa
 */
@Stateless
public class EntrepriseFacade extends AbstractFacade<Entreprise> {
    @EJB
    private InteractionFacade interactionFacade;

    @PersistenceContext
    private EntityManager em;

    
    // Variable du formulaire pour la création d'une entreprise
   
    // On hérite du CRUD + count + pagination
    // si on doit faire de nouvelles fonctionnalités
    // ou de nouvelles requêtes on rajoutera
    // des méthodes ici...
    
    
   
    public void creerEntreprisesDeTest() {
        System.out.println("CREATION DE DONNEES DE TEST");

        Entreprise e1 = new Entreprise("Miage Nice",
                "Route des Lucioles",
                "06560", "Sophia-Antipolis",
                "La meilleure entreprise du monde");
        
        // utilisation de la méthode héritée pour faire
        // un insert
        create(e1);
        // une interaction pour l'entreprise
        Interaction i1 = new InteractionCoupTelephone("Appel de Mr Tartanpion pour la taxe d'aprentissage au 0654345323", "0654345323");
        // on fait un insert dans la table des interactions
        interactionFacade.create(i1);
        // on met à jour la jointure
        e1.addInteraction(i1);
        
        Interaction i2 = new InteractionEmail("Email à Mr Dupont", "0493546543");
        // on fait un insert dans la table des interactions
        interactionFacade.create(i2);
        // on met à jour la jointure
        e1.addInteraction(i2);

        
        Entreprise e2 = new Entreprise("Polytech Nice",
                "Site des Templier",
                "06560", "Sophia-Antipolis",
                "De l'autre côté de la rue");
        
        // utilisation de la méthode héritée pour faire
        // un insert
        create(e2);
        
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntrepriseFacade() {
        super(Entreprise.class);
    }

    
     public void create(Entreprise e) {
         System.out.println(e.getId()+"loooooooooooooooooooooo");
        getEntityManager().persist(e);
       
    }


    public Entreprise update(Entreprise entreprise) {
     return em.merge(entreprise);  
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    public Entreprise getEntreprise(int idEntreprise) {  
        return em.find(Entreprise.class, idEntreprise);  
}  
    
}
