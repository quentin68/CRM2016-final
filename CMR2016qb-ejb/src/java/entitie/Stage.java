/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
public class Stage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private TypeStageEnum type;
    @ManyToOne(cascade=CascadeType.ALL)
    private Entreprise entreprise;
    @ManyToOne(cascade=CascadeType.ALL)
    private Etudiant etudiant;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    private String intitule;
    private String contenu;

    /**
     *
     */
    public Stage() {
    }

    /**
     *
     * @param type
     * @param entreprise
     * @param etudiant
     * @param dateDebut
     * @param dateFin
     * @param intitule
     * @param contenu
     */
    public Stage(TypeStageEnum type, Entreprise entreprise, Etudiant etudiant, Date dateDebut, Date dateFin, String intitule, String contenu) {
        this.type = type;
        this.entreprise = entreprise;
        this.etudiant = etudiant;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.intitule = intitule;
        this.contenu = contenu;
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
    public TypeStageEnum getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(TypeStageEnum type) {
        this.type = type;
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
    public Etudiant getEtudiant() {
        return etudiant;
    }

    /**
     *
     * @param etudiant
     */
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    /**
     *
     * @return
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     *
     * @param dateDebut
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     *
     * @return
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     *
     * @param dateFin
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     *
     * @return
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     *
     * @param intitule
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     *
     * @return
     */
    public String getContenu() {
        return contenu;
    }

    /**
     *
     * @param contenu
     */
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
        if (!(object instanceof Stage)) {
            return false;
        }
        Stage other = (Stage) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Stage[ id=" + id + " ]";
    }
    
}
