package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;
import com.flurry.sudoku.reader.dummy.DummySudokuReader;
import org.junit.AssertX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MultiThreadedSudokuValidatorTest {
    private ISudokuReader reader;
    private boolean expectedOutput;

    public MultiThreadedSudokuValidatorTest(ISudokuReader reader, boolean expectedOutput) {
        this.reader = reader;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}),true},
                {new DummySudokuReader(new int[][]{{1}}),true},
                {new DummySudokuReader(new int[][]{{1,4,2,3},{4,1,3,2},{4,2,3,1},{3,1,4,2}}),false},
                {new DummySudokuReader(new int[][]{{1,4,2,3},{1,4,3,2},{4,2,3,1},{3,1,4,2}}),false},
                {new DummySudokuReader(new int[][]{{1,1,2,3},{4,4,3,2},{4,2,3,1},{3,1,4,2}}),false},
        });
    }

    @Test
    public void successTest() throws SudokuException {
        AssertX.assertEquals(expectedOutput, new MultiThreadedSudokuValidator(reader).checkSudoku());
    }
}
