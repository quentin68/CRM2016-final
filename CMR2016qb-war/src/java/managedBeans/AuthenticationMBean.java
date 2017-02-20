/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.Utilisateur;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import session.SessionUtils;
import session.UtilisateurFacade;

/**
 *
 * @author deptinfo
 */
@Named(value = "authenticationMBean")
@SessionScoped
public class AuthenticationMBean implements Serializable {
    @EJB  
 private UtilisateurFacade uf;
 private Utilisateur utilisateur;  
 private int idUser;
 private String pseudo;
 private String password;
 private List<Utilisateur> liste = new ArrayList();
    /**
     * Creates a new instance of AuthenticationMBean
     */
 
 
     public List<Utilisateur> getUtilisateur() {
         liste.clear();
        Utilisateur u= uf.get(5);
        liste.add(u);
        return liste; 
    }
       public String connect() {  
           
       
          // System.out.println(.login+"  "+ pass);
       Utilisateur u = uf.getByLogin(pseudo, password);
       if (u != null) {
           HttpSession session = SessionUtils.getSession();
           session.setAttribute("username", u);
           System.out.println("hello");
            return "index";
        } else {
           System.out.println("uuuu");
            return "error";
                        
                    }
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
    this.utilisateur = uf.get(idUser);  
  }  
    public AuthenticationMBean() {
    }
    
     public void checkErrors(ComponentSystemEvent event) throws ServletException, IOException {
         System.out.println("aaaaaaaaaaaaaaddd");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        if ("true".equals((String)request.getParameter("failed"))) {
            System.out.println("ooooooooooooo");
            /* GET parameter "failed" has been sent in the HTTP request... */
            context.addMessage(null, new FacesMessage("Login failed!"));
        }
        
       
        else if (request.getRequestedSessionId()!=null && !request.isRequestedSessionIdValid()
                    & request.getParameter("logout")==null) {
            System.out.println("iiiiiiiiiiiiiiii");
            
            /* The user session has timed out (not caused by a logout action)... */
            context.addMessage(null, new FacesMessage("Your session has timed out!"));
        }
        else if (request.getParameter("logout")!=null && request.getParameter("logout").equalsIgnoreCase("true")) {
            context.addMessage(null, new FacesMessage("Logout done."));
            System.out.println("uuuuuuuuuuu");
        }
    }
 
    public String logout() {
        String page="/login?logout=true&faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
          request.logout();
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed!"));
            page="/login?logout=false&faces-redirect=true";
        }
        return page;
    }
    
}
