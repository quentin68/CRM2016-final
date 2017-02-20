/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Etudiant;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.EtudiantFacade;

/**
 *
 * @author B4RL1V3
 */
@Named(value = "etudiantMBean")
@ViewScoped
public class EtudiantMBean {
    @EJB
    private EtudiantFacade etudiantFacade;

    private int id;
    private Etudiant etudiant;
    private List<Etudiant> liste = new ArrayList();

    public EtudiantMBean() {
    }

    public List<Etudiant> getEtudiants() {
        if(liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste; 
    }

    public void refreshListeFromDatabase() {
        System.out.println("JE REMPLIS LA LISTE");
        liste = etudiantFacade.findAll();
    }

    public String showDetails(int id) {  
        return "forms/entudiant?id=" + id;  
    }  
    
    public String showCreate() {  
        return "forms/etudiant";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Etudiant getDetails() {  
        if(etudiant == null){
            etudiant = new Etudiant();
        }
        return etudiant;  
    }  

    public String update() {  
        etudiantFacade.edit(etudiant);
        return "index";  
    }  

    public String list() {
        return "index";  
    }  

    public void loadEtudiant() {  
        this.etudiant = etudiantFacade.find(id);  
    } 
}
