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
     * @param str арифметическое выражение
     * @return результат
     */
    public static double Calc(String str){
        pointer = 0;
        return Count(str.toCharArray());
    }

    /**
     * Функция. которая выполняет арифметические действия
     * @param array массив символов
     * @return результат
     */
    private static double Count(char[] array){
        double result = 0;

        for (; pointer < array.length; pointer++) {

            if (Character.isDigit(array[pointer])) {

                result = Pars(array);

            } else {
                if (pointer == 0){
                    throw new ParsException();
                }

                switch (array[pointer]) {
                    case '*': pointer++; result = result * Pars(array); break;
                    case '/': pointer++; result = result / Pars(array); break;
                    case '+': pointer++; result = result + Count(array); break;
                    case '-': pointer++;

                        int temp = pointer;
                        for (; pointer < array.length; pointer++) {
                            if (array[pointer] == '*' || array[pointer] == '/') {
                                pointer = temp;
                                result = result - Count(array);
                                break;
                            } else if (array[pointer] == '+' || array[pointer] == '-')
                            {
                                pointer = temp;
                                result = result - Pars(array);
                                break;
                            }
                        }

                        if (pointer == array.length){
                            pointer = temp;
                            result = result - Pars(array);
                        }

                        break;

                    default: throw new ParsException();
                }
            }
        }

        return result;
    }

    /**
     * Парсит массив символов и возвращает число, соотвествующее массиву
     * @param array массив символов
     * @return число
     */
    private static double Pars(char[] array) {
       StringBuilder s = new StringBuilder();

        for (; pointer < array.length; pointer++) {

            if (Character.isDigit(array[pointer]) || array[pointer] == '.') {

                s.append(array[pointer]);

            } else {

                pointer--;
                break;

            }
        }

        try{
            return Double.parseDouble(s.toString());
        } catch (NumberFormatException e){
            throw new ParsException();
        }
    }
}
