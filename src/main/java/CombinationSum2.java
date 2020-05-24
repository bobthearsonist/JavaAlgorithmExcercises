import lombok.val;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
 */

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            var sorted = new TreeMap<Integer, HashSet<Integer>>();

            IntStream.rangeClosed(0,candidates.length-1).forEach(
                    index -> {
                        //TODO two n*log(n) traversals for get and put
                        //TODO check equals behavior
                        val candidate = candidates[index];
                        if(sorted.containsKey(candidate)) {
                            var current = sorted.get(candidate);
                            current.add(index);
                            sorted.put(candidate, current);
                        } else {
                            var current = new HashSet<Integer>();
                            current.add(index);
                            sorted.put(candidate,current);
                        }
                    }
            );

            var traversal = sorted.entrySet();
            var solutions = new HashSet<HashMap<Integer,Integer>>();
            //note: we are traversing again. we can probably collapse the two loops
            IntStream.rangeClosed(0,candidates.length-1).forEach( index -> {
                int candidate = candidates[index];
                var currentSolution = new HashMap<Integer,Integer>() {{ put(candidate,index); }};
                var currentSum = candidate;

                for(var current: traversal){
                    var difference = target - currentSum;

                    if(difference < 0) {
                    // there are no more valid sums for the current index
                        break;
                    } else {
                    // add current to the solution
                        var occurences = current.getValue();
                        int nextIndex = index;
                        for(int occurence : occurences) { if(occurence>index) nextIndex=occurence; break; }
                        if(nextIndex!=index) {
                            currentSolution.put(current.getKey(), nextIndex);
                            currentSum += current.getKey();
                        }
                    }

                    if(currentSum == target) {
                    // check the current solution for validity
                        solutions.add(currentSolution);
                        break;
                    }
                }});

            return solutions.stream().map(set->set.keySet().stream().collect(Collectors.toList())).collect(Collectors.toList());
    }
}
