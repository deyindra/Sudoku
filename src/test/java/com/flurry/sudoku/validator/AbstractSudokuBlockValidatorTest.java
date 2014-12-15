package com.flurry.sudoku.validator;

import com.flurry.sudoku.reader.ISudokuReader;

public abstract class AbstractSudokuBlockValidatorTest extends AbstractSudokuValidatorTest{
    protected int col;
    protected int row;

    protected AbstractSudokuBlockValidatorTest(ISudokuReader reader, boolean expectedOutput, int col, int row) {
        super(reader, expectedOutput);
        this.col = col;
        this.row = row;
    }
}
