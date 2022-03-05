import java.util.regex.Pattern;

public class KataSolution {
    public static Pattern regex = Pattern.compile("\\((-?[\\w\\d+]|-?\\d\\w+)([-+]\\d+)\\)\\^(\\d+)");
    public static String firstPartRegex = "(-?\\d*)(\\w?)";
    public static String variable = null;
    public static Integer a = null;
    public static Integer b = null;
    public static Integer initExp = null;

    public static String expand(String expr) {
        String fPart = expr.replaceAll(regex.pattern(), "$1");
        b = Integer.parseInt(expr.replaceAll(regex.pattern(), "$2"));
        initExp = Integer.parseInt(expr.replaceAll(regex.pattern(), "$3"));

        variable = fPart.replaceAll(firstPartRegex, "$2");
        try {
            a = Integer.parseInt(fPart.replaceAll(firstPartRegex, "$1"));
        } catch (NumberFormatException e) {
            if (fPart.replaceAll(firstPartRegex, "$1").length() == 0) {
                a = 1;
            } else {
                a = -1;
            }
        }
        if (b == 0) return (int) Math.pow(a, initExp) + variable + "^" + initExp;

        long expB = (long) Math.pow(b, initExp);
        String result = calculate(initExp, new StringBuilder()).append(expB < 0 ? expB : "+" + expB).toString();
        return result.startsWith("+") ? result.substring(1) : result;
    }

    public static StringBuilder calculate(Integer exp, StringBuilder extension) {
        if (exp == 0) {
            return extension;
        } else if (exp == 1) {
            long index = (long) ((f(initExp) / (f(initExp - exp) * f(exp))) * Math.pow(a, exp) * Math.pow(b, initExp - exp));
            return extension.append(index > 0 ? (index != 1 ? "+" + index : "") : index).append(variable);
        } else {
            long index = (long) ((f(initExp) / (f(initExp - exp) * f(exp))) * Math.pow(a, exp) * Math.pow(b, initExp - exp));
            return calculate(exp - 1, extension.append(index > 0 ? (index != 1 ? "+" + index : "") : (index != -1 ? +index : "-")).append(variable).append("^").append(exp));
        }
    }

    public static long f(Integer n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * f(n - 1);
        }
    }
}