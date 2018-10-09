package com.company;

public class Main {

    public static void main(String[] args) {
        //Test Pars()
        assert Calc.Calc("1234".toCharArray()) == 1234.0;

        //Test multiplication
        assert Calc.Calc("1*2*3/1".toCharArray()) == 6.0;
        assert Calc.Calc("123*2".toCharArray()) == 246.0;

        //Test sum
        assert Calc.Calc("123+2".toCharArray()) == 125.0;

        //Test sum and multiplication
        assert Calc.Calc("2+2*2".toCharArray()) == 6.0;
        assert Calc.Calc("2+2*2-2/2".toCharArray()) == 5.0;
        assert Calc.Calc("22+22*22-22/22".toCharArray()) == 505.0;

        //Double
        assert Calc.Calc("22+2.2*22-22/22".toCharArray()) == 69.4;

        //Complex
        assert Calc.Calc("22-2+22+22*2-22+22/22".toCharArray()) == 65.0;
        assert Calc.Calc("133+3*5+4/555-6+44*1000".toCharArray()) == 44142.00720720721;

        //Assert throws ParsException
        assertThrowsParsEx("133+3×5+4÷555-6+44×1000");
        assertThrowsParsEx("22 +22*22-22/22");
    }

    private static void assertThrowsParsEx(String s){
        try {
            Calc.Calc(s.toCharArray());
            assert false;
        } catch(ParsException e){
            assert true;
        }
    }
}
