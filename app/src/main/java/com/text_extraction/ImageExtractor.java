package com.text_extraction;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class ImageExtractor {

    public String extractText(File imageFile) {
        Tesseract tesseract = new Tesseract();
        String result = "";
        try {
            tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata"); // Ensure correct path
            result = tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return result;
    }
}
