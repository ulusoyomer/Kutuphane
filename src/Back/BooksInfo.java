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
public class BooksInfo {
    private int id,page;
    private String name,writer,publisher,type;
    private Date year;

    public BooksInfo(int id, String name, String writer, String publisher, int page, String type, Date year) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.publisher = publisher;
        this.page = page;
        this.type = type;
        this.year = year;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getBType() {
        return type;
    }

    public void setBType(String type) {
        this.type = type;
    }
    
}
