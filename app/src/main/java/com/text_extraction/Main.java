package com.text_extraction;

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        // This will main frame
        JFrame frame = new JFrame("Text Extraction Tool 🩷");
        frame.setSize(600, 500);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        
        frame.getContentPane().setBackground(new Color(255, 182, 193)); // Light pink

       
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 182, 193));

        
        JLabel label = new JLabel("Select a file and file type to extract text ", SwingConstants.CENTER);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); 
        panel.add(label, BorderLayout.NORTH);

       
        JPanel fileSelectionPanel = new JPanel();
        fileSelectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); 
        fileSelectionPanel.setBackground(new Color(255, 182, 193)); 

        
        String[] fileTypes = { "Select File Type ", "Image", "PDF", "TXT", "Word", "Excel" };
        JComboBox<String> fileTypeDropdown = new JComboBox<>(fileTypes);
        fileTypeDropdown.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        fileTypeDropdown.setBackground(new Color(250, 224, 228));
        fileTypeDropdown.setOpaque(true);  
        fileTypeDropdown.setPreferredSize(new Dimension(150, 30)); 
        fileSelectionPanel.add(fileTypeDropdown);

       
        JButton fileButton = new JButton("Browse Files ");
        fileButton.setBackground(new Color(255, 105, 180)); 
        fileButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        fileButton.setForeground(Color.WHITE);
        fileButton.setFocusPainted(false); 
        fileSelectionPanel.add(fileButton);

        panel.add(fileSelectionPanel, BorderLayout.CENTER);

        
        frame.add(panel);
        frame.setVisible(true);

       
        fileButton.addActionListener(e -> {
            String selectedType = (String) fileTypeDropdown.getSelectedItem();

            if (selectedType == null || selectedType.equals("Select File Type 🩷")) {
                JOptionPane.showMessageDialog(frame, "Please select a file type first 🩷.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a File 🩷");
            fileChooser.setFileFilter(new FileNameExtensionFilter(
                    selectedType + " Files 🩷", getFileExtensions(selectedType)));
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String extractedText = "";

                try {
                    switch (selectedType) {
                        case "Image":
                            extractedText = new ImageExtractor().extractText(file);
                            break;
                        case "PDF":
                            extractedText = new PDFExtractor().extractText(file);
                            break;
                        case "TXT":
                            extractedText = new TXTExtractor().extractText(file);
                            break;
                        case "Word":
                            extractedText = new WordExtractor().extractText(file);
                            break;
                        case "Excel":
                            extractedText = new ExcelExtractor().extractText(file);
                            break;
                        default:
                            extractedText = "Unsupported file type ";
                    }

                   
                    System.out.println("Extracted Text: " + extractedText);
                    
                   
                    JFrame extractedTextFrame = new JFrame("Extracted Text ");
                    extractedTextFrame.setSize(600, 500); 
                    extractedTextFrame.setLocationRelativeTo(null);
                    extractedTextFrame.getContentPane().setBackground(new Color(255, 182, 193));

                    
                    JTextArea textArea = new JTextArea();
                    textArea.setText(extractedText);
                    textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 14)); 
                    textArea.setWrapStyleWord(true);
                    textArea.setLineWrap(true);
                    textArea.setEditable(false);
                    textArea.setBackground(new Color(250, 224, 228)); 
                    textArea.setForeground(new Color(173, 0, 117)); 
                    textArea.setCaretColor(Color.BLACK); 

                    
                    textArea.setBorder(BorderFactory.createLineBorder(new Color(255, 105, 180), 3));

                    
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    extractedTextFrame.add(scrollPane);

                    
                    JButton backButton = new JButton("Back ");
                    backButton.setBackground(new Color(255, 105, 180)); // Hot pink
                    backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
                    backButton.setForeground(Color.WHITE);
                    backButton.setFocusPainted(false); 
                    backButton.addActionListener(e1 -> extractedTextFrame.dispose()); 
                    extractedTextFrame.add(backButton, BorderLayout.SOUTH);

                    
                    extractedTextFrame.setVisible(true);

                } catch (Exception ex) {
                    extractedText = "Error 🩷: " + ex.getMessage();
                    ex.printStackTrace();
                }
            }
        });
    }


    private static String[] getFileExtensions(String fileType) {
        switch (fileType) {
            case "Image":
                return new String[] { "jpg", "png", "jpeg" };
            case "PDF":
                return new String[] { "pdf" };
            case "TXT":
                return new String[] { "txt" };
            case "Word":
                return new String[] { "docx" };
            case "Excel":
                return new String[] { "xlsx" };
            default:
                return new String[] {};
        }
    }
}
