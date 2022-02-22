import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {
    @Test
    void simpleTest(){
        Assert.assertEquals("2a",EqSystem.simplify(new String[]{"a + a = b", "b - d = c", "a + b = d"}, "c + a + b"));
    }
    @Test
    void secondSimpleTest(){
        Assert.assertEquals("210a",new String[] {"a + 3g = k", "-70a = g"},"-k + a");
    }
}
