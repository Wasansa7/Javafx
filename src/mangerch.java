/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallmyscens;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Wasan
 */
@Entity
@Table(name = "mangerdb")
public class mangerch implements java.io.Serializable{

    @Id
    @Column(name = "userName")
    public String userName;
    @Column(name = "passWord")
    public String passWord;
    @Column(name = "emailmanger")
    public String emailmanger;

    public mangerch() {
    }

    public mangerch(String userName, String passWord, String emailmanger) {
        this.userName = userName;
        this.passWord = passWord;
        this.emailmanger = emailmanger;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmailmanger() {
        return emailmanger;
    }

    public void setEmailmanger(String emailmanger) {
        this.emailmanger = emailmanger;
    }

}
