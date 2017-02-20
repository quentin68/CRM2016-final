/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author B4RL1V3
 */
@Entity
public class ContactEntreprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    @ManyToOne(cascade=CascadeType.ALL)
    private Entreprise entreprise;
    private String poste;

    /**
     *
     */
    public ContactEntreprise() {
    }
    
    /**
     *
     * @param nom
     * @param prenom
     * @param mail
     * @param entreprise
     * @param poste
     */
    public ContactEntreprise(String nom, String prenom, String mail, Entreprise entreprise, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.entreprise = entreprise;
        this.poste = poste;
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
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     *
     * @return
     */
    public Entreprise getEntreprise() {
        return entreprise;
    }

    /**
     *
     * @param entreprise
     */
    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    /**
     *
     * @return
     */
    public String getPoste() {
        return poste;
    }

    /**
     *
     * @param poste
     */
    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactEntreprise)) {
            return false;
        }
        ContactEntreprise other = (ContactEntreprise) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ContactENtreprise[ id=" + id + " ]";
    }
    
}
