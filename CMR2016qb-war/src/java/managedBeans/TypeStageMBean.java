/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entitie.TypeStageEnum;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;


/**
 *
 * @author B4RL1V3
 */
@Named(value = "typeStageMBean")
@ApplicationScoped
public class TypeStageMBean {

    /**
     * Creates a new instance of TypeMBean
     */
    public TypeStageMBean() {
    }
    
    /**
     *
     * @return
     */
    public TypeStageEnum[] getTypesStage() {
        return TypeStageEnum.values();
    }
}
