/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Utilisateur;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import session.UtilisateurFacade;

/**
 *
 * @author QBAUER
 */
@Named(value = "authenticationMBean")
@SessionScoped
public class AuthenticationMBean implements Serializable {
    @EJB
    private UtilisateurFacade uf;
    private String pseudo;
    private String password;
    private Utilisateur utilisateur = null;

    /**
     *
     */
    public AuthenticationMBean() {
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
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

    public String connexion() {
        utilisateur = uf.getByLogin(pseudo, password);

        if(utilisateur != null) {
            return "/index";
        }
        else {
            return "/error";
        }
    }
    
    public boolean isLog() {
        return utilisateur != null;
    }
    
    public void isConnected() throws IOException {
        if(utilisateur == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/CMR2016qb-war/faces/login.xhtml");
        }
    }
    
    public String deconnexion() {
        utilisateur = null;
        pseudo = null;
        password = null;
        return "/index";
    }
}