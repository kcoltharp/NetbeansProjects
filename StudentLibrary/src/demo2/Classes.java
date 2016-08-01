/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenny
 */
@Entity
@Table(name = "CLASSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "SELECT c FROM Classes c")})
public class Classes implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CLASS_NUM")
    private long classNum;
    @Column(name = "CLASS_START")
    @Temporal(TemporalType.TIME)
    private Date classStart;
    @Column(name = "LESSON1_START")
    @Temporal(TemporalType.TIME)
    private Date lesson1Start;
    @Column(name = "LESSON2_START")
    @Temporal(TemporalType.TIME)
    private Date lesson2Start;
    @Column(name = "LEGAL_TEST_START")
    @Temporal(TemporalType.TIME)
    private Date legalTestStart;
    @Column(name = "LESSON3_START")
    @Temporal(TemporalType.TIME)
    private Date lesson3Start;
    @Column(name = "SAFETY_TEST_START")
    @Temporal(TemporalType.TIME)
    private Date safetyTestStart;
    @Column(name = "QUAL_START")
    @Temporal(TemporalType.TIME)
    private Date qualStart;

    public Classes(){
    }

    public Classes(Integer id){
        this.id = id;
    }

    public Classes(Integer id, long classNum){
        this.id = id;
        this.classNum = classNum;
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

    public Date getClassStart(){
        return classStart;
    }

    public void setClassStart(Date classStart){
        this.classStart = classStart;
    }

    public Date getLesson1Start(){
        return lesson1Start;
    }

    public void setLesson1Start(Date lesson1Start){
        this.lesson1Start = lesson1Start;
    }

    public Date getLesson2Start(){
        return lesson2Start;
    }

    public void setLesson2Start(Date lesson2Start){
        this.lesson2Start = lesson2Start;
    }

    public Date getLegalTestStart(){
        return legalTestStart;
    }

    public void setLegalTestStart(Date legalTestStart){
        this.legalTestStart = legalTestStart;
    }

    public Date getLesson3Start(){
        return lesson3Start;
    }

    public void setLesson3Start(Date lesson3Start){
        this.lesson3Start = lesson3Start;
    }

    public Date getSafetyTestStart(){
        return safetyTestStart;
    }

    public void setSafetyTestStart(Date safetyTestStart){
        this.safetyTestStart = safetyTestStart;
    }

    public Date getQualStart(){
        return qualStart;
    }

    public void setQualStart(Date qualStart){
        this.qualStart = qualStart;
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
        if(!(object instanceof Classes)){
            return false;
        }
        Classes other = (Classes) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "demo2.Classes[ id=" + id + " ]";
    }

}
