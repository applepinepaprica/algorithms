using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calc2
{
    class Program
    {
        static double Pars(char[] mas, ref int j)
        {
            double num = 0;
            if (Char.IsDigit(mas[j]))
            {
                string ch = char.ToString(mas[j]);
                j++;
                for (; j < mas.Length; j++)
                {
                    if (Char.IsDigit(mas[j]) || mas[j] == ',')
                    {
                        ch = ch + mas[j];
                    }
                    else break;

                }
                num = Double.Parse(ch);
                j--;
            }
            else if (Char.IsLetter(mas[j]))
            {
                string characters = char.ToString(mas[j]);
                j++;
                for (; j < mas.Length; j++)
                {
                    if (Char.IsLetterOrDigit(mas[j]))
                    {
                        characters = characters + mas[j];
                    }
                    else break;

                }
                Console.Write("Enter the variable {0}: ", characters);
                num = double.Parse(Console.ReadLine());
                j--;
            }
            else switch (mas[j])
                {
                    case '(': j++; num = Calc(mas, ref j);  break;
                    case ' ': j++; num = Pars(mas, ref j);  break;
                }
            return num;
        }

        static double Calc(char[] mas, ref int i)
        {
            double result = 0;
            bool flag = true;
            for (; i < mas.Length && flag; i++)
            {
                    if (Char.IsLetterOrDigit(mas[i]))
                    {
                        result = Pars(mas, ref i);
                    }
                    else switch (mas[i])
                        {
                            case '*': i++; result = result * Pars(mas, ref i); break;
                            case '/': i++; result = result / Pars(mas, ref i); break;
                            case '+': i++; result = result + Calc(mas, ref i); if (mas[i] == ')') { i--; }; break;
                            case '-': i++; result = result - Calc(mas, ref i); if (mas[i] == ')') { i--; }; break;
                            case '(': i++; result = Calc(mas, ref i); break;
                            case ')': flag = false; break;
                        }

            }
            i--;
            return result;
        }

        static void Main(string[] args)
        {
            //Console.Write("Enter an arithmetic expression: ");
            //string str = Console.ReadLine();
            //char[] mas = str.ToCharArray();

            //string str = "per+ (4,5 + 577*6*700/7,5 + 5*6)/(655*7*5/10)-3 = ";
            string str = "(1+2)*3/4";

            char[] str = str.ToCharArray();
            foreach (char el in str)
            {
                Console.Write(el);
            }
            Console.WriteLine();

            int t = 0;
            double result = Calc(str, ref t);
            Console.WriteLine("result: {0}", result);
            Console.ReadKey();
        }
    }
}
