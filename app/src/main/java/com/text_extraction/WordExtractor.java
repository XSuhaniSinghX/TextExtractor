package com.text_extraction;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class WordExtractor {

    public String extractText(File wordFile) {
        StringBuilder result = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(wordFile);
             XWPFDocument doc = new XWPFDocument(fis)) {

            // Extract text from paragraphs
            List<XWPFParagraph> paragraphs = doc.getParagraphs();
            for (XWPFParagraph paragraph : paragraphs) {
                result.append(paragraph.getText()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
