/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entitie.ContactEntreprise;
import entitie.Entreprise;
import entitie.Etudiant;
import entitie.Interaction;
import entitie.InteractionEnum;
import entitie.Stage;
import entitie.TypeStageEnum;
import entitie.Utilisateur;
import java.util.Date;
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
    @EJB
    private ContactEntrepriseFacade cf;
    @EJB
    private StageFacade sf;
    @EJB
    private EtudiantFacade etf;
    @EJB
    private InteractionFacade itf;
    
    /**
     *
     */
    @PostConstruct
    public void remplirDB() {
        Entreprise e1 = new Entreprise("Miage Nice",
                "Route des Lucioles",
                "06560", "Sophia-Antipolis",
                "La meilleure entreprise du monde", null);
        ef.create(e1);
        Entreprise e2 = new Entreprise("Polytech Nice",
                "Site des Templier",
                "06560", "Sophia-Antipolis",
                "De l'autre côté de la rue", null);
        ef.create(e2); 
        
        
        Utilisateur u1 = new Utilisateur("Bauer", "Quentin", "quentin68", "123456", "qbauer68@gmail.com", "0610936472");
        uf.create(u1);
        Utilisateur u2 = new Utilisateur("Rabadan", "Andy", "arabadan", "123456", "andy.rabadan@hotmail.fr", "0658678690");
        uf.create(u2);
        
        
        Etudiant et1 = new Etudiant("Bauer", "Quentin", 21324540, "qbauer68@gmail.com");
        etf.create(et1);
        Etudiant et2 = new Etudiant("Rabadan", "Andy", 21407395, "andy.rabadan@hotmail.fr");
        etf.create(et2);
        
        
        ContactEntreprise c1 = new ContactEntreprise("Dupres", "Jacques", "mail@entreprise.fr", e1, "RH");
        cf.create(c1);
        ContactEntreprise c2 = new ContactEntreprise("Dupres", "Pierre", "mail@entreprise.fr", e2, "DSI");
        cf.create(c2);
        
        
        Stage s1 = new Stage(TypeStageEnum.L3, e1, et1, new Date(), new Date(), "Stage de L3", "Développement d'un site internet pour l'entreprise.");
        sf.create(s1);
        
        Interaction i1 = new Interaction(new Date(), InteractionEnum.TELEPHONE, e1, u1, c1, s1, "Appel de Mr Tartanpion pour la taxe d'aprentissage au 0654345323");
        itf.create(i1);
        Interaction i2 = new Interaction(new Date(), InteractionEnum.MAIL, e1, u1, c1, null, "Email à Mr Dupont");
        itf.create(i2);
    }
}