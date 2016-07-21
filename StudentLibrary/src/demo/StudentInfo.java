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
@Table(name = "student_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentInfo.findAll", query = "SELECT s FROM StudentInfo s"),
    @NamedQuery(name = "StudentInfo.findById", query = "SELECT s FROM StudentInfo s WHERE s.id = :id"),
    @NamedQuery(name = "StudentInfo.findBySex", query = "SELECT s FROM StudentInfo s WHERE s.sex = :sex"),
    @NamedQuery(name = "StudentInfo.findByDob", query = "SELECT s FROM StudentInfo s WHERE s.dob = :dob"),
    @NamedQuery(name = "StudentInfo.findByAddress", query = "SELECT s FROM StudentInfo s WHERE s.address = :address"),
    @NamedQuery(name = "StudentInfo.findByAddress2", query = "SELECT s FROM StudentInfo s WHERE s.address2 = :address2"),
    @NamedQuery(name = "StudentInfo.findByCity", query = "SELECT s FROM StudentInfo s WHERE s.city = :city"),
    @NamedQuery(name = "StudentInfo.findByState", query = "SELECT s FROM StudentInfo s WHERE s.state = :state"),
    @NamedQuery(name = "StudentInfo.findByZip", query = "SELECT s FROM StudentInfo s WHERE s.zip = :zip"),
    @NamedQuery(name = "StudentInfo.findByEmail", query = "SELECT s FROM StudentInfo s WHERE s.email = :email"),
    @NamedQuery(name = "StudentInfo.findByHphone", query = "SELECT s FROM StudentInfo s WHERE s.hphone = :hphone"),
    @NamedQuery(name = "StudentInfo.findByCphone", query = "SELECT s FROM StudentInfo s WHERE s.cphone = :cphone"),
    @NamedQuery(name = "StudentInfo.findByLic", query = "SELECT s FROM StudentInfo s WHERE s.lic = :lic"),
    @NamedQuery(name = "StudentInfo.findByLicSt", query = "SELECT s FROM StudentInfo s WHERE s.licSt = :licSt")})
public class StudentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "zip")
    private String zip;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "hphone")
    private String hphone;
    @Basic(optional = false)
    @Column(name = "cphone")
    private String cphone;
    @Basic(optional = false)
    @Column(name = "lic#")
    private String lic;
    @Basic(optional = false)
    @Column(name = "lic_st")
    private String licSt;
    @JoinColumn(name = "student_num", referencedColumnName = "student_num")
    @ManyToOne(optional = false)
    private StudentNumbers studentNum;

    public StudentInfo() {
    }

    public StudentInfo(Integer id) {
        this.id = id;
    }

    public StudentInfo(Integer id, String sex, Date dob, String address, String address2, String city, String state, String zip, String email, String hphone, String cphone, String lic, String licSt) {
        this.id = id;
        this.sex = sex;
        this.dob = dob;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.hphone = hphone;
        this.cphone = cphone;
        this.lic = lic;
        this.licSt = licSt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getLic() {
        return lic;
    }

    public void setLic(String lic) {
        this.lic = lic;
    }

    public String getLicSt() {
        return licSt;
    }

    public void setLicSt(String licSt) {
        this.licSt = licSt;
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
        if (!(object instanceof StudentInfo)) {
            return false;
        }
        StudentInfo other = (StudentInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.StudentInfo[ id=" + id + " ]";
    }
    
}
