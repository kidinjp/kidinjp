package jp.webschool.java.chapter4;

public class Sample4_10 {
	/**
	 * 課題内容
	 * 以下の４つの演算を行い、結果を出力するプログラムを作成してください。
	 * (5 + 4) * 20
	 * (5 + 4) * 20 + 10 * 200
	 * ((5 + 4) * 20 + 10 * 200) * (500 * 100 + 200 / 10)
	 * ((5 + 4) * 20 + 10 * 200) * (500 * 100 + 200 / 10) * 100
	 * 
	 * 【条件】
	 * 演算結果を「System.out.println()」で直接出力しても、一度変数に格納してもどちらでも構いません。
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println((5 + 4) * 20);
		System.out.println((5 + 4) * 20 + 10 * 200);
		System.out.println(((5 + 4) * 20 + 10 * 200) * (500 * 100 + 200 / 10));

		// int の範囲（符号付き整数 -2147483648 ～ 2147483647）を超えるのでlongにしました。
		System.out.println(((5 + 4) * 20 + 10 * 200) * (long) (500 * 100 + 200 / 10) * 100);	
	}
}
