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
public class TranInfo {
    private int id,memid,bookid;
    private Date gudate,gbdate;
    private String username,bookname;

    public TranInfo(int id, int memid, int bookid, Date gudate, Date gbdate, String username, String bookname) {
        this.id = id;
        this.memid = memid;
        this.bookid = bookid;
        this.gudate = gudate;
        this.gbdate = gbdate;
        this.username = username;
        this.bookname = bookname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemid() {
        return memid;
    }

    public void setMemid(int memid) {
        this.memid = memid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public Date getGudate() {
        return gudate;
    }

    public void setGudate(Date gudate) {
        this.gudate = gudate;
    }

    public Date getGbdate() {
        return gbdate;
    }

    public void setGbdate(Date gbdate) {
        this.gbdate = gbdate;
    }
}
