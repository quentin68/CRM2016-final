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
 * @author B4RL1V3
 */
@Named(value = "entrepriseMBean")
@ViewScoped
public class EntrepriseMBean implements Serializable {
    @EJB
    private EntrepriseFacade entrepriseFacade;

    private int id;
    private Entreprise entreprise;
    private List<Entreprise> liste = new ArrayList();

    public EntrepriseMBean() {
    }

    public List<Entreprise> getEntreprises() {
        if(liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste; 
    }

    public void refreshListeFromDatabase() {
        System.out.println("JE REMPLIS LA LISTE");
        liste = entrepriseFacade.findAll();
    }
    
    public String voirInteractions(Entreprise e) {
        System.out.println("DANS voirInteractions id=" + e.getId());
        return "interactions?faces-redirect=true";
    }

    public String showDetails(int id) {  
        return "/forms/entreprise?idEntreprise=" + id;  
    }  
    
    public String showCreate() {  
        return "/forms/entreprise";
    }  
    
     public String gologin() {  
        return "/login";  
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
        return "/index";  
    }  

    public String list() {
        return "/index";  
    }  

    public void loadEntreprise() {  
        this.entreprise = entrepriseFacade.find(id);  
    } 
}
