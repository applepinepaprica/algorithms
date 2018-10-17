package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

//https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
public class Brackets {

    public static void main(String[] args) {
	    assert brackets("[ff]f(ff)");
	    assert !brackets("sfeg[{sg]f}");
        System.out.println("All tests passed");
    }

    private static boolean brackets(String str) {
        Deque<Character> array = new ArrayDeque<>();
        boolean result = true;

        for (int i = 0; i < str.length() && result; i++) {
            switch (str.charAt(i)) {
                case '(':
                case '{':
                case '[': array.push(str.charAt(i)); break;
                case ')': if (array.pop() != '(') { result = false; } break;
                case '}': if (array.pop() != '{') { result = false; } break;
                case ']': if (array.pop() != '[') { result = false; } break;
                default: break;
            }
        }

        return result;
    }
}
