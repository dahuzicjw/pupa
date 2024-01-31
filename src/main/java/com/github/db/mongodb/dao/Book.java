package com.github.db.mongodb.dao;

/**
 * Created by Kevin on 2016/5/29.
 */
public class Book {
    private Integer bookID;
    private String bookName;

    public Book(Integer bookID, String bookName) {
        this.bookID = bookID;
        this.bookName = bookName;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
