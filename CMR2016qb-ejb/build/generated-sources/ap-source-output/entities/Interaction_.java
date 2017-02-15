package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-15T21:13:45")
@StaticMetamodel(Interaction.class)
public abstract class Interaction_ { 

    public static volatile SingularAttribute<Interaction, Integer> id;
    public static volatile SingularAttribute<Interaction, Date> dateInteraction;
    public static volatile SingularAttribute<Interaction, String> contenu;

}