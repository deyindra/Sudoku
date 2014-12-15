package com.flurry.sudoku.validator;

import com.flurry.sudoku.reader.ISudokuReader;

public abstract class AbstractSudokuValidatorTest {
    protected ISudokuReader reader;
    protected boolean expectedOutput;

    protected AbstractSudokuValidatorTest(ISudokuReader reader, boolean expectedOutput) {
        this.reader = reader;
        this.expectedOutput = expectedOutput;
    }
}
