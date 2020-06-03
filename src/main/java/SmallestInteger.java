import java.util.Arrays;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

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
