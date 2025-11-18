/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rivu
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class LibraryGUI extends JFrame {
    private Library library = new Library();
    private DefaultTableModel model;

    public LibraryGUI() {
        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Table
        model = new DefaultTableModel(new String[]{"ID", "Title", "Author", "Available"}, 0);
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        //Input
        JPanel panel = new JPanel(new GridLayout(2, 4));
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JButton addBtn = new JButton("Add Book");

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(addBtn);
        add(panel, BorderLayout.NORTH);

        //Search Section
        JLabel searchLabel = new JLabel("Search Title:");
        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");
        JButton showAllBtn = new JButton("Show All");
        JButton saveBtn = new JButton("Save");
        JButton loadBtn = new JButton("Load");

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(searchLabel);
        bottomPanel.add(searchField);
        bottomPanel.add(searchBtn);
        bottomPanel.add(showAllBtn);
        bottomPanel.add(saveBtn);
        bottomPanel.add(loadBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        //Add Book Action
        addBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();

            if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
                return;
            }

            Book b = new Book(id, title, author);
            library.addBook(b);
            model.addRow(new Object[]{id, title, author, true});

            idField.setText("");
            titleField.setText("");
            authorField.setText("");
        });

        //Search Action
        searchBtn.addActionListener(e -> {
            String title = searchField.getText().trim().toLowerCase();
            if (title.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a title to search!");
                return;
            }

            model.setRowCount(0); 
            //clear table
            boolean found = false;
            for (Book b : library.getBooks()) {
                if (b.getTitle().toLowerCase().contains(title)) {
                    model.addRow(new Object[]{b.getId(), b.getTitle(), b.getAuthor(), b.isAvailable()});
                    found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "No books found for: " + title);
            }
        });

        //Show All Action
        showAllBtn.addActionListener(e -> {
            model.setRowCount(0);
            for (Book b : library.getBooks()) {
                model.addRow(new Object[]{b.getId(), b.getTitle(), b.getAuthor(), b.isAvailable()});
            }
        });

        //Save
        saveBtn.addActionListener(e -> {
            try {
                library.saveToFile("books.txt");
                JOptionPane.showMessageDialog(this, "Saved Successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error Saving File!");
            }
        });

        //Load
        loadBtn.addActionListener(e -> {
            try {
                library.loadFromFile("books.txt");
                model.setRowCount(0);
                for (Book b : library.getBooks()) {
                    model.addRow(new Object[]{b.getId(), b.getTitle(), b.getAuthor(), b.isAvailable()});
                }
                JOptionPane.showMessageDialog(this, "Loaded Successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error Loading File!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryGUI().setVisible(true));
    }
}

    

