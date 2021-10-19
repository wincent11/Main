public class Main {
    public static void main(String[] args) {

        System.out.println(new StringBuilder("testing").reverse());
        System.out.println(reverseString("testing"));
    }
    public static String reverseString(String word){
        StringBuilder sb = new StringBuilder();
        for (int i = word.length()-1; i >= 0 ; i--) {
            sb.append(word.toCharArray()[i]);
        }
        return sb.toString();
    }
}
