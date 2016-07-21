package demo;

import demo.Classes;
import demo.Scores;
import demo.StudentEmergency;
import demo.StudentGun;
import demo.StudentInfo;
import demo.Students;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-20T18:14:05")
@StaticMetamodel(StudentNumbers.class)
public class StudentNumbers_ { 

    public static volatile CollectionAttribute<StudentNumbers, Scores> scoresCollection;
    public static volatile CollectionAttribute<StudentNumbers, StudentEmergency> studentEmergencyCollection;
    public static volatile CollectionAttribute<StudentNumbers, StudentGun> studentGunCollection;
    public static volatile SingularAttribute<StudentNumbers, String> studentName;
    public static volatile CollectionAttribute<StudentNumbers, Students> studentsCollection;
    public static volatile SingularAttribute<StudentNumbers, Classes> classNum;
    public static volatile SingularAttribute<StudentNumbers, Long> studentNum;
    public static volatile CollectionAttribute<StudentNumbers, StudentInfo> studentInfoCollection;

}