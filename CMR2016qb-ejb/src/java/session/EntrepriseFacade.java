/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entitie.Entreprise;
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
}
