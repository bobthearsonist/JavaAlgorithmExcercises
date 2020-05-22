public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        return Long.valueOf(s.chars().distinct().count()).intValue();
    }
}
