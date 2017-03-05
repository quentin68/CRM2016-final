/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entitie.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author B4RL1V3
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

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
    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    /**
     * Verifie si le login et le mot de passe correspondent a un compte parmi
     * les utilisateurs enregistres
     *
     * @param login
     * @param password
     * @return
     */
    public Utilisateur getByLogin(String login, String password) {
        try {
            Query q = em.createQuery("select u from Utilisateur u where u.pseudo=:login and u.password=:password");

            q.setParameter("login", login);
            q.setParameter("password", password);

            return (Utilisateur) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
