package jp.webschool.java.chapter4;

public class Sample4_05 {
	/**
	 * 演算子の優先順位 4_09
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 5;
		int b = 4;
		// 括弧なし
		System.out.println("括弧なし");
		System.out.println(a + " + " + b + " = " + a + b);
		System.out.println(a + " * " + b + " = " + a * b);
		// 括弧あり
		System.out.println("括弧あり");
		System.out.println(a + " + " + b + " = " + (a + b));
		System.out.println(a + " * " + b + " = " + (a * b));
		// 前後テスト
		System.out.println("(前後テスト[括弧なし])" + a + b);
		System.out.println("(前後テスト[括弧あり])" + (a + b));

	}

}
