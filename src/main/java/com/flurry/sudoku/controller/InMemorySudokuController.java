package com.flurry.sudoku.controller;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;
import com.flurry.sudoku.reader.InMemorySudokuReader;
import com.flurry.sudoku.validator.AbstractSudokuValidator;
import com.flurry.sudoku.validator.SingleThreadedSudokuValidator;

/**
 * @author idey
 * A In meomry Sudoku controller which is reponsible for creating {@link com.flurry.sudoku.controller.InMemorySudokuController}
 * and pass the same to {@link com.flurry.sudoku.validator.SingleThreadedSudokuValidator}
 */
public class InMemorySudokuController implements ISudokuController{
    private AbstractSudokuValidator singleThreadedSudokuValidator;

    public InMemorySudokuController(int number, String filePath) throws SudokuException{
        ISudokuReader reader = new InMemorySudokuReader(number, filePath);
        singleThreadedSudokuValidator = new SingleThreadedSudokuValidator(reader);
    }

    @Override
    public boolean performValidation() throws SudokuException {
        return singleThreadedSudokuValidator.checkSudoku();
    }
}
