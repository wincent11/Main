import java.lang.StringBuilder;
class Solution {
    public static String whoLikesIt(String... names) {
        StringBuilder result = new StringBuilder();
        switch (names.length) {
            case 0: {
                result.append("no one");
            }
            case 1: {
                result.append(result.isEmpty() ? names[0] + " likes this" : " likes this");
                break;
            }
            case 2: {
                result.append(names[0]).append(" and ").append(names[1]).append(" like this");
                break;
            }
            case 3: {
                result.append(names[0]).append(", ").append(names[1]).append(" and ").append(names[2]).append(" like this");
                break;
            }
            default: {
                result.append(names[0]).append(", ").append(names[1]).append(" and ").append(names.length - 2).append(" others like this");
            }
        }
        return result.toString();
    }
}