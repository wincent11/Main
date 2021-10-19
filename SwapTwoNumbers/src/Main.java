public class Main {
    public static void main(String[] args) {
        int a = 6;
        int b = 7;
        System.out.println("a :" + a);
        System.out.println("b :" + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("Swap:");
        System.out.println("a :" + a);
        System.out.println("b :" + b);
    }
}
