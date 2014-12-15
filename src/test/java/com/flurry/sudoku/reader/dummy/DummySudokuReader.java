package com.flurry.sudoku.reader.dummy;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;

/**
 * @author idey
 * Purpose of the dummy Sudoku Reader is to facilitate getValue and geTotalLength
 * which can be used to unit test all the validator
 */
public class DummySudokuReader implements ISudokuReader{
    private int[][] array;

    public DummySudokuReader(int[][] array) {
        this.array = array;
    }

    @Override
    public int getValue(int row, int column) throws SudokuException {
        int value=-1;
        if(array!=null){
            if(row>0 && row<=array.length){
                row = row -1 ;
                int[] subArray = array[row];
                if(subArray!=null){
                    if(column>0 && column<=subArray.length){
                        column=column-1;
                        value = subArray[column];
                    }else {
                        throw new SudokuException("Invalid column... "+column);
                    }
                }else{
                    throw new SudokuException("Sub Array is null");
                }
            }else{
                throw new SudokuException("Invalid col... "+row);
            }
        }else{
            throw new SudokuException("Array is null");
        }
        return value;
    }

    @Override
    public int getTotalLength() {
        return (array!=null ? array.length : 0);
    }
}
