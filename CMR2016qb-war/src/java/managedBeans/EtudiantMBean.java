/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Etudiant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.EtudiantFacade;

/**
 *
 * @author B4RL1V3
 */
@Named(value = "etudiantMBean")
@ViewScoped
public class EtudiantMBean implements Serializable {
    @EJB
    private EtudiantFacade etudiantFacade;

    private int id;
    private Etudiant etudiant;
    private List<Etudiant> liste = new ArrayList();

    /**
     *
     */
    public EtudiantMBean() {
    }

    /**
     *
     * @return
     */
    public List<Etudiant> getEtudiants() {
        if(liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste; 
    }

    /**
     *
     */
    public void refreshListeFromDatabase() {
        System.out.println("JE REMPLIS LA LISTE");
        liste = etudiantFacade.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public String showDetails(int id) {  
        return "/forms/etudiant?faces-redirect=true&id=" + id;  
    }  
    
    /**
     *
     * @return
     */
    public String showCreate() {  
        return "/forms/etudiant?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Etudiant getDetails() {  
        if(etudiant == null){
            etudiant = new Etudiant();
        }
        return etudiant;  
    }  

    /**
     *
     * @return
     */
    public String update() {  
        etudiantFacade.edit(etudiant);
        return "/lists/etudiants?faces-redirect=true";  
    }  

    /**
     *
     * @param e
     * @return
     */
    public String delete(Etudiant e) {  
        etudiantFacade.remove(e);
        return "/lists/etudiants?faces-redirect=true";  
    } 
    
    /**
     *
     * @return
     */
    public String list() {
        return "/lists/etudiants?faces-redirect=true";  
    }  

    /**
     *
     */
    public void loadEtudiant() {  
        this.etudiant = etudiantFacade.find(id);  
    } 
    
    /**
     *
     * @return
     */
    public List<Etudiant> getAllEtudiants() {
        return etudiantFacade.findAll();
    }
    
    /**
     *
     * @return
     */
    public Converter getEtudiantsConverter() {
        return etudiantsConverter;
    }

    private final Converter etudiantsConverter = new Converter() {
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            System.out.println(value);
            Etudiant e = etudiantFacade.find(Integer.parseInt(value));
            return e;
       }
        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            Etudiant e = (Etudiant) value;
            return String.valueOf(e.getId()); 
        }
    };
}
