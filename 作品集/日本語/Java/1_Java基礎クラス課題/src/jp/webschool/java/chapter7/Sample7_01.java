package jp.webschool.java.chapter7;

public class Sample7_01 {
	/**
	 * 配列の繰り返し処理 7_05
	 * @param args
	 */

	public static void main(String[] args) {
		int[] li = {5064, 3072, 10048, 3458, 6679};
		for (int i = 0; i < li.length; i++) {
			System.out.println((i + 1) + " 日目：" + li[i]);
		}
	}

}
