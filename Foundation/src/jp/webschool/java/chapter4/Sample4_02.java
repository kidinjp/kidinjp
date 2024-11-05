package jp.webschool.java.chapter4;

public class Sample4_02 {
	/**
	 * インクリメントの前置後置 4_04
	 * @param args
	 */
	public static void main(String[] args) {
		// 変数の宣言
		int a = 0;
		int b = 0;
		int c;
		// 前置
		c = ++ a;
		System.out.println("前置インクリメント");
		System.out.println("a : " + a);
		System.out.println("c : " + c);
		// 後置
		c = b ++;
		System.out.println("後置インクリメント");
		System.out.println("b : " + b);
		System.out.println("c : " + c);

	}

}
