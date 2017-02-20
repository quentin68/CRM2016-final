package entitie;

import entitie.ContactEntreprise;
import entitie.Entreprise;
import entitie.InteractionEnum;
import entitie.Stage;
import entitie.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-20T12:32:46")
@StaticMetamodel(Interaction.class)
public class Interaction_ { 

    public static volatile SingularAttribute<Interaction, ContactEntreprise> contactEntreprise;
    public static volatile SingularAttribute<Interaction, Entreprise> entreprise;
    public static volatile SingularAttribute<Interaction, Stage> stage;
    public static volatile SingularAttribute<Interaction, Utilisateur> utilisateur;
    public static volatile SingularAttribute<Interaction, Integer> id;
    public static volatile SingularAttribute<Interaction, Date> dateInteraction;
    public static volatile SingularAttribute<Interaction, InteractionEnum> type;
    public static volatile SingularAttribute<Interaction, String> contenu;

}