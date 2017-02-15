/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

/**
 *
 * @author mbuffa
 */
@Entity
public class InteractionCoupTelephone extends Interaction  {
    private String numeroTel;
    
    public InteractionCoupTelephone() {
    }
 
    public InteractionCoupTelephone(String contenu, String numero) {
       super(contenu);
       this.numeroTel = numero;
   }

    public String getNumeroTel() {
        return numeroTel;
    }
    
    @Override
    public String getType() {
        return "Coup de téléphone";
    }
}
