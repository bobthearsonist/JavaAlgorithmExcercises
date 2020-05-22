import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class TwoSum {
    public int[] twoSumInnerIterator(int[] nums, int target) {
        var list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        var iterator = list.listIterator();
        var reverseIterator = list.listIterator(list.size());
        while(iterator.hasNext()){
            var val = iterator.next();
            var innerIterator = list.listIterator(iterator.nextIndex());
            while(innerIterator.hasNext()){
                int innerVal = innerIterator.next();
                if(val+innerVal == target) {
                    return new int[]{iterator.previousIndex(),innerIterator.previousIndex()};
                }
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    public int[] twoSumForLoops(int[] nums, int target) {
        int lastIndex = nums.length-1;
        for(int headIndex = 0; headIndex < nums.length; headIndex++){
            int headVal = nums[headIndex];
            for(int tailIndex = lastIndex; tailIndex > headIndex; tailIndex--){
                int tailVal = nums[tailIndex];
                if(tailVal+headVal==target) return new int[]{headIndex,tailIndex};
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    public int[] twoSumForLoops_optimized(int[] nums, int target) {
        for(int headIndex = 0; headIndex < nums.length; headIndex++){
            for(int tailIndex = nums.length-1; tailIndex > headIndex; tailIndex--){
                if(nums[tailIndex]+nums[headIndex]==target) return new int[]{headIndex,tailIndex};
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    public int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int index=0;index<nums.length;index++){
            map.put(nums[index],index);
        }
        for(int index=0;index<nums.length;index++) {
            int compliment = target - nums[index];
            if (map.containsKey(compliment)) {
                Integer complimentIndex = map.get(compliment);
                if (!complimentIndex.equals(index)) return new int[]{index, complimentIndex};
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    public int[] twoSumHash_onePass(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int index=0;index<nums.length;index++){
            int compliment = target - nums[index];
            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), index};
            }
            map.put(nums[index],index);
        }
        throw new IllegalArgumentException("Not found");
    }

    static class NotFoundException extends Throwable {
    }
}
