package jp.webschool.java.chapter4;

public class Sample4_01 {
	/**
	 * 算術演算子（四則演算）4_01
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("算術演算子の練習です。");
		// 演算する値を宣言
		int number1 = 23;
		int number2 = 10;
		//各種演算
		System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
		System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
		System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
		System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
		System.out.println(number1 + " % " + number2 + " = " + (number1 % number2));
	}

}
