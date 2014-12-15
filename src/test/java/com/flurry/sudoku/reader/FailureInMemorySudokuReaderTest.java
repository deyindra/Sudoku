package com.flurry.sudoku.reader;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.rule.ExceptionLoggingRule;
import org.junit.AssertX;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FailureInMemorySudokuReaderTest extends AbstractInMemorySudokuReaderTest {

    public FailureInMemorySudokuReaderTest(String fileName,
                                           int number,
                                           int row, int column) {
        super(fileName, number, -1, row, column, -1);
    }

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {FailureInMemorySudokuReaderTest.class.getResource("/sampleInput 4x4.txt").getPath(),4,0,10},
                {FailureInMemorySudokuReaderTest.class.getResource("/sampleInput 9x9.txt").getPath(),9,10,0}

        });
    }


    @Test
    public void failedSudokuReaderTest() throws SudokuException {
        expectedException.expect(SudokuException.class);
        ISudokuReader reader = new InMemorySudokuReader(number,fileName);
        AssertX.assertTrue(reader.getValue(row,column)==expectedValue);
    }
}
