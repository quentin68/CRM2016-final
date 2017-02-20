/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Interaction;
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
public class InteractionMBean {
    @EJB
    private InteractionFacade interactionFacade;

    private int id;
    private Interaction interaction;
    private List<Interaction> liste = new ArrayList();

    public InteractionMBean() {
    }

    public List<Interaction> getEtudiants() {
        if(liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste; 
    }

    public void refreshListeFromDatabase() {
        System.out.println("JE REMPLIS LA LISTE");
        liste = interactionFacade.findAll();
    }

    public String showDetails(int id) {  
        return "forms/interaction?id=" + id;  
    }  
    
    public String showCreate() {  
        return "forms/interaction";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Interaction getDetails() {  
        if(interaction == null){
            interaction = new Interaction();
        }
        return interaction;  
    }  

    public String update() {  
        interactionFacade.edit(interaction);
        return "index";  
    }  

    public String list() {
        return "index";  
    }  

    public void loadInteraction() {  
        this.interaction = interactionFacade.find(id);  
    } 
}
