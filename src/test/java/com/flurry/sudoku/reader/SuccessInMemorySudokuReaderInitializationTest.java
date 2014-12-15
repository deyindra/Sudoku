package com.flurry.sudoku.reader;

import com.flurry.sudoku.exception.SudokuException;
import org.junit.AssertX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SuccessInMemorySudokuReaderInitializationTest extends AbstractInMemorySudokuReaderInitializationTest {
    public SuccessInMemorySudokuReaderInitializationTest(String fileName, int number, int[][] expectedOutput) {
        super(fileName, number, expectedOutput);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {SuccessInMemorySudokuReaderInitializationTest.class.getResource("/sampleInput 1x1.txt").getPath(),1,new int[][]{{1}}},
                {SuccessInMemorySudokuReaderInitializationTest.class.getResource("/sampleInput 4x4.txt").getPath(),4,new int[][]{{1,4,2,3
               },{2,3,1,4},{4,2,3,1},{3,1,4,2}}},
                {SuccessInMemorySudokuReaderInitializationTest.class.getResource("/sampleInput 9x9.txt").getPath(), 9, new int[][]{{5,3,4,6,7,8,9,1,2},
                        {6,7,2,1,9,5,3,4,8}, {1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3}, {4,2,6,8,5,3,7,9,1}, {7,1,3,9,2,4,8,5,6},
                        {9,6,1,5,3,7,2,8,4}, {2,8,7,4,1,9,6,3,5}, {3,4,5,2,8,6,1,7,9}}}
     });
    }

    @Test
    public void successSudokuReaderTest() throws SudokuException {
        AssertX.assertArrayEquals(this.expectedOutput, new InMemorySudokuReader(number,fileName).getArray());
    }
}
