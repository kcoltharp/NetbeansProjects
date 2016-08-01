/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "STUDENT_GUN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentGun.findAll", query = "SELECT s FROM StudentGun s")})
public class StudentGun implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "GUNTYPE")
    private String guntype;
    @Basic(optional = false)
    @Column(name = "GUNMANUFACTURER")
    private String gunmanufacturer;
    @Basic(optional = false)
    @Column(name = "CALIBER")
    private String caliber;
    @JoinColumn(name = "STUDENT_NUM", referencedColumnName = "STUDENT_NUM")
    @ManyToOne(optional = false)
    private StudentNumbers studentNum;

    public StudentGun(){
    }

    public StudentGun(Integer id){
        this.id = id;
    }

    public StudentGun(Integer id, String guntype, String gunmanufacturer, String caliber){
        this.id = id;
        this.guntype = guntype;
        this.gunmanufacturer = gunmanufacturer;
        this.caliber = caliber;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getGuntype(){
        return guntype;
    }

    public void setGuntype(String guntype){
        this.guntype = guntype;
    }

    public String getGunmanufacturer(){
        return gunmanufacturer;
    }

    public void setGunmanufacturer(String gunmanufacturer){
        this.gunmanufacturer = gunmanufacturer;
    }

    public String getCaliber(){
        return caliber;
    }

    public void setCaliber(String caliber){
        this.caliber = caliber;
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
        if(!(object instanceof StudentGun)){
            return false;
        }
        StudentGun other = (StudentGun) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "demo2.StudentGun[ id=" + id + " ]";
    }

}
