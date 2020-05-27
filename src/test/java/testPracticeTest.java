import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class testPracticeTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(true,"aab"),
                arguments(false,"ba"),
                arguments(false,"bba"),
                arguments(false,"ababa"),
                arguments(false,"abba")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void check(boolean expected, String input) {
        Assertions.assertEquals(expected, ABeforeB.check(input));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void check2(boolean expected, String input) {
        Assertions.assertEquals(expected, ABeforeB.check2(input));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void check3(boolean expected, String input) {
        Assertions.assertEquals(expected, ABeforeB.check3(input));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void check4(boolean expected, String input) {
        Assertions.assertEquals(expected, ABeforeB.check4(input));
    }
}