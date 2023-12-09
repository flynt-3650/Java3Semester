/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.texteditor;

import java.io.*;

class TextDocument implements IDocument {
    private final String filename;
    private String fileContent;

    public TextDocument(String filename, final boolean open) {
        this.filename = filename;

        if (open) {
            openDocument();
        } else {
            createNewDocument();
            openDocument();
        }
    }

    private boolean doesFileExist() {
        File file = new File(FILE_SAVE_DIR + File.separator + filename);
        return file.exists();
    }

    public String getFileContent() {
        openDocument(); // Update upon viewing
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public void openDocument() {
        // Read text from file with name `filename` and save it to fileContent
        File file = new File(FILE_SAVE_DIR + File.separator + filename);
        if (!doesFileExist()) {
            System.err.println("Error: File does not exist.");
            System.exit(1);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            fileContent = contentBuilder.toString();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void createNewDocument() {
        // Create a new file with name `filename`. Save it by the address given in FILE_SAVE_DIR

        if (doesFileExist()) {
            System.err.println("Error: File already exists.");
            System.exit(1);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_SAVE_DIR + File.separator + filename))) {
            writer.write("");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void saveFile() {
        // Write text from fileContent to the file with name `filename`
        File file = new File(FILE_SAVE_DIR + File.separator + filename);

        if (!doesFileExist()) {
            System.err.println("Error: File does not exist.");
            System.exit(1);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(fileContent);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
