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
@Table(name = "student_gun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentGun.findAll", query = "SELECT s FROM StudentGun s"),
    @NamedQuery(name = "StudentGun.findById", query = "SELECT s FROM StudentGun s WHERE s.id = :id"),
    @NamedQuery(name = "StudentGun.findByGunType", query = "SELECT s FROM StudentGun s WHERE s.gunType = :gunType"),
    @NamedQuery(name = "StudentGun.findByGunManufacturer", query = "SELECT s FROM StudentGun s WHERE s.gunManufacturer = :gunManufacturer"),
    @NamedQuery(name = "StudentGun.findByCaliber", query = "SELECT s FROM StudentGun s WHERE s.caliber = :caliber")})
public class StudentGun implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "gunType")
    private String gunType;
    @Basic(optional = false)
    @Column(name = "gunManufacturer")
    private String gunManufacturer;
    @Basic(optional = false)
    @Column(name = "caliber")
    private String caliber;
    @JoinColumn(name = "student_num", referencedColumnName = "student_num")
    @ManyToOne(optional = false)
    private StudentNumbers studentNum;

    public StudentGun() {
    }

    public StudentGun(Integer id) {
        this.id = id;
    }

    public StudentGun(Integer id, String gunType, String gunManufacturer, String caliber) {
        this.id = id;
        this.gunType = gunType;
        this.gunManufacturer = gunManufacturer;
        this.caliber = caliber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGunType() {
        return gunType;
    }

    public void setGunType(String gunType) {
        this.gunType = gunType;
    }

    public String getGunManufacturer() {
        return gunManufacturer;
    }

    public void setGunManufacturer(String gunManufacturer) {
        this.gunManufacturer = gunManufacturer;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
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
        if (!(object instanceof StudentGun)) {
            return false;
        }
        StudentGun other = (StudentGun) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.StudentGun[ id=" + id + " ]";
    }
    
}
