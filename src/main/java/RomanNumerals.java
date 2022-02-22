import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    static Map<Integer, String> digits = new HashMap<>();
    public static int number;

    public static void init() {
        digits.put(1000, "M");
        digits.put(500, "D");
        digits.put(100, "C");
        digits.put(50, "L");
        digits.put(10, "X");
        digits.put(5, "V");
        digits.put(1, "I");
    }

    public static StringBuilder subtraction(StringBuilder result, int minFilter, int maxLimit, int minLimit) {
        if (number >= maxLimit) {
            result.append(digits.get(maxLimit));
            number -= maxLimit;
            return result;
        }
        if (number >= minFilter) {
            result.append(digits.get(minLimit)).append(digits.get(maxLimit));
            number -= minFilter;
        }
        return result;
    }

    public static String toRoman(int n) {
        number = n;
        init();
        StringBuilder result = new StringBuilder();
        while (number != 0) {
            if (number >= 900) {
                result = subtraction(result, 900, 1000, 100);
                continue;
            }
            if (number >= 400) {
                result = subtraction(result, 400, 500, 100);
                continue;
            }
            if (number >= 90) {
                result = subtraction(result, 90, 100, 10);
                continue;
            }
            if (number >= 40) {
                result = subtraction(result, 40, 50, 10);
                continue;
            }
            if (number >= 9) {
                result = subtraction(result, 9, 10, 1);
                continue;
            }
            if (number >= 4) {
                result = subtraction(result, 4, 5, 1);
                continue;
            }
            if (number >= 1) {
                result.append(digits.get(1));
                number -= 1;
            }
        }
        return result.toString();
    }

    public static int fromRoman(String romanNumeral) {
        init();
        int result = 0;
        StringBuilder romanNumberSB = new StringBuilder(romanNumeral);
        while (romanNumberSB.length() != 0) {
            if (romanNumberSB.substring(0, 1).equals(digits.get(1000))) {
                romanNumberSB.delete(0, 1);
                result += 1000;
                continue;
            }
            if (romanNumberSB.substring(0, 1).equals(digits.get(500))) {
                romanNumberSB.delete(0, 1);
                result += 500;
                continue;
            }
            if (romanNumberSB.substring(0, 1).equals(digits.get(100))) {
                if (romanNumberSB.length() > 1) {
                    if (romanNumberSB.substring(1, 2).equals(digits.get(1000))) {
                        result += 900;
                        romanNumberSB.delete(0, 2);
                        continue;
                    }
                    if (romanNumberSB.substring(1, 2).equals(digits.get(500))) {
                        result += 400;
                        romanNumberSB.delete(0, 2);
                        continue;
                    }
                }
                romanNumberSB.delete(0, 1);
                result += 100;
                continue;
            }
            if (romanNumberSB.substring(0, 1).equals(digits.get(50))) {
                romanNumberSB.delete(0, 1);
                result += 50;
                continue;
            }
            if (romanNumberSB.substring(0, 1).equals(digits.get(10))) {
                if (romanNumberSB.length() > 1) {
                    if (romanNumberSB.substring(1, 2).equals(digits.get(100))) {
                        result += 90;
                        romanNumberSB.delete(0, 2);
                        continue;
                    }
                    if (romanNumberSB.substring(1, 2).equals(digits.get(50))) {
                        result += 40;
                        romanNumberSB.delete(0, 2);
                        continue;
                    }
                }
                romanNumberSB.delete(0, 1);
                result += 10;
                continue;
            }
            if (romanNumberSB.substring(0, 1).equals(digits.get(5))) {
                romanNumberSB.delete(0, 1);
                result += 5;
                continue;
            }
            if (romanNumberSB.substring(0, 1).equals(digits.get(1))) {
                if (romanNumberSB.length() > 1) {
                    if (romanNumberSB.substring(1, 2).equals(digits.get(10))) {
                        result += 9;
                        romanNumberSB.delete(0, 2);
                        continue;
                    }
                    if (romanNumberSB.substring(1, 2).equals(digits.get(5))) {
                        result += 4;
                        romanNumberSB.delete(0, 2);
                        continue;
                    }
                }
                romanNumberSB.delete(0, 1);
                result += 1;
            }
        }
        return result;
    }
}