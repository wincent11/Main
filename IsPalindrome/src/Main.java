public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("test"));
        System.out.println(isPalindrome("teet"));
    }

    static boolean isPalindrome(String words){
        return new StringBuilder(words).reverse().toString().equals(words);
    }
}
