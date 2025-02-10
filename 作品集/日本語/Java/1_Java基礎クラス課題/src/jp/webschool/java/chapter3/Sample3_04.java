package jp.webschool.java.chapter3;

public class Sample3_04 {

	public static void main(String[] args) {
		// 変数の使い方（変数から変数へ値を渡す）3_09
		// 変数を初期化
		int a = 10;
		int b = 20;
		System.out.println("変数を初期化");
		System.out.println("a の値は " + a);
		System.out.println("b の値は " + b);
		// 変数 a に、変数 b の値を代入
		a = b;
		System.out.println("変数 a に、変数 b の値を代入");
		System.out.println("a の値は " + a);
		System.out.println("b の値は " + b);
		// 変数 a に、変数 b の値と 100 を加算した結果を代入
		a = b + 100;
		System.out.println("変数 a に、変数 b の値と 100 を加算した結果を代入");
		System.out.println("a の値は " + a);
		System.out.println("b の値は " + b);
	}
}