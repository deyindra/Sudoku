package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;

/**
 * @author idey
 * An Abstract Class which will be validate Sudoku row wise, column wise and block wise
 * @see com.flurry.sudoku.validator.IValidator
 * @see com.flurry.sudoku.validator.BlockSudokuValidator
 * @see com.flurry.sudoku.validator.RowSudokuValidator
 * @see com.flurry.sudoku.validator.ColSudokuValidator
 */
public abstract class AbstractSudokuValidator implements IValidator{
    protected ISudokuReader reader;
    protected int totalLength;

    /**
     * @param reader Take {@link com.flurry.sudoku.reader.ISudokuReader} as input
     * @throws SudokuException in case is reader is null
     */
    protected AbstractSudokuValidator(ISudokuReader reader) throws SudokuException{
        if(reader!=null) {
            this.reader = reader;
            this.totalLength = reader.getTotalLength();
        }else{
            throw new SudokuException("Invalid Reader");
        }
    }
}
