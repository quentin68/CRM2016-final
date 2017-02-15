/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entities.Entreprise;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.EntrepriseFacade;

/**
 *
 * @author deptinfo
 */
@Named(value = "entrepriseDetailsMBean")
@ViewScoped
public class EntrepriseDetailsMBean implements Serializable {

     private int idEntreprise;
     private String nom;
     private String ville;
     private String adresse;
     private String codePostal;
     private String description;
  private Entreprise entreprise;  
  
  @EJB  
 private EntrepriseFacade entrepriseFacade;
  
      public void creerEntreprise()
              
    {
        entrepriseFacade.create(new Entreprise(this.getNom(),this.getAdresse(), this.getCodePostal(), this.getVille(), this.getDescription()));
    }
    // GETTER AN SETTER
    
    
    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    
  /** 
   * Renvoie les détails du client courant (celui dans l'attribut customer de 
   * cette classe), qu'on appelle une propriété (property) 
   */  
  public Entreprise getDetails() { 
    return entreprise;  
  }  
  
  /** 
   * Action handler - met à jour la base de données en fonction du client passé 
   * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
   */  
  public String update() {  
    System.out.println("###UPDATE###");  
    entreprise = entrepriseFacade.update(entreprise);  
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
    this.entreprise = entrepriseFacade.getEntreprise(idEntreprise);  
  }  
}  
   
    

