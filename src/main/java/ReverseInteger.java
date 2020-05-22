import static java.lang.Math.abs;

public class ReverseInteger {
    public static int reverse(int x) {
        int isNegative = x < 0 ? -1 : 1;
        String reversed = new StringBuilder(Integer.toString(abs(x))).reverse().toString();

        try {
            return Integer.valueOf(reversed)*isNegative;
        } catch(NumberFormatException e) {
            return 0;
        }
    }
}
