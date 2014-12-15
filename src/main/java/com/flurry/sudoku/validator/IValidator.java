package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;

/**
 * This interface to will be used for validate row or column or a square region for a given
 * Sudoku
 * @see com.flurry.sudoku.validator.AbstractSudokuValidator
 * @see com.flurry.sudoku.validator.RowSudokuValidator
 * @see com.flurry.sudoku.validator.ColSudokuValidator
 * @see com.flurry.sudoku.validator.BlockSudokuValidator
 */
public interface IValidator {
    boolean checkSudoku() throws SudokuException;
}
