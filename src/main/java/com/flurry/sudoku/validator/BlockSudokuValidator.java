package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;

import java.util.BitSet;

/**
 * @author idey
 * Validate all numbers in a given block. extends {@link com.flurry.sudoku.validator.AbstractSudokuValidator}
 * @see com.flurry.sudoku.validator.AbstractSudokuValidator
 */
final class BlockSudokuValidator extends AbstractSudokuValidator{
    private int row;
    private int col;

    /**
     *
     * @param reader {@link com.flurry.sudoku.reader.ISudokuReader} as input
     * @param row row should be >=1 && <=totalLength and in case totalLength>1
     *            row % sqrt(totalLength) ==1
     * @param col col should be >=1 && <=totalLength and in case totalLength>1
     *            col % sqrt(totalLength) ==1
     * @throws SudokuException in case row and col are not satisfying the condition
     */
    public BlockSudokuValidator(ISudokuReader reader, int row, int col) throws SudokuException {
        super(reader);
        int squareRootLength = (int)Math.sqrt(totalLength);
        if(row>0 && row<=totalLength && ((totalLength==1) || (row % squareRootLength)==1)){
            this.row = row;
        }else {
            throw new SudokuException("Invalid rows.... "+row);
        }
        if(col>0 && col<=totalLength && ((totalLength==1) || (col % squareRootLength)==1)){
            this.col = col;
        }else {
            throw new SudokuException("Invalid cols.... "+col);
        }
    }

    /**
     * @return true if all numbers are unique
     * @throws SudokuException
     */
    @Override
    public boolean checkSudoku() throws SudokuException {
        int squareRootLength = (int)Math.sqrt(totalLength);
        BitSet bitSet = new BitSet(totalLength);
        boolean validate = true;
        for(int r=row;r<row+squareRootLength;r++){
            for(int c=col;c<col+squareRootLength;c++){
                int value = reader.getValue(r,c);
                if(bitSet.get(value)){
                    validate = false;
                    break;
                }
                bitSet.set(value);
            }
        }
        return validate;
    }
}
