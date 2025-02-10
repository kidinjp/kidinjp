package jp.webschool.java.chapter6;

public class Sample6_03 {
	/**
	 * 繰り返し処理（while 文） 6_05
	 * @param args
	 */

	public static void main(String[] args) {
		// 繰り返し回数
		int i = 1;
		// 100 まで繰り返し
		while (i <= 100) {
			System.out.println(i + " です。" + (i % 10 == 0 ? "キリの良い数字です。": ""));
			i++;
		}

	}

}
