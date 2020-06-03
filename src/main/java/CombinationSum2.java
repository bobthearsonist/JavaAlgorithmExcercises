import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    No 0's!
 */


//normally I wouldnt have comments, but here they are left to show assumptions/thought process. In production code I would #cleancoce into variable names or function names
public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var sorted = IntStream.rangeClosed(0,candidates.length-1)
                .boxed()
                // {index, value}
                .collect(Collectors.toMap(i->i,i->candidates[i]))// O(n)
                .entrySet()
                .stream()
                //don't even bother if larger than target (because all positive)
                .filter(i -> i.getValue() <= target)
                // streams use TimSort n*log(n) average
                .sorted(Comparator.comparing(Entry::getValue))
                .collect(Collectors.toList());

        var solutions = new LinkedList<LinkedList<Integer>>();

        for(Entry<Integer, Integer> i: sorted){
            //keep a current sum to avoid an iterable reduction each loop
            int currentSum = i.getValue();
            var currentSolution = new LinkedList<Integer>();
            currentSolution.add(i.getValue());

            for(Entry<Integer, Integer> j: sorted){
                if(currentSum == target) {
                // check the current solution for validity
                    solutions.add(currentSolution);
                    break;
                } else if( currentSum > target) {
                // if we have blown through the target just stop
                    break;
                } else if( j.getKey() != i.getKey()){
                // add current to the solution, but don't re-use elements
                    currentSum += j.getValue();
                    currentSolution.add(j.getValue());
                }
            }
        };
        return solutions.parallelStream().collect(Collectors.toList());
//        return solutions.parallelStream()
//                .map(s->s.stream().collect(Collectors.toList()))
//                .collect(Collectors.toList());
    }

    public static List<List<Integer>> combinationSum2_faster(int[] candidates, int target) {
        return null;
    }
}
