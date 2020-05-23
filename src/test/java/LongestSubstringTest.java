import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubstringTest {

    @Test
    void lengthOfLongestSubstring() {
        Assertions.assertEquals(6, LongestSubstring.lengthOfLongestSubstring("asjrgapa"));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(0, LongestSubstring.lengthOfLongestSubstring(""));
        Assertions.assertEquals(2, LongestSubstring.lengthOfLongestSubstring("ab"));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void lengthOfLongestSubstring_arrayImplementation() {
        Assertions.assertEquals(6, LongestSubstring.lengthOfLongestSubstring_arrayImplementation("asjrgapa"));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring_arrayImplementation("abcabcbb"));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring_arrayImplementation("pwwkew"));
        Assertions.assertEquals(0, LongestSubstring.lengthOfLongestSubstring_arrayImplementation(""));
        Assertions.assertEquals(2, LongestSubstring.lengthOfLongestSubstring_arrayImplementation("ab"));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring_arrayImplementation("dvdf"));
    }

    @Test
    void lengthOfLongestSubstring_kRepetitionsAllowed() {
        Assertions.assertEquals(5, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("eceba", 2));
        Assertions.assertEquals(6, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("abcabcbb", 2));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("eeee", 3));


        //orignal implementation tests
        Assertions.assertEquals(6, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("asjrgapa", 1));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("abcabcbb", 1));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("pwwkew", 1));
        Assertions.assertEquals(0, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("", 1));
        Assertions.assertEquals(2, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("ab", 1));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("dvdf", 1));
    }

    @ParameterizedTest(name = "test {index} the longest non-repeating substring of string {0} has {1} characters")
    @MethodSource("testCases")
    void lengthOfLongestSubstring_windowed(int expected, String s) {
        Assertions.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring_windowed(s));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(4,"jbpnbwwd"),
                arguments(6, "asjrgapa"),
                arguments(3, "abcabcbb"),
                arguments(3, "pwwkew"),
                arguments(0, ""),
                arguments(2, "ab"),
                arguments(3, "dvdf")
        );
    }
}