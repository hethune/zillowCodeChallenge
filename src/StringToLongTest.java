import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by wenhang on 3/8/14.
 */
public class StringToLongTest {
    @org.junit.Test
    public void testStringToLong() throws Exception {
        StringToLong stringToLong = new StringToLong();
        String s = null;
        //Test Null
        try {
            stringToLong.stringToLong(s);
            fail("Null Input case not passed");
        } catch (IllegalArgumentException e) {
        }

        // Test Illegal arguments
        try {
            s = "";
            stringToLong.stringToLong(s);
            fail("Empty Input case not passed");
        } catch (IllegalArgumentException e) {
        }

        try {
            s = "-";
            stringToLong.stringToLong(s);
            fail("Null Input case not passed");
        } catch (IllegalArgumentException e) {
        }

        try {
            s = "--1";
            stringToLong.stringToLong(s);
            fail("Empty Input case not passed");
        } catch (IllegalArgumentException e) {
        }

        try {
            s = "-1a";
            stringToLong.stringToLong(s);
            fail("Empty Input case not passed");
        } catch (IllegalArgumentException e) {
        }

        try {
            s = "-1..1";
            stringToLong.stringToLong(s);
            fail("Empty Input case not passed");
        } catch (IllegalArgumentException e) {
        }

        try {
            s = "-1.1a";
            stringToLong.stringToLong(s);
            fail("Empty Input case not passed");
        } catch (IllegalArgumentException e) {
        }

        // test longs
        s = "1234";
        assertEquals(stringToLong.stringToLong(s), 1234L);

        s = "-567890";
        assertEquals(stringToLong.stringToLong(s), -567890L);

        s = "2147483647";
        assertEquals(stringToLong.stringToLong(s), 2147483647L);

        s= "9223372036854775807";
        assertEquals(stringToLong.stringToLong(s),9223372036854775807L);

        // test doubles
        s = "123.678";
        assertEquals(stringToLong.stringToLong(s),123L);


        // test overflows
        try {
            s= "119223372036854775808";
            stringToLong.stringToLong(s);
            fail("Input overflowing case not passed");
        } catch (IllegalArgumentException e) {

        }

    }
}
