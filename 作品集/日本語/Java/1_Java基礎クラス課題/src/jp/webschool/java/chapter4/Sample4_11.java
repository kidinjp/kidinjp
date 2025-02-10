package jp.webschool.java.chapter4;

public class Sample4_11 {
	/**
	 * 課題内容
	 * 以下の４つの演算を行い、結果を出力するプログラムを作成してください。
	 * 0.5 * 5.1
	 * (int)0.5 * (int)5.1
	 * 0.1 * 0.1
	 * 0.01 * 0.001
	 * 
	 * 【条件】
	 * 演算結果を「System.out.println()」で直接出力しても、一度変数に格納してもどちらでも構いません。
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(0.5 * 5.1);
		System.out.println((int)0.5 * (int)5.1);
		System.out.println(0.1 * 0.1);
		System.out.println(0.01 * 0.001);	// 出力された 1.0E-5 は科学的表記法
	}

}
