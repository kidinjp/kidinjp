package jp.webschool.java.chapter6;

public class Sample6_01 {
	/**
	 * 「for 文」の確認 6_02
	 * @param args
	 */
	public static void main(String[] args) {
		// 変数を宣言
		int a = 100;
		// 「for 文」の確認
		for (int i = 0; i < 10; i++) {
			a += 5;
		}
		// 結果出力
		System.out.println(a);
	}

}
