import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuValidator {
    final static Set<Integer> reference = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).boxed().collect(Collectors.toSet());

    public static boolean check(int[][] sudoku) {
        Set<Integer> square = new HashSet<>();
        int OX = 0;
        int OY = 0;
        for (int count = 1; count <= 9; count++) {
            for (int i = OX; i < 3 + OX; i++) {
                for (int j = OY; j < 3 + OY; j++) {
                    square.add(sudoku[i][j]);
                }
            }
            if (!reference.equals(square)) {
                return false;
            }
            square.clear();
            OX += 3;
            if (count % 3 == 0) {
                OX = 0;
                OY += 3;
            }
        }
        return true;
    }
}