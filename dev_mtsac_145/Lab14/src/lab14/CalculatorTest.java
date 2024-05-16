package lab14;

import java.util.Scanner;

public class CalculatorTest {
	public static void main(String[] args)
	{
	Scanner scin = new Scanner(System.in);
	System.out.print("Enter two integers : ");
	int a = scin.nextInt();
	int b = scin.nextInt();
	Calculator.plus(a, b);
	Calculator.minus(a, b);
	System.out.println("Plus : " + Calculator.plusResult());
	System.out.println("Minus : " + Calculator.minusResult());
	System.out.println();
	System.out.print("Enter three integers for plus : ");
	int x = scin.nextInt();
	int y = scin.nextInt();
	int z = scin.nextInt();
	Calculator.plus(x);
	System.out.println("Total : " + Calculator.total());
	Calculator.plus(y);
	System.out.println("Total : " + Calculator.total());
	Calculator.plus(z);
	System.out.println("Total : " + Calculator.total());
	System.out.println();
	System.out.print("Enter one more integer for minus : ");
	int w = scin.nextInt();
	Calculator.minus(w);
	System.out.println("Total : " + Calculator.total());
	}
	
}
