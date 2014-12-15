package org.junit;

public class AssertX extends Assert {
    private AssertX() {
        throw new AssertionError("Invalid initialization....");
    }

    public static void assertArrayEquals(int[][] expected,
                                         int[][] actual) {

        if (expected != null && actual==null) {
            fail("expected array and actual array are not same");
        }else if (expected==null && actual!=null){
            fail("expected array and actual array are not same");
        }else if(expected!=null){
            int actualLength = actual.length;
            int expectedLength = expected.length;
            if(actualLength!=expectedLength){
                fail("expected array and actual array length are not same");
            }else{
                for(int i=0;i<actualLength-1;i++){
                    assertArrayEquals(expected[i],actual[i]);
                }
            }
        }
    }
}
