public class AlternatingCharacters {

    public static int count(String str) {
        char[] array = str.toCharArray();
        int num = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == array[i]) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        assert count("AAAA") == 3;
        assert count("BBBBB") == 4;
        assert count("ABABABAB") == 0;
        assert count("BABABA") == 0;
        assert count("AAABBB") == 4;
    }
}
