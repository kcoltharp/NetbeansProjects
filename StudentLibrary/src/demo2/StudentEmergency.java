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
@Table(name = "STUDENT_EMERGENCY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentEmergency.findAll", query = "SELECT s FROM StudentEmergency s")})
public class StudentEmergency implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "EMERGENCYNAME")
    private String emergencyname;
    @Basic(optional = false)
    @Column(name = "EMERGENCYRELATION")
    private String emergencyrelation;
    @Basic(optional = false)
    @Column(name = "EMERGENCYADDRESS")
    private String emergencyaddress;
    @Basic(optional = false)
    @Column(name = "EMERGENCYADDRESS2")
    private String emergencyaddress2;
    @Basic(optional = false)
    @Column(name = "EMERGENCYCITY")
    private String emergencycity;
    @Basic(optional = false)
    @Column(name = "EMERGENCYSTATE")
    private String emergencystate;
    @Basic(optional = false)
    @Column(name = "EMERGENCYZIP")
    private String emergencyzip;
    @Basic(optional = false)
    @Column(name = "EMERGENCYPHONE")
    private String emergencyphone;
    @Basic(optional = false)
    @Column(name = "EMERGENCYCELL")
    private String emergencycell;
    @Basic(optional = false)
    @Column(name = "EMERGENCYWORK")
    private String emergencywork;
    @JoinColumn(name = "STUDENT_NUM", referencedColumnName = "STUDENT_NUM")
    @ManyToOne(optional = false)
    private StudentNumbers studentNum;

    public StudentEmergency(){
    }

    public StudentEmergency(Integer id){
        this.id = id;
    }

    public StudentEmergency(Integer id, String emergencyname, String emergencyrelation, String emergencyaddress, String emergencyaddress2, String emergencycity, String emergencystate, String emergencyzip, String emergencyphone, String emergencycell, String emergencywork){
        this.id = id;
        this.emergencyname = emergencyname;
        this.emergencyrelation = emergencyrelation;
        this.emergencyaddress = emergencyaddress;
        this.emergencyaddress2 = emergencyaddress2;
        this.emergencycity = emergencycity;
        this.emergencystate = emergencystate;
        this.emergencyzip = emergencyzip;
        this.emergencyphone = emergencyphone;
        this.emergencycell = emergencycell;
        this.emergencywork = emergencywork;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getEmergencyname(){
        return emergencyname;
    }

    public void setEmergencyname(String emergencyname){
        this.emergencyname = emergencyname;
    }

    public String getEmergencyrelation(){
        return emergencyrelation;
    }

    public void setEmergencyrelation(String emergencyrelation){
        this.emergencyrelation = emergencyrelation;
    }

    public String getEmergencyaddress(){
        return emergencyaddress;
    }

    public void setEmergencyaddress(String emergencyaddress){
        this.emergencyaddress = emergencyaddress;
    }

    public String getEmergencyaddress2(){
        return emergencyaddress2;
    }

    public void setEmergencyaddress2(String emergencyaddress2){
        this.emergencyaddress2 = emergencyaddress2;
    }

    public String getEmergencycity(){
        return emergencycity;
    }

    public void setEmergencycity(String emergencycity){
        this.emergencycity = emergencycity;
    }

    public String getEmergencystate(){
        return emergencystate;
    }

    public void setEmergencystate(String emergencystate){
        this.emergencystate = emergencystate;
    }

    public String getEmergencyzip(){
        return emergencyzip;
    }

    public void setEmergencyzip(String emergencyzip){
        this.emergencyzip = emergencyzip;
    }

    public String getEmergencyphone(){
        return emergencyphone;
    }

    public void setEmergencyphone(String emergencyphone){
        this.emergencyphone = emergencyphone;
    }

    public String getEmergencycell(){
        return emergencycell;
    }

    public void setEmergencycell(String emergencycell){
        this.emergencycell = emergencycell;
    }

    public String getEmergencywork(){
        return emergencywork;
    }

    public void setEmergencywork(String emergencywork){
        this.emergencywork = emergencywork;
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
        if(!(object instanceof StudentEmergency)){
            return false;
        }
        StudentEmergency other = (StudentEmergency) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "demo2.StudentEmergency[ id=" + id + " ]";
    }

}
