package jp.webschool.java.chapter6;

public class Sample6_02 {
	/**
	 * 繰り返し処理（for 文）6_03
	 * @param args
	 */
	public static void main(String[] args) {
		// 足し算用の変数を宣言
		int kotae = 0;
		// 1 から 100 まで繰り返し
		for (int i = 1; i <= 100; i++) {
			kotae += i;
		}
		// 結果出力
		System.out.println(kotae);
	}

}
