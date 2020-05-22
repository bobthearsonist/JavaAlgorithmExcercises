import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LongestCommonPrefixTest {

    private List<Object[]> testCases = Arrays.asList(
            //expected,input
            new Object[]{"bob",new String[]{"bobbete","bob","bobbie"}},
            new Object[]{"n",new String[]{"n","n","n"}},
            new Object[]{"",new String[]{"nomatch","match"}},
            new Object[]{"",new String[]{}},
            new Object[]{"",new String[]{""}},
            new Object[]{"",new String[]{"","nope"}}
    );

    @Test
    void longestCommonPrefix() {
        testCases.forEach( testCase ->
                Assertions.assertEquals(
                        testCase[0],LongestCommonPrefix.longestCommonPrefix((String[])testCase[1]))
        );
    }
}