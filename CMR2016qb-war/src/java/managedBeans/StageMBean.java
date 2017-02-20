/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Stage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.StageFacade;

/**
 *
 * @author B4RL1V3
 */
@Named(value = "stageMBean")
@ViewScoped
public class StageMBean implements Serializable {
    @EJB
    private StageFacade stageFacade;

    private int id;
    private Stage stage;
    private List<Stage> liste = new ArrayList();

    public StageMBean() {
    }

    public List<Stage> getStages() {
        if(liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste; 
    }

    public void refreshListeFromDatabase() {
        System.out.println("JE REMPLIS LA LISTE");
        liste = stageFacade.findAll();
    }

    public String showDetails(int id) {  
        return "/forms/stage?faces-redirect=true&id=" + id;  
    }  
    
    public String showCreate() {  
        return "/forms/stage?faces-redirect=true";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stage getDetails() {  
        if(stage == null){
            stage = new Stage();
        }
        return stage;  
    }  

    public String update() {  
        stageFacade.edit(stage);
        return "/lists/stages?faces-redirect=true";  
    }  

    public String list() {
        return "/lists/stages?faces-redirect=true";  
    }  

    public void loadStage() {  
        this.stage = stageFacade.find(id);  
    } 
}