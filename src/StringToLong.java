import java.util.ArrayList;
import java.util.List;

/**
 * Question 1) Given a string, write a routine that converts the string to a long,
 * without using the built in functions that would do this. Describe what (if any)
 * limitations the code has.
 * Created by wenhang on 3/8/14.
 */
public class StringToLong {

    private static String errorMsg = "Invalid Input";

    public long stringToLong(String s) throws IllegalArgumentException{

        if (s == null || s.length() == 0) { throw new IllegalArgumentException(errorMsg); }

        int sign = 1;
        int startIndex = 0;
        // negative number
        if (s.charAt(startIndex) == '-') {
            startIndex = 1;
            sign = -1;
            //edge case s = "-"
            if (s.length() < 2) { throw new IllegalArgumentException(errorMsg); }
        }
        // get each digit
        List<Integer> digits = new ArrayList<Integer>();
        for (int i = startIndex; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp > '9' || tmp < '0') {
                throw new IllegalArgumentException(errorMsg);
            }
            // convert to ascii value and then to integer
            int curr = ((int) tmp) - 48;
            digits.add(curr);
        }
        // Add up all digit
        long val = 0L;
        // check for overflows
        long prev = val;
        for (int i = 0; i < digits.size(); i++) {
            val += digits.get(i) * ((long) Math.pow(10, ((double)digits.size() - i - 1.0)));
            if (val < prev) {
                throw new IllegalArgumentException("Input Over flowed");
            }
        }
        return val * sign;
    }
}
