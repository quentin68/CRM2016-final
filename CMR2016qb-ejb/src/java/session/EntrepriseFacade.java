/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entitie.Entreprise;
import entitie.Interaction;
import entitie.InteractionEnum;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author B4RL1V3
 */
@Stateless
public class EntrepriseFacade extends AbstractFacade<Entreprise> {
    @PersistenceContext(unitName = "CMR2016qb-ejbPU")
    private EntityManager em;
    private InteractionFacade interactionFacade;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public EntrepriseFacade() {
        super(Entreprise.class);
    }
    
    /**
     *
     */
    public void creerEntreprisesDeTest() {
        System.out.println("CREATION DE DONNEES DE TEST");

        Entreprise e1 = new Entreprise("Miage Nice",
                "Route des Lucioles",
                "06560", "Sophia-Antipolis",
                "La meilleure entreprise du monde", null);
        
        // utilisation de la méthode héritée pour faire
        // un insert
        create(e1);
        // une interaction pour l'entreprise
        //Interaction i1 = new Interaction(new Date(), InteractionEnum.TELEPHONE, e1, null, null, null, "Appel de Mr Tartanpion pour la taxe d'aprentissage au 0654345323");
        // on fait un insert dans la table des interactions
        //interactionFacade.create(i1);
        // on met à jour la jointure
        //e1.addInteraction(i1);
        
        //Interaction i2 = new Interaction(new Date(), InteractionEnum.MAIL, e1, null, null, null, "Email à Mr Dupont");
        // on fait un insert dans la table des interactions
        //interactionFacade.create(i2);
        // on met à jour la jointure
        //e1.addInteraction(i2);

        
        Entreprise e2 = new Entreprise("Polytech Nice",
                "Site des Templier",
                "06560", "Sophia-Antipolis",
                "De l'autre côté de la rue", null);
        
        // utilisation de la méthode héritée pour faire
        // un insert
        create(e2); 
    }
}
