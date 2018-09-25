//https://www.hackerrank.com/challenges/new-year-chaos/problem
public class NewYearChaos {

    public static String method(String str) {
        char[] array = str.toCharArray();
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            int j = Character.getNumericValue(array[i]) - 1;
            if (Math.abs(j - i) > 2) {
                return "Too chaotic";
            } else {
                num = num + Math.abs(j - i);
            }
        }
        return Integer.toString(num/2);
    }

    public static void main(String[] args) {
        assert method("21534").equals("3");
        assert method("25134").equals("Too chaotic");
        assert method("51237864").equals("Too chaotic");
        assert method("12537486").equals("5");
        assert method("12534786").equals("4");
    }
}
