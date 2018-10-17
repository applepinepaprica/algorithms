package com.company.calculator;

import org.junit.Test;

/**
 * Тесты для проверки класса Calc
 */
public class CalcTest {

    /**
     * Проверяет, правильно ли парсится число из строки
     */
    @Test
    public void pars() {
        assert Calc.calc("1234") == 1234.0;
    }

    /**
     * Проверяет умножение
     */
    @Test
    public void multiplication() {
        assert Calc.calc("1*2*3/1") == 6.0;
        assert Calc.calc("123*2") == 246.0;
    }

    /**
     * Проверяет сумму
     */
    @Test
    public void sum() {
        assert Calc.calc("123+2") == 125.0;
    }

    /**
     * Проверяет сумму и умножение
     */
    @Test
    public void sumAndMultiplication() {
        assert Calc.calc("2+2*2") == 6.0;
        assert Calc.calc("2+2*2-2/2") == 5.0;
        assert Calc.calc("22+22*22-22/22") == 505.0;
    }

    /**
     * Проверяет, правильно ли считаются выражения с дробными
     */
    @Test
    public void test_double() {
        assert Calc.calc("22+2.2*22-22/22") == 69.4;
    }

    /**
     * Проверяет, как считаются сложные выражение
     */
    @Test
    public void complex() {
        assert Calc.calc("22-2+22+22*2-22+22/22") == 65.0;
        assert Calc.calc("133+3*5+4/555-6+44*1000") == 44142.00720720721;
    }

    /**
     * Тесты, которые проверяют, выбрасывается ли исключении при некорректном вводе
     */
    @Test
    public void parsException() {
        assertThrowsParsEx("133+3×5+4÷555-6+44×1000");
        assertThrowsParsEx("22 +22*22-22/22");
    }

    @Test
    public void brackets() {
        assert Calc.calc("(2*3)+2") == 8.0;
        assert Calc.calc("(2+2+2)*2") == 8.0;
    }

    /**
     * Проверяет, выбрасывается ли исключении при некорректном вводе
     *
     * @param s арифметичсекое выражение
     */
    private static void assertThrowsParsEx(String s) {
        try {
            Calc.calc(s);
            assert false;
        } catch (ParsException e) {
            assert true;
        }
    }
}