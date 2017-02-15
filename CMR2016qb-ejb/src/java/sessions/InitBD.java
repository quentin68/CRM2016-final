/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author mbuffa
 */
@Singleton
@Startup // créé dès le déploiement
@LocalBean
public class InitBD {
    @EJB
    private EntrepriseFacade entrepriseFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PostConstruct
    public void initBDAvecDonneesTest() {
        System.out.println("### INIT BD ###");
        entrepriseFacade.creerEntreprisesDeTest();
    }
}
