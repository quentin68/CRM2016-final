/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entitie.Interaction;
import entitie.Utilisateur;
import java.util.Collection;
import java.util.List;
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
     *
     * @param u
     */
    @Override
    public void create(Utilisateur u) {

        getEntityManager().persist(u);
    }

    /**
     *
     * @param nom
     * @param prenom
     * @param pseudo
     * @param password
     * @param mail
     * @param telephone
     *
     * @return
     */
    public Utilisateur add(String nom, String prenom, String pseudo, String password, String mail, String telephone) {
        Utilisateur u = new Utilisateur(nom, prenom, pseudo, password, mail, telephone);
        em.persist(u);
        return u;
    }

    /**
     *
     * @param id
     */
    public void del(int id) {
        Utilisateur u = em.find(Utilisateur.class, id);

        Query q = em.createQuery("select i from Interaction i where i.utilisateur=:user");
        q.setParameter("user", u);
        List<Interaction> interaction = q.getResultList();

        for (Interaction i : interaction) {
            em.remove(i);
        }

        em.remove(u);
    }

    /**
     *
     * @param id
     * @return
     */
    public Utilisateur get(int id) {
        try {
            Query q = em.createQuery("select u from Utilisateur u where u.id=:id");

            q.setParameter("id", id);

            return (Utilisateur) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     *
     * @param nom
     * @return
     */
    public Utilisateur getByName(String nom) {
        try {
            Query q = em.createQuery("select u from Utilisateur u where u.nom=:nom");

            q.setParameter("nom", nom);

            return (Utilisateur) q.getResultList().get(0);
        } catch (NoResultException e) {
            return null;
        }
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

    /**
     *
     * @param start
     * @param nb
     * @return
     */
    public Collection<Utilisateur> getAll(int start, int nb) {
        try {
            Query q = em.createQuery("select u from Utilisateur u order by u.nom");

            q.setFirstResult(start);
            q.setMaxResults(nb);

            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     *
     * @return
     */
    public int getNb() {
        Query q = em.createQuery("SELECT COUNT(u) FROM Utilisateur u");
        return Integer.parseInt(q.getResultList().get(0).toString());
    }

    /**
     *
     * @param id
     * @param nom
     * @param prenom
     * @param pseudo
     * @param password
     * @param mail
     * @param telephone
     * @param estAdmin
     *
     */
    public void set(int id, String nom, String prenom, String pseudo, String password, String mail, String telephone, boolean estAdmin) {
        Utilisateur u = em.find(Utilisateur.class, id);

        u.setNom(nom);
        u.setPrenom(prenom);
        u.setPseudo(pseudo);
        u.setPassword(password);
        u.setMail(mail);
        u.setTelephone(telephone);
    }
}
