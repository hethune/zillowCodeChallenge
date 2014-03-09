import java.util.ArrayList;
import java.util.List;

/**
 * Question 1) Given a string, write a routine that converts the string to a long,
 * without using the built in functions that would do this. Describe what (if any)
 * limitations the code has.
 * Created by wenhang on 3/8/14.
 */

/**
 * Usage: Converts string to long
 * Valid for every valid string that represents a number in the natural representation
 * The number has to be with the long range, defined by the System
 * If the number is a double, e.g. 123.66, the method will return the flour of the number, e.g. 123
 * Please refer to the unit tests for valid and invalid inputs
 */
public class StringToLong {

    private static String errorMsg = "Invalid Input";

    public long stringToLong(String s) throws IllegalArgumentException{

        if (s == null) { throw new IllegalArgumentException(errorMsg); }

        s = s.trim();

        if (s.length() == 0) { throw new IllegalArgumentException(errorMsg); }

        int sign = 1;
        int startIndex = 0;
        boolean dotAppeared = false;
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
            if (tmp == '.') {
                if (dotAppeared) { throw new IllegalArgumentException(errorMsg); }
                dotAppeared = true;
            }
            if (tmp > '9' || tmp < '0' && tmp != '.') {
                throw new IllegalArgumentException(errorMsg);
            }
            if (dotAppeared) { continue; }
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
