/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.ContactEntreprise;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.ContactEntrepriseFacade;

/**
 *
 * @author B4RL1V3
 */
@Named(value = "contactEntrepriseMBean")
@ViewScoped
public class ContactEntrepriseMBean implements Serializable {
    @EJB
    private ContactEntrepriseFacade contactEntrepriseFacade;

    private int id;
    private ContactEntreprise contactEntreprise;
    private List<ContactEntreprise> liste = new ArrayList();

    public ContactEntrepriseMBean() {
    }

    public List<ContactEntreprise> getContactEntreprises() {
        if(liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste; 
    }

    public void refreshListeFromDatabase() {
        System.out.println("JE REMPLIS LA LISTE");
        liste = contactEntrepriseFacade.findAll();
    }

    public String showDetails(int id) {  
        return "/forms/contactEntreprise?faces-redirect=true&id=" + id;  
    }  
    
    public String showCreate() {  
        return "/forms/contactEntreprise?faces-redirect=true";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactEntreprise getDetails() {  
        if(contactEntreprise == null){
            contactEntreprise = new ContactEntreprise();
        }
        return contactEntreprise;  
    }  

    public String update() {  
        contactEntrepriseFacade.edit(contactEntreprise);
        return "/lists/contactsEntreprise?faces-redirect=true";  
    }  

    public String list() {
        return "/lists/contactsEntreprise?faces-redirect=true";  
    }  

    public void loadContactEntreprise() {  
        this.contactEntreprise = contactEntrepriseFacade.find(id);  
    }
    
    public List<ContactEntreprise> getAllContactsEntreprise() {
        return contactEntrepriseFacade.findAll();
    }
    
    public Converter getContactsEntrepriseConverter() {
        return contactsEntrepriseConverter;
    }

    private final Converter contactsEntrepriseConverter = new Converter() {
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            System.out.println(value);
            ContactEntreprise e = contactEntrepriseFacade.find(Integer.parseInt(value));
            return e;
       }
        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            ContactEntreprise e = (ContactEntreprise) value;
            return String.valueOf(e.getId()); 
        }
    };
}
