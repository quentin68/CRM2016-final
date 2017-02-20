package entitie;

import entitie.Entreprise;
import entitie.Etudiant;
import entitie.TypeStageEnum;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-17T11:43:28")
@StaticMetamodel(Stage.class)
public class Stage_ { 

    public static volatile SingularAttribute<Stage, Entreprise> entreprise;
    public static volatile SingularAttribute<Stage, Date> dateDebut;
    public static volatile SingularAttribute<Stage, Integer> id;
    public static volatile SingularAttribute<Stage, Date> dateFin;
    public static volatile SingularAttribute<Stage, TypeStageEnum> type;
    public static volatile SingularAttribute<Stage, String> intitule;
    public static volatile SingularAttribute<Stage, String> contenu;
    public static volatile SingularAttribute<Stage, Etudiant> etudiant;

}