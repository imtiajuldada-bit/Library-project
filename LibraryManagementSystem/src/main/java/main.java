/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rivu
 */
public class main {
    public static void main(String[] args) {
        // Run GUI safely in the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LibraryGUI frame = new LibraryGUI();
                frame.setTitle("Library Management System");
                frame.setSize(700, 500);
                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null); // Center window
                frame.setVisible(true);
            }
        });
    }
}


