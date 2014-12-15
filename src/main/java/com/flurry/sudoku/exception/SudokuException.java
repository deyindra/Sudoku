package com.flurry.sudoku.exception;

/**
 * @author idey
 * A checked Exception which extends {@link java.lang.Exception}
 * @see java.lang.Exception
 */
public class SudokuException extends Exception{
    public SudokuException(String s) {
        super(s);
    }

    public SudokuException(Throwable throwable) {
        super(throwable);
    }
}
