package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;
import com.flurry.sudoku.reader.dummy.DummySudokuReader;
import com.flurry.sudoku.rule.ExceptionLoggingRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FailureSudokuBlockValidatorTest extends AbstractSudokuBlockValidatorTest{

    public FailureSudokuBlockValidatorTest(ISudokuReader reader,
                                          int col, int row) {
        super(reader, false, col, row);
    }

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}), 0,0},
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}), 5,5},
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}), 1,2},
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}), 1,4},
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}), 2,1},
                {new DummySudokuReader(new int[][]{{1,4,2,3},{2,3,1,4},{4,2,3,1},{3,1,4,2}}), 4,1},
                {new DummySudokuReader(new int[][]{{1}}), 2,2},
        });
    }

    @Test
    public void failureTest() throws SudokuException {
        expectedException.expect(SudokuException.class);
        new BlockSudokuValidator(reader,row,col).checkSudoku();
    }
}
