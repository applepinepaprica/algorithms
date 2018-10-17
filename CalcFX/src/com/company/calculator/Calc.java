package com.company.calculator;

/**
 * Класс со статическими методами для вычисления арифметического выражения
 */
public class Calc {

    /**
     * Указатель на текущий символ в массиве
     */
    private static int pointer;

    /**
     * Находит результат арифметического выражения
     *
     * @param arithmeticExpression арифметическое выражение
     * @return результат
     */
    public static double calc(String arithmeticExpression) {
        pointer = 0;
        return count(arithmeticExpression.toCharArray());
    }

    /**
     * Функция. которая выполняет арифметические действия
     *
     * @param array массив символов
     * @return результат
     */
    private static double count(char[] array) {
        double result = 0;

        for (; pointer < array.length; pointer++) {

            if (Character.isDigit(array[pointer])) {
                result = pars(array);
            } else {

                if (pointer == 0) {
                    throw new ParsException();
                }

                //Increment _after_ switch
                switch (array[pointer++]) {
                    case '*': result = result * pars(array); break;
                    case '/': result = result / pars(array); break;
                    case '+': result = result + count(array); break;
                    case '-': result = subtraction(array, result); break;
                    default: throw new ParsException();
                }
            }
        }

        return result;
    }

    /**
     * Функция для вычитания
     * Если после минуса идет умножение/деление, то вычитается произведение,
     * если плюс/минус, то вычитается число, следующее за минусом
     *
     * @param array  массив символов
     * @param result уменьшаемое
     * @return разность
     */
    private static double subtraction(char[] array, double result) {
        int temp = pointer;
        for (; pointer < array.length; pointer++) {
            if (array[pointer] == '*' || array[pointer] == '/') {
                pointer = temp;
                result = result - count(array);
                break;
            } else if (array[pointer] == '+' || array[pointer] == '-') {
                pointer = temp;
                result = result - pars(array);
                break;
            }
        }

        if (pointer == array.length) {
            pointer = temp;
            result = result - pars(array);
        }

        return result;
    }

    /**
     * Парсит массив символов и возвращает число, соотвествующее массиву
     *
     * @param array массив символов
     * @return число
     */
    private static double pars(char[] array) {
        StringBuilder s = new StringBuilder();

        for (; pointer < array.length; pointer++) {

            if (Character.isDigit(array[pointer]) || array[pointer] == '.') {

                s.append(array[pointer]);

            } else {

                pointer--;
                break;

            }
        }

        try {
            return Double.parseDouble(s.toString());
        } catch (NumberFormatException e) {
            throw new ParsException();
        }
    }
}
