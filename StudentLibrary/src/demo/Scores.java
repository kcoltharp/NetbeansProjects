/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenny
 */
@Entity
@Table(name = "scores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scores.findAll", query = "SELECT s FROM Scores s"),
    @NamedQuery(name = "Scores.findById", query = "SELECT s FROM Scores s WHERE s.id = :id"),
    @NamedQuery(name = "Scores.findByLegalTestScore", query = "SELECT s FROM Scores s WHERE s.legalTestScore = :legalTestScore"),
    @NamedQuery(name = "Scores.findBySafetyTestScore", query = "SELECT s FROM Scores s WHERE s.safetyTestScore = :safetyTestScore"),
    @NamedQuery(name = "Scores.findByCombinedScore", query = "SELECT s FROM Scores s WHERE s.combinedScore = :combinedScore"),
    @NamedQuery(name = "Scores.findByTargetHits", query = "SELECT s FROM Scores s WHERE s.targetHits = :targetHits"),
    @NamedQuery(name = "Scores.findByPassFail", query = "SELECT s FROM Scores s WHERE s.passFail = :passFail")})
public class Scores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "legal_test_score")
    private float legalTestScore;
    @Basic(optional = false)
    @Column(name = "safety_test_score")
    private float safetyTestScore;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "combined_score")
    private Float combinedScore;
    @Column(name = "target_hits")
    private Integer targetHits;
    @Column(name = "pass_fail")
    private String passFail;
    @JoinColumn(name = "class_num", referencedColumnName = "class_num")
    @ManyToOne(optional = false)
    private Classes classNum;
    @JoinColumn(name = "student_num", referencedColumnName = "student_num")
    @ManyToOne
    private StudentNumbers studentNum;

    public Scores() {
    }

    public Scores(Integer id) {
        this.id = id;
    }

    public Scores(Integer id, float legalTestScore, float safetyTestScore) {
        this.id = id;
        this.legalTestScore = legalTestScore;
        this.safetyTestScore = safetyTestScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getLegalTestScore() {
        return legalTestScore;
    }

    public void setLegalTestScore(float legalTestScore) {
        this.legalTestScore = legalTestScore;
    }

    public float getSafetyTestScore() {
        return safetyTestScore;
    }

    public void setSafetyTestScore(float safetyTestScore) {
        this.safetyTestScore = safetyTestScore;
    }

    public Float getCombinedScore() {
        return combinedScore;
    }

    public void setCombinedScore(Float combinedScore) {
        this.combinedScore = combinedScore;
    }

    public Integer getTargetHits() {
        return targetHits;
    }

    public void setTargetHits(Integer targetHits) {
        this.targetHits = targetHits;
    }

    public String getPassFail() {
        return passFail;
    }

    public void setPassFail(String passFail) {
        this.passFail = passFail;
    }

    public Classes getClassNum() {
        return classNum;
    }

    public void setClassNum(Classes classNum) {
        this.classNum = classNum;
    }

    public StudentNumbers getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(StudentNumbers studentNum) {
        this.studentNum = studentNum;
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
        if (!(object instanceof Scores)) {
            return false;
        }
        Scores other = (Scores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.Scores[ id=" + id + " ]";
    }
    
}
