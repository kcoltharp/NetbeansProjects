package demo;

import demo.StudentNumbers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-20T18:14:05")
@StaticMetamodel(StudentGun.class)
public class StudentGun_ { 

    public static volatile SingularAttribute<StudentGun, String> gunType;
    public static volatile SingularAttribute<StudentGun, String> caliber;
    public static volatile SingularAttribute<StudentGun, String> gunManufacturer;
    public static volatile SingularAttribute<StudentGun, Integer> id;
    public static volatile SingularAttribute<StudentGun, StudentNumbers> studentNum;

}