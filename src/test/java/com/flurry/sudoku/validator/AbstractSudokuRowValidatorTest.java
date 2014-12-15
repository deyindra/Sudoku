package com.flurry.sudoku.validator;

import com.flurry.sudoku.reader.ISudokuReader;

public abstract class AbstractSudokuRowValidatorTest extends AbstractSudokuValidatorTest{
    protected int row;

    protected AbstractSudokuRowValidatorTest(ISudokuReader reader, boolean expectedOutput, int row) {
        super(reader, expectedOutput);
        this.row = row;
    }
}
