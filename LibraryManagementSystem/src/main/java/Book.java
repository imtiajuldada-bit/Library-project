/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rivu
 */
public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getId()
    { return id; }
    public String getTitle() 
    { return title; }
    public String getAuthor() 
    { return author; }
    public boolean isAvailable() 
    { return available; }

    public void borrowBook() 
    { this.available = false; }
    public void returnBook() 
    { this.available = true; }

    @Override
    public String toString() {
        return id + "," + title + "," + author + "," + available;
    }
}


