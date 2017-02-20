/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author B4RL1V3
 */
@Singleton
@Startup
@LocalBean
public class initDB {
    @EJB
    private EntrepriseFacade ef;
    @EJB
    private UtilisateurFacade uf;
    
    @PostConstruct
    public void remplirDB() {
        ef.creerEntreprisesDeTest();
        uf.creerAdmin();
    }
}