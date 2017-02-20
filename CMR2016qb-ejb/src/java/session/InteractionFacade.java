/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entitie.Entreprise;
import entitie.Interaction;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author B4RL1V3
 */
@Stateless
public class InteractionFacade extends AbstractFacade<Interaction> {
    @PersistenceContext(unitName = "CMR2016qb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InteractionFacade() {
        super(Interaction.class);
    }

    public List<Interaction> findByEntreprise(int idEntreprise) {
        try {
            Entreprise e = em.find(Entreprise.class, idEntreprise);
            Query query = em.createQuery("SELECT i FROM Interaction i WHERE i.entreprise = :entreprise");
            query.setParameter("entreprise", e);
            System.out.println("résult : "+query.getMaxResults());
            return query.getResultList();
        }
        catch(Exception e) {
            return null;
        }
    }
    
}
