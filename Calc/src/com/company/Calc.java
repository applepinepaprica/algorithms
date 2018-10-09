package com.company;

class Calc {
    private static int pointer;

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

        return Double.parseDouble(s.toString());
    }

    private static double Count(char[] array){
        double result = 0;

        for (; pointer < array.length; pointer++) {
            if (Character.isDigit(array[pointer])) {
                result = Pars(array);
            } else {
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
                        break;
                    default: throw new ParsException();
                }
            }
        }

        return result;
    }

    static double Calc(char[] array){
        pointer = 0;

        return Count(array);
    }
}
