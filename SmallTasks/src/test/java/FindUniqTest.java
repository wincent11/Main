import org.junit.Test;
import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class FindUniqTest {
    @Test
    public void testBasic()
    {
        assertEquals(9, FindUniq.squareSum(new int[] {1,2,2}));
        assertEquals(5, FindUniq.squareSum(new int[] {1,2}));
        assertEquals(50, FindUniq.squareSum(new int[] {5,-3,4}));
        assertEquals(0, FindUniq.squareSum(new int[] {}));
    }
}