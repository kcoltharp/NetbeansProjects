package demo;

import demo.Classes;
import demo.StudentNumbers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-20T18:14:05")
@StaticMetamodel(Scores.class)
public class Scores_ { 

    public static volatile SingularAttribute<Scores, Float> combinedScore;
    public static volatile SingularAttribute<Scores, Float> safetyTestScore;
    public static volatile SingularAttribute<Scores, Integer> targetHits;
    public static volatile SingularAttribute<Scores, Integer> id;
    public static volatile SingularAttribute<Scores, Classes> classNum;
    public static volatile SingularAttribute<Scores, String> passFail;
    public static volatile SingularAttribute<Scores, StudentNumbers> studentNum;
    public static volatile SingularAttribute<Scores, Float> legalTestScore;

}