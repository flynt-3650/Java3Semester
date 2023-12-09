/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.texteditor;

interface IDocumentFactory {
    IDocument createOpen(String name); // creates new object related to already existing file

    IDocument createNew(String name); // create new object related to the new file

}
