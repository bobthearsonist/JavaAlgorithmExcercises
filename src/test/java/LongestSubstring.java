import java.util.HashSet;
import java.util.stream.Collector;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        String longest = s.substring(0,1);
        HashSet<Character> current = new HashSet<>();
        for(Character c: s.toCharArray()){
            if(current.contains(c)) {
                if(longest.length() < current.size()) {
                    longest = current.stream().collect(Collector.of(
                            StringBuilder::new,
                            StringBuilder::append,
                            StringBuilder::append,
                            StringBuilder::toString
                            )
                    );
                }
                current.clear();
                current.add(c);
            }
            else {
                current.add(c);
            }
        }
        return longest.length();
    }
}
