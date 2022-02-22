import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralsTest {

    @Test
    public void testToRoman() throws Exception {
        Assert.assertThat("1 converts to 'I'", RomanNumerals.toRoman(540), is("DXL"));
        Assert.assertThat("2 converts to 'II'", RomanNumerals.toRoman(2), is("II"));
    }


    @Test
    public void testFromRoman() throws Exception {
        assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("II"), is(2));
    }
}