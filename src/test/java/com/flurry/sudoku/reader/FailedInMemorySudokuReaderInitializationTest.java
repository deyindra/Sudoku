package com.flurry.sudoku.reader;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.rule.ExceptionLoggingRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FailedInMemorySudokuReaderInitializationTest extends AbstractInMemorySudokuReaderInitializationTest {

    public FailedInMemorySudokuReaderInitializationTest(String fileName, int number) {
        super(fileName, number, null);
    }

    @Rule
    public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null,-4}, // Negative number failure test
                {null,2}, //Not a perfect square failure test
                {null,4}, //file path is null failure test
                {"",4}, //empty file path is null failure test
                {"",4}, //empty file path is null failure test
                {System.getProperty("user.home"),4}, //empty file path is null failure test
                {FailedInMemorySudokuReaderInitializationTest.class
                        .getResource("/failed_sudoku_file_test_with_failed_regex.txt")
                        .getPath(),4}, //File contains invalid comma separated number
                {FailedInMemorySudokuReaderInitializationTest.class
                        .getResource("/failed_sudoku_file_test_with_failed_total_array_length.txt")
                        .getPath(),4}, //total length is not 4X4

                {FailedInMemorySudokuReaderInitializationTest.class
                        .getResource("/failed_sudoku_file_test_with_empty_content.txt")
                        .getPath(),4} //total length is not 4X4
        });
    }

    @Test
    public void failedSudokuReaderTest() throws SudokuException {
        expectedException.expect(SudokuException.class);
        new InMemorySudokuReader(number,fileName);
    }
}
