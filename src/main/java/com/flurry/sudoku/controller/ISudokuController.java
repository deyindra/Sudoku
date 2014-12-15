package com.flurry.sudoku.controller;

import com.flurry.sudoku.exception.SudokuException;

/**
 * @author idey
 * Controller class which will be responsitble for creating {@link com.flurry.sudoku.reader.ISudokuReader},
 * pass the reader instance to {@link com.flurry.sudoku.validator.AbstractSudokuValidator} and call
 * {@link com.flurry.sudoku.validator.AbstractSudokuValidator#checkSudoku()} method
 */
public interface ISudokuController {
    boolean performValidation() throws SudokuException;
}
