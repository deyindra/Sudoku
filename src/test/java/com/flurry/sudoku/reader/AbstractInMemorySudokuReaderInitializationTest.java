package com.flurry.sudoku.reader;

public abstract class AbstractInMemorySudokuReaderInitializationTest {
    protected String fileName;
    protected int number;
    protected int[][] expectedOutput;

    protected AbstractInMemorySudokuReaderInitializationTest(String fileName,
                                                             int number,
                                                             int[][] expectedOutput) {
        this.fileName = fileName;
        this.number = number;
        this.expectedOutput = expectedOutput;
    }
}
