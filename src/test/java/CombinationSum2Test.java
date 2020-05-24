import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
 */
class CombinationSum2Test {

    static Stream<Arguments> testCases() {
            return Stream.of(
                    //coverage
                    //expected, candidates, target
                    arguments(
                            //multiple matches
                            //zero case
                            //values too large
                            Arrays.asList(Arrays.asList(2,3), Arrays.asList(5,0)),
                            new int[]{2,3,5,0,6,20},
                            5
                    ),
                    arguments(
                            //multiple matches
                            //duplicate solutions
                            Arrays.asList(Arrays.asList(2,3), Arrays.asList(5,0)),
                            new int[]{2,3,0,2,3},
                            5
                    ),
                    arguments(
                            //empty
                            Arrays.asList(Arrays.asList(2,3), Arrays.asList(5,0)),
                            new int[]{},
                            0
                    ),
                    arguments(
                            //no solution
                            Arrays.asList(Arrays.asList(2,3), Arrays.asList(5,0)),
                            new int[]{1,1,1,1},
                            0
                    ),
                    arguments(
                            //single case is solution
                            Arrays.asList(Arrays.asList(2,3), Arrays.asList(5,0)),
                            new int[]{1,1},
                            2
                    )
            );
    }

    @ParameterizedTest()
    @MethodSource("testCases")
    void combinationSum2(List<List<Integer>> expected, int[] candidates, int target) {
        Assertions.assertIterableEquals(expected,CombinationSum2.combinationSum2(candidates,target));
    }
}