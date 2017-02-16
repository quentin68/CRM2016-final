/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author B4RL1V3
 */
@Entity
public class Interaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateInteraction;
    private InteractionEnum type;
    @ManyToOne
    private Entreprise entreprise;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private ContactEntreprise contactEntreprise;
    @ManyToOne
    private Stage stage;
    private String contenu;

    public Interaction() {
    }

    public Interaction(Date dateInteraction, InteractionEnum type, Entreprise entreprise, Utilisateur utilisateur, ContactEntreprise contactEntreprise, Stage stage, String contenu) {
        this.dateInteraction = dateInteraction;
        this.type = type;
        this.entreprise = entreprise;
        this.utilisateur = utilisateur;
        this.contactEntreprise = contactEntreprise;
        this.stage = stage;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateInteraction() {
        return dateInteraction;
    }

    public void setDateInteraction(Date dateInteraction) {
        this.dateInteraction = dateInteraction;
    }

    public InteractionEnum getType() {
        return type;
    }

    public void setType(InteractionEnum type) {
        this.type = type;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ContactEntreprise getContactEntreprise() {
        return contactEntreprise;
    }

    public void setContactEntreprise(ContactEntreprise contactEntreprise) {
        this.contactEntreprise = contactEntreprise;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
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
        if (!(object instanceof Interaction)) {
            return false;
        }
        Interaction other = (Interaction) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Interaction[ id=" + id + " ]";
    }
    
}
