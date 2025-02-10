package jp.webschool.java.chapter10;

public class Sample10_05 {

	/**
	 * コンストラクタ（引数有無）の動作確認 10_09
	 * @param args
	 */
	public static void main(String[] args) {
		// Machine インスタンスを生成（引数なしのコンストラクタ）
		Machine m1 = new Machine();
		m1.showData();

		// Machine インスタンスを生成（引数ありのコンストラクタ）
		Machine m2 = new Machine("M002", 500, 600, 800, "キャンディ（レモン味）", 1000);
		m2.showData();

	}

}
