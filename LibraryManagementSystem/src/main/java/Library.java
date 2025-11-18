/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rivu
 */

import java.util.*;
import java.io.*;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b) { books.add(b); }
    public ArrayList<Book> getBooks() { return books; }

    public Book searchByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (Book b : books) {
            bw.write(b.toString());
            bw.newLine();
        }
        bw.close();
    }

    public void loadFromFile(String filename) throws IOException {
        books.clear();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            Book b = new Book(data[0], data[1], data[2]);
            if (data[3].equals("false")) b.borrowBook();
            books.add(b);
        }
        br.close();
    }
}

    

