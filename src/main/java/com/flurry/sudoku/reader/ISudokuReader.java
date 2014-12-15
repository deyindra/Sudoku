package com.flurry.sudoku.reader;

import com.flurry.sudoku.exception.SudokuException;

/**
 * Interface for reading Sudoku input for specific rows and column
 * This also provide Length of the internal 2 dimensional array (Both number of rows and column are same)
 * @see com.flurry.sudoku.reader.InMemorySudokuReader
 */
public interface ISudokuReader {

    /**
     *
     * @return return total Number of rows or column
     */
    int getTotalLength();

    /**
     *
     * @param row row number
     * @param column column number
     * @return return value from row and column
     * @throws com.flurry.sudoku.exception.SudokuException in case row and column value is out of range
     */
    int getValue(int row, int column) throws SudokuException;
}
