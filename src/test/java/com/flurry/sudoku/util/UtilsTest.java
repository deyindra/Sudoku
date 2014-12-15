package com.flurry.sudoku.util;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
    @Test
    public void trueSquareRootTest(){
        Assert.assertTrue(Utils.isPrefectSquare(4));
    }

    @Test
    public void falseSquareRootTest(){
        Assert.assertFalse(Utils.isPrefectSquare(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failureSquareRootTest1(){
        Utils.isPrefectSquare(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failureSquareRootTest2(){
        Utils.isPrefectSquare(0);
    }
}
