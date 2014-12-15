package com.flurry.sudoku.reader;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author idey
 * The purpose of the class is to read the comma seperated integer value from the text file and
 * create in-memory two dimentional Array of N X N
  * @see com.flurry.sudoku.exception.SudokuException
 * @see java.io.BufferedReader
 * @see java.io.File
 * @see java.io.FileReader
 * @see com.flurry.sudoku.reader.ISudokuReader
 */
public final class InMemorySudokuReader implements ISudokuReader{
    /**
     * {@link java.util.List} data structure to hold integer array as individual element
     */
    private List<int[]> listArray;
    /**
     * totalLength of the internal 2 dimensional array
     */
    private int totalLength;
    /**
     * Regex format to read the comma separated input from file.
     */
    private static final String REGEX_FORMAT = "^[1-%d](,[1-%d]){%d}$";

    /**
     * {@link org.slf4j.Logger} for the Debugging purpose
     */
    private static Logger LOG = LoggerFactory.getLogger(InMemorySudokuReader.class);

    /**
     *
     * @param arrayLength A 32 bit positive integer, which will vary from 0 to {@link java.lang.Integer#MAX_VALUE}.
     *                    The number has to be perfect square
     * @param filePath a File path which will contain as sudoku number ranging from 1 to arrayLength
     * @throws SudokuException
     * @see com.flurry.sudoku.util.Utils
     * @see java.io.BufferedReader
     * @see java.io.FileReader
     * @see java.io.File
     */
    public InMemorySudokuReader(int arrayLength, String filePath) throws SudokuException {
        BufferedReader reader=null;
        try {
            /**
             * arrayLength should be less than or equal to 0
             */
            if (arrayLength <= 0) {
                throw new SudokuException("Invalid Number, please provide a positive number");
            }

            /**
             * array length should be a perfect square, e.g. 1, 4, 9, 16, 25... N^2
             */
            if (!Utils.isPrefectSquare(arrayLength)) {
                throw new SudokuException(String.format("%d is not perfect square number...", arrayLength));
            }
            /**
             * Forming a regular expression which will validate every number should range from 1 to arrayLength
             * and total count of number should be arrayLength
             */
            String regEx = String.format(REGEX_FORMAT, arrayLength, arrayLength, arrayLength - 1);
            LOG.info(String.format("Final Regular expression %s", regEx));
            /**
             * Check the if the filePath is not null or empty
             */
            if (filePath != null && !("").equals(filePath.trim())) {
                filePath = filePath.trim();
                //Decode the file path in case file has embedded space
                filePath = URLDecoder.decode(filePath, "UTF-8");
                File f = new File(filePath);
                //check if the filePath is not directory
                if(f.isDirectory()){
                    throw new SudokuException(String.format("%s file path is a folder",filePath));
                }else{
                    //Initialize BufferedReader....
                    reader = new BufferedReader(new FileReader(f));
                    String line;
                    //Read the entire Line
                    while((line = reader.readLine())!=null){
                        /**
                         * Check with if the line matches with the regular expression,if not,
                         * it will throw {@link com.flurry.sudoku.exception.SudokuException}
                        */
                        line = line.trim();
                        if(Pattern.matches(regEx,line)){
                            //Split all numbers separated by comma into String
                            String[] strArray = line.split(",");
                            int[] oneDimensionalArray = new int[strArray.length];
                            int count=0;
                            for(String value:strArray){
                                oneDimensionalArray[count++] = Integer.parseInt(value);
                            }
                            //check if the listArray is null or empty, if so initialize the listArray
                            if(this.listArray==null || this.listArray.isEmpty()){
                                this.listArray = new ArrayList<int[]>();
                            }
                            //Add to the integer array listArray
                            this.listArray.add(oneDimensionalArray);
                        }else{
                            throw new SudokuException(String.format("%s line is invalid for Sudoku Array",line));
                        }
                    }
                    //Check the list Array Size, if this is not equal to arrayLength it will throw
                    //SudokuException
                    if(this.listArray==null || this.listArray.size()!=arrayLength){
                        throw new SudokuException("Two Dimensional Array size is not same as "+arrayLength);
                    }
                    /**
                     * Initialize the totalLength
                     */
                    totalLength = listArray.size();

                }
            } else {
                throw new SudokuException("Invalid File Path");
            }
        }catch (IOException ex){
            throw new SudokuException(ex);
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (IOException ex){
                    LOG.error(ex.toString());
                    throw new SudokuException(ex);
                }
            }
        }
    }
    protected int[][] getArray() {
        return listArray.toArray(new int[listArray.size()][]);
    }

    /**
     *
     * @return total row and column length of the 2 dimensional array
     */
    @Override
    public int getTotalLength() {
        return totalLength;
    }

    /**
     *
     * @param row row number it varies from 1 to totalLength
     * @param column column number, it varies from 1 to totalLength
     * @return return value of the specific row and column index
     * @throws SudokuException in case row<=0 or row>totalLength or column<=0 or column>totalLength
     */
    @Override
    public int getValue(int row, int column) throws SudokuException {
        if(row>0 && row<=totalLength){
            row = row-1;
        }else{
            throw new SudokuException(String.format("%d is invalid row", row));
        }

        if(column>0 && column<=totalLength){
            column = column-1;
        }else{
            throw new SudokuException(String.format("%d is invalid column", column));
        }
        return listArray.get(row)[column];
    }
}
