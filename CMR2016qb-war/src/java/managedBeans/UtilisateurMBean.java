/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Utilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.UtilisateurFacade;

/**
 *
 * @author B4RL1V3
 */
@Named(value = "utilisateurMBean")
@ViewScoped
public class UtilisateurMBean implements Serializable {
    @EJB
    private UtilisateurFacade utilisateurFacade;

    private int id;
    private Utilisateur utilisateur;
    private List<Utilisateur> liste = new ArrayList();

    public UtilisateurMBean() {
    }

    public List<Utilisateur> getUtilisateurs() {
        if(liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste; 
    }

    public void refreshListeFromDatabase() {
        System.out.println("JE REMPLIS LA LISTE");
        liste = utilisateurFacade.findAll();
    }

    public String showDetails(int id) {  
        return "/forms/utilisateur?faces-redirect=true&id=" + id;  
    }  
    
    public String showCreate() {  
        return "/forms/utilisateur?faces-redirect=true";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getDetails() {  
        if(utilisateur == null){
            utilisateur = new Utilisateur();
        }
        return utilisateur;  
    }  

    public String update() {  
        utilisateurFacade.edit(utilisateur);
        return "/lists/utilisateurs?faces-redirect=true";  
    }  

    public String list() {
        return "/lists/utilisateurs?faces-redirect=true";  
    }  

    public void loadUtilisateur() {  
        this.utilisateur = utilisateurFacade.find(id);  
    } 
}
