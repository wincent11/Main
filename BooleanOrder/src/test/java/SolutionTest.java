import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;


public class SolutionTest {

    @Test
    public void sampleTests() {
//        Assert.assertEquals(new BigInteger("2"),            new BooleanOrder("tft","^&").solve());
        Assert.assertEquals(new BigInteger("16"),           new BooleanOrder("ttftff","|&^&&").solve());
//        Assert.assertEquals(new BigInteger("339"),          new BooleanOrder("ttftfftf","|&^&&||").solve());
//        Assert.assertEquals(new BigInteger("851"),          new BooleanOrder("ttftfftft","|&^&&||^").solve());
//        Assert.assertEquals(new BigInteger("2434"),         new BooleanOrder("ttftfftftf","|&^&&||^&").solve());
//        Assert.assertEquals(new BigInteger("945766470799"), new BooleanOrder("ttftfftftffttfftftftfftft","|&^&&||^&&^^|&&||^&&||&^").solve());
    }
}