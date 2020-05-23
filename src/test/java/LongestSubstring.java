import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()) return 0;
        if(s.length()==1) return 1;

        String longest = s.substring(0,1);
        HashSet<Character> current = new HashSet<>();
        var list = s.chars().mapToObj(c-> (char)c).collect(Collectors.toList());

        for(var outerIterator = list.listIterator(); outerIterator.hasNext(); outerIterator.next()){
            for(var innerIterator = list.listIterator(outerIterator.nextIndex()) ; innerIterator.hasNext();) {
                char c = innerIterator.next();
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
                }
            }
        }
        return longest.length();
    }
}
