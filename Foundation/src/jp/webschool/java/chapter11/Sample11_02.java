package jp.webschool.java.chapter11;

public class Sample11_02 {

	/**
	 * テストメソッドの呼び出し 11_06
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスを生成
		ChocolateMachine m = new ChocolateMachine("C001", 200, 250, 200, "チョコレート", 50);
		// テストメソッド呼び出し
		m.test();
	}

}
