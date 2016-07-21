/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kenny
 */
@Entity
@Table(name = "classes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "SELECT c FROM Classes c"),
    @NamedQuery(name = "Classes.findById", query = "SELECT c FROM Classes c WHERE c.id = :id"),
    @NamedQuery(name = "Classes.findByClassNum", query = "SELECT c FROM Classes c WHERE c.classNum = :classNum"),
    @NamedQuery(name = "Classes.findByClassStart", query = "SELECT c FROM Classes c WHERE c.classStart = :classStart"),
    @NamedQuery(name = "Classes.findByLesson1Start", query = "SELECT c FROM Classes c WHERE c.lesson1Start = :lesson1Start"),
    @NamedQuery(name = "Classes.findByLesson2Start", query = "SELECT c FROM Classes c WHERE c.lesson2Start = :lesson2Start"),
    @NamedQuery(name = "Classes.findByLegalTestStart", query = "SELECT c FROM Classes c WHERE c.legalTestStart = :legalTestStart"),
    @NamedQuery(name = "Classes.findByLesson3Start", query = "SELECT c FROM Classes c WHERE c.lesson3Start = :lesson3Start"),
    @NamedQuery(name = "Classes.findBySafetyTestStart", query = "SELECT c FROM Classes c WHERE c.safetyTestStart = :safetyTestStart"),
    @NamedQuery(name = "Classes.findByQualStart", query = "SELECT c FROM Classes c WHERE c.qualStart = :qualStart")})
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "class_num")
    private long classNum;
    @Column(name = "class_start")
    @Temporal(TemporalType.TIME)
    private Date classStart;
    @Column(name = "lesson1_start")
    @Temporal(TemporalType.TIME)
    private Date lesson1Start;
    @Column(name = "lesson2_start")
    @Temporal(TemporalType.TIME)
    private Date lesson2Start;
    @Column(name = "legal_test_start")
    @Temporal(TemporalType.TIME)
    private Date legalTestStart;
    @Column(name = "lesson3_start")
    @Temporal(TemporalType.TIME)
    private Date lesson3Start;
    @Column(name = "safety_test_start")
    @Temporal(TemporalType.TIME)
    private Date safetyTestStart;
    @Column(name = "qual_start")
    @Temporal(TemporalType.TIME)
    private Date qualStart;
    @OneToMany(mappedBy = "classNum")
    private Collection<StudentNumbers> studentNumbersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classNum")
    private Collection<Scores> scoresCollection;

    public Classes() {
    }

    public Classes(Integer id) {
        this.id = id;
    }

    public Classes(Integer id, long classNum) {
        this.id = id;
        this.classNum = classNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getClassNum() {
        return classNum;
    }

    public void setClassNum(long classNum) {
        this.classNum = classNum;
    }

    public Date getClassStart() {
        return classStart;
    }

    public void setClassStart(Date classStart) {
        this.classStart = classStart;
    }

    public Date getLesson1Start() {
        return lesson1Start;
    }

    public void setLesson1Start(Date lesson1Start) {
        this.lesson1Start = lesson1Start;
    }

    public Date getLesson2Start() {
        return lesson2Start;
    }

    public void setLesson2Start(Date lesson2Start) {
        this.lesson2Start = lesson2Start;
    }

    public Date getLegalTestStart() {
        return legalTestStart;
    }

    public void setLegalTestStart(Date legalTestStart) {
        this.legalTestStart = legalTestStart;
    }

    public Date getLesson3Start() {
        return lesson3Start;
    }

    public void setLesson3Start(Date lesson3Start) {
        this.lesson3Start = lesson3Start;
    }

    public Date getSafetyTestStart() {
        return safetyTestStart;
    }

    public void setSafetyTestStart(Date safetyTestStart) {
        this.safetyTestStart = safetyTestStart;
    }

    public Date getQualStart() {
        return qualStart;
    }

    public void setQualStart(Date qualStart) {
        this.qualStart = qualStart;
    }

    @XmlTransient
    public Collection<StudentNumbers> getStudentNumbersCollection() {
        return studentNumbersCollection;
    }

    public void setStudentNumbersCollection(Collection<StudentNumbers> studentNumbersCollection) {
        this.studentNumbersCollection = studentNumbersCollection;
    }

    @XmlTransient
    public Collection<Scores> getScoresCollection() {
        return scoresCollection;
    }

    public void setScoresCollection(Collection<Scores> scoresCollection) {
        this.scoresCollection = scoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.Classes[ id=" + id + " ]";
    }
    
}
