/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entities.Utilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.GestionnaireUtilisateur;

/**
 *
 * @author deptinfo
 */
@Named(value = "utilisateurMBean")
@ViewScoped
public class UtilisateurMBean implements Serializable {
@EJB  
 private GestionnaireUtilisateur gu;
 private Utilisateur utilisateur;  
 private int idUser;
 private String pseudo;
 private String password;
   private List<Utilisateur> liste = new ArrayList();
    /**
     * Creates a new instance of UtilisateurMBean
     * @return 
     */
public Utilisateur getDetails() {  
    return utilisateur;  
  }  

    public UtilisateurMBean() {
    }
    
    
     public List<Utilisateur> getUtilisateur() {
         liste.clear();
        Utilisateur u= gu.get(5);
        liste.add(u);
        return liste; 
    }
       public String connect() {  
        return "index?action=connexion";  
    }  

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       
    
     public void loadUser() {  
    this.utilisateur = gu.get(idUser);  
  }  
}
