/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.InteractionEnum;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author B4RL1V3
 */
@Named(value = "typesInteractionMBean")
@ApplicationScoped
public class TypesInteractionMBean {

    /**
     * Creates a new instance of TypesInteraction
     */
    public TypesInteractionMBean() {
    }
    
    public InteractionEnum[] getTypesInteraction() {
        return InteractionEnum.values();
    }
    
}
