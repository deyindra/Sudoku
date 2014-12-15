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
public class SuccessSudokuColValidatorTest extends AbstractSudokuColValidatorTest{

    public SuccessSudokuColValidatorTest(ISudokuReader reader, boolean expectedOutput, int col) {
        super(reader, expectedOutput, col);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}), true, 1},
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}), true, 4},
                {new DummySudokuReader(new int[][]{{1}}), true, 1},
        });
    }

    @Test
    public void successTest() throws SudokuException {
        AssertX.assertEquals(true, new ColSudokuValidator(reader,col).checkSudoku());
    }
}
