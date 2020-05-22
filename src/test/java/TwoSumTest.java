import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TwoSumTest {

    public static TwoSum twoSumTest = new TwoSum();

    public static List<Object[]> testCases = Arrays.asList(
            new Object[]{new int[]{2, 4}, -8, new int[]{-1, -2, -3, -4, -5},1},
            new Object[]{new int[]{0, 1}, 5, new int[]{3, 2},2},
            new Object[]{new int[]{1, 2}, 6, new int[]{3, 2, 4},3},
            new Object[]{new int[]{0, 1}, 9, new int[]{2, 7, 11, 15},4},
            new Object[]{new int[]{0, 2}, 0,new int[]{-3,4,3,90},5},
            new Object[]{new int[]{0, 1}, 6, new int[]{3, 3},6}
            );

    @Test
    @SneakyThrows
    void twoSumInnerIterator() {
        testCases.forEach( testCase->
                Assertions.assertArrayEquals((int[]) testCase[0],
                        twoSumTest.twoSumInnerIterator(
                                (int[])testCase[2],
                                (int)testCase[1]),
                        "test number "+(int)testCase[3])
        );
    }

    @Test
    void twoSumForLoops() {
        testCases.forEach( testCase->
                Assertions.assertArrayEquals((int[]) testCase[0],
                        twoSumTest.twoSumForLoops(
                                (int[])testCase[2],
                                (int)testCase[1]),
                        "test number "+(int)testCase[3])
        );
    }

    @Test
    void twoSumForLoops_optimized() {
        testCases.forEach( testCase->
                Assertions.assertArrayEquals((int[]) testCase[0],
                        twoSumTest.twoSumForLoops_optimized(
                                (int[])testCase[2],
                                (int)testCase[1]),
                        "test number "+(int)testCase[3])
        );
    }

    @Test
    void twoSumHash() {
        testCases.forEach( testCase->
                Assertions.assertArrayEquals((int[]) testCase[0],
                        twoSumTest.twoSumHash(
                                (int[])testCase[2],
                                (int)testCase[1]),
                        "test number "+(int)testCase[3])
        );
    }

    @Test
    void twoSumHash_onePass() {
        testCases.forEach( testCase->
                Assertions.assertArrayEquals((int[]) testCase[0],
                        twoSumTest.twoSumHash_onePass(
                                (int[])testCase[2],
                                (int)testCase[1]),
                        "test number "+(int)testCase[3])
        );
    }
}