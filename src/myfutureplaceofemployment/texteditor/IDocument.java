/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.texteditor;

interface IDocument {
    String FILE_SAVE_DIR = "src/myfutureplaceofemployment/filesys/files";

    void openDocument();

    void createNewDocument();

    void saveFile();
}
