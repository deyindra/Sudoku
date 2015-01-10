package com.flurry.sudoku.controller;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.validator.constant.ValidatorType;
import org.junit.AssertX;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class InMemorySudokuControllerTest {
    private int number;
    private String filePath;
    private ValidatorType type;
    private boolean expectedOutput;

    public InMemorySudokuControllerTest(int number, String filePath, ValidatorType type, boolean expectedOutput) {
        this.number = number;
        this.filePath = filePath;
        this.type = type;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4,InMemorySudokuController.class.getResource("/sampleInput 4x4.txt").getPath(), ValidatorType.SINGLE, true},
                {4,InMemorySudokuController.class.getResource("/sampleInvalidInput 4x4.txt").getPath(),ValidatorType.SINGLE,false},
                {4,InMemorySudokuController.class.getResource("/sampleInput 4x4.txt").getPath(), ValidatorType.MULTI, true},
                {4,InMemorySudokuController.class.getResource("/sampleInvalidInput 4x4.txt").getPath(),ValidatorType.MULTI,false}
        });
    }

    @Test
    public void testController() throws SudokuException {
        AssertX.assertEquals(expectedOutput, new InMemorySudokuController(number,filePath, type).performValidation());
    }
}
