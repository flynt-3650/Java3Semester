/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.texteditor;

class TextDocumentFactory implements IDocumentFactory {
    @Override
    public TextDocument createOpen(String filename) {
        return new TextDocument(filename, true);
    }

    @Override
    public TextDocument createNew(String filename) {
        return new TextDocument(filename, false);
    }
}
