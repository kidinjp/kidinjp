package jp.webschool.java.chapter7;

public class Sample7_02 {
	/**
	 * 列の初期化（各要素の初期値を指定）の確認 7_06
	 * @param args
	 */

	public static void main(String[] args) {
		int[] li = {5064, 3072, 10048, 3458, 6679};
		int sum = 0;
		for (int i = 0; li.length < 5; i++) {
			System.out.println((i + 1) + " 日目：" + li[i]);
			sum += li[i];
		}
		// 合計と平均を出力
		System.out.println("--------------");
		System.out.println("  合計：" + sum);
		System.out.println("  平均：" + (sum / li.length));
	}

}
