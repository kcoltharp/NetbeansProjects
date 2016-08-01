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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "STUDENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")})
public class Students implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @Column(name = "LNAME")
    private String lname;
    @Basic(optional = false)
    @Column(name = "SUBMISSIONDATE")
    @Temporal(TemporalType.DATE)
    private Date submissiondate;
    @Basic(optional = false)
    @Column(name = "SUBMISSIONTIME")
    @Temporal(TemporalType.TIME)
    private Date submissiontime;
    @JoinColumn(name = "STUDENT_NUM", referencedColumnName = "STUDENT_NUM")
    @ManyToOne(optional = false)
    private StudentNumbers studentNum;

    public Students(){
    }

    public Students(Integer id){
        this.id = id;
    }

    public Students(Integer id, String fname, String lname, Date submissiondate, Date submissiontime){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.submissiondate = submissiondate;
        this.submissiontime = submissiontime;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getFname(){
        return fname;
    }

    public void setFname(String fname){
        this.fname = fname;
    }

    public String getLname(){
        return lname;
    }

    public void setLname(String lname){
        this.lname = lname;
    }

    public Date getSubmissiondate(){
        return submissiondate;
    }

    public void setSubmissiondate(Date submissiondate){
        this.submissiondate = submissiondate;
    }

    public Date getSubmissiontime(){
        return submissiontime;
    }

    public void setSubmissiontime(Date submissiontime){
        this.submissiontime = submissiontime;
    }

    public StudentNumbers getStudentNum(){
        return studentNum;
    }

    public void setStudentNum(StudentNumbers studentNum){
        this.studentNum = studentNum;
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
        if(!(object instanceof Students)){
            return false;
        }
        Students other = (Students) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "demo2.Students[ id=" + id + " ]";
    }

}
