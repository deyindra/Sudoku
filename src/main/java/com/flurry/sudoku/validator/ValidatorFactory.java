package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;
import com.flurry.sudoku.validator.constant.ValidatorType;

public class ValidatorFactory {
    public static AbstractSudokuValidator getValidator(ValidatorType type, ISudokuReader reader) throws SudokuException {
        if(type == ValidatorType.SINGLE){
            return new SingleThreadedSudokuValidator(reader);
        }else if (type == ValidatorType.MULTI){
            return new MultiThreadedSudokuValidator(reader);
        }else{
            throw new SudokuException("Invalid Validator");
        }
    }
}
