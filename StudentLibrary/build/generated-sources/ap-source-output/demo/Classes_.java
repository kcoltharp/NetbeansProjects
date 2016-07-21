package demo;

import demo.Scores;
import demo.StudentNumbers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-20T18:14:05")
@StaticMetamodel(Classes.class)
public class Classes_ { 

    public static volatile SingularAttribute<Classes, Date> safetyTestStart;
    public static volatile SingularAttribute<Classes, Date> lesson3Start;
    public static volatile CollectionAttribute<Classes, Scores> scoresCollection;
    public static volatile SingularAttribute<Classes, Date> classStart;
    public static volatile SingularAttribute<Classes, Date> lesson1Start;
    public static volatile SingularAttribute<Classes, Date> legalTestStart;
    public static volatile CollectionAttribute<Classes, StudentNumbers> studentNumbersCollection;
    public static volatile SingularAttribute<Classes, Date> lesson2Start;
    public static volatile SingularAttribute<Classes, Integer> id;
    public static volatile SingularAttribute<Classes, Long> classNum;
    public static volatile SingularAttribute<Classes, Date> qualStart;

}