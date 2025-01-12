# Text Extractor

## Description
The Text Extractor is a tool designed to extract text from various file types and media, including images, PDFs, text files, Word documents, and Excel sheets.

---

## Features
- **Multi-Format Support**: Extract text from images, PDFs, Word, Excel, and plain text files.
- **Handwriting Recognition**: Use OCR to recognize handwritten text from images.
- **Single-Window Navigation**: Extracted text is displayed right in the app, with an option to go back.

---

## Requirements
- **Java 11+**: Ensure Java is installed.
- - **Tesseract OCR**:
  - Download from [Tesseract GitHub](https://github.com/tesseract-ocr/tesseract).
  - Set the correct `tessdata` path in the code.
- **Apache POI**: For Word and Excel file processing.
- **Maven** (optional): To manage dependencies.

---

## Quick Start
1. Clone the project using the following command:
   ```bash
   git clone https://github.com/xsuhanisinghx/TextExtractor.git
   ```
2. Add required libraries (Tess4J, Apache POI).
3. Update the `tessdata` path in the code:
   ```java
   tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");
4. Run the MainApp class.
5. Select the file type, upload your file, and click "Extract" to view the text.
6. Select the file type, upload your file, and click **Extract** to view the extracted text.

---

## Notes
- **Handwriting Recognition**: Accuracy depends on the clarity of the handwriting and image quality.
- **Performance**: Processing large files may take longer; ensure sufficient system resources.
- **Dependencies**: Ensure all libraries are correctly added to avoid runtime issues.
---

## Coming Soon
- Text extraction from GIFs, videos, and live camera feeds.

---

## Credits 
- [Tesseract OCR](https://github.com/tesseract-ocr/tesseract)
- [Apache POI](https://poi.apache.org/)
