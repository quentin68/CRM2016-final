/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessions.GestionnaireUtilisateur;
import entities.Utilisateur;
import sessions.ValidForms;

/**
 *
 * @author deptinfo
 */
@WebServlet(name = "ServletConnexion", urlPatterns = {"/utilisateur"})
public class ServletUtilisateur extends HttpServlet {
    @EJB
    private GestionnaireUtilisateur gestionnaireUtilisateur;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        Object session = request.getSession(true).getAttribute("id");
        if (action != null) {
            switch (action) {
                case "utilisateur": {
                    if (session != null) {
                        Utilisateur u = gestionnaireUtilisateur.get((int) session);
                        request.setAttribute("u", u);
                    }

                    Map<String, String> erreurs = new HashMap<String, String>();

                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    String pseudo = request.getParameter("pseudo");
                    String password = request.getParameter("password");
                    String password2 = request.getParameter("confirmPassword");
                    String mail = request.getParameter("mail");
                    String telephone = request.getParameter("telephone");
                    

                    if (request.getMethod().equals("POST")) {
                        try {
                            ValidForms.validationText(nom);
                        } catch (Exception e) {
                            erreurs.put("nom", e.getMessage());
                        }

                        try {
                            ValidForms.validationText(prenom);
                        } catch (Exception e) {
                            erreurs.put("prenom", e.getMessage());
                        }

                        try {
                            ValidForms.validationText(pseudo);
                        } catch (Exception e) {
                            erreurs.put("pseudo", e.getMessage());
                        }

                        try {
                            ValidForms.validationMotsDePasse(password, password2);
                        } catch (Exception e) {
                            erreurs.put("password", e.getMessage());
                        }

                        try {
                            ValidForms.validationEmail(mail);
                        } catch (Exception e) {
                            erreurs.put("mail", e.getMessage());
                        }

                        try {
                            ValidForms.validationTelephone(telephone);
                        } catch (Exception e) {
                            erreurs.put("telephone", e.getMessage());
                        }

                    }

                    if (erreurs.isEmpty() && request.getMethod().equals("POST")) {

                        if (session == null) {
                            gestionnaireUtilisateur.add(nom, prenom, pseudo, password, mail, telephone, false);
                        } else {
                            gestionnaireUtilisateur.set((int) session, nom, prenom, pseudo, password, mail, telephone,false);
                        }

                        response.sendRedirect("utilisateur?action=mesAnnonces");
                    } else {
                        request.setAttribute("erreurs", erreurs);

                        if (session == null) {
                            request.getRequestDispatcher("customer/inscription.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("customer/profil.jsp").forward(request, response);
                        }
                    }

                    break;
                }
                
                /*
                case "mesAnnonces": {
                    if (session == null) {
                        response.sendRedirect("?action=accueil");
                        break;
                    }

                    int page = 1;
                    int perPage = 10;
                    String currentPage = request.getParameter("page");
                    if (currentPage != null) {
                        page = Integer.parseInt(currentPage);
                        if (page <= 0) {
                            page = 1;
                        }
                    }

                    Collection<Annonce> annonces = gestionnaireAnnonce.getAllUser((page - 1) * perPage, perPage, gestionnaireUtilisateur.get((int) session));
                    int nbAnnonces = gestionnaireAnnonce.getNbAllUser(gestionnaireUtilisateur.get((int) session));
                    int nbPages = (int) Math.ceil(nbAnnonces * 1.0 / perPage);

                    request.setAttribute("lesAnnonces", annonces);
                    request.setAttribute("nbAnnonces", nbAnnonces);
                    request.setAttribute("nbPages", nbPages);
                    request.setAttribute("currentPage", page);

                    request.getRequestDispatcher("customer/annonces.jsp").forward(request, response);
                    break;
                }
                case "supprimerAnnonce": {
                    if (session == null) {
                        response.sendRedirect("?action=accueil");
                        break;
                    }
                    int idAnnonce = Integer.parseInt(request.getParameter("id"));

                    Annonce a = gestionnaireAnnonce.get(idAnnonce);
                    Utilisateur u = gestionnaireUtilisateur.get((int) session);

                    if (!u.equals(a.getUtilisateur())) {
                        response.sendRedirect("?action=accueil");
                        break;
                    }

                    gestionnaireAnnonce.del(idAnnonce);

                    response.sendRedirect("utilisateur?action=mesAnnonces");
                    break; 
                }*/
                case "connexion": {
                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    System.out.println("HHHHHHAAAAAAAAAAAAAA");
                    Utilisateur u = gestionnaireUtilisateur.getByLogin(login, password);

                    if (u != null) {
                        System.out.println("BAAAAAAAAAAAAAAAA");
                        request.getSession(true).setAttribute("utilisateur", login);
                        request.getSession(true).setAttribute("id", u.getId());
                        request.getSession(true).setAttribute("estAdmin", u.getEstAdmin());
                    } else {
                        System.out.println("HOOOOOOOOO");
                        response.getWriter().write("error");
                    }

                    break;
                }
                case "deconnexion": {
                    request.getSession(false).invalidate();
                }
                default:
                    response.sendRedirect("?action=accueil");
                    break;
            }
        } else {
            response.sendRedirect("?action=accueil");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
