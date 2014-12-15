package com.flurry.sudoku.reader;

import com.flurry.sudoku.exception.SudokuException;
import org.junit.AssertX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SuccessInMemorySudokuReaderTest extends AbstractInMemorySudokuReaderTest {

    public SuccessInMemorySudokuReaderTest(String fileName,
                                           int number,
                                           int expectedLength,
                                           int row, int column,
                                           int expectedValue) {
        super(fileName, number, expectedLength, row, column, expectedValue);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {SuccessInMemorySudokuReaderTest.class.getResource("/sampleInput 4x4.txt").getPath(),4,4,1,2,4},
                {SuccessInMemorySudokuReaderTest.class.getResource("/sampleInput 9x9.txt").getPath(),9,9,9,9,9}
        });
    }

    @Test
    public void successSudokuReaderTest() throws SudokuException {
        ISudokuReader reader = new InMemorySudokuReader(number,fileName);
        AssertX.assertTrue(reader.getTotalLength()==expectedLength);
        AssertX.assertTrue(reader.getValue(row,column)==expectedValue);
    }
}
