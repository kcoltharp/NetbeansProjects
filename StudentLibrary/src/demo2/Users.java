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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenny
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})
public class Users implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "ADMIN")
    private Character admin;

    public Users(){
    }

    public Users(Integer userId){
        this.userId = userId;
    }

    public Users(Integer userId, String username, String password, Character admin){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Character getAdmin(){
        return admin;
    }

    public void setAdmin(Character admin){
        this.admin = admin;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof Users)){
            return false;
        }
        Users other = (Users) object;
        if((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "demo2.Users[ userId=" + userId + " ]";
    }

}
