import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ReverseIntegerTest {

    private List<Object[]> testCases = Arrays.asList(
            //expected,input
            new Object[]{-123,-321},
            new Object[]{0,0},
            new Object[]{12,21},
            new Object[]{0,1534236469}
    );

    @Test
    void reverse() {
        testCases.stream().forEach( testCase ->
                    Assertions.assertEquals((int)testCase[0],ReverseInteger.reverse((int)testCase[1]))
        );
    }
}