package com.flurry.sudoku.validator;

import com.flurry.sudoku.reader.ISudokuReader;

public abstract class AbstractSudokuColValidatorTest extends AbstractSudokuValidatorTest{
    protected int col;

    protected AbstractSudokuColValidatorTest(ISudokuReader reader, boolean expectedOutput, int col) {
        super(reader, expectedOutput);
        this.col = col;
    }
}
