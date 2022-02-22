import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BooleanOrder {
    StringBuilder expression;
    String operands;
    String operators;
    public BooleanOrder(final String operands, final String operators) {
        expression = new StringBuilder();
        expression.append(strToInt(operands.split("")[0]));
        for (int i = 0; i < operators.length(); i++) {
            expression.append(operators.split("")[i]);
            expression.append(strToInt(operands.split("")[i+1]));
        }
        System.out.println((1&1)|1);

    }
    public int strToInt(String el){
        return el.equals("t")?1:0;
    }

    public BigInteger solve() {

        return BigInteger.ZERO;
    }

    //        Assert.assertEquals(new BigInteger("2"),            new BooleanOrder("tft","^&").solve());
}