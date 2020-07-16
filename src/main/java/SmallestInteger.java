import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        for(var iterator = Arrays.stream(A).distinct().sorted().iterator(); iterator.hasNext();) {
            Integer current = iterator.next();
            Integer next;
            if(iterator.hasNext()) {
                next = iterator.next();
            } else {
                return current+1;
            }
            if(!Integer.valueOf(current+1).equals(next)) {
                return current+1;
            }
        }
        return 1;
    }
}
