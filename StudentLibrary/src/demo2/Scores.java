/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenny
 */
@Entity
@Table(name = "SCORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scores.findAll", query = "SELECT s FROM Scores s")})
public class Scores implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CLASS_NUM")
    private long classNum;
    @Column(name = "STUDENT_NUM")
    private BigInteger studentNum;
    @Basic(optional = false)
    @Column(name = "LEGAL_TEST_SCORE")
    private float legalTestScore;
    @Basic(optional = false)
    @Column(name = "SAFETY_TEST_SCORE")
    private float safetyTestScore;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMBINED_SCORE")
    private Float combinedScore;
    @Column(name = "TARGET_HITS")
    private Integer targetHits;
    @Column(name = "PASS_FAIL")
    private String passFail;

    public Scores(){
    }

    public Scores(Integer id){
        this.id = id;
    }

    public Scores(Integer id, long classNum, float legalTestScore, float safetyTestScore){
        this.id = id;
        this.classNum = classNum;
        this.legalTestScore = legalTestScore;
        this.safetyTestScore = safetyTestScore;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public long getClassNum(){
        return classNum;
    }

    public void setClassNum(long classNum){
        this.classNum = classNum;
    }

    public BigInteger getStudentNum(){
        return studentNum;
    }

    public void setStudentNum(BigInteger studentNum){
        this.studentNum = studentNum;
    }

    public float getLegalTestScore(){
        return legalTestScore;
    }

    public void setLegalTestScore(float legalTestScore){
        this.legalTestScore = legalTestScore;
    }

    public float getSafetyTestScore(){
        return safetyTestScore;
    }

    public void setSafetyTestScore(float safetyTestScore){
        this.safetyTestScore = safetyTestScore;
    }

    public Float getCombinedScore(){
        return combinedScore;
    }

    public void setCombinedScore(Float combinedScore){
        this.combinedScore = combinedScore;
    }

    public Integer getTargetHits(){
        return targetHits;
    }

    public void setTargetHits(Integer targetHits){
        this.targetHits = targetHits;
    }

    public String getPassFail(){
        return passFail;
    }

    public void setPassFail(String passFail){
        this.passFail = passFail;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof Scores)){
            return false;
        }
        Scores other = (Scores) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "demo2.Scores[ id=" + id + " ]";
    }

}
