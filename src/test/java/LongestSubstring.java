import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        String longest = s.substring(0, 1);
        HashSet<Character> current = new HashSet<>();
        var list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        for (var outerIterator = list.listIterator(); outerIterator.hasNext(); outerIterator.next()) {
            for (var innerIterator = list.listIterator(outerIterator.nextIndex()); innerIterator.hasNext(); ) {
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
                    if (s.length() - outerIterator.nextIndex() < longest.length()) break;
                }
            }
        }
        return longest.length();
    }

    public static int lengthOfLongestSubstring_arrayImplementation(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        String longest = s.substring(0, 1);
        HashSet<Character> current = new HashSet<>();

        for (int outerIterator = 0; outerIterator < s.length(); outerIterator++) {
            for (int innerIterator = outerIterator; innerIterator < s.length(); innerIterator++) {
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
                    if (s.length() - outerIterator < longest.length()) break;
                }
            }
        }
        return longest.length();
    }

    public static int lengthOfLongestSubstring_kRepetitionsAllowed(String s, int k) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int longest = 1;
        HashMap<Character, Integer> current = new HashMap();

        for (int outerIterator = 0; outerIterator < s.length(); outerIterator++) {
            for (int innerIterator = outerIterator; innerIterator < s.length(); innerIterator++) {
                Character c = s.charAt(innerIterator);
                if (current.containsKey(c) && current.get(c) == k) {
                    current.clear();
                    break;
                } else if (current.containsKey(c)) {
                    current.replace(c, current.get(c) + 1);
                } else {
                    current.put(c, 1);
                }

                int currentLength = current.values().stream().reduce(Integer::sum).get();
                if (longest < currentLength) {
                    longest = currentLength;
                }
            }
        }
        return longest;
    }

    public static int lengthOfLongestSubstring_windowed(String s){
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int longest = 1;
        var visited = new HashSet<Character>();

        for (int leftIterator = 0; leftIterator < s.length();) {
            for (int rightIterator = leftIterator; rightIterator < s.length(); rightIterator++) {
                char left = s.charAt(leftIterator);
                char right = s.charAt(rightIterator);
                if (visited.contains(right)) {
                    visited.remove(left);
                    leftIterator++;
                }
                visited.add(right);
                if (longest < visited.size()) {
                    longest = visited.size();
                }
            }
        }
        return longest;
    }
}