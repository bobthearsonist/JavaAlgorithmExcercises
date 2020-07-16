import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class EasyTest {

    static Stream<Arguments> myAtoITestCases(){
        return Stream.of(
                //expected, input
                arguments(42,"42"),
                arguments(-42,"-42"),
                arguments(-42,"     -42"),
                arguments(-42,"-42 some other junk"),
                //arguments(42,"some other junk 42"),
                arguments(0,"some other junk 42"),
                arguments(0,"    "),
                arguments(0,"-91283472332"),
                arguments(0,"99283472332")
        );
    }

    @ParameterizedTest()
    @MethodSource("myAtoITestCases")
    void myAtoi(int expected, String input) {
        Assertions.assertEquals(expected, Easy.myAtoi(input));
    }

    static Stream<Arguments> containsTestCases(){
        return Stream.of(
                arguments(true, new int[]{1, 2, 3, 4},4),
                arguments(false, new int[]{1, 2, 3, 4},5),
                arguments(true, new int[]{-1, 2, 3, 4},-1)
        );
    }
    @ParameterizedTest()
    @MethodSource("containsTestCases")
    void containsk(boolean expected, int[] array, int k) {
        Assertions.assertEquals(expected, Easy.containsk(array,k));
    }
}