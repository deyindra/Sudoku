package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;

/**
 * @author idey
 * A Singlethreaded validator which will internally call
 * {@link com.flurry.sudoku.validator.RowSudokuValidator}, {@link com.flurry.sudoku.validator.ColSudokuValidator}
 * and {@link com.flurry.sudoku.validator.BlockSudokuValidator} and check if the given sudoku is valid or not
 * @see com.flurry.sudoku.validator.AbstractSudokuValidator
 * @see com.flurry.sudoku.validator.IValidator
 * @see com.flurry.sudoku.validator.RowSudokuValidator
 * @see com.flurry.sudoku.validator.ColSudokuValidator
 * @see com.flurry.sudoku.validator.BlockSudokuValidator
 */
public final class SingleThreadedSudokuValidator extends AbstractSudokuValidator {

    public SingleThreadedSudokuValidator(ISudokuReader reader) throws SudokuException {
        super(reader);
    }

    /**
     * This method call {@link com.flurry.sudoku.validator.RowSudokuValidator} for all rows
     * {@link com.flurry.sudoku.validator.ColSudokuValidator} for all cols
     * {@link com.flurry.sudoku.validator.BlockSudokuValidator} for all valid regions
     * @return return true in case all validator return true
     * @throws com.flurry.sudoku.exception.SudokuException
     */
    @Override
    public boolean checkSudoku() throws SudokuException {
        boolean result=true;

        for(int row=1;result && row<=totalLength;row++){
            AbstractSudokuValidator validator = new RowSudokuValidator(reader,row);
            result = validator.checkSudoku();
        }

        for(int col=1;result && col<=totalLength;col++){
            AbstractSudokuValidator validator = new ColSudokuValidator(reader,col);
            result = validator.checkSudoku();
        }

        int squareRootLength = (int)Math.sqrt(totalLength);
        for(int row=1;result && row<=totalLength;row+=squareRootLength){
            for(int col=1;result && col<=totalLength;col+=squareRootLength){
                AbstractSudokuValidator validator = new BlockSudokuValidator(reader,row,col);
                result = validator.checkSudoku();
            }
        }
        return result;
    }
}
