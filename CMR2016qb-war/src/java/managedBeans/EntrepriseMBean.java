/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Entreprise;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.EntrepriseFacade;

/**
 *
 * @author micbuffa
 */
@Named(value = "entrepriseMBean")
@ViewScoped
public class EntrepriseMBean implements Serializable {
    @EJB
    private EntrepriseFacade entrepriseFacade;

    private int id;
    private Entreprise entreprise;
    private List<Entreprise> liste = new ArrayList();
    /**
     * Creates a new instance of EntrepriseMBean
     */
    public EntrepriseMBean() {
    }
   
    // 1 - DES MODELES = définis par des getters et des setters
    
    // Modèles correspondant à la liste des entreprises
    public List<Entreprise> getEntreprises() {
        if(liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste; 
    }

    // ACTION METHOD (méthodes appelées par click sur 
    // bouton/lien ou event
    public void refreshListeFromDatabase() {
        // on remplit la liste
        System.out.println("JE REMPLIS LA LISTE");
        liste = entrepriseFacade.findAll();
    }
    
    public String voirInteractions(Entreprise e) {
        // ici on va voir...
        System.out.println("DANS voirInteractions id=" + e.getId());
        return "/lists/interactions?faces-redirect=true";
    }
    
    /** 
     * Action handler - appelé lorsque l'utilisateur sélectionne une ligne dans 
     * la DataTable pour voir les détails de l'entreprise
     * @param id 
     * @return 
     */  
    public String showDetails(int id) {
        return "/forms/entreprise?faces-redirect=true&id=" + id;  
    }  
    
    public String showCreate() {  
        return "EntrepriseDetails";
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entreprise getDetails() {  
        if(entreprise == null){
            entreprise = new Entreprise();
        }
        return entreprise;  
    }  

    public String update() {  
        entrepriseFacade.edit(entreprise);
        return "/lists/entreprises?faces-redirect=true";  
    }  

    public String list() {
        return "/lists/entreprises?faces-redirect=true";  
    }  

    public void loadEntreprise() {  
        this.entreprise = entrepriseFacade.find(id);  
    }
}
