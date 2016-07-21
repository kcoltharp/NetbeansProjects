/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenny
 */
@Entity
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findById", query = "SELECT s FROM Students s WHERE s.id = :id"),
    @NamedQuery(name = "Students.findByFname", query = "SELECT s FROM Students s WHERE s.fname = :fname"),
    @NamedQuery(name = "Students.findByLname", query = "SELECT s FROM Students s WHERE s.lname = :lname"),
    @NamedQuery(name = "Students.findBySubmissionDate", query = "SELECT s FROM Students s WHERE s.submissionDate = :submissionDate"),
    @NamedQuery(name = "Students.findBySubmissionTime", query = "SELECT s FROM Students s WHERE s.submissionTime = :submissionTime")})
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @Column(name = "lname")
    private String lname;
    @Basic(optional = false)
    @Column(name = "submissionDate")
    @Temporal(TemporalType.DATE)
    private Date submissionDate;
    @Basic(optional = false)
    @Column(name = "submissionTime")
    @Temporal(TemporalType.TIME)
    private Date submissionTime;
    @JoinColumn(name = "student_num", referencedColumnName = "student_num")
    @ManyToOne(optional = false)
    private StudentNumbers studentNum;

    public Students() {
    }

    public Students(Integer id) {
        this.id = id;
    }

    public Students(Integer id, String fname, String lname, Date submissionDate, Date submissionTime) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.submissionDate = submissionDate;
        this.submissionTime = submissionTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
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
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.Students[ id=" + id + " ]";
    }
    
}
