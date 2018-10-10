package com.company;

import org.junit.Test;

public class CalcTest {

    @Test
    public void pars() {
        assert Calc.Calc("1234") == 1234.0;
    }

    @Test
    public void multiplication() {
        assert Calc.Calc("1*2*3/1") == 6.0;
        assert Calc.Calc("123*2") == 246.0;
    }

    @Test
    public void sum(){
        assert Calc.Calc("123+2") == 125.0;
    }

    @Test
    public void sumAndMultiplication(){
        assert Calc.Calc("2+2*2") == 6.0;
        assert Calc.Calc("2+2*2-2/2") == 5.0;
        assert Calc.Calc("22+22*22-22/22") == 505.0;
    }

    @Test
    public void test_double(){
        assert Calc.Calc("22+2.2*22-22/22") == 69.4;
    }

    @Test
    public void complex(){
        assert Calc.Calc("22-2+22+22*2-22+22/22") == 65.0;
        assert Calc.Calc("133+3*5+4/555-6+44*1000") == 44142.00720720721;
    }

    @Test
    public void parsException(){
        assertThrowsParsEx("133+3×5+4÷555-6+44×1000");
        assertThrowsParsEx("22 +22*22-22/22");
    }

    private static void assertThrowsParsEx(String s){
        try {
            Calc.Calc(s);
            assert false;
        } catch(ParsException e){
            assert true;
        }
    }
}