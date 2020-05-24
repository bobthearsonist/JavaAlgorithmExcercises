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

        var visited = new HashMap<Character,Integer>();//(character,left-most occurrence)
        int longest = 1;

        for (int rightIterator = 0, leftIterator = 0; rightIterator < s.length(); rightIterator++) {
            char right = s.charAt(rightIterator);

            int current = (rightIterator-leftIterator)+1;

            if (visited.containsKey(right)) {
                int newLeftIterator = visited.get(right) + 1;
                for(int i=leftIterator; i < newLeftIterator ; i++) {
                    visited.remove(s.charAt(i));
                }
                leftIterator = newLeftIterator;
            } else if (longest < current) {
                longest = current;
            }

            visited.put(right,rightIterator);
        }

        return longest;
    }

    public static int lengthOfLongestSubstring_windowed_optimized(String s){
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        var visited = new HashMap<Character,Integer>();//(character,left-most occurrence)
        int longest = 1;

        for (int rightIterator = 0, leftIterator = 0; rightIterator < s.length(); rightIterator++) {
            char right = s.charAt(rightIterator);

            String current = s.substring(leftIterator,rightIterator+1);

            if (visited.containsKey(right)) {
                leftIterator = visited.get(right) + 1;
                for(int i=0; i <= visited.get(right) ; i++) {
                    visited.remove(current.charAt(i));
                }
            } else if (longest < current.length()) {
                longest = current.length();
            }

            visited.put(right,rightIterator);
        }

        return longest;
    }
}