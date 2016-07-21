package demo;

import demo.StudentNumbers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-20T18:14:05")
@StaticMetamodel(Students.class)
public class Students_ { 

    public static volatile SingularAttribute<Students, String> fname;
    public static volatile SingularAttribute<Students, String> lname;
    public static volatile SingularAttribute<Students, Date> submissionDate;
    public static volatile SingularAttribute<Students, Integer> id;
    public static volatile SingularAttribute<Students, StudentNumbers> studentNum;
    public static volatile SingularAttribute<Students, Date> submissionTime;

}