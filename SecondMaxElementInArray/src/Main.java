import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 9, 4, 4, 7, 10};

        //Traditional approach
        int max = array[0];
        int secondMax = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            }
        }
        System.out.println("Second max Element: " + secondMax);

        //Approach using stream
        System.out.println("Second max Element: " + Arrays.stream(array).sorted().toArray()[array.length - 2]);

        //Approach using sort() Arrays method
        Arrays.sort(array);
        System.out.println("Second max Element: " + array[array.length - 2]);
    }
}
