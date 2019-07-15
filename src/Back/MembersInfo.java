/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Back;

import java.util.Date;

/**
 *
 * @author qq
 */
public class MembersInfo {
    private int id;
    private long tcno;
    private String Name,Surname;
    private Date regDate;
    private String tel;

    public MembersInfo(int id, String Name, String Surname, long Tcno,String tel,Date regDate) {
        this.id = id;
        this.Name = Name;
        this.Surname = Surname;
        this.tcno = Tcno;
        this.regDate = regDate;
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public long getTcno() {
        return tcno;
    }

    public void setTcno(long Tcno) {
        this.tcno = Tcno;
    }
    
}
