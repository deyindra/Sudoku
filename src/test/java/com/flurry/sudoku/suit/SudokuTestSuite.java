package com.flurry.sudoku.suit;

import com.flurry.sudoku.controller.InMemorySudokuController;
import com.flurry.sudoku.controller.InMemorySudokuControllerTest;
import com.flurry.sudoku.reader.FailedInMemorySudokuReaderInitializationTest;
import com.flurry.sudoku.reader.FailureInMemorySudokuReaderTest;
import com.flurry.sudoku.reader.SuccessInMemorySudokuReaderInitializationTest;
import com.flurry.sudoku.reader.SuccessInMemorySudokuReaderTest;
import com.flurry.sudoku.util.UtilsTest;
import com.flurry.sudoku.validator.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FailedInMemorySudokuReaderInitializationTest.class,
        SuccessInMemorySudokuReaderInitializationTest.class,
        UtilsTest.class,
        SuccessInMemorySudokuReaderTest.class,
        FailureInMemorySudokuReaderTest.class,
        SuccessSudokuRowValidatorTest.class,
        SuccessSudokuColValidatorTest.class,
        FailureSudokuRowValidatorTest.class,
        FailureSudokuColValidatorTest.class,
        SuccessSudokuBlockValidatorTest.class,
        FailureSudokuBlockValidatorTest.class,
        SingleThreadedSudokuValidatorTest.class,
        InMemorySudokuControllerTest.class
})
public class SudokuTestSuite {
}
