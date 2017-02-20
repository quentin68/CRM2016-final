/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Interaction;
import entitie.Stage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.InteractionFacade;

/**
 *
 * @author B4RL1V3
 */
@Named(value = "interactionMBean")
@ViewScoped
public class InteractionMBean implements Serializable {
    @EJB
    private InteractionFacade interactionFacade;

    private int id;
    private Interaction interaction;
    private List<Interaction> liste = new ArrayList();
    private int idEntreprise;

    public InteractionMBean() {
    }

    public List<Interaction> getInteractions() {
        refreshListeFromDatabase();
        return liste; 
    }

    public void refreshListeFromDatabase() {
        if(idEntreprise != 0) {
            liste = interactionFacade.findByEntreprise(idEntreprise);
        }
        else {
            liste = interactionFacade.findAll();
        }
    }
    
    public String voirStage(Stage s) {
        return "/forms/stage?faces-redirect=true&id=" + s.getId();
    }

    public String showDetails(int id) {  
        return "/forms/interaction?faces-redirect=true&id=" + id;  
    }  
    
    public String showCreate() {  
        return "/forms/interaction?faces-redirect=true";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public Interaction getDetails() {  
        if(interaction == null){
            interaction = new Interaction();
        }
        return interaction;  
    }  

    public String update() {  
        interactionFacade.edit(interaction);
        return "/lists/interactions?faces-redirect=true";  
    }  

    public String list() {
        return "/lists/interactions?faces-redirect=true";  
    }  

    public void loadInteraction() {  
        this.interaction = interactionFacade.find(id);  
    } 
}
