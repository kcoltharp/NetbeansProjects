/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kenny
 */
@Entity
@Table(name = "student_numbers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentNumbers.findAll", query = "SELECT s FROM StudentNumbers s"),
    @NamedQuery(name = "StudentNumbers.findByStudentNum", query = "SELECT s FROM StudentNumbers s WHERE s.studentNum = :studentNum"),
    @NamedQuery(name = "StudentNumbers.findByStudentName", query = "SELECT s FROM StudentNumbers s WHERE s.studentName = :studentName")})
public class StudentNumbers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_num")
    private Long studentNum;
    @Basic(optional = false)
    @Column(name = "student_name")
    private String studentName;
    @JoinColumn(name = "class_num", referencedColumnName = "class_num")
    @ManyToOne
    private Classes classNum;
    @OneToMany(mappedBy = "studentNum")
    private Collection<Scores> scoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentNum")
    private Collection<StudentGun> studentGunCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentNum")
    private Collection<Students> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentNum")
    private Collection<StudentInfo> studentInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentNum")
    private Collection<StudentEmergency> studentEmergencyCollection;

    public StudentNumbers() {
    }

    public StudentNumbers(Long studentNum) {
        this.studentNum = studentNum;
    }

    public StudentNumbers(Long studentNum, String studentName) {
        this.studentNum = studentNum;
        this.studentName = studentName;
    }

    public Long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Long studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Classes getClassNum() {
        return classNum;
    }

    public void setClassNum(Classes classNum) {
        this.classNum = classNum;
    }

    @XmlTransient
    public Collection<Scores> getScoresCollection() {
        return scoresCollection;
    }

    public void setScoresCollection(Collection<Scores> scoresCollection) {
        this.scoresCollection = scoresCollection;
    }

    @XmlTransient
    public Collection<StudentGun> getStudentGunCollection() {
        return studentGunCollection;
    }

    public void setStudentGunCollection(Collection<StudentGun> studentGunCollection) {
        this.studentGunCollection = studentGunCollection;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    @XmlTransient
    public Collection<StudentInfo> getStudentInfoCollection() {
        return studentInfoCollection;
    }

    public void setStudentInfoCollection(Collection<StudentInfo> studentInfoCollection) {
        this.studentInfoCollection = studentInfoCollection;
    }

    @XmlTransient
    public Collection<StudentEmergency> getStudentEmergencyCollection() {
        return studentEmergencyCollection;
    }

    public void setStudentEmergencyCollection(Collection<StudentEmergency> studentEmergencyCollection) {
        this.studentEmergencyCollection = studentEmergencyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentNum != null ? studentNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentNumbers)) {
            return false;
        }
        StudentNumbers other = (StudentNumbers) object;
        if ((this.studentNum == null && other.studentNum != null) || (this.studentNum != null && !this.studentNum.equals(other.studentNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.StudentNumbers[ studentNum=" + studentNum + " ]";
    }
    
}
