import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    @Test
    void lengthOfLongestSubstring() {
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring("pwwkew")); }
}