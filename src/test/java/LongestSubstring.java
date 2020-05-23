import java.util.HashSet;
import java.util.stream.Collector;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()) return 0;
        if(s.length()==1) return 1;

        String longest = s.substring(0,1);
        HashSet<Character> current = new HashSet<>();

        for(int outerIterator = 0; outerIterator < s.length(); outerIterator++){
            for(int innerIterator = outerIterator ; innerIterator < s.length(); innerIterator++) {
                char c = s.charAt(innerIterator);
                if (current.contains(c)) {
                    current.clear();
                    break;
                }
                current.add(c);

                if (longest.length() < current.size()) {
                    longest = current.stream().collect(Collector.of(
                            StringBuilder::new,
                            StringBuilder::append,
                            StringBuilder::append,
                            StringBuilder::toString
                            )
                    );
                    if(s.length()-outerIterator < longest.length()) break;
                }
            }
        }
        return longest.length();
    }
}
