import org.junit.Test;
import java.util.Arrays;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class LeftRotation {

    public static int[] rotation (int[] array, int d) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int j = Math.floorMod(i - d, array.length);
            result[j] = array[i];
        }

        return result;
    }

    @Test
    public static void main(String[] args) {
        assert Arrays.equals(rotation(new int[] { 1, 2, 3, 4, 5 }, 4), new int[]{ 5, 1, 2, 3, 4 });
        assert Arrays.equals(rotation(new int[] { 1, 2, 3, 4, 5 }, 2), new int[]{ 3, 4, 5, 1, 2 });
        assert Arrays.equals(rotation(new int[] { 1, 2, 3, 4, 5 }, 7), new int[]{ 3, 4, 5, 1, 2 });
        assert Arrays.equals(rotation(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5), new int[]{ 6, 7, 1, 2, 3, 4, 5 });
    }
}
