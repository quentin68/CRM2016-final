/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Entreprise;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.EntrepriseFacade;

/**
 *
 * @author B4RL1V3
 */
@Named(value = "entrepriseDetailsMBean")
@ViewScoped
public class EntrepriseDetailsMBean implements Serializable {
    private int idEntreprise;
    private Entreprise entreprise;
    
    @EJB
    private EntrepriseFacade entrepriseManager;
    
    /**
     * Creates a new instance of EntrepriseDetailsMBean
     */
    public EntrepriseDetailsMBean() {
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public Entreprise getDetails() {  
        if(entreprise == null){
            entreprise = new Entreprise();
        }
        return entreprise;  
    }  

    /** 
    * Action handler - met à jour la base de données en fonction du client passé 
    * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
    */  
    public String update() {  
        if(!entreprise.equals(null)) {
            System.out.println("###UPDATE###");
            entrepriseManager.edit(entreprise);
        }
        else {
            System.out.println("###CREATE###");
            entrepriseManager.create(entreprise);
        }
        return "index";  
    }  

    /** 
    * Action handler - renvoie vers la page qui affiche la liste des clients 
    */  
    public String list() {  
        System.out.println("###LIST###");  
        return "index";  
    }  

    public void loadEntreprise() {  
        this.entreprise = entrepriseManager.find(idEntreprise);  
    } 
}
