package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;

import java.util.BitSet;

/**
 * @author idey
 * Validate all numbers in a given row. extends {@link com.flurry.sudoku.validator.AbstractSudokuValidator}
 * @see com.flurry.sudoku.validator.AbstractSudokuValidator
 */
public final class RowSudokuValidator extends AbstractSudokuValidator{
    public int row;

    /**
     *
     * @param reader {@link com.flurry.sudoku.reader.ISudokuReader} as input
     * @param row row should be >=1 && <=totalLength
     * @throws SudokuException in case row is out of range
     */
    public RowSudokuValidator(ISudokuReader reader, int row) throws SudokuException {
        super(reader);
        if(row>0 && row<=this.totalLength) {
            this.row = row;
        }else {
            throw new SudokuException("Invalid row... "+row);
        }
    }

    /**
     *
     * @return true if all numbers are unique
     * @throws SudokuException
     */
    @Override
    public boolean checkSudoku() throws SudokuException {
        BitSet bitSet = new BitSet(totalLength);
        boolean validate = true;
        for(int col=1;col<=totalLength;col++){
            int value = reader.getValue(row,col);
            if(bitSet.get(value)){
                validate = false;
                break;
            }
            bitSet.set(value);
        }
        return validate;
    }
}
