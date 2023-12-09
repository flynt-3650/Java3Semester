/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.texteditor;

public class Main {
    public static void main(String[] args) {
        TextDocumentFactory factory = new TextDocumentFactory();
        TextDocument txtDoc = factory.createOpen("1.txt");
        txtDoc.setFileContent("1234\n312");
        txtDoc.saveFile();
        System.out.println(txtDoc.getFileContent());
        txtDoc.setFileContent("hi");
        //txtDoc.saveFile();
        System.out.println(txtDoc.getFileContent());
    }
}
