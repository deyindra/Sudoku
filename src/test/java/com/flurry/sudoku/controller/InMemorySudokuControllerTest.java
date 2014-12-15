package com.flurry.sudoku.controller;

import com.flurry.sudoku.exception.SudokuException;
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
    private boolean expectedOutput;

    public InMemorySudokuControllerTest(int number, String filePath, boolean expectedOutput) {
        this.number = number;
        this.filePath = filePath;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4,InMemorySudokuController.class.getResource("/sampleInput 4x4.txt").getPath(), true},
                {4,InMemorySudokuController.class.getResource("/sampleInvalidInput 4x4.txt").getPath(),false}
        });
    }

    @Test
    public void testController() throws SudokuException {
        AssertX.assertEquals(expectedOutput, new InMemorySudokuController(number,filePath).performValidation());
    }
}
