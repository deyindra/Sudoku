package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;

import java.util.BitSet;

/**
 * @author idey
 * Validate all numbers in a given col. extends {@link com.flurry.sudoku.validator.AbstractSudokuValidator}
 * @see com.flurry.sudoku.validator.AbstractSudokuValidator
 */
public final class ColSudokuValidator extends AbstractSudokuValidator{
    public int col;

    /**
     * @param reader {@link com.flurry.sudoku.reader.ISudokuReader} as input
     * @param col col should be >=1 && <=totalLength
     * @throws SudokuException in case col is out of range
     */
    public ColSudokuValidator(ISudokuReader reader, int col) throws SudokuException {
        super(reader);
        if(col>0 && col<=this.totalLength) {
            this.col = col;
        }else {
            throw new SudokuException("Invalid column... "+col);
        }
    }

    /**
     * @return true if all numbers are unique
     * @throws SudokuException
     */
    @Override
    public boolean checkSudoku() throws SudokuException {
        BitSet bitSet = new BitSet(totalLength);
        boolean validate = true;
        for(int row=1;row<=totalLength;row++){
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
