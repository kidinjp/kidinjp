package jp.webschool.java.chapter5;

public class Sample5_03 {
	/**
	 * if - else if 文」の確認 5_06
	 * @param args
	 */
	public static void main(String[] args) {
		// 変数を宣言
		int a = 5;
		int b = 10;
		// 「if - else if 文」の確認
		if (a == b) {
			System.out.println("a" + " は " + b + "と同じです");
		} else if (a > b) {
			System.out.println("a" + " は " + b + "よりも大きいです");
		} else {
			System.out.println("a" + " は " + b + "未満です");
		}
	}

}
