public class Main {
    public static void main(String[] args) {
        System.out.println(isPrimeNumber(7));
    }
    public static  boolean isPrimeNumber(int num){
        boolean isPrime = true;

        for (int i = 2; i <= num/2; i++) {
            if (num%i==0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
