import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubstringTest {

    final String CUSTOM_OUTPUT_TEXT = "test {index} the longest non-repeating substring of string {0} has {1} characters";

    static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(6,"wobgrovw"),
                arguments(3, "abcabcbb"),
                arguments(5, "tmmzuxt"),
                arguments(3, "dvdf"),
                arguments(2, "ab"),
                arguments(3, "pwwkew"),
                arguments(4,"jbpnbwwd"),
                arguments(6, "asjrgapa"),
                arguments(0, "")
        );
    }

    @ParameterizedTest(name = CUSTOM_OUTPUT_TEXT)
    @MethodSource("testCases")
    void lengthOfLongestSubstring(int expected, String s) {
        Assertions.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(s));
    }

    @ParameterizedTest(name = CUSTOM_OUTPUT_TEXT)
    @MethodSource("testCases")
    void lengthOfLongestSubstring_arrayImplementation(int expected, String s) {
        Assertions.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring_arrayImplementation(s));
    }

    @ParameterizedTest(name = CUSTOM_OUTPUT_TEXT)
    @MethodSource("testCases")
    void lengthOfLongestSubstring_kRepetitionsAllowed(int expected, String s) {
        //orignal implementation tests
        Assertions.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed(s, 1));
    }

    @Test
    void lengthOfLongestSubstring_kRepetitionsAllowed() {
        Assertions.assertEquals(5, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("eceba", 2));
        Assertions.assertEquals(6, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("abcabcbb", 2));
        Assertions.assertEquals(3, LongestSubstring.lengthOfLongestSubstring_kRepetitionsAllowed("eeee", 3));
    }

    @ParameterizedTest(name = CUSTOM_OUTPUT_TEXT)
    @MethodSource("testCases")
    void lengthOfLongestSubstring_windowed(int expected, String s) {
        Assertions.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring_windowed(s));
    }

    @ParameterizedTest(name = CUSTOM_OUTPUT_TEXT)
    @MethodSource("testCases")
    void lengthOfLongestSubstring_windowed_optimized(int expected, String s) {
        Assertions.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring_windowed_optimized(s));
    }
}