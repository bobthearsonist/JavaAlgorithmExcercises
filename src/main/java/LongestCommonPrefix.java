import java.util.LinkedList;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        var prefix = new StringBuilder("");
        try {
            for (int index = 0; ; index++) {//iterate until we get a runtime exception
                LinkedList<Character> current = new LinkedList<>();
                for (int string = 0; string < strs.length; string++) {
                    current.add(strs[string].charAt(index));
                }
                var allMatch = current.stream().allMatch(current.get(0)::equals);
                if(allMatch) {
                    prefix.append(current.get(0));
                } else {
                    return prefix.toString();
                }
            }
        } catch(IndexOutOfBoundsException ex){
            return prefix.toString();
        }
    }
}
