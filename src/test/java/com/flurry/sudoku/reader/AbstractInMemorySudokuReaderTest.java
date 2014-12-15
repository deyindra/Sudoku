package com.flurry.sudoku.reader;

public abstract class AbstractInMemorySudokuReaderTest {
    protected String fileName;
    protected int number;
    protected int expectedLength;
    protected int row;
    protected int column;
    protected int expectedValue;

    protected AbstractInMemorySudokuReaderTest(String fileName,
                                               int number,
                                               int expectedLength,
                                               int row,
                                               int column,
                                               int expectedValue) {
        this.fileName = fileName;
        this.number = number;
        this.expectedLength = expectedLength;
        this.row = row;
        this.column = column;
        this.expectedValue = expectedValue;
    }
}
